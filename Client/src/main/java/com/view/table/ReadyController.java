package com.view.table;

import com.Game;
import com.view.hall.HallController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/23 23:45
 */
public class ReadyController implements Initializable {
    @FXML private BorderPane borderPane;
    private double xOffset;
    private double yOffset;
    @FXML public Label title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drag and Drop animation
        //<editor-fold defaultstate="collapsed" desc=" Drag and Drop">
        borderPane.setOnMousePressed(event -> {
            xOffset = HallController.getStage().getX() - event.getScreenX();
            yOffset = HallController.getStage().getY() - event.getScreenY();
            borderPane.setCursor(Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            HallController.getStage().setX(event.getScreenX() + xOffset);
            HallController.getStage().setY(event.getScreenY() + yOffset);
            TableController.getInstance().getReadyStage().setX(event.getScreenX() + xOffset);
            TableController.getInstance().getReadyStage().setY(event.getScreenY() + yOffset);
        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>
    }

    @FXML
    private void ready(){
        TableController.getInstance().getReadyStage().close();
        //TODO - send to server (playerAction = ready)
    }

    @FXML
    private void invite(){
        //TODO - invite
    }

    // return to game hall
    public void returnHall() {
        HallController.getStage().close();
        Game.getPrimaryStage().show();
        //TODO - send to server (playerStatus = inHall)
    }

    // Minimize Window
    public void minimizeWindow(){
        HallController.getStage().setIconified(true);
        TableController.getInstance().getReadyStage().setIconified(true);
    }
}
