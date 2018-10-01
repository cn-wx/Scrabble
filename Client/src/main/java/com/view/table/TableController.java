package com.view.table;

import com.Game;
import com.view.hall.HallController;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @author xuwang < xuwang2@student.unimelb.edu.au >
 * @id 979895
 * @date 2018/9/17 19:26
 */
public class TableController implements Initializable{

    public static String[] board = new String[400];
    public static final int TableWidth = 1100;
    public static final int TableHeight = 825;
    private double xOffset;
    private double yOffset;
    //<editor-fold defaultstate="collapsed" desc="// initialize for game board (Do not open)" (P.S. this work is exhausting) >
    @FXML private BorderPane borderPane;
    @FXML public Label title;
    @FXML private Label player1Name;
    @FXML private Label player1Score;
    @FXML public Label player1Ready;
    @FXML private ImageView player1Turn;
    @FXML private Label player2Name;
    @FXML private Label player2Score;
    @FXML private Label player2Ready;
    @FXML private ImageView player2Turn;
    @FXML private Label player3Name;
    @FXML private Label player3Score;
    @FXML private Label player3Ready;
    @FXML private ImageView player3Turn;
    @FXML private Label player4Name;
    @FXML private Label player4Score;
    @FXML private Label player4Ready;
    @FXML private ImageView player4Turn;
    @FXML private TextField T0;
    @FXML private TextField T1;
    @FXML private TextField T2;
    @FXML private TextField T3;
    @FXML private TextField T4;
    @FXML private TextField T5;
    @FXML private TextField T6;
    @FXML private TextField T7;
    @FXML private TextField T8;
    @FXML private TextField T9;
    @FXML private TextField T10;
    @FXML private TextField T11;
    @FXML private TextField T12;
    @FXML private TextField T13;
    @FXML private TextField T14;
    @FXML private TextField T15;
    @FXML private TextField T16;
    @FXML private TextField T17;
    @FXML private TextField T18;
    @FXML private TextField T19;
    @FXML private TextField T20;
    @FXML private TextField T21;
    @FXML private TextField T22;
    @FXML private TextField T23;
    @FXML private TextField T24;
    @FXML private TextField T25;
    @FXML private TextField T26;
    @FXML private TextField T27;
    @FXML private TextField T28;
    @FXML private TextField T29;
    @FXML private TextField T30;
    @FXML private TextField T31;
    @FXML private TextField T32;
    @FXML private TextField T33;
    @FXML private TextField T34;
    @FXML private TextField T35;
    @FXML private TextField T36;
    @FXML private TextField T37;
    @FXML private TextField T38;
    @FXML private TextField T39;
    @FXML private TextField T40;
    @FXML private TextField T41;
    @FXML private TextField T42;
    @FXML private TextField T43;
    @FXML private TextField T44;
    @FXML private TextField T45;
    @FXML private TextField T46;
    @FXML private TextField T47;
    @FXML private TextField T48;
    @FXML private TextField T49;
    @FXML private TextField T50;
    @FXML private TextField T51;
    @FXML private TextField T52;
    @FXML private TextField T53;
    @FXML private TextField T54;
    @FXML private TextField T55;
    @FXML private TextField T56;
    @FXML private TextField T57;
    @FXML private TextField T58;
    @FXML private TextField T59;
    @FXML private TextField T60;
    @FXML private TextField T61;
    @FXML private TextField T62;
    @FXML private TextField T63;
    @FXML private TextField T64;
    @FXML private TextField T65;
    @FXML private TextField T66;
    @FXML private TextField T67;
    @FXML private TextField T68;
    @FXML private TextField T69;
    @FXML private TextField T70;
    @FXML private TextField T71;
    @FXML private TextField T72;
    @FXML private TextField T73;
    @FXML private TextField T74;
    @FXML private TextField T75;
    @FXML private TextField T76;
    @FXML private TextField T77;
    @FXML private TextField T78;
    @FXML private TextField T79;
    @FXML private TextField T80;
    @FXML private TextField T81;
    @FXML private TextField T82;
    @FXML private TextField T83;
    @FXML private TextField T84;
    @FXML private TextField T85;
    @FXML private TextField T86;
    @FXML private TextField T87;
    @FXML private TextField T88;
    @FXML private TextField T89;
    @FXML private TextField T90;
    @FXML private TextField T91;
    @FXML private TextField T92;
    @FXML private TextField T93;
    @FXML private TextField T94;
    @FXML private TextField T95;
    @FXML private TextField T96;
    @FXML private TextField T97;
    @FXML private TextField T98;
    @FXML private TextField T99;
    @FXML private TextField T100;
    @FXML private TextField T101;
    @FXML private TextField T102;
    @FXML private TextField T103;
    @FXML private TextField T104;
    @FXML private TextField T105;
    @FXML private TextField T106;
    @FXML private TextField T107;
    @FXML private TextField T108;
    @FXML private TextField T109;
    @FXML private TextField T110;
    @FXML private TextField T111;
    @FXML private TextField T112;
    @FXML private TextField T113;
    @FXML private TextField T114;
    @FXML private TextField T115;
    @FXML private TextField T116;
    @FXML private TextField T117;
    @FXML private TextField T118;
    @FXML private TextField T119;
    @FXML private TextField T120;
    @FXML private TextField T121;
    @FXML private TextField T122;
    @FXML private TextField T123;
    @FXML private TextField T124;
    @FXML private TextField T125;
    @FXML private TextField T126;
    @FXML private TextField T127;
    @FXML private TextField T128;
    @FXML private TextField T129;
    @FXML private TextField T130;
    @FXML private TextField T131;
    @FXML private TextField T132;
    @FXML private TextField T133;
    @FXML private TextField T134;
    @FXML private TextField T135;
    @FXML private TextField T136;
    @FXML private TextField T137;
    @FXML private TextField T138;
    @FXML private TextField T139;
    @FXML private TextField T140;
    @FXML private TextField T141;
    @FXML private TextField T142;
    @FXML private TextField T143;
    @FXML private TextField T144;
    @FXML private TextField T145;
    @FXML private TextField T146;
    @FXML private TextField T147;
    @FXML private TextField T148;
    @FXML private TextField T149;
    @FXML private TextField T150;
    @FXML private TextField T151;
    @FXML private TextField T152;
    @FXML private TextField T153;
    @FXML private TextField T154;
    @FXML private TextField T155;
    @FXML private TextField T156;
    @FXML private TextField T157;
    @FXML private TextField T158;
    @FXML private TextField T159;
    @FXML private TextField T160;
    @FXML private TextField T161;
    @FXML private TextField T162;
    @FXML private TextField T163;
    @FXML private TextField T164;
    @FXML private TextField T165;
    @FXML private TextField T166;
    @FXML private TextField T167;
    @FXML private TextField T168;
    @FXML private TextField T169;
    @FXML private TextField T170;
    @FXML private TextField T171;
    @FXML private TextField T172;
    @FXML private TextField T173;
    @FXML private TextField T174;
    @FXML private TextField T175;
    @FXML private TextField T176;
    @FXML private TextField T177;
    @FXML private TextField T178;
    @FXML private TextField T179;
    @FXML private TextField T180;
    @FXML private TextField T181;
    @FXML private TextField T182;
    @FXML private TextField T183;
    @FXML private TextField T184;
    @FXML private TextField T185;
    @FXML private TextField T186;
    @FXML private TextField T187;
    @FXML private TextField T188;
    @FXML private TextField T189;
    @FXML private TextField T190;
    @FXML private TextField T191;
    @FXML private TextField T192;
    @FXML private TextField T193;
    @FXML private TextField T194;
    @FXML private TextField T195;
    @FXML private TextField T196;
    @FXML private TextField T197;
    @FXML private TextField T198;
    @FXML private TextField T199;
    @FXML private TextField T200;
    @FXML private TextField T201;
    @FXML private TextField T202;
    @FXML private TextField T203;
    @FXML private TextField T204;
    @FXML private TextField T205;
    @FXML private TextField T206;
    @FXML private TextField T207;
    @FXML private TextField T208;
    @FXML private TextField T209;
    @FXML private TextField T210;
    @FXML private TextField T211;
    @FXML private TextField T212;
    @FXML private TextField T213;
    @FXML private TextField T214;
    @FXML private TextField T215;
    @FXML private TextField T216;
    @FXML private TextField T217;
    @FXML private TextField T218;
    @FXML private TextField T219;
    @FXML private TextField T220;
    @FXML private TextField T221;
    @FXML private TextField T222;
    @FXML private TextField T223;
    @FXML private TextField T224;
    @FXML private TextField T225;
    @FXML private TextField T226;
    @FXML private TextField T227;
    @FXML private TextField T228;
    @FXML private TextField T229;
    @FXML private TextField T230;
    @FXML private TextField T231;
    @FXML private TextField T232;
    @FXML private TextField T233;
    @FXML private TextField T234;
    @FXML private TextField T235;
    @FXML private TextField T236;
    @FXML private TextField T237;
    @FXML private TextField T238;
    @FXML private TextField T239;
    @FXML private TextField T240;
    @FXML private TextField T241;
    @FXML private TextField T242;
    @FXML private TextField T243;
    @FXML private TextField T244;
    @FXML private TextField T245;
    @FXML private TextField T246;
    @FXML private TextField T247;
    @FXML private TextField T248;
    @FXML private TextField T249;
    @FXML private TextField T250;
    @FXML private TextField T251;
    @FXML private TextField T252;
    @FXML private TextField T253;
    @FXML private TextField T254;
    @FXML private TextField T255;
    @FXML private TextField T256;
    @FXML private TextField T257;
    @FXML private TextField T258;
    @FXML private TextField T259;
    @FXML private TextField T260;
    @FXML private TextField T261;
    @FXML private TextField T262;
    @FXML private TextField T263;
    @FXML private TextField T264;
    @FXML private TextField T265;
    @FXML private TextField T266;
    @FXML private TextField T267;
    @FXML private TextField T268;
    @FXML private TextField T269;
    @FXML private TextField T270;
    @FXML private TextField T271;
    @FXML private TextField T272;
    @FXML private TextField T273;
    @FXML private TextField T274;
    @FXML private TextField T275;
    @FXML private TextField T276;
    @FXML private TextField T277;
    @FXML private TextField T278;
    @FXML private TextField T279;
    @FXML private TextField T280;
    @FXML private TextField T281;
    @FXML private TextField T282;
    @FXML private TextField T283;
    @FXML private TextField T284;
    @FXML private TextField T285;
    @FXML private TextField T286;
    @FXML private TextField T287;
    @FXML private TextField T288;
    @FXML private TextField T289;
    @FXML private TextField T290;
    @FXML private TextField T291;
    @FXML private TextField T292;
    @FXML private TextField T293;
    @FXML private TextField T294;
    @FXML private TextField T295;
    @FXML private TextField T296;
    @FXML private TextField T297;
    @FXML private TextField T298;
    @FXML private TextField T299;
    @FXML private TextField T300;
    @FXML private TextField T301;
    @FXML private TextField T302;
    @FXML private TextField T303;
    @FXML private TextField T304;
    @FXML private TextField T305;
    @FXML private TextField T306;
    @FXML private TextField T307;
    @FXML private TextField T308;
    @FXML private TextField T309;
    @FXML private TextField T310;
    @FXML private TextField T311;
    @FXML private TextField T312;
    @FXML private TextField T313;
    @FXML private TextField T314;
    @FXML private TextField T315;
    @FXML private TextField T316;
    @FXML private TextField T317;
    @FXML private TextField T318;
    @FXML private TextField T319;
    @FXML private TextField T320;
    @FXML private TextField T321;
    @FXML private TextField T322;
    @FXML private TextField T323;
    @FXML private TextField T324;
    @FXML private TextField T325;
    @FXML private TextField T326;
    @FXML private TextField T327;
    @FXML private TextField T328;
    @FXML private TextField T329;
    @FXML private TextField T330;
    @FXML private TextField T331;
    @FXML private TextField T332;
    @FXML private TextField T333;
    @FXML private TextField T334;
    @FXML private TextField T335;
    @FXML private TextField T336;
    @FXML private TextField T337;
    @FXML private TextField T338;
    @FXML private TextField T339;
    @FXML private TextField T340;
    @FXML private TextField T341;
    @FXML private TextField T342;
    @FXML private TextField T343;
    @FXML private TextField T344;
    @FXML private TextField T345;
    @FXML private TextField T346;
    @FXML private TextField T347;
    @FXML private TextField T348;
    @FXML private TextField T349;
    @FXML private TextField T350;
    @FXML private TextField T351;
    @FXML private TextField T352;
    @FXML private TextField T353;
    @FXML private TextField T354;
    @FXML private TextField T355;
    @FXML private TextField T356;
    @FXML private TextField T357;
    @FXML private TextField T358;
    @FXML private TextField T359;
    @FXML private TextField T360;
    @FXML private TextField T361;
    @FXML private TextField T362;
    @FXML private TextField T363;
    @FXML private TextField T364;
    @FXML private TextField T365;
    @FXML private TextField T366;
    @FXML private TextField T367;
    @FXML private TextField T368;
    @FXML private TextField T369;
    @FXML private TextField T370;
    @FXML private TextField T371;
    @FXML private TextField T372;
    @FXML private TextField T373;
    @FXML private TextField T374;
    @FXML private TextField T375;
    @FXML private TextField T376;
    @FXML private TextField T377;
    @FXML private TextField T378;
    @FXML private TextField T379;
    @FXML private TextField T380;
    @FXML private TextField T381;
    @FXML private TextField T382;
    @FXML private TextField T383;
    @FXML private TextField T384;
    @FXML private TextField T385;
    @FXML private TextField T386;
    @FXML private TextField T387;
    @FXML private TextField T388;
    @FXML private TextField T389;
    @FXML private TextField T390;
    @FXML private TextField T391;
    @FXML private TextField T392;
    @FXML private TextField T393;
    @FXML private TextField T394;
    @FXML private TextField T395;
    @FXML private TextField T396;
    @FXML private TextField T397;
    @FXML private TextField T398;
    @FXML private TextField T399;
    //</editor-fold>
    private static TableController instance;
    private static Stage readyStage;
    private static Stage timerStage;
    public static ReadyController readyController;
    public static TimerController timerController;
    private int index;
    private static Boolean myTurn;

    public TableController(){
        instance = this;
    }

    public static TableController getInstance() {
        return instance;
    }

    public Stage getReadyStage(){
        return readyStage;
    }

    public Stage getTimerStage() {
        return timerStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //<editor-fold defaultstate="collapsed" desc="//Drag and Drop animation">
        borderPane.setOnMousePressed(event -> {
            xOffset = HallController.getStage().getX() - event.getScreenX();
            yOffset = HallController.getStage().getY() - event.getScreenY();
            borderPane.setCursor(Cursor.CLOSED_HAND);
        });

        borderPane.setOnMouseDragged(event -> {
            HallController.getStage().setX(event.getScreenX() + xOffset);
            HallController.getStage().setY(event.getScreenY() + yOffset);

        });

        borderPane.setOnMouseReleased(event -> {
            borderPane.setCursor(Cursor.DEFAULT);
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="//Initialize Player Status">

        // player name
        String emptyPlayerName = "Empty";
        player1Name.setText(emptyPlayerName);
        player2Name.setText(emptyPlayerName);
        player3Name.setText(emptyPlayerName);
        player4Name.setText(emptyPlayerName);

        //player score
        String emptyPlayerScore = "0";
        player1Score.setText(emptyPlayerScore);
        player2Score.setText(emptyPlayerScore);
        player3Score.setText(emptyPlayerScore);
        player4Score.setText(emptyPlayerScore);

        //player ready
        player1Ready.setVisible(false);
        player2Ready.setVisible(false);
        player3Ready.setVisible(false);
        player4Ready.setVisible(false);

        //player turn                                              change src to "images/true.png" to show green light
        player1Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
        player2Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
        player3Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
        player4Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));

        //</editor-fold>

        for (int i = 0; i<400; i ++){
            board[i]="";
        }
        this.setBoard(board);
    }

