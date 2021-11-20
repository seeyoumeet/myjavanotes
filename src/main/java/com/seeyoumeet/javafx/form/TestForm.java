package com.seeyoumeet.javafx.form;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author : yuc5015
 * @Date : 2021/9/1
 * @Description :
 * @Modified By :
 */
public class TestForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlPath = getClass().getResource("/com/seeyoumeet/javafx/fxml/testform.fxml").getPath().replaceAll("%20","");       //解决路径中含有空格的情况
        fxmlPath = java.net.URLDecoder.decode(fxmlPath,"utf-8"); //解决路径包含中文的情况
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));

        primaryStage.setTitle("深化巩固全国违建别墅问题清查整治行动摸排情况信息采集系统");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void stop()throws Exception{
        System.exit(200);
    }
}
