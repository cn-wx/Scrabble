package com;

import java.io.BufferedReader;
import java.net.SocketException;
import java.util.StringTokenizer;

public class Listener extends Thread {

    private BufferedReader reader;
    private String msg = null;
    public Listener(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {

        try {
            //Read messages from the server while the end of the stream is not reached
            while((msg = reader.readLine()) != null) {
                //Print the messages to the console
                System.out.println(msg);
                StringTokenizer st = new StringTokenizer(msg, "|");
                String operation = st.nextToken();
                String msg = st.nextToken();
                if (operation.equals("hallplayer")){
                    //TODO referesh playerlist
                }
                if (operation.equals("halltable")){
                    //TODO referesh table list
                }
                if (operation.equals("gameplay")){
                    //TODO referesh game playerlist
                }
                if (operation.equals("voting")){
                    Game.voting(msg);
                }
                if (operation.equals("gamestart")){
                    //TODO show game start message
                }
                if (operation.equals("turn")){
                    if (msg.equals("yourturn")){
                        Game.turn = true;
                    }
                    else{
                        Game.turn =false;
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket closed because the user typed exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getMessage(){
        return msg;
    }
}