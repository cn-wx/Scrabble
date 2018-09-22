package com.server;

import com.game.GameRoom;
import com.messages.GameStatus;
import com.messages.Message;
import com.messages.PlayerAction;
import com.messages.PlayerStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EachConnection implements Runnable {

    private static GameRoom game;
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
    static Logger logger = LoggerFactory.getLogger(EachConnection.class);
    private Map<String, String> listToSend = new HashMap<String, String>();



    public EachConnection(Socket clientSocket, int clientNum) {
        this.clientSocket = clientSocket;
        this.clientNum = clientNum;
    }


    // listening from client messages
    @Override
    public void run() {

        try {
            in = clientSocket.getInputStream();
            ois = new ObjectInputStream(in);

            out = clientSocket.getOutputStream();
            oos = new ObjectOutputStream(out);

            while (clientSocket.isConnected()){
                Message clientMsg = (Message) ois.readObject();

                //TODO - Ethan & Eric
                if (clientMsg != null){
                    switch (clientMsg.getPlayerStatus()){
                        case SET_NAME:
                            inSetName(clientMsg);
                            break;
                        case IN_HALL:
                            inHall(clientMsg);
                            break;
                        case IN_ROOM:
                            inRoom(clientMsg);
                            break;
                        case IN_GAME:
                            ingame(clientMsg);
                            break;
                    }
                }

            }
        } catch (SocketException socketException){
            logger.info("Client on port " + clientSocket.getPort() + " exited.");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // in setName status
    private synchronized void inSetName (Message m){
        String name = m.getClientName();
        nameCheck(name);
    }

    private void nameCheck(String name){
        Message toClient = new Message();
    /*
    if valid
       m2Client sets userlist,gamelist and a confirm messages
       write

       send  the name to the global name list
    else
        set non-valid m
        write
     */
    }


    // in hall status
    // inHall 的话，需不需要先判断一下，如果玩家操作是JoinGame再加入table , 然后再告诉所有玩家xxx进入了大厅?（看完可删掉此注释）
    private synchronized void inHall(Message m){
        List<EachConnection> clients = ServerState.getInstance().getConnectedClients();

        if (m.getPlayerAction() == PlayerAction.JOIN_GAME){
            int tableId = m.getTableId();
            join(tableId);
            m.setPlayerStatus(PlayerStatus.IN_ROOM);
            broadCast(clients);
        }
    }



    private void join(int tableId){

        // if player is connected & table is not full (maximum 4 players)
        if (game.getNumOfPlayer()<4){
            game.addPlayer(this.clientNum);
            setClientStatus(PlayerStatus.IN_ROOM);
        }
        //change status
        // game not exist
        game = new GameRoom(this.clientNum,tableId);
        // set non-valid m
        //
    }

    // in room status
    private synchronized void inRoom(Message m){
        List<EachConnection> clients = ServerState.getInstance().getConnectedClients();
        if (m.getPlayerAction() == PlayerAction.READY){
            ready();
            m.setPlayerStatus(PlayerStatus.READY);
            //TODO - 准备消息是不是只告诉在一个房间内的玩家 (?)
            broadCast(clients);
        }
    }

    private void ready(){
        // variables
        int numReady= 0;
        EachConnection[] players = game.getPlayerList();

        // logic part
        // change status
        setClientStatus(PlayerStatus.READY);
        roombroadCast();
        //check how many players are in ready condition

        for (EachConnection player : players){
            if (player.getClientStatus().equals(PlayerStatus.READY)){
                numReady +=1;
            }
        }
        if ( (numReady == game.getNumOfPlayer()) && (numReady >= GameRoom.getMinimumPlayerNumber()) ){
            roombroadCast();
            //TODO - start game
        }

    }

    // in game status

    private synchronized void ingame(Message m){
        switch (m.getPlayerAction()){
            case GAME_CONTENT:
                gameContent(m);
                break;
            case VOTING:
                voting();
                break;
            case PASS:
                pass();
                break;
        }
    }

    private void sequenceDecision(){
        //return the messages that who should go first
    }

    private void gameContent(Message m){
        Character Gamecharacter = m.getGameCharacter();
        String Gamelocation = m.getGameLocation();
        String Gameword = m.getGameWord();
        roombroadCast();
    }

    private void voting(){
        // if one N
        //  write "Player X loses this turn"
        if (!game.gameEnd()){
            sequenceDecision();
        }

        // else{
        //    change score and broadcast
        if (!game.gameEnd()){
            sequenceDecision();
        }
        game.gameResult();
    }

    private void pass(){
        // check number of pass numbers
        // == K, then end game
        roombroadCast();
    }
    private void roombroadCast(){
        EachConnection[] players = game.getPlayerList();

        Message m = new Message();
        for (EachConnection player : players){
            player.write(m);
        }
    }

    private void broadCast(List<EachConnection> clients){
        Message m = new Message();
        for(EachConnection client : clients) {
            client.write(m);
        }
    }


    public synchronized void write(Message m) {
        try {
            oos.writeObject(m);
            oos.flush();
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


}
