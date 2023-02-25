package net.badmidi.ecms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.badmidi.ecms.sps.SPS;

import java.io.*;

public class AppController {

    SPS sps;

    @FXML
    private Label welcomeText;
    @FXML
    private Label badFileName;
    @FXML
    private TextField filename;
    @FXML
    private Button openFile;

    @FXML
    private Button play;


    @FXML
    protected void onOpenFileButtonClick() {
        if(load(filename.getCharacters().toString())) {
            filename.setVisible(false);
            badFileName.setVisible(false);
            openFile.setVisible(false);

            play.setVisible(true);
        }
    }



    public void initialize() {
        play.setVisible(false);
    }
    public boolean load(String filename) {
        if(filename==null) {
            filename = "default.dat";
            save(filename);
        }
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            this.sps = (SPS) ois.readObject();
            return true;
        } catch (FileNotFoundException fnf) {
            badFileName.setText("That File Does Not Exists");
            return false;
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void save(String filename) {
        if(filename==null) {
            filename= "default.dat";
        }
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            SPS dStorage = sps;

            oos.writeObject(dStorage);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}