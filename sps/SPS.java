import java.util.ArrayList;
class SPS{
	//public List<List<Note>> board = new ArrayList<List<Note>>;
	public Note[][] board = new Note[88][100];
	public int[] keyVals = new int[88];
	public int[] pitches = new int[88];
	public SPS(){
		
	}
	public void addNote(int key){
		board[key][keyVals[key]++] = new Note(pitches[key],1);
	}
}
