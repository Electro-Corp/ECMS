package net.badmidi.ecms;

import javafx.fxml.FXML;
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
    protected void onOpenFileButtonClick() {
        load(filename.getCharacters().toString());
    }



    public void load(String filename) {
        if(filename==null) {
            filename = "default.dat";
            save(filename);
        }
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            this.sps = (SPS) ois.readObject();

        } catch (FileNotFoundException fnf) {
            badFileName.setText("That File Does Not Exists");
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
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