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
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import com.messages.*;
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
    public static InputStream in;
    public static OutputStream out;
    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;
    public static Socket socket;
    public static boolean turn = false;
    public static Listener m1;
//    public static Message msg = null;


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
            out = socket.getOutputStream();
            oos = new ObjectOutputStream(out);
            in = socket.getInputStream();
            ois = new ObjectInputStream(in);
            m1 = new Listener(ois);
            m1.start();
        }catch (IOException e){
            LoginController.getInstance().loginFailure("Could not connect to server");
            e.printStackTrace();
        }
    }
//    public static void ready(){
//        sendmsg("game|ready");
//    }
//    public static void sendcharacter(String character, String location, String word){
//        sendmsg("setCharacter|" + character+" " + location +" "+word);
//    }
//    public static void passturn(){
//        sendmsg("passturn");
//    }
//    public static void voting(String word){
//        //TODO show the word
//        boolean vote = true;
//        //TODO get the voting result from UI.
//        if (vote == true){
//            sendmsg("votingresult|true");
//        }
//        else{
//            sendmsg("votingresult|false");
//        }
//    }
    public static void sendmsg(Message msg) {
        try {
            oos.writeObject(msg);
            oos.flush();
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
    public static void setUsername(String username){
        Message message = new Message();
        message.setPlayerStatus(PlayerStatus.SET_NAME);
        message.setClientName(username);
        sendmsg(message);
    }
//    public static boolean entryTable(String tableNumber){
//        sendmsg(tableNumber);
//        return checkValid(tableNumber);
//    }
//    public static boolean invitePlayer(String playername){
//        sendmsg(playername);
//        return checkValid(playername);
//    }
//    private static boolean checkValid(String username) {
//        Message message = new Message();
//        message = m1.getMessage();
//        System.out.print(message);
//        while ((message.getPlayerStatus() != PlayerStatus.SET_NAME) && (!message.getClientName().equals(username))) {
//            message = m1.getMessage();
//        }
//        if (message.getFeedBackMessage().equals("ValidName")) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