    public void setBoard(String[] board){
        this.board = board;
        T0.setText(board[0]);
        T1.setText(board[1]);
        T2.setText(board[2]);
        T3.setText(board[3]);
        T4.setText(board[4]);
        T5.setText(board[5]);
        T6.setText(board[6]);
        T7.setText(board[7]);
        T8.setText(board[8]);
        T9.setText(board[9]);
        T10.setText(board[10]);
        T11.setText(board[11]);
        T12.setText(board[12]);
        T13.setText(board[13]);
        T14.setText(board[14]);
        T15.setText(board[15]);
        T16.setText(board[16]);
        T17.setText(board[17]);
        T18.setText(board[18]);
        T19.setText(board[19]);
        T20.setText(board[20]);
        T21.setText(board[21]);
        T22.setText(board[22]);
        T23.setText(board[23]);
        T24.setText(board[24]);
        T25.setText(board[25]);
        T26.setText(board[26]);
        T27.setText(board[27]);
        T28.setText(board[28]);
        T29.setText(board[29]);
        T30.setText(board[30]);
        T31.setText(board[31]);
        T32.setText(board[32]);
        T33.setText(board[33]);
        T34.setText(board[34]);
        T35.setText(board[35]);
        T36.setText(board[36]);
        T37.setText(board[37]);
        T38.setText(board[38]);
        T39.setText(board[39]);
        T40.setText(board[40]);
        T41.setText(board[41]);
        T42.setText(board[42]);
        T43.setText(board[43]);
        T44.setText(board[44]);
        T45.setText(board[45]);
        T46.setText(board[46]);
        T47.setText(board[47]);
        T48.setText(board[48]);
        T49.setText(board[49]);
        T50.setText(board[50]);
        T51.setText(board[51]);
        T52.setText(board[52]);
        T53.setText(board[53]);
        T54.setText(board[54]);
        T55.setText(board[55]);
        T56.setText(board[56]);
        T57.setText(board[57]);
        T58.setText(board[58]);
        T59.setText(board[59]);
        T60.setText(board[60]);
        T61.setText(board[61]);
        T62.setText(board[62]);
        T63.setText(board[63]);
        T64.setText(board[64]);
        T65.setText(board[65]);
        T66.setText(board[66]);
        T67.setText(board[67]);
        T68.setText(board[68]);
        T69.setText(board[69]);
        T70.setText(board[70]);
        T71.setText(board[71]);
        T72.setText(board[72]);
        T73.setText(board[73]);
        T74.setText(board[74]);
        T75.setText(board[75]);
        T76.setText(board[76]);
        T77.setText(board[77]);
        T78.setText(board[78]);
        T79.setText(board[79]);
        T80.setText(board[80]);
        T81.setText(board[81]);
        T82.setText(board[82]);
        T83.setText(board[83]);
        T84.setText(board[84]);
        T85.setText(board[85]);
        T86.setText(board[86]);
        T87.setText(board[87]);
        T88.setText(board[88]);
        T89.setText(board[89]);
        T90.setText(board[90]);
        T91.setText(board[91]);
        T92.setText(board[92]);
        T93.setText(board[93]);
        T94.setText(board[94]);
        T95.setText(board[95]);
        T96.setText(board[96]);
        T97.setText(board[97]);
        T98.setText(board[98]);
        T99.setText(board[99]);
        T100.setText(board[100]);
        T101.setText(board[101]);
        T102.setText(board[102]);
        T103.setText(board[103]);
        T104.setText(board[104]);
        T105.setText(board[105]);
        T106.setText(board[106]);
        T107.setText(board[107]);
        T108.setText(board[108]);
        T109.setText(board[109]);
        T110.setText(board[110]);
        T111.setText(board[111]);
        T112.setText(board[112]);
        T113.setText(board[113]);
        T114.setText(board[114]);
        T115.setText(board[115]);
        T116.setText(board[116]);
        T117.setText(board[117]);
        T118.setText(board[118]);
        T119.setText(board[119]);
        T120.setText(board[120]);
        T121.setText(board[121]);
        T122.setText(board[122]);
        T123.setText(board[123]);
        T124.setText(board[124]);
        T125.setText(board[125]);
        T126.setText(board[126]);
        T127.setText(board[127]);
        T128.setText(board[128]);
        T129.setText(board[129]);
        T130.setText(board[130]);
        T131.setText(board[131]);
        T132.setText(board[132]);
        T133.setText(board[133]);
        T134.setText(board[134]);
        T135.setText(board[135]);
        T136.setText(board[136]);
        T137.setText(board[137]);
        T138.setText(board[138]);
        T139.setText(board[139]);
        T140.setText(board[140]);
        T141.setText(board[141]);
        T142.setText(board[142]);
        T143.setText(board[143]);
        T144.setText(board[144]);
        T145.setText(board[145]);
        T146.setText(board[146]);
        T147.setText(board[147]);
        T148.setText(board[148]);
        T149.setText(board[149]);
        T150.setText(board[150]);
        T151.setText(board[151]);
        T152.setText(board[152]);
        T153.setText(board[153]);
        T154.setText(board[154]);
        T155.setText(board[155]);
        T156.setText(board[156]);
        T157.setText(board[157]);
        T158.setText(board[158]);
        T159.setText(board[159]);
        T160.setText(board[160]);
        T161.setText(board[161]);
        T162.setText(board[162]);
        T163.setText(board[163]);
        T164.setText(board[164]);
        T165.setText(board[165]);
        T166.setText(board[166]);
        T167.setText(board[167]);
        T168.setText(board[168]);
        T169.setText(board[169]);
        T170.setText(board[170]);
        T171.setText(board[171]);
        T172.setText(board[172]);
        T173.setText(board[173]);
        T174.setText(board[174]);
        T175.setText(board[175]);
        T176.setText(board[176]);
        T177.setText(board[177]);
        T178.setText(board[178]);
        T179.setText(board[179]);
        T180.setText(board[180]);
        T181.setText(board[181]);
        T182.setText(board[182]);
        T183.setText(board[183]);
        T184.setText(board[184]);
        T185.setText(board[185]);
        T186.setText(board[186]);
        T187.setText(board[187]);
        T188.setText(board[188]);
        T189.setText(board[189]);
        T190.setText(board[190]);
        T191.setText(board[191]);
        T192.setText(board[192]);
        T193.setText(board[193]);
        T194.setText(board[194]);
        T195.setText(board[195]);
        T196.setText(board[196]);
        T197.setText(board[197]);
        T198.setText(board[198]);
        T199.setText(board[199]);
        T200.setText(board[200]);
        T201.setText(board[201]);
        T202.setText(board[202]);
        T203.setText(board[203]);
        T204.setText(board[204]);
        T205.setText(board[205]);
        T206.setText(board[206]);
        T207.setText(board[207]);
        T208.setText(board[208]);
        T209.setText(board[209]);
        T210.setText(board[210]);
        T211.setText(board[211]);
        T212.setText(board[212]);
        T213.setText(board[213]);
        T214.setText(board[214]);
        T215.setText(board[215]);
        T216.setText(board[216]);
        T217.setText(board[217]);
        T218.setText(board[218]);
        T219.setText(board[219]);
        T220.setText(board[220]);
        T221.setText(board[221]);
        T222.setText(board[222]);
        T223.setText(board[223]);
        T224.setText(board[224]);
        T225.setText(board[225]);
        T226.setText(board[226]);
        T227.setText(board[227]);
        T228.setText(board[228]);
        T229.setText(board[229]);
        T230.setText(board[230]);
        T231.setText(board[231]);
        T232.setText(board[232]);
        T233.setText(board[233]);
        T234.setText(board[234]);
        T235.setText(board[235]);
        T236.setText(board[236]);
        T237.setText(board[237]);
        T238.setText(board[238]);
        T239.setText(board[239]);
        T240.setText(board[240]);
        T241.setText(board[241]);
        T242.setText(board[242]);
        T243.setText(board[243]);
        T244.setText(board[244]);
        T245.setText(board[245]);
        T246.setText(board[246]);
        T247.setText(board[247]);
        T248.setText(board[248]);
        T249.setText(board[249]);
        T250.setText(board[250]);
        T251.setText(board[251]);
        T252.setText(board[252]);
        T253.setText(board[253]);
        T254.setText(board[254]);
        T255.setText(board[255]);
        T256.setText(board[256]);
        T257.setText(board[257]);
        T258.setText(board[258]);
        T259.setText(board[259]);
        T260.setText(board[260]);
        T261.setText(board[261]);
        T262.setText(board[262]);
        T263.setText(board[263]);
        T264.setText(board[264]);
        T265.setText(board[265]);
        T266.setText(board[266]);
        T267.setText(board[267]);
        T268.setText(board[268]);
        T269.setText(board[269]);
        T270.setText(board[270]);
        T271.setText(board[271]);
        T272.setText(board[272]);
        T273.setText(board[273]);
        T274.setText(board[274]);
        T275.setText(board[275]);
        T276.setText(board[276]);
        T277.setText(board[277]);
        T278.setText(board[278]);
        T279.setText(board[279]);
        T280.setText(board[280]);
        T281.setText(board[281]);
        T282.setText(board[282]);
        T283.setText(board[283]);
        T284.setText(board[284]);
        T285.setText(board[285]);
        T286.setText(board[286]);
        T287.setText(board[287]);
        T288.setText(board[288]);
        T289.setText(board[289]);
        T290.setText(board[290]);
        T291.setText(board[291]);
        T292.setText(board[292]);
        T293.setText(board[293]);
        T294.setText(board[294]);
        T295.setText(board[295]);
        T296.setText(board[296]);
        T297.setText(board[297]);
        T298.setText(board[298]);
        T299.setText(board[299]);
        T300.setText(board[300]);
        T301.setText(board[301]);
        T302.setText(board[302]);
        T303.setText(board[303]);
        T304.setText(board[304]);
        T305.setText(board[305]);
        T306.setText(board[306]);
        T307.setText(board[307]);
        T308.setText(board[308]);
        T309.setText(board[309]);
        T310.setText(board[310]);
        T311.setText(board[311]);
        T312.setText(board[312]);
        T313.setText(board[313]);
        T314.setText(board[314]);
        T315.setText(board[315]);
        T316.setText(board[316]);
        T317.setText(board[317]);
        T318.setText(board[318]);
        T319.setText(board[319]);
        T320.setText(board[320]);
        T321.setText(board[321]);
        T322.setText(board[322]);
        T323.setText(board[323]);
        T324.setText(board[324]);
        T325.setText(board[325]);
        T326.setText(board[326]);
        T327.setText(board[327]);
        T328.setText(board[328]);
        T329.setText(board[329]);
        T330.setText(board[330]);
        T331.setText(board[331]);
        T332.setText(board[332]);
        T333.setText(board[333]);
        T334.setText(board[334]);
        T335.setText(board[335]);
        T336.setText(board[336]);
        T337.setText(board[337]);
        T338.setText(board[338]);
        T339.setText(board[339]);
        T340.setText(board[340]);
        T341.setText(board[341]);
        T342.setText(board[342]);
        T343.setText(board[343]);
        T344.setText(board[344]);
        T345.setText(board[345]);
        T346.setText(board[346]);
        T347.setText(board[347]);
        T348.setText(board[348]);
        T349.setText(board[349]);
        T350.setText(board[350]);
        T351.setText(board[351]);
        T352.setText(board[352]);
        T353.setText(board[353]);
        T354.setText(board[354]);
        T355.setText(board[355]);
        T356.setText(board[356]);
        T357.setText(board[357]);
        T358.setText(board[358]);
        T359.setText(board[359]);
        T360.setText(board[360]);
        T361.setText(board[361]);
        T362.setText(board[362]);
        T363.setText(board[363]);
        T364.setText(board[364]);
        T365.setText(board[365]);
        T366.setText(board[366]);
        T367.setText(board[367]);
        T368.setText(board[368]);
        T369.setText(board[369]);
        T370.setText(board[370]);
        T371.setText(board[371]);
        T372.setText(board[372]);
        T373.setText(board[373]);
        T374.setText(board[374]);
        T375.setText(board[375]);
        T376.setText(board[376]);
        T377.setText(board[377]);
        T378.setText(board[378]);
        T379.setText(board[379]);
        T380.setText(board[380]);
        T381.setText(board[381]);
        T382.setText(board[382]);
        T383.setText(board[383]);
        T384.setText(board[384]);
        T385.setText(board[385]);
        T386.setText(board[386]);
        T387.setText(board[387]);
        T388.setText(board[388]);
        T389.setText(board[389]);
        T390.setText(board[390]);
        T391.setText(board[391]);
        T392.setText(board[392]);
        T393.setText(board[393]);
        T394.setText(board[394]);
        T395.setText(board[395]);
        T396.setText(board[396]);
        T397.setText(board[397]);
        T398.setText(board[398]);
        T399.setText(board[399]);
    }

