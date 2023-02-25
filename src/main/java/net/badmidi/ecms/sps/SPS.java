package net.badmidi.ecms.sps;

import java.util.ArrayList;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
public class SPS {
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
	public void addNote(int key){
		board[key][keyVals[key]++] = new Note(key,1);
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
		for(int i = 0; i < notes; i++){
			for(int g = 0; g < 127; g++){
				if(board[g][0] != null){
					System.out.println(board[g][0].pitch +" , with current g is "+g);
					channel.noteOn((int)board[g][0].pitch, 100);
					sleep((int)board[g][0].duration * 1000);
					channel.noteOff((int)board[g][0].pitch);
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

	public double getTestVal() {
		return testVal;
	}

	public void incTestVal() {
		testVal++;
	}

}
