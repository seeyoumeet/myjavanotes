package com.seeyoumeet.javafx;

import com.seeyoumeet.javafx.form.TestForm;
import javafx.application.Application;

/**
 * @Author : yuc5015
 * @Date : 2021/9/1
 * @Description :
 * @Modified By :
 */
public class JavaFXApplication {

    public static void main(String[] args) {
        // 调用Application的launch方法启动应用
        Application.launch(TestForm.class, args);
    }
}
