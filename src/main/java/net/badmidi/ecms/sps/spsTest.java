package net.badmidi.ecms.sps;

class spsTest{
	public static void main(String[] args){
		SPS sp = new SPS();
		sp.addNote(0);
		try{
			sp.playMusic();
		}catch(Exception e){
			System.out.println("FAIL");
		}
	}
}