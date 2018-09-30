package com.game;

import com.server.EachConnection;
import com.server.ServerState;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class GameRoom {
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
    private Map<String, String> playerStatus = new HashMap();
    private String[] board;
    private Map<String, Integer> playerScore = new HashMap();
    private boolean gameStart = false;

    public GameRoom(int clientNum, int tableId) {
        addPlayer(clientNum);
        initialBoard();
        this.tableId = tableId;
    }

    public void initialGame() {
        addOneTurn();
        for (String key : playerStatus.keySet()) {
            playerStatus.replace(key, "NotTurn");
        }
        playerStatus.replace(playerList[0].getClientName(), "Turn");
    }

    public void initialBoard() {
        board = new String[400];
        for (int i = 0; i < 400; i++) {
            board[i] = "0";
        }
    }

    public void addCharacter(int index, String character) {
        board[index] = character;
    }

    public String[] getBoard() {
        return board;
    }

    public void setPlayerScore(String name, Integer score) {
        playerScore.replace(name, score);
    }

    public Map<String, Integer> getPlayerScore() {
        return playerScore;
    }

    public void addPlayer(int clientNum) {
        List<EachConnection> clients = ServerState.getClientInstance().getConnectedClients();
        for (EachConnection client : clients) {
            if (client.getClientNum() == clientNum) {
                playerList[numOfPlayer] = client;
                playerStatus.put(client.getClientName(), "NotReady");
                playerScore.put(client.getClientName(), 0);
            }
        }
        this.numOfPlayer += 1;
    }

    public void deletePlayer(int clientNum, String name) {
        int index = indexOf(clientNum);
        playerStatus.remove(name);
        playerScore.remove(name);
        if (index != -1) {
            playerList[index] = null;
            for (int x = 0; x < numOfPlayer; x++) {
                if (x >= index) {
                    playerList[x] = playerList[x + 1];
                }
            }
        }
        this.numOfPlayer -= 1;
    }

    public void playerReady(String name) {
        playerStatus.replace(name, "Ready");
    }

    public void turnPass() {
        int index = totalTurn % numOfPlayer - 1;
        playerTurn(playerList[index].getClientName());
    }

    public void playerTurn(String name) {
        playerStatus.replace(name, "Turn");
        for (String key : playerStatus.keySet()) {
            if (!key.equals(name)) {
                playerStatus.replace(key, "NotTurn");
            }
        }
    }

    public Map getPlayerStatus() {
        return playerStatus;
    }

    private int indexOf(int clientNum) {
        for (int i = 0; i < numOfPlayer; i++) {
            if (playerList[i].getClientNum() == clientNum) {
                return i;
            }
        }
        return -1;
    }

    public String votingResult() {
        if (turnNum == 4 && votingNum == MAXIMUM_PLAYER_NUMBER) {
            setTurnNum(0);
            return "Accept";
        } else if (turnNum == 4 && votingNum != MAXIMUM_PLAYER_NUMBER) {
            setTurnNum(0);
            return "Reject";
        } else {
            return "inProgress";
        }
    }

    public String passResult() {
        if (turnNum == 4 && passNum == MAXIMUM_PLAYER_NUMBER) {
            setTurnNum(0);
            return "GameEnd";
        } else if (turnNum == 4 && passNum != MAXIMUM_PLAYER_NUMBER) {
            setTurnNum(0);
            return "GameContinue";
        } else {
            return "inProgress";
        }
    }


    public boolean gameEnd() {
        if (numOfPlayer < MINIMUM_PLAYER_NUMBER || spaceRemain == 0) {
            return true;
        }
        return false;
    }

    //TODO gameResult format
    public Map<String, Integer> gameResult() {
        EachConnection[] ranks = new EachConnection[numOfPlayer];
        System.arraycopy(playerList, 0, ranks, 0, numOfPlayer);
        Arrays.sort(ranks, new descComparator());               // ranking on DESC
        int rank = 1;
        Map<String, Integer> resultF = new HashMap<>();
        for (int i = 0; i < numOfPlayer; i++) {
            if (ranks[i].getScore() > ranks[i].getScore()) {
                resultF.put(ranks[i].getClientName(), rank);
                rank += 1;
            } else {
                resultF.put(ranks[i].getClientName(), rank);
            }
        }
        return resultF;
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

    public void voting() {
        this.votingNum += 1;
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

    public void pass() {
        addOneTurn();
        this.passNum += 1;
        this.turnNum += 1;
    }

    public int getTotalTurn() {
        return totalTurn;
    }

    public void setTotalTurn(int totalTurn) {
        this.totalTurn = totalTurn;
    }

    public void addOneTurn() {
        this.totalTurn += 1;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    private int nameCompare(String s1, String s2) {   // method using for customized comparison functions below
        int bigger = 1, smaller = -1, equal = 0;
        if (s1.compareTo(s2) > 0)
            return bigger;
        else if (s1.compareTo(s2) < 0)
            return smaller;
        return equal;
    }

    private int winRateCompare(double w1, double w2) { // method using for customized comparison functions below
        int bigger = 1, smaller = -1, equal = 0;
        if (w1 > w2)
            return bigger;
        else if (w1 < w2)
            return smaller;
        return equal;
    }


    class descComparator implements Comparator<EachConnection> {
        int equal = 0, reverse = -1;
        // comparison function using for sort array in descending order
        @Override
        public int compare(EachConnection p1, EachConnection p2) {
            int value = winRateCompare(p1.getScore(), p2.getClientNum());
            if (value == equal)         // if win rate is equal, sort in alphabetical order
                return nameCompare(p1.getClientName(), p2.getClientName());
            return value * (reverse);     // reverse the value return from ascComparator and get desc one
        }
    }
}