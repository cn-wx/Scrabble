package com;

import com.view.login.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/17 19:24
 */
public class Game extends Application {
    private static String[] namepool={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","b2","b3","c1","c2","c3"};
    private static Stage primaryStageObj;
    public static final int LoginWidth = 500;
    public static final int LoginHeight = 600;
    public static BufferedReader reader;
    public static BufferedWriter writer;
    public static Socket socket;
    public static Listener m1;
    public static boolean turn = false;
    public void start(Stage primaryStage) throws Exception {
        primaryStageObj = primaryStage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root, LoginWidth, LoginHeight);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

    public static Stage getPrimaryStage() {
        return primaryStageObj;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void connect(String host, int port){
        try{
            socket = new Socket(host, port);
            LoginController.getInstance().showUsernameScene();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            m1 = new Listener(reader);
            m1.start();
        }catch (IOException e){
            LoginController.getInstance().loginFailure("Could not connect to server");
            e.printStackTrace();
        }
    }
    public static void ready(){
        sendmsg("game|ready");
    }
    public static void sendcharacter(String character, String location, String word){
        sendmsg("setCharacter|" + character+" " + location +" "+word);
    }
    public static void passturn(){
        sendmsg("passturn");
    }
    public static void voting(String word){
        //TODO show the word
        boolean vote = true;
        //TODO get the voting result from UI.
        if (vote == true){
            sendmsg("votingresult|true");
        }
        else{
            sendmsg("votingresult|false");
        }
    }
    public static void sendmsg(String msg) {
        try {
            writer.write(msg + "\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String randomeUser(){
        Random rand = new Random();
        int i;
        i = rand.nextInt(namepool.length);
        return(namepool[i]);
    }
    public static boolean setUsername(String username){
        sendmsg(username);
        return checkValid(username);
    }
    public static boolean entryTable(String tableNumber){
        sendmsg(tableNumber);
        return checkValid(tableNumber);
    }
    public static boolean invitePlayer(String playername){
        sendmsg(playername);
        return checkValid(playername);
    }
    private static boolean checkValid(String message){
        String msg = m1.getMessage();
        StringTokenizer st = new StringTokenizer(msg, "|");
        String operation = st.nextToken();
        String receive = st.nextToken();
        while ((!receive.equals(message + "Valid")) && (!receive.equals(message + "notValid"))){
            msg = m1.getMessage();
            st = new StringTokenizer(msg, "|");
            operation = st.nextToken();
            receive = st.nextToken();
        }
        if (receive.equals(message+"Valid")){
            return true;
        }
        else{
            return false;
        }
    }
}
