package net.badmidi.ecms.sps;

import java.io.Serializable;
import java.util.ArrayList;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
public class SPS implements Serializable{
	//public List<List<Note>> board = new ArrayList<List<Note>>;
	public Note[][] board = new Note[127][100]; // create keyboard with 100 notes per key
	public int[] keyVals = new int[127]; // how many keys are already established in slot
	int notes = 0; // total count of keys	//
	public int testVal = 0;
	public static final int SAMPLE_RATE = 16 * 1024;
	//
	public SPS(){
		// nothing to see here...
	}
	public void addNote(int key, double duration){
		board[key][keyVals[key]++] = new Note(key,duration);
		notes++;
	}
	// play music
	public void playMusic(int pos) throws Exception{
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		MidiChannel[] channels = synth.getChannels();
		MidiChannel channel = channels[0];
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		System.out.println("ECMS main play system called, data:");
        System.out.println("Instruments: "+instr.length);
		System.out.println("Song data:");
		System.out.println("Notes: "+notes);
        synth.loadInstrument(instr[0]);//load an instrument
		// loop over the length of the song
		for(int i = pos; i < board[0].length; i++){
			// loop over every key
			for(int g = 0; g < 127; g++){
				if(board[g][i] != null){
					System.out.println(board[g][i].pitch +" , with current g is "+g);
					channel.noteOn((int)board[g][i].pitch, 100);
					sleep((int)board[g][0].duration * 1000);
					channel.noteOff((int)board[g][i].pitch);
				}
			}
		}
		synth.close();
	}
	private static void sleep(int iUSecs)
	{
		try
		{
			Thread.sleep(iUSecs);
		}
		catch (InterruptedException e)
		{
		}
	}
	// testing purposes
	public int goof(){
		return testVal;
	}
	public void resizeSong(int newSize){
		//omg memory managment???
		Note[][] tmp = new Note[127][newSize];
		for(int i = 0; i < board[0].length; i++){
			tmp[i] = board[i];
		}
	}
	
}
