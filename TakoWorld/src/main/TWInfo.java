package main;

import java.awt.Graphics2D;

public class TWInfo {
	public Graphics2D g;
	public double frameTime;
	public long currentTime;
	public long pushTime;//最後にボタンを押した時間
	public boolean[] keyState;

	public TWInfo() {
		this.keyState=new boolean[8];
		for(int i=0;i<8;i++) {
			this.keyState[i]=false;
		}
		this.pushTime=System.currentTimeMillis();
	}

}