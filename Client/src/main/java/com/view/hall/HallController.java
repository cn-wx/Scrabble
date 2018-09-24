package com.view.hall;

import com.Game;
import com.model.player.Player;
import com.view.table.TableController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/18 2:19
 */
public class HallController implements Initializable {

    @FXML private BorderPane borderPane;
    @FXML private TableView<Player> playerList;
    @FXML private TableColumn username;
    @FXML private TableColumn status;
    @FXML private void handleButton1() throws IOException {enterTable(1);}
    @FXML private void handleButton2() throws IOException {enterTable(2);}
    @FXML private void handleButton3() throws IOException {enterTable(3);}
    @FXML private void handleButton4() throws IOException {enterTable(4);}
    @FXML private void handleButton5() throws IOException {enterTable(5);}
    @FXML private void handleButton6() throws IOException {enterTable(6);}
    @FXML private void handleButton7() throws IOException {enterTable(7);}
    @FXML private void handleButton8() throws IOException {enterTable(8);}
    @FXML private void handleButton9() throws IOException {enterTable(9);}
    @FXML private void handleButton10() throws IOException {enterTable(10);}
    @FXML private void handleButton11() throws IOException {enterTable(11);}
    @FXML private void handleButton12() throws IOException {enterTable(12);}

    public static final int HallWidth = 1100;
    public static final int HallHeight = 800;
    public static ObservableList<Player> data = FXCollections.observableArrayList();
    public static TableController tableController;
    private double xOffset;
    private double yOffset;
    public Scene scene;
    private static HallController instance;
    private static Stage stage;
    public static String tableNumber;

    public HallController() {
        instance = this;
    }

    public static HallController getInstance() {
        return instance;
    }

    public static Stage getStage() {
        return stage;
    }

    public void updateStatus(Player player) {
        data.add(player);
        playerList.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Drag and Drop animation
        //<editor-fold defaultstate="collapsed" desc=" Drag and Drop">
        borderPane.setOnMousePressed(event -> {
            xOffset = Game.getPrimaryStage().getX() - event.getScreenX();
            yOffset = Game.getPrimaryStage().getY() - event.getScreenY();
            borderPane.setCursor(javafx.scene.Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            Game.getPrimaryStage().setX(event.getScreenX() + xOffset);
            Game.getPrimaryStage().setY(event.getScreenY() + yOffset);

        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    // Terminates Application
    public void closeSystem(){
        Platform.exit();
        System.exit(0);
    }

    // Minimize Window
    public void minimizeWindow(){
        Game.getPrimaryStage().setIconified(true);
    }

    private void enterTable(int tableName) throws IOException{
        tableNumber = "Table "+String.valueOf(tableName);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/table.fxml"));
        Parent window = (Pane) fxmlLoader.load();
        tableController = fxmlLoader.getController();
        tableController.title.setText(tableNumber);

        // TODO - enter the table (?)
        // code for showing the 'game Table':   " HallController.getInstance().showTable(); "
        // comment "showTable()" below after implementing Listener
        showTable();

        Game.getPrimaryStage().hide();
        this.scene = new Scene(window);

    }

    private void showTable(){
        Platform.runLater(() -> {
            stage = new Stage();
            stage.setResizable(false);
            stage.setWidth(TableController.TableWidth);
            stage.setHeight(TableController.TableHeight);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setOnCloseRequest((WindowEvent e) -> Game.getPrimaryStage().show());
            stage.setScene(this.scene);
            stage.centerOnScreen();
            stage.show();
            // Show ready stage
            try {
                TableController.getInstance().showReadyStage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