    public String[] getBoard(){
        String[] gameBoard = new String[400];
        gameBoard[0] = T0.getText();
        gameBoard[1] = T1.getText();
        gameBoard[2] = T2.getText();
        gameBoard[3] = T3.getText();
        gameBoard[4] = T4.getText();
        gameBoard[5] = T5.getText();
        gameBoard[6] = T6.getText();
        gameBoard[7] = T7.getText();
        gameBoard[8] = T8.getText();
        gameBoard[9] = T9.getText();
        gameBoard[10] = T10.getText();
        gameBoard[11] = T11.getText();
        gameBoard[12] = T12.getText();
        gameBoard[13] = T13.getText();
        gameBoard[14] = T14.getText();
        gameBoard[15] = T15.getText();
        gameBoard[16] = T16.getText();
        gameBoard[17] = T17.getText();
        gameBoard[18] = T18.getText();
        gameBoard[19] = T19.getText();
        gameBoard[20] = T20.getText();
        gameBoard[21] = T21.getText();
        gameBoard[22] = T22.getText();
        gameBoard[23] = T23.getText();
        gameBoard[24] = T24.getText();
        gameBoard[25] = T25.getText();
        gameBoard[26] = T26.getText();
        gameBoard[27] = T27.getText();
        gameBoard[28] = T28.getText();
        gameBoard[29] = T29.getText();
        gameBoard[30] = T30.getText();
        gameBoard[31] = T31.getText();
        gameBoard[32] = T32.getText();
        gameBoard[33] = T33.getText();
        gameBoard[34] = T34.getText();
        gameBoard[35] = T35.getText();
        gameBoard[36] = T36.getText();
        gameBoard[37] = T37.getText();
        gameBoard[38] = T38.getText();
        gameBoard[39] = T39.getText();
        gameBoard[40] = T40.getText();
        gameBoard[41] = T41.getText();
        gameBoard[42] = T42.getText();
        gameBoard[43] = T43.getText();
        gameBoard[44] = T44.getText();
        gameBoard[45] = T45.getText();
        gameBoard[46] = T46.getText();
        gameBoard[47] = T47.getText();
        gameBoard[48] = T48.getText();
        gameBoard[49] = T49.getText();
        gameBoard[50] = T50.getText();
        gameBoard[51] = T51.getText();
        gameBoard[52] = T52.getText();
        gameBoard[53] = T53.getText();
        gameBoard[54] = T54.getText();
        gameBoard[55] = T55.getText();
        gameBoard[56] = T56.getText();
        gameBoard[57] = T57.getText();
        gameBoard[58] = T58.getText();
        gameBoard[59] = T59.getText();
        gameBoard[60] = T60.getText();
        gameBoard[61] = T61.getText();
        gameBoard[62] = T62.getText();
        gameBoard[63] = T63.getText();
        gameBoard[64] = T64.getText();
        gameBoard[65] = T65.getText();
        gameBoard[66] = T66.getText();
        gameBoard[67] = T67.getText();
        gameBoard[68] = T68.getText();
        gameBoard[69] = T69.getText();
        gameBoard[70] = T70.getText();
        gameBoard[71] = T71.getText();
        gameBoard[72] = T72.getText();
        gameBoard[73] = T73.getText();
        gameBoard[74] = T74.getText();
        gameBoard[75] = T75.getText();
        gameBoard[76] = T76.getText();
        gameBoard[77] = T77.getText();
        gameBoard[78] = T78.getText();
        gameBoard[79] = T79.getText();
        gameBoard[80] = T80.getText();
        gameBoard[81] = T81.getText();
        gameBoard[82] = T82.getText();
        gameBoard[83] = T83.getText();
        gameBoard[84] = T84.getText();
        gameBoard[85] = T85.getText();
        gameBoard[86] = T86.getText();
        gameBoard[87] = T87.getText();
        gameBoard[88] = T88.getText();
        gameBoard[89] = T89.getText();
        gameBoard[90] = T90.getText();
        gameBoard[91] = T91.getText();
        gameBoard[92] = T92.getText();
        gameBoard[93] = T93.getText();
        gameBoard[94] = T94.getText();
        gameBoard[95] = T95.getText();
        gameBoard[96] = T96.getText();
        gameBoard[97] = T97.getText();
        gameBoard[98] = T98.getText();
        gameBoard[99] = T99.getText();
        gameBoard[100] = T100.getText();
        gameBoard[101] = T101.getText();
        gameBoard[102] = T102.getText();
        gameBoard[103] = T103.getText();
        gameBoard[104] = T104.getText();
        gameBoard[105] = T105.getText();
        gameBoard[106] = T106.getText();
        gameBoard[107] = T107.getText();
        gameBoard[108] = T108.getText();
        gameBoard[109] = T109.getText();
        gameBoard[110] = T110.getText();
        gameBoard[111] = T111.getText();
        gameBoard[112] = T112.getText();
        gameBoard[113] = T113.getText();
        gameBoard[114] = T114.getText();
        gameBoard[115] = T115.getText();
        gameBoard[116] = T116.getText();
        gameBoard[117] = T117.getText();
        gameBoard[118] = T118.getText();
        gameBoard[119] = T119.getText();
        gameBoard[120] = T120.getText();
        gameBoard[121] = T121.getText();
        gameBoard[122] = T122.getText();
        gameBoard[123] = T123.getText();
        gameBoard[124] = T124.getText();
        gameBoard[125] = T125.getText();
        gameBoard[126] = T126.getText();
        gameBoard[127] = T127.getText();
        gameBoard[128] = T128.getText();
        gameBoard[129] = T129.getText();
        gameBoard[130] = T130.getText();
        gameBoard[131] = T131.getText();
        gameBoard[132] = T132.getText();
        gameBoard[133] = T133.getText();
        gameBoard[134] = T134.getText();
        gameBoard[135] = T135.getText();
        gameBoard[136] = T136.getText();
        gameBoard[137] = T137.getText();
        gameBoard[138] = T138.getText();
        gameBoard[139] = T139.getText();
        gameBoard[140] = T140.getText();
        gameBoard[141] = T141.getText();
        gameBoard[142] = T142.getText();
        gameBoard[143] = T143.getText();
        gameBoard[144] = T144.getText();
        gameBoard[145] = T145.getText();
        gameBoard[146] = T146.getText();
        gameBoard[147] = T147.getText();
        gameBoard[148] = T148.getText();
        gameBoard[149] = T149.getText();
        gameBoard[150] = T150.getText();
        gameBoard[151] = T151.getText();
        gameBoard[152] = T152.getText();
        gameBoard[153] = T153.getText();
        gameBoard[154] = T154.getText();
        gameBoard[155] = T155.getText();
        gameBoard[156] = T156.getText();
        gameBoard[157] = T157.getText();
        gameBoard[158] = T158.getText();
        gameBoard[159] = T159.getText();
        gameBoard[160] = T160.getText();
        gameBoard[161] = T161.getText();
        gameBoard[162] = T162.getText();
        gameBoard[163] = T163.getText();
        gameBoard[164] = T164.getText();
        gameBoard[165] = T165.getText();
        gameBoard[166] = T166.getText();
        gameBoard[167] = T167.getText();
        gameBoard[168] = T168.getText();
        gameBoard[169] = T169.getText();
        gameBoard[170] = T170.getText();
        gameBoard[171] = T171.getText();
        gameBoard[172] = T172.getText();
        gameBoard[173] = T173.getText();
        gameBoard[174] = T174.getText();
        gameBoard[175] = T175.getText();
        gameBoard[176] = T176.getText();
        gameBoard[177] = T177.getText();
        gameBoard[178] = T178.getText();
        gameBoard[179] = T179.getText();
        gameBoard[180] = T180.getText();
        gameBoard[181] = T181.getText();
        gameBoard[182] = T182.getText();
        gameBoard[183] = T183.getText();
        gameBoard[184] = T184.getText();
        gameBoard[185] = T185.getText();
        gameBoard[186] = T186.getText();
        gameBoard[187] = T187.getText();
        gameBoard[188] = T188.getText();
        gameBoard[189] = T189.getText();
        gameBoard[190] = T190.getText();
        gameBoard[191] = T191.getText();
        gameBoard[192] = T192.getText();
        gameBoard[193] = T193.getText();
        gameBoard[194] = T194.getText();
        gameBoard[195] = T195.getText();
        gameBoard[196] = T196.getText();
        gameBoard[197] = T197.getText();
        gameBoard[198] = T198.getText();
        gameBoard[199] = T199.getText();
        gameBoard[200] = T200.getText();
        gameBoard[201] = T201.getText();
        gameBoard[202] = T202.getText();
        gameBoard[203] = T203.getText();
        gameBoard[204] = T204.getText();
        gameBoard[205] = T205.getText();
        gameBoard[206] = T206.getText();
        gameBoard[207] = T207.getText();
        gameBoard[208] = T208.getText();
        gameBoard[209] = T209.getText();
        gameBoard[210] = T210.getText();
        gameBoard[211] = T211.getText();
        gameBoard[212] = T212.getText();
        gameBoard[213] = T213.getText();
        gameBoard[214] = T214.getText();
        gameBoard[215] = T215.getText();
        gameBoard[216] = T216.getText();
        gameBoard[217] = T217.getText();
        gameBoard[218] = T218.getText();
        gameBoard[219] = T219.getText();
        gameBoard[220] = T220.getText();
        gameBoard[221] = T221.getText();
        gameBoard[222] = T222.getText();
        gameBoard[223] = T223.getText();
        gameBoard[224] = T224.getText();
        gameBoard[225] = T225.getText();
        gameBoard[226] = T226.getText();
        gameBoard[227] = T227.getText();
        gameBoard[228] = T228.getText();
        gameBoard[229] = T229.getText();
        gameBoard[230] = T230.getText();
        gameBoard[231] = T231.getText();
        gameBoard[232] = T232.getText();
        gameBoard[233] = T233.getText();
        gameBoard[234] = T234.getText();
        gameBoard[235] = T235.getText();
        gameBoard[236] = T236.getText();
        gameBoard[237] = T237.getText();
        gameBoard[238] = T238.getText();
        gameBoard[239] = T239.getText();
        gameBoard[240] = T240.getText();
        gameBoard[241] = T241.getText();
        gameBoard[242] = T242.getText();
        gameBoard[243] = T243.getText();
        gameBoard[244] = T244.getText();
        gameBoard[245] = T245.getText();
        gameBoard[246] = T246.getText();
        gameBoard[247] = T247.getText();
        gameBoard[248] = T248.getText();
        gameBoard[249] = T249.getText();
        gameBoard[250] = T250.getText();
        gameBoard[251] = T251.getText();
        gameBoard[252] = T252.getText();
        gameBoard[253] = T253.getText();
        gameBoard[254] = T254.getText();
        gameBoard[255] = T255.getText();
        gameBoard[256] = T256.getText();
        gameBoard[257] = T257.getText();
        gameBoard[258] = T258.getText();
        gameBoard[259] = T259.getText();
        gameBoard[260] = T260.getText();
        gameBoard[261] = T261.getText();
        gameBoard[262] = T262.getText();
        gameBoard[263] = T263.getText();
        gameBoard[264] = T264.getText();
        gameBoard[265] = T265.getText();
        gameBoard[266] = T266.getText();
        gameBoard[267] = T267.getText();
        gameBoard[268] = T268.getText();
        gameBoard[269] = T269.getText();
        gameBoard[270] = T270.getText();
        gameBoard[271] = T271.getText();
        gameBoard[272] = T272.getText();
        gameBoard[273] = T273.getText();
        gameBoard[274] = T274.getText();
        gameBoard[275] = T275.getText();
        gameBoard[276] = T276.getText();
        gameBoard[277] = T277.getText();
        gameBoard[278] = T278.getText();
        gameBoard[279] = T279.getText();
        gameBoard[280] = T280.getText();
        gameBoard[281] = T281.getText();
        gameBoard[282] = T282.getText();
        gameBoard[283] = T283.getText();
        gameBoard[284] = T284.getText();
        gameBoard[285] = T285.getText();
        gameBoard[286] = T286.getText();
        gameBoard[287] = T287.getText();
        gameBoard[288] = T288.getText();
        gameBoard[289] = T289.getText();
        gameBoard[290] = T290.getText();
        gameBoard[291] = T291.getText();
        gameBoard[292] = T292.getText();
        gameBoard[293] = T293.getText();
        gameBoard[294] = T294.getText();
        gameBoard[295] = T295.getText();
        gameBoard[296] = T296.getText();
        gameBoard[297] = T297.getText();
        gameBoard[298] = T298.getText();
        gameBoard[299] = T299.getText();
        gameBoard[300] = T300.getText();
        gameBoard[301] = T301.getText();
        gameBoard[302] = T302.getText();
        gameBoard[303] = T303.getText();
        gameBoard[304] = T304.getText();
        gameBoard[305] = T305.getText();
        gameBoard[306] = T306.getText();
        gameBoard[307] = T307.getText();
        gameBoard[308] = T308.getText();
        gameBoard[309] = T309.getText();
        gameBoard[310] = T310.getText();
        gameBoard[311] = T311.getText();
        gameBoard[312] = T312.getText();
        gameBoard[313] = T313.getText();
        gameBoard[314] = T314.getText();
        gameBoard[315] = T315.getText();
        gameBoard[316] = T316.getText();
        gameBoard[317] = T317.getText();
        gameBoard[318] = T318.getText();
        gameBoard[319] = T319.getText();
        gameBoard[320] = T320.getText();
        gameBoard[321] = T321.getText();
        gameBoard[322] = T322.getText();
        gameBoard[323] = T323.getText();
        gameBoard[324] = T324.getText();
        gameBoard[325] = T325.getText();
        gameBoard[326] = T326.getText();
        gameBoard[327] = T327.getText();
        gameBoard[328] = T328.getText();
        gameBoard[329] = T329.getText();
        gameBoard[330] = T330.getText();
        gameBoard[331] = T331.getText();
        gameBoard[332] = T332.getText();
        gameBoard[333] = T333.getText();
        gameBoard[334] = T334.getText();
        gameBoard[335] = T335.getText();
        gameBoard[336] = T336.getText();
        gameBoard[337] = T337.getText();
        gameBoard[338] = T338.getText();
        gameBoard[339] = T39.getText();
        gameBoard[340] = T340.getText();
        gameBoard[341] = T341.getText();
        gameBoard[342] = T342.getText();
        gameBoard[343] = T343.getText();
        gameBoard[344] = T344.getText();
        gameBoard[345] = T345.getText();
        gameBoard[346] = T346.getText();
        gameBoard[347] = T347.getText();
        gameBoard[348] = T348.getText();
        gameBoard[349] = T349.getText();
        gameBoard[350] = T350.getText();
        gameBoard[351] = T351.getText();
        gameBoard[352] = T352.getText();
        gameBoard[353] = T353.getText();
        gameBoard[354] = T354.getText();
        gameBoard[355] = T355.getText();
        gameBoard[356] = T356.getText();
        gameBoard[357] = T357.getText();
        gameBoard[358] = T358.getText();
        gameBoard[359] = T359.getText();
        gameBoard[360] = T360.getText();
        gameBoard[361] = T361.getText();
        gameBoard[362] = T362.getText();
        gameBoard[363] = T363.getText();
        gameBoard[364] = T364.getText();
        gameBoard[365] = T365.getText();
        gameBoard[366] = T366.getText();
        gameBoard[367] = T367.getText();
        gameBoard[368] = T368.getText();
        gameBoard[369] = T369.getText();
        gameBoard[370] = T370.getText();
        gameBoard[371] = T371.getText();
        gameBoard[372] = T372.getText();
        gameBoard[373] = T373.getText();
        gameBoard[374] = T374.getText();
        gameBoard[375] = T375.getText();
        gameBoard[376] = T376.getText();
        gameBoard[377] = T377.getText();
        gameBoard[378] = T378.getText();
        gameBoard[379] = T379.getText();
        gameBoard[380] = T380.getText();
        gameBoard[381] = T381.getText();
        gameBoard[382] = T382.getText();
        gameBoard[383] = T383.getText();
        gameBoard[384] = T384.getText();
        gameBoard[385] = T385.getText();
        gameBoard[386] = T386.getText();
        gameBoard[387] = T387.getText();
        gameBoard[388] = T388.getText();
        gameBoard[389] = T389.getText();
        gameBoard[390] = T390.getText();
        gameBoard[391] = T391.getText();
        gameBoard[392] = T392.getText();
        gameBoard[393] = T393.getText();
        gameBoard[394] = T394.getText();
        gameBoard[395] = T395.getText();
        gameBoard[396] = T396.getText();
        gameBoard[397] = T397.getText();
        gameBoard[398] = T398.getText();
        gameBoard[399] = T399.getText();
        return gameBoard;
    }

