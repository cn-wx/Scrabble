package com.view.table;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/23 23:45
 */
public class ReadyController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void allReady(){
        TableController.getInstance().getReadyStage().close();
    }
}
