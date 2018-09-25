package com.game;

import com.messages.Message;
import com.server.EachConnection;
import com.server.ServerState;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class GameRoom{
    // assuming there are up to 4 players
    private static int MAXIMUM_PLAYER_NUMBER = 4;
    private static int MINIMUM_PLAYER_NUMBER = 2;
    // tracking number of total players in one game room
    private int numOfPlayer;
    private int tableId;
    private EachConnection[] playerList = new EachConnection[MAXIMUM_PLAYER_NUMBER];
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int votingNum = 0;
    private int spaceRemain = 400;
    private int turnNum = 0;
    private int passNum = 0;
    private int totalTurn = 0;

    public GameRoom(int clientNum, int tableId) {
        addPlayer(clientNum);
        this.tableId = tableId;
    }

    public void addPlayer(int clientNum){
        List<EachConnection> clients = ServerState.getClientInstance().getConnectedClients();
        for (EachConnection client : clients){
            if (client.getClientNum() == clientNum){
                playerList[numOfPlayer] = client;
            }
        }
        this.numOfPlayer+=1;
    }

    public void deletePlayer(int clientNum){
        int index = indexOf(clientNum);
        if (index != -1){
            playerList[index] = null;
            for (int x = 0; x < numOfPlayer ; x++) {
                if(x>=index){
                    playerList[x] = playerList[x+1];
                }
            }
        }
        this.numOfPlayer-=1;
    }

    private int indexOf(int clientNum){
        for (int i = 0; i <numOfPlayer ; i++) {
            if (playerList[i].getClientNum() == clientNum){
                return i;
            }
        }
        return -1;
    }

    public String votingResult(){
        if (turnNum == 4 && votingNum == MAXIMUM_PLAYER_NUMBER){
            setTurnNum(0);
            return "Accept";
        }else if (turnNum == 4 && votingNum != MAXIMUM_PLAYER_NUMBER){
            setTurnNum(0);
            return "Reject";
        }else{
            return "inProgress";
        }
    }

    public String passResult(){
        if (turnNum == 4 && passNum == MAXIMUM_PLAYER_NUMBER){
            setTurnNum(0);
            return "GameEnd";
        }else if (turnNum == 4 && passNum != MAXIMUM_PLAYER_NUMBER){
            setTurnNum(0);
            return "GameContinue";
        }else{
            return "inProgress";
        }
    }



    public boolean gameEnd(){
        if (numOfPlayer < MINIMUM_PLAYER_NUMBER || spaceRemain == 0){
            return true;
        }
        return false;
    }

    //TODO gameResult format
    public void gameResult(){

    }


    public int getTableId() {
        return tableId;
    }

    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    public static int getMaximumPlayerNumber() {
        return MAXIMUM_PLAYER_NUMBER;
    }

    public static int getMinimumPlayerNumber() {
        return MINIMUM_PLAYER_NUMBER;
    }

    public void setNumOfPlayer(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getSpaceRemain() {
        return spaceRemain;
    }

    public void setSpaceRemain(int spaceRemain) {
        this.spaceRemain = spaceRemain;
    }

    public EachConnection[] getPlayerList() {
        return playerList;
    }

    public void setPlayerList(EachConnection[] playerList) {
        this.playerList = playerList;
    }

    public int getVotingNum() {
        return votingNum;
    }

    public void voting(int votingNum) {
        this.votingNum += votingNum;
        this.turnNum += 1;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public int getPassNum() {
        return passNum;
    }

    public void pass(int passNum) {
        this.passNum += passNum;
        this.turnNum += 1;
    }

    public int getTotalTurn() {
        return totalTurn;
    }

    public void setTotalTurn(int totalTurn) {
        this.totalTurn = totalTurn;
    }

    public void addOneTurn(){
        this.totalTurn += 1;
    }
}