    public boolean compare(){
        String[] newBoard = this.getBoard();
        int number = 0;
        for (int i =0;i<400;i++){
            if (!newBoard[i].equals(board[i])) {
                number++;
                index = i;
            }
        }
        if (number != 1){
            setBoard(board);
            Platform.runLater(()->{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Input Error!");
                alert.setContentText("You can only enter one letter during your turn.");
                alert.showAndWait();
            });
            return false;
        }
        else{
            board = getBoard();
            return true;
        }
    }
    public void resetPlayerStatus(){
        Platform.runLater(()->{
            String emptyPlayerName = "Empty";
            player1Name.setText(emptyPlayerName);
            player2Name.setText(emptyPlayerName);
            player3Name.setText(emptyPlayerName);
            player4Name.setText(emptyPlayerName);

            String emptyPlayerScore = "0";
            player1Score.setText(emptyPlayerScore);
            player2Score.setText(emptyPlayerScore);
            player3Score.setText(emptyPlayerScore);
            player4Score.setText(emptyPlayerScore);

            player1Ready.setVisible(false);
            player2Ready.setVisible(false);
            player3Ready.setVisible(false);
            player4Ready.setVisible(false);
        });
    }

    public void refreshPlayerTurn(String name,Boolean turn){
        Platform.runLater(()->{
            if (player1Name.getText().equals(name)){
                if (turn){
                    player1Turn.setImage(new Image(getClass().getClassLoader().getResource("images/true.png").toString()));
                }else {
                    player1Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
                }
            } else if (player2Name.getText().equals(name)){
                if (turn){
                    player2Turn.setImage(new Image(getClass().getClassLoader().getResource("images/true.png").toString()));
                }else {
                    player2Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
                }
            } else if (player3Name.getText().equals(name)){
                if (turn){
                    player3Turn.setImage(new Image(getClass().getClassLoader().getResource("images/true.png").toString()));
                }else {
                    player3Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
                }
            } else if (player4Name.getText().equals(name)){
                if (turn){
                    player4Turn.setImage(new Image(getClass().getClassLoader().getResource("images/true.png").toString()));
                }else {
                    player4Turn.setImage(new Image(getClass().getClassLoader().getResource("images/false.png").toString()));
                }
            }
        });
    }

