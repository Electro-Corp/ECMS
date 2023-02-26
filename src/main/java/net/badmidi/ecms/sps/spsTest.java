package net.badmidi.ecms.sps;

public class spsTest{
	public static void main(String[] args){
		SPS sp = new SPS();
		sp.addNote(60,3);
		sp.addNote(61,1);
		sp.addNote(62,2);
		try{
			sp.playMusic(0);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
}
