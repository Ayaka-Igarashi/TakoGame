package main.items_b;

import java.awt.geom.AffineTransform;

import main.TWInfo;
import main.constant.MUSIC_NUM;
import main.supers.GameItem;
import main.supers.SoundBox;

public class AnimItem extends GameChara_B {

	protected long startTime;
	protected int framex,framey;//横、縦のコマ数
	protected int framenum;//コマ数
	protected long oneTime;//コマ時間

	private int nowFrame;//現在のコマ

	public boolean isAnim;

	public boolean isJudge;

	//protected boolean autorepeat=true;
	public GameChara_B setAnimation(int x,int y,int num,long oneTime) {
		this.isAnim=false;
		this.framex=x;
		this.framey=y;
		this.framenum=num;
		this.oneTime=oneTime;
		this.nowFrame=0;
		//this.autorepeat=autorepeat;
		this.center.x=this.imgList.get(0).img.getWidth()/this.framex/2;
		this.center.y=this.imgList.get(0).img.getHeight()/this.framey/2;
		return this;
	}

	//初期設定
	@Override
	public void first() {
		this.isAnim=false;
		this.size=30;
		this.isJudge=false;
	}



	public void start(TWInfo tInfo) {
		if(this.isAnim==false) {
			this.startTime=tInfo.currentTime;
			this.isAnim=true;
			this.isJudge=true;
			//SoundBox.singleton.playClip(MUSIC_NUM.ATTACK);
			this.menuTime=0;
		}
	}

	@Override
	public GameItem draw(TWInfo tInfo) {

		if(this.isAnim==false)return this;

		if(this.isMenuTime==false) {//メニュー表示中はアニメーションストップ
			//現在のコマを求める
			this.nowFrame=(int) ((tInfo.currentTime-this.startTime-this.menuTime)/this.oneTime);
		}


		//アニメ終了判定
		if(this.nowFrame==this.framenum) {
			this.isAnim=false;
			SoundBox.singleton.stopClip(MUSIC_NUM.ATTACK);
			SoundBox.singleton.stopClip(MUSIC_NUM.HIT);
			return this;
		}


		int row=this.nowFrame/this.framex;
		int col=this.nowFrame%this.framey;
		int w=this.imgList.get(0).img.getWidth()/framex;
		int h=this.imgList.get(0).img.getHeight()/framey;

		//変形退避
		AffineTransform oldtr=tInfo.g.getTransform();
		tInfo.g.translate(this.position.x, this.position.y);
		tInfo.g.rotate(this.angle/180.0*Math.PI,0,0);
		tInfo.g.drawImage(this.imgList.get(0).img,
				-(int)this.center.x,-(int)this.center.y,-(int)this.center.x+w,-(int)this.center.y+h,
				col*w,row*h,(col+1)*w,(row+1)*h,
				null);
		//変形復帰
		tInfo.g.setTransform(oldtr);
		return this;

	}



	@Override
	public void control(TWInfo tInfo) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