    public void setAllReady(){
        Platform.runLater(()->{
            player1Ready.setVisible(false);
            player2Ready.setVisible(false);
            player3Ready.setVisible(false);
            player4Ready.setVisible(false);
        });
    }

    public void refreshPlayerScore(String name,String score){
        Platform.runLater(()->{
            if (player1Name.getText().equals(name)){
                player1Score.setText(score);
            } else if (player2Name.getText().equals(name)){
                player2Score.setText(score);
            } else if (player3Name.getText().equals(name)){
                player3Score.setText(score);
            } else if (player4Name.getText().equals(name)){
                player4Score.setText(score);
            }
        });
    }

    public void refreshPlayerStatus(String name,String status){
        Platform.runLater(()->{
            if (player1Name.getText().equals("Empty")){
                player1Name.setText(name);
                if (status.equals("NotReady")){
                    player1Ready.setVisible(false);
                }else if (status.equals("Ready")){
                    player1Ready.setVisible(true);
                }
            }else if (player2Name.getText().equals("Empty")){
                player2Name.setText(name);
                if (status.equals("NotReady")){
                    player2Ready.setVisible(false);
                }else if (status.equals("Ready")){
                    player2Ready.setVisible(true);
                }
            }else if (player3Name.getText().equals("Empty")){
                player3Name.setText(name);
                if (status.equals("NotReady")){
                    player3Ready.setVisible(false);
                }else if (status.equals("Ready")){
                    player3Ready.setVisible(true);
                }
            }else if (player4Name.getText().equals("Empty")){
                player4Name.setText(name);
                if (status.equals("NotReady")){
                    player4Ready.setVisible(false);
                }else if (status.equals("Ready")){
                    player4Ready.setVisible(true);
                }
            }
        });
    }
    @FXML
    public void showReadyStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/ready.fxml"));
        Parent window = (Pane) fxmlLoader.load();
        readyController = fxmlLoader.getController();
        readyController.title.setText(HallController.tableNumber);
        Scene scene = new Scene(window);
        scene.setFill(null);

