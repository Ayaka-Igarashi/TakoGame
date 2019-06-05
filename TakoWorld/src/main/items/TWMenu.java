package main.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.supers.GameItem;
import main.supers.SoundBox;

public class TWMenu extends GameItem {
	private boolean menuTime;
	//-1:初期,0:セーブ確認,1:ロード確認,2:終了確認,3:セーブしました4:ロードします
	private int menuState;
	private int nowChoice;
	private int confirmChoice;

	private boolean exitFlg;

	private String[] menuText= {"SAVE","LOAD","EXIT"};
	private String[] confirm= {"セーブしますか","ロードしますか","タイトルに戻りますか"};
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

	@Override
	public void first() {
		this.menuTime=false;
		this.menuState=-1;
		this.nowChoice=0;
		this.confirmChoice=0;
		this.exitFlg=false;
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
				}else if(this.menuState==0||this.menuState==1||this.menuState==2){
					if(this.confirmChoice==0) {//ok
						if(this.menuState==0) {
							this.action(tInfo);//saveする
							this.menuState=3;
						}else if(this.menuState==1) {
							this.menuState=4;
						}else if(this.menuState==2) {
							this.action(tInfo);//exitする
						}
					}else if(this.confirmChoice==1){//no
						this.menuState=-1;
						this.confirmChoice=0;
					}
				}else if(this.menuState==3) {//セーブしました
					this.menuState=-1;
					this.nowChoice=0;
					this.confirmChoice=0;
				}else if(this.menuState==4) {//ロードします
					this.nowChoice=0;
					this.confirmChoice=0;
					this.menuTime=false;
					this.action(tInfo);//loadする
					this.menuState=-1;
				}
			}
		}
		if(key==KEY_STATE.X) {
			if(this.menuTime==false) {
				this.menuTime=true;//メニュー表示状態にする
			}else if(this.menuTime==true) {//メニューを閉じる
				this.menuTime=false;
				this.menuState=-1;
				this.nowChoice=0;
				this.confirmChoice=0;
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
					if(this.nowChoice<2) {
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

	//セーブ、ロード、exitする
	public void action(TWInfo tInfo) {
		if(this.menuState==0) {
			tInfo.save();
		}else if (this.menuState==4) {
			tInfo.load();
		}else if (this.menuState==2) {
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
				tInfo.g.drawString(this.menuText[i],(int)this.loc[i].x-100,(int)this.loc[i].y+25);
			}
		}else if(this.menuState==0||this.menuState==1||this.menuState==2){
			tInfo.g.drawString(this.confirm[this.menuState],200,200);
			tInfo.g.drawString(this.yesNo[0],350,240);//yes
			tInfo.g.drawString(this.yesNo[1],350,300);//no
		}else if(this.menuState==3) {
			tInfo.g.drawString("セーブしました",200,200);
		}else if(this.menuState==4) {
			tInfo.g.drawString("ロードします",200,200);
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
			}else if(this.menuState==0||this.menuState==1||this.menuState==2){
				this.setPosition(1, loc[this.confirmChoice]);
				this.setVisible(1, true);
				this.drawOne(tInfo,1);
			}

			this.drawText(tInfo);
		}
		return this;
	}

}
