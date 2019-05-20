package main;

import java.awt.Graphics2D;

public class TWInfo {
	public Graphics2D g;
	public double frameTime;
	public long currentTime;
	public boolean[] keyState;

	public TWInfo() {
		this.keyState=new boolean[8];
		for(int i=0;i<8;i++) {
			this.keyState[i]=false;
		}
	}

}
