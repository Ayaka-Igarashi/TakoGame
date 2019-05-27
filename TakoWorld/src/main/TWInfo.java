package main;

import java.awt.Graphics2D;

public class TWInfo {
	public Graphics2D g;
	public double frameTime;
	public long currentTime;
	public long pushTime;//最後にボタンを押した時間
	public boolean[] keyState;
	public boolean[] keyReleased;//キーが押された後はなされたか

	public int[] choice=new int[5];//選択したもの

	public TWInfo() {
		this.keyState=new boolean[8];
		this.keyReleased=new boolean[8];
		for(int i=0;i<8;i++) {
			this.keyState[i]=false;
			this.keyReleased[i]=true;//放された後ということにする
		}

		for(int i=0;i<5;i++) {
			this.choice[i]=-1;
		}

		this.pushTime=System.currentTimeMillis();
	}

}
