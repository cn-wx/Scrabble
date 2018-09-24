package com.server;

import java.util.ArrayList;
import java.util.List;

import com.game.GameRoom;

// TODO - add gamelist !!!
public class ServerState {

    private static ServerState clientInstance;
    private static ServerState gameInstance;
    private List<EachConnection> connectedClients;
    private List<GameRoom> createdGames;
    public static ArrayList UserList = new ArrayList();

    private ServerState() {
        connectedClients = new ArrayList<>();
        createdGames = new ArrayList<>();
    }

    public static synchronized ServerState getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new ServerState();
        }
        return gameInstance;
    }

    public synchronized void gameConnected(GameRoom client) {
        createdGames.add(client);
    }

    public synchronized void clientDisconnected(GameRoom client) {
        createdGames.remove(client);
    }

    public synchronized List<GameRoom> getConnectedGames() {
        return createdGames;
    }


    public static synchronized ServerState getClientInstance() {
        if (clientInstance == null) {
            clientInstance = new ServerState();
        }
        return clientInstance;
    }

    public synchronized void clientConnected(EachConnection client) {
        connectedClients.add(client);
    }

    public synchronized void clientDisconnected(EachConnection client) {
        connectedClients.remove(client);
    }

    public synchronized List<EachConnection> getConnectedClients() {
        return connectedClients;
    }
}
