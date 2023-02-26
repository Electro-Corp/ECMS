package net.badmidi.ecms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.badmidi.ecms.sps.SPS;
import net.badmidi.ecms.sps.SPSFile;

import java.io.*;

public class AppController implements Serializable {

    SPS sps;
    SPSFile spsFile;

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
    private Button createBasic;
    @FXML
    private Button incTestVal;
    @FXML
    private Button save;

    private String curName;
    @FXML
    protected void onOpenFileButtonClick() {
        if(load(filename.getCharacters().toString())) {
            filename.setVisible(false);
            badFileName.setVisible(false);
            openFile.setVisible(false);

            play.setVisible(true);
            curName = filename.getCharacters().toString();
        }
    }

    @FXML
    protected void onPlayPressed() {
        testVal.setVisible(true);
        testVal.setText(String.valueOf(sps.goof()));
        if(sps != null){
            try{
            sps.playMusic(0);}catch(Exception e){}
        }
    }

    public void initialize() {
        filename.setText(".sps");
        filename.setAccessibleText("Filename");
        play.setVisible(false);
        play.setText("Play (NO WORK)");
        testVal.setVisible(false);
        createBasic.setVisible(true);
        createBasic.setText("Generate test sps file with sounds");
        // for each element that will be "removed" (hidden)
        openFile.managedProperty().bind(openFile.visibleProperty());
        play.managedProperty().bind(play.visibleProperty());
        filename.managedProperty().bind(filename.visibleProperty());
        badFileName.managedProperty().bind(badFileName.visibleProperty());
        testVal.managedProperty().bind(testVal.visibleProperty());
        // incTestVal.managedProperty().bind(incTestVal.visibleProperty());
        // incTestVal.visibleProperty().bind(play.visibleProperty());
        save.managedProperty().bind(save.visibleProperty());
        save.visibleProperty().bind(play.visibleProperty());
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
        } catch (ClassNotFoundException egx) {
            //egx.printStackTrace();
            return false;
        } catch(InvalidClassException error){
            badFileName.setText("File created with an earlier build of ECMS");
            return false;
        } catch(IOException e){
            return false;
        }
    }

    public void save(String filename) {
        if(filename==null) {
            filename= "default.sps";
        }
        //updateSPSFile();
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
                return name.equals
                (filename.getCharacters().toString());
            }});

        if(matches != null && matches.length > 0) {
            return;
        }
        
        save(filename.getCharacters().toString());
        load(filename.getCharacters().toString());
        onOpenFileButtonClick();
        newSPS.setVisible(false);
    }

    @FXML
    public void onIncTestValPressed() {
       // sps.incTestVal();
    }
    @FXML
    public void onSavePressed() {
        save(curName);
        // TODO: Allow user to choose save loc/name
        
    }
    public void demo(){
        sps = new SPS();
		sps.addNote(60,3);
		sps.addNote(61,1);
		sps.addNote(62,2);
        
        save("demo.sps");
    }


   


}