package com.messages;

import com.game.GameRoom;
import com.server.EachConnection;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable{

    private List<EachConnection> connectedClients;
    private List<GameRoom> createdGames;
    private EachConnection[] playerList;
    private PlayerAction playerAction;
    private ServerAction serverAction;
    private GameStatus gameStatus;
    private PlayerStatus playerStatus;
    private Character gameCharacter;
    private String gameLocation;
    private String gameWord;
    private String clientName;
    private String feedBackMessage;
    private int clientNum;
    private int tableId;
    private int votingNum;


    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getClientNum() {
        return clientNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public PlayerAction getPlayerAction() {
        return playerAction;
    }

    public void setPlayerAction(PlayerAction playerAction) {
        this.playerAction = playerAction;
    }

    public Character getGameCharacter() {
        return gameCharacter;
    }

    public void setGameCharacter(Character gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getFeedBackMessage() {
        return feedBackMessage;
    }

    public void setFeedBackMessage(String feedBackMessage) {
        this.feedBackMessage = feedBackMessage;
    }
    public List<EachConnection> getConnectedClients() {
        return connectedClients;
    }

    public void setConnectedClients(List<EachConnection> connectedClients) {
        this.connectedClients = connectedClients;
    }

    public List<GameRoom> getCreatedGames() {
        return createdGames;
    }

    public void setCreatedGames(List<GameRoom> createdGames) {
        this.createdGames = createdGames;
    }

    public ServerAction getServerAction() {
        return serverAction;
    }

    public void setServerAction(ServerAction serverAction) {
        this.serverAction = serverAction;
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

    public void setVotingNum(int votingNum) {
        this.votingNum = votingNum;
    }
}
