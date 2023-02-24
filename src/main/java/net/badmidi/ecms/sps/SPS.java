import java.util.ArrayList;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
public class SPS {
	//public List<List<Note>> board = new ArrayList<List<Note>>;
	public Note[][] board = new Note[127][100];
	public int[] keyVals = new int[127];
	public int[] pitches = new int[88];
	//
	public static final int SAMPLE_RATE = 16 * 1024;
	//
	public SPS(){
		for(int i = 0; i < 88; i++)
			pitches[i] = i;
	}
	public void addNote(int key){
		board[key][keyVals[key]++] = new Note(key,1);
	}
	public void playMusic() throws Exception{
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		MidiChannel[] channels = synth.getChannels();
		MidiChannel channel = channels[0];

		channel.noteOn((int)board[0][0].pitch, 10);
		sleep(1);
		channel.noteOff((int)board[0][0].pitch);

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


}