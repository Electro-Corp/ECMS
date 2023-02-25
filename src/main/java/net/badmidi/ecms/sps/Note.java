package net.badmidi.ecms.sps;

import java.io.Serializable;

public class Note implements Serializable{
	public double pitch, duration;
	public Note(double pitch, double duration){
		this.pitch = pitch;
		this.duration = duration;
	}
}