        Platform.runLater(() -> {
            readyStage = new Stage();
            // Paternity
            readyStage.initOwner(title.getScene().getWindow());
            readyStage.initStyle(StageStyle.UNDECORATED);
            readyStage.initStyle(StageStyle.TRANSPARENT);
            readyStage.initModality(Modality.APPLICATION_MODAL);
            readyStage.setWidth(TableWidth);
            readyStage.setHeight(TableHeight);
            readyStage.setScene(scene);
            readyStage.show();
        });
    }

    public void gameStart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/timer.fxml"));
        Parent window = (Pane) fxmlLoader.load();
        timerController = fxmlLoader.getController();
        Scene timerScene = new Scene(window);
        timerScene.setFill(null);
        Platform.runLater(()->{
            timerStage = new Stage();
            timerStage.initOwner(title.getScene().getWindow());
            timerStage.initStyle(StageStyle.UNDECORATED);
            timerStage.initStyle(StageStyle.TRANSPARENT);
            timerStage.initModality(Modality.APPLICATION_MODAL);
            timerStage.setWidth(TableWidth);
            timerStage.setHeight(TableHeight);
            timerStage.setX(HallController.getStage().getX());
            timerStage.setY(HallController.getStage().getY());
            timerStage.setScene(timerScene);
            timerStage.show();
        });
        this.setAllReady();
    }

    @FXML
    private void confirm() {
        if (Game.turn){
            Platform.runLater(()->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Direction Confirmation");
                alert.setHeaderText("Please choose a direction:");
                alert.setContentText("Choose your option.");
                ButtonType buttonTypeH = new ButtonType("Horizontal");
                ButtonType buttonTypeV = new ButtonType("Vertical");
                ButtonType buttonTypeCancel = new ButtonType("Let me think", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(buttonTypeH, buttonTypeV, buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                String word =null;
                String inputRegex = "^[a-zA-Z]{1}$";
                // user chose "Horizontal"
                if (result.get() == buttonTypeH){
                    if (compare() == true){
                        if (!getBoard()[index].matches(inputRegex)){
                            Platform.runLater(()->{
                                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                alert1.setHeaderText("Input Error!");
                                alert1.setContentText("You can only enter one letter in the box.");
                                alert1.showAndWait();
                            });
                        } else {
                            word = Game.horizontal(index,getBoard());
                            Game.sendCharacter(index,getBoard()[index].toUpperCase(),word);
                        }
                    }
                    // user chose "Vertical"
                } else if (result.get() == buttonTypeV) {
                    if (compare() == true){
                        word = Game.horizontal(index,getBoard());
                        Game.sendCharacter(index,getBoard()[index],word);
                    }
                }
            });
        } else {
            Platform.runLater(()->{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Not your turn!");
                alert.setContentText("Please wait for others...");
                alert.showAndWait();
            });
        }
    }

    @FXML
    private void pass(){
        if (Game.turn){
            Game.pass();
        }else {
            Platform.runLater(()->{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Not your turn!");
                alert.setContentText("Please wait for others...");
                alert.showAndWait();
            });
        }
    }

    public void voting(String name,String word){
        Platform.runLater(()->{
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Voting Confirmation");
            alert1.setHeaderText("Do you want to vote for this word ?");
            alert1.setContentText("Do you really think this is a word ?");
            ButtonType buttonyes = new ButtonType("Yes");
            ButtonType buttonno = new ButtonType("No");
            alert1.getButtonTypes().setAll(buttonyes,buttonno);
            Optional<ButtonType> result1 = alert1.showAndWait();
            if(result1.get()==buttonyes) {
                Game.voting(true,name,word);
            }
            else if(result1.get()==buttonno) {
                Game.voting(false,name,word);
            }
        });
    }

    @FXML
    private void help(){
        Platform.runLater(()->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Welcome to Scrabble");
            alert.setHeaderText("About Scrabble:");
            alert.setContentText(" ·The players turn by turn can place alphabet tiles on the grid to form a word.\r\n\r\n· The player who places the associated letter"
                    + " will get points equal to the length of the word.\r\n\r\n· The word is considered valid if all the other players vote in favour of the word."
                    + "\r\n\r\n ·The game ends when there is no place in the grid.");
            alert.showAndWait();
        });
    }

    // return to game hall
    public void returnHall() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("Confirmation");
        alert.setContentText("Are you sure you want to exit this game ?");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            HallController.getStage().close();
            Game.getPrimaryStage().show();
            Game.returnToHall();
        }
    }

    // Minimize Window
    public void minimizeWindow(){
        HallController.getStage().setIconified(true);
    }

}
