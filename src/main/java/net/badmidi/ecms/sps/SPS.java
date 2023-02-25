package net.badmidi.ecms.sps;

import java.io.Serializable;
import java.util.ArrayList;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
public class SPS implements Serializable{
	//public List<List<Note>> board = new ArrayList<List<Note>>;
	public Note[][] board = new Note[127][100];
	public int[] keyVals = new int[127];
	int notes =0;
	public int[] pitches = new int[88];
	//
	private double testVal = 0;
	public static final int SAMPLE_RATE = 16 * 1024;
	//
	public SPS(){
		for(int i = 0; i < 88; i++)
			pitches[i] = i;
	}
	public void addNote(int key, double duration){
		board[key][keyVals[key]++] = new Note(key,duration);
		notes++;
	}
	public void playMusic() throws Exception{
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		MidiChannel[] channels = synth.getChannels();
		MidiChannel channel = channels[0];
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
        System.out.println("Instruments: "+instr.length);
		System.out.println("Notes: "+notes);
        synth.loadInstrument(instr[0]);//load an instrument
		//
		for(int i = 0; i < 100; i++){
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
	public int goof(){
		return 3;
	}
	

}
