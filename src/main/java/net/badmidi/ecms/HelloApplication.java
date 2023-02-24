package net.badmidi.ecms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.badmidi.ecms.sps.SPS;

import java.io.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.lang.Object;
import java.io.IOException;

public class HelloApplication extends Application {
    SPS sps;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);



        stage.setTitle("ECMS");
        stage.setScene(scene);
        stage.show();
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream("save.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            SPS dStorage = (SPS) ois.readObject();

            this.sps = dStorage;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}