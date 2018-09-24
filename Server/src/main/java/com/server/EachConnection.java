package com.server;

import com.game.GameRoom;
import com.messages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EachConnection implements Runnable {

    private int score;
    private Socket clientSocket;
    private static Server server;
    private PlayerStatus clientStatus;
    private int clientNum;
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String clientName;
    private int tableId;
    static Logger logger = LoggerFactory.getLogger(EachConnection.class);
    private Map<String, String> listToSend = new HashMap<String, String>();



    public EachConnection(Socket clientSocket, int clientNum) throws IOException{
        this.clientSocket = clientSocket;
        this.clientNum = clientNum;

        out = clientSocket.getOutputStream();
        oos = new ObjectOutputStream(out);

        in = clientSocket.getInputStream();
        ois = new ObjectInputStream(in);
    }


    // listening from client messages
    @Override
    public void run() {
        try {
            logInFeedBack();
            while (true){
                Message clientMsg = (Message) ois.readObject();

                //TODO - Ethan & Eric
                if (clientMsg != null){
                    switch (clientMsg.getPlayerStatus()){
                        case SET_NAME:
                            inSetName(clientMsg);
                            break;
                            /*
                        case IN_HALL:
                            inHall(clientMsg);
                            break;
                        case IN_ROOM:
                            inRoom(clientMsg);
                            break;
                        case IN_GAME:
                            inGame(clientMsg);
                            break;
                            */
                    }
                }
            }
        } catch (SocketException socketException){
            if (clientName!=null){
                ServerState.UserList.remove(clientName);
            }
            logger.info("Client on port " + clientSocket.getPort() + " exited.");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    // log-in status
    private synchronized void logInFeedBack() throws IOException{
        Message m = new Message();
        m.setPlayerStatus(PlayerStatus.LOG_IN);
        m.setClientName("test");
        m.setFeedBackMessage("success");
        oos.writeObject(m);
        oos.flush();
    }

    // in setName status
    private synchronized void inSetName (Message m) throws IOException{
        String name = m.getClientName();
        nameCheck(name);
    }

    private void nameCheck(String name) throws IOException{
        Message toClient = new Message();
        Message toALL = new Message();
        //Map<String,String> clients = getClientLists();
        //List<GameRoom> gameRooms = ServerState.getClientInstance().getConnectedGames();

        if (!ServerState.UserList.contains(name)){
            setClientStatus(PlayerStatus.IN_HALL);
            setClientName(name);
            // TODO settting two lists
            toClient.setPlayerStatus(PlayerStatus.SET_NAME);
            //toClient.setConnectedClients(clients);
            //toClient.setCreatedGames(gameRooms);
            toClient.setClientName(name);
            toClient.setFeedBackMessage("ValidName");
            ServerState.UserList.add(name);
            oos.writeObject(toClient);

            /*
            //broadcast
            toALL.setServerAction(ServerAction.UPDATE);
            toALL.setConnectedClients(clients);
            toALL.setCreatedGames(gameRooms);
            broadCast(clients,toALL);
            */
        }else{
            toClient.setClientName(name);
            toClient.setFeedBackMessage("InvalidName");
            oos.writeObject(toClient);
        }
    }
    /*
       // in hall status
       private synchronized void inHall(Message m) throws IOException{
           if (m.getPlayerAction() == PlayerAction.JOIN_GAME){
               tableId = m.getTableId();
               join(tableId);
           }
       }


       private void join(int tableId)throws IOException{
           Message toClient = new Message();
           Message toALL = new Message();
           List<EachConnection> clients = ServerState.getClientInstance().getConnectedClients();
           List<GameRoom> gameRooms = ServerState.getGameInstance().getConnectedGames();
           int index = -1;

           switch (tableValid(tableId,gameRooms)){
               case "ValidTable":
                   index = tableIndex(tableId,gameRooms);
                   gameRooms.get(index).addPlayer(this.clientNum);
                   setClientStatus(PlayerStatus.IN_ROOM);
                   toClient.setPlayerStatus(PlayerStatus.IN_ROOM);
                   toClient.setServerAction(ServerAction.RESPONSE);
                   toClient.setPlayerList(gameRooms.get(index).getPlayerList());
                   toClient.setFeedBackMessage("ValidTable");
                   oos.writeObject(toClient);
                   break;
               case "TableNotExist":
                   GameRoom gameRoom = new GameRoom(this.clientNum,tableId);
                   // TODO- insert game into game list
                   index = tableIndex(tableId,gameRooms);
                   gameRooms.get(index).addPlayer(this.clientNum);
                   setClientStatus(PlayerStatus.IN_ROOM);
                   toClient.setPlayerStatus(PlayerStatus.IN_ROOM);
                   toClient.setServerAction(ServerAction.RESPONSE);
                   toClient.setPlayerList(gameRooms.get(index).getPlayerList());
                   toClient.setFeedBackMessage("ValidTable");
                   oos.writeObject(toClient);
                   break;
               case "InvalidTable":
                   toClient.setServerAction(ServerAction.RESPONSE);
                   toClient.setFeedBackMessage("InvalidTable");
                   oos.writeObject(toClient);
                   break;
           }
           // broadcast
           toALL.setServerAction(ServerAction.UPDATE);
           toALL.setConnectedClients(clients);
           toALL.setCreatedGames(ServerState.getGameInstance().getConnectedGames());
           broadCast(ServerState.getClientInstance().getConnectedClients(),toALL);
       }

       private String tableValid(int tableId,List<GameRoom> gameRooms){
           for (int i = 0; i < gameRooms.size(); i++) {
               if (gameRooms.get(i).getTableId()== tableId
                       && gameRooms.get(i).getNumOfPlayer() < gameRooms.get(i).getMaximumPlayerNumber()){
                   return "ValidTable";
               }else if (gameRooms.get(i).getTableId()== tableId
                       && gameRooms.get(i).getNumOfPlayer() == gameRooms.get(i).getMaximumPlayerNumber()){
                   return "InvalidTable";
               }
           }
           return "TableNotExist";
       }

       private int tableIndex(int tableId,List<GameRoom> gameRooms) {
           int index = -1;
           for (int i = 0; i < gameRooms.size(); i++) {
               if (gameRooms.get(i).getTableId() == tableId) {
                   index = i;
                   return index;
               }
           }
           return index;
       }


       // in room status
       private synchronized void inRoom(Message m) throws IOException{
           if (m.getPlayerAction() == PlayerAction.READY){
               ready();
           }
       }

       private void ready() throws IOException{
           Message toClient = new Message();
           Message toPlayers = new Message();
           int numReady= 0;
           EachConnection[] players = getPlayerList();
           GameRoom game = getCurrentGame();

           // logic part
           setClientStatus(PlayerStatus.READY);
           //check how many players are in ready condition
           for (EachConnection player : players){
               if (player.getClientStatus().equals(PlayerStatus.READY)){
                   numReady +=1;
               }
           }
           if ( (numReady == game.getNumOfPlayer()) && (numReady >= GameRoom.getMinimumPlayerNumber()) ){
               //TODO game status - all ready
               toPlayers.setPlayerStatus(PlayerStatus.IN_GAME);
               toPlayers.setPlayerAction(PlayerAction.READY);
               toPlayers.setServerAction(ServerAction.RESPONSE);
               roombroadCast(players,toPlayers);
               sequenceDecision();
           }else {
               toClient.setPlayerStatus(PlayerStatus.READY);
               toClient.setServerAction(ServerAction.RESPONSE);
               toClient.setPlayerList(game.getPlayerList());
               oos.writeObject(toClient);
               toPlayers.setServerAction(ServerAction.UPDATE);
               toPlayers.setPlayerList(game.getPlayerList());
               roombroadCast(players,toPlayers);
           }
       }

       // in game status
       private synchronized void inGame(Message m){
           switch (m.getPlayerAction()){
               case GAME_CONTENT:
                   gameContent(m);
                   break;
               case VOTING:
                   voting(m);
                   break;
               case PASS:
                   pass();
                   break;
           }
           getCurrentGame().addOneTurn();
       }

       private void sequenceDecision(){
           //return the messages that who should go first
           Message toClient = new Message();
           toClient.setServerAction(ServerAction.RESPONSE);
           toClient.setFeedBackMessage("It's your turn");
           EachConnection[] players = getPlayerList();
           GameRoom game = getCurrentGame();

           switch (game.getTotalTurn() % game.getMaximumPlayerNumber()){
               case 0:
                   players[0].write(toClient);
                   break;
               case 1:
                   players[1].write(toClient);
                   break;
               case 2:
                   players[2].write(toClient);
                   break;
               case 3:
                   players[3].write(toClient);
                   break;
           }



       }

       private void gameContent(Message m){
           EachConnection[] players = getPlayerList();
           Message toPlayers = new Message();

           toPlayers.setGameCharacter(m.getGameCharacter());
           toPlayers.setGameLocation(m.getGameLocation());
           toPlayers.setGameWord(m.getGameWord());
           toPlayers.setPlayerStatus(PlayerStatus.IN_GAME);
           toPlayers.setPlayerAction(PlayerAction.GAME_CONTENT);
           toPlayers.setServerAction(ServerAction.UPDATE);
           roombroadCast(players,toPlayers);
       }

       private void voting(Message m){
           EachConnection[] players = getPlayerList();
           GameRoom game = getCurrentGame();
           Message toPlayers = new Message();
           int votingNum = m.getVotingNum();
           game.voting(votingNum);
           toPlayers.setServerAction(ServerAction.RESPONSE);
           toPlayers.setPlayerStatus(PlayerStatus.IN_GAME);
           toPlayers.setPlayerAction(PlayerAction.VOTING);
           switch (game.votingResult()){
               case "Accpet":
                   score += m.getGameWord().length();
                   toPlayers.setFeedBackMessage("WordAccepted");
                   roombroadCast(players,toPlayers);
                   break;
               case "Reject":
                   toPlayers.setFeedBackMessage("WordRejected");
                   roombroadCast(players,toPlayers);
                   break;
               case "inProgress":
                   break;
           }
           if (!game.gameEnd()){
               sequenceDecision();
           }else{
               //TODO Game END part
               // return game result
               game.gameResult();
           }
       }

       //TODO pass logic is wrong
       private void pass(){
           EachConnection[] players = getPlayerList();
           GameRoom game = getCurrentGame();
           Message toPlayers = new Message();
           game.pass(1);
           toPlayers.setServerAction(ServerAction.RESPONSE);
           toPlayers.setPlayerStatus(PlayerStatus.IN_GAME);
           toPlayers.setPlayerAction(PlayerAction.VOTING);
           switch (game.passResult()){
               case "GameEnd":
                   toPlayers.setFeedBackMessage("GameEnd");
                   roombroadCast(players,toPlayers);
                   break;
               case "GameContinue":
                   toPlayers.setFeedBackMessage("GameContinue");
                   roombroadCast(players,toPlayers);
                   sequenceDecision();
                   break;
               case "inProgress":
                   break;
           }
       }

       */
    private void roombroadCast(EachConnection[] players,Message m){
        for (EachConnection player : players){
            player.write(m);
        }
    }

    private void broadCast(List<EachConnection> clients, Message m){
        for(EachConnection client : clients) {
            client.write(m);
        }
    }

    private synchronized void write(Message m) {
        try {
            oos.writeObject(m);
            oos.flush();
            oos.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientNum() {
        return clientNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public PlayerStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(PlayerStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    private Map<String,String> getClientLists(){
        Map<String,String> clientLists = new HashMap<>();
        List<EachConnection> clients = ServerState.getClientInstance().getConnectedClients();
        for (EachConnection client : clients){
            clientLists.put(client.getClientName(),client.getClientStatus().toString());
        }
        return clientLists;
    }

    /*
    private EachConnection[] getPlayerList (){
        List<GameRoom> gameRooms = ServerState.getGameInstance().getConnectedGames();
        int index = tableIndex(tableId,gameRooms);
        return gameRooms.get(index).getPlayerList();
    }

    private GameRoom getCurrentGame (){
        List<GameRoom> gameRooms = ServerState.getGameInstance().getConnectedGames();
        int index = tableIndex(tableId,gameRooms);
        return gameRooms.get(index);
    }
    */

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
