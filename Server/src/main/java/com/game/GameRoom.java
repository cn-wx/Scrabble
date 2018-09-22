package com.game;

import com.messages.Message;
import com.messages.PlayerStatus;
import com.server.EachConnection;
import com.server.ServerState;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class GameRoom{
    // assuming there are up to 10 players
    private static int MAXIMUM_PLAYER_NUMBER = 10;
    private static int MINIMUM_PLAYER_NUMBER = 2;
    // tracking number of total players in one game room
    private int numOfPlayer;
    private int tableId;
    private EachConnection[] playerList = new EachConnection[MAXIMUM_PLAYER_NUMBER];
    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int spaceRemain = 400;

    public GameRoom(int clientNum, int tableId) {
        addPlayer(clientNum);
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }
    public int getNumOfPlayer() {
        return numOfPlayer;
    }

    // TODO - listening from clients' game info

    public void addPlayer(int clientNum){
        List<EachConnection> clients = ServerState.getInstance().getConnectedClients();
        for (EachConnection client : clients){
            if (client.getClientNum() == clientNum){
                playerList[numOfPlayer] = client;
            }
        }
        this.numOfPlayer+=1;
    }

    public void deletePlayer(Message m){
        int index = indexOf(m.getClientNum());
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

    public boolean gameEnd(){
        if (numOfPlayer < MINIMUM_PLAYER_NUMBER || spaceRemain == 0){
            return true;
        }
        return false;
    }

    //TODO gameResult format
    public void gameResult(){

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
}
