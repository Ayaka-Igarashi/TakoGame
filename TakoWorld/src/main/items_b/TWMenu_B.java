package main.items_b;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.supers.GameItem;
import main.supers.SoundBox;

public class TWMenu_B extends GameItem {
	private boolean menuTime;
	//-1:初期,0:終了確認
	private int menuState;
	private int nowChoice;
	private int confirmChoice;

	private boolean exitFlg;

	private long startTime;//メニューを開いた時の時間
	public long openTime;//メニュー表示時間
	public boolean setTimeFlg;

	private String[] menuText= {"EXIT"};
	private String[] confirm= {"タイトルに戻りますか"};
	private String[] yesNo= {"はい","いいえ"};
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.BOLD,25);

	private Point2D.Double menuLoc=new Point2D.Double(140, 80);
	private Point2D.Double[] loc= {
			new Point2D.Double(450,195),
			new Point2D.Double(450,275),
			new Point2D.Double(450,355)
	};

	public boolean isMenuTime() {
		return this.menuTime;
	}

	public boolean isExit() {
		return this.exitFlg;
	}

	public void resetOpenTime() {
		this.openTime=0;
	}

	@Override
	public void first() {
		this.menuTime=false;
		this.menuState=-1;
		this.nowChoice=0;
		this.confirmChoice=0;
		this.exitFlg=false;
		this.startTime=0;
		this.openTime=0;
		this.setTimeFlg=false;
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(key==KEY_STATE.Z) {
			if(this.menuTime==true) {//メニュー選択
				if(this.menuState==-1) {
					this.menuState=this.nowChoice;
				}else if(this.menuState==0){
					if(this.confirmChoice==0) {//ok
						this.action(tInfo);//exitする
					}else if(this.confirmChoice==1){//no
						this.menuState=-1;
						this.confirmChoice=0;
					}
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			}
		}
		if(key==KEY_STATE.X) {
			if(this.menuTime==false) {
				this.menuTime=true;//メニュー表示状態にする
				this.startTime=tInfo.currentTime;//時間を測る
			}else if(this.menuTime==true) {//メニューを閉じる
				this.menuTime=false;
				this.menuState=-1;
				this.nowChoice=0;
				this.confirmChoice=0;
				this.openTime=tInfo.currentTime-this.startTime;
				this.setTimeFlg=true;
				//System.out.println(TWMenu_B.openTime);
			}
		}
		if(key==KEY_STATE.UP) {
			if(this.menuTime==true) {
				if(this.menuState==-1) {
					if(this.nowChoice>0) {
						this.nowChoice-=1;
					}
				}else {
					if(this.confirmChoice>0) {
						this.confirmChoice-=1;
					}
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			}
		}else if(key==KEY_STATE.DOWN) {
			if(this.menuTime==true) {
				if(this.menuState==-1) {
					if(this.nowChoice<0) {
						this.nowChoice+=1;
					}
				}else {
					if(this.confirmChoice<1) {
						this.confirmChoice+=1;
					}
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			}
		}
		return;

	}

	//exitする
	public void action(TWInfo tInfo) {
		if (this.menuState==0) {
			this.exitFlg=true;
		}
		return;
	}

	//テキストを書く
	public void drawText(TWInfo tInfo) {
		tInfo.g.setColor(Color.WHITE);
		tInfo.g.setFont(this.font);
		if(this.menuState==-1) {
			for(int i=0;i<this.menuText.length;i++) {
				this.drawStr(tInfo,this.menuText[i],(int)this.loc[i].x-100,(int)this.loc[i].y+25);
			}
		}else if(this.menuState==0){
			this.drawStr(tInfo,this.confirm[this.menuState],200,200);
			this.drawStr(tInfo,this.yesNo[0],350,240);//yes
			this.drawStr(tInfo,this.yesNo[1],350,300);//no
		}
	}

	//全体を描く
	@Override
	public GameItem draw(TWInfo tInfo) {
		if(this.menuTime==true) {
			this.setPosition(0, menuLoc);
			this.setVisible(0, true);
			this.drawOne(tInfo, 0);
			if(this.menuState==-1) {
				this.setPosition(1, loc[this.nowChoice]);
				this.setVisible(1, true);
				this.drawOne(tInfo,1);
			}else if(this.menuState==0){
				this.setPosition(1, loc[this.confirmChoice]);
				this.setVisible(1, true);
				this.drawOne(tInfo,1);
			}

			this.drawText(tInfo);
		}
		return this;
	}

}
