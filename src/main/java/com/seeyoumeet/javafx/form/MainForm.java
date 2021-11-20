package com.seeyoumeet.javafx.form;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @Author : yuc5015
 * @Date : 2021/9/1
 * @Description :
 * @Modified By :
 */
public class MainForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 读取Fxml文件的配置信息
//        Parent root = FXMLLoader.load(getClass().getResource("/com/seeyoumeet/javafx/fxml/mainform.fxml"));

        Parent root = new Pane();
        // 将配置的元素放置进行类似JFrame窗体框架的Scene中
        primaryStage.setScene(new Scene(root));

        // 设置我的舞台名称
        primaryStage.setTitle("Hello World");

        // 显示我的舞台
        primaryStage.show();
    }

    @Override
    public void stop()throws Exception{
        System.exit(200);
    }
}
