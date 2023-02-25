package net.badmidi.ecms.sps;

public class spsTest{
	public static void main(String[] args){
		SPS sp = new SPS();
		sp.addNote(60);
		sp.addNote(61);
		sp.addNote(62);
		try{
			sp.playMusic();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
}
