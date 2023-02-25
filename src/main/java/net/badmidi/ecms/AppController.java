package net.badmidi.ecms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.badmidi.ecms.sps.SPS;

import java.io.*;

public class AppController implements Serializable {

    SPS sps;

    @FXML
    private Label testVal;
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
    private Button newSPS;


    @FXML
    protected void onOpenFileButtonClick() {
        if(load(filename.getCharacters().toString())) {
            filename.setVisible(false);
            badFileName.setVisible(false);
            openFile.setVisible(false);

            play.setVisible(true);
        }
    }

    @FXML
    protected void onPlayPressed() {
        testVal.setVisible(true);
        testVal.setText(String.valueOf(sps.getTestVal()));
    }

    public void initialize() {
        filename.setText(".sps");
        filename.setAccessibleText("Filename");
        play.setVisible(false);
        play.setText("Play (NO WORK)");
        testVal.setVisible(false);
        // for each element that will be "removed" (hidden)
        openFile.managedProperty().bind(openFile.visibleProperty());
        play.managedProperty().bind(play.visibleProperty());
        filename.managedProperty().bind(filename.visibleProperty());
        badFileName.managedProperty().bind(badFileName.visibleProperty());
        testVal.managedProperty().bind(testVal.visibleProperty());
    }
    public boolean load(String filename) {
        if(filename==null) {
            filename = "default.sps";
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
            filename= "default.sps";
        }
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            SPS dStorage;

            if(sps!=null)
                 dStorage = sps;
            else
                dStorage = new SPS();

            oos.writeObject(dStorage);
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onNewPressed() {
        String directory = "";
        File dir = new File(directory);

        File[] matches = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name)
            {
                return name.equals(filename.getCharacters().toString());
            }});

        if(matches.length > 0) {
            return;
        }
        save(null);
        load(filename.getCharacters().toString());
    }


}