package main.items;

import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

//選択肢
public class Choice extends GameItem{
	private Point2D.Double loc1=new Point2D.Double(200,100);
	private Point2D.Double loc2=new Point2D.Double(200,250);
	private Point2D.Double loc3=new Point2D.Double(200,400);

	private boolean choiceTime=false;//選択肢が出ている状態か
	private int choiceNum;//選択肢の数
	private int nowChoice;

	public boolean isChoiceTime() {
		return this.choiceTime;
	}

	//初期画像設定
	@Override
	public void first() {
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo, int key,int action) {
		if(key==KEY_STATE.Z) {
			if(this.choiceTime==false) {
				switch(action) {
				case 1:
					this.choiceNum=1;
					this.choiceTime=true;
					break;
				case 2:
					this.choiceNum=2;
					this.choiceTime=true;
					break;
				case 3:
					this.choiceNum=3;
					this.choiceTime=true;
					break;
				default:
				}
			}else if(this.choiceTime==true) {
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.choiceTime=false;
				this.nowChoice=0;
			}
		}
		if(key==KEY_STATE.UP) {
			if(this.nowChoice<=0) {
				this.nowChoice-=1;
			}
		}else if(key==KEY_STATE.DOWN) {
			if(this.nowChoice>=this.choiceNum-1) {
				this.nowChoice+=1;
			}
		}
	}


	@Override
	public GameItem draw(TWInfo tInfo) {
		if(this.choiceTime==true) {
			switch(this.choiceNum) {
			case 1://選択済みのやつのみ表示
				this.setPosition(1,loc1);
				this.setVisible(1, true);
				this.drawOne(tInfo,1);
				break;
			case 2:
				this.setPosition(0,loc1);
				this.setVisible(0, true);
				this.drawOne(tInfo,0);
				this.setPosition(0,loc2);
				this.setVisible(0, true);
				this.drawOne(tInfo,0);
				break;
			case 3:
				this.setPosition(0,loc1);
				this.setVisible(0, true);
				this.drawOne(tInfo,0);
				this.setPosition(0,loc2);
				this.setVisible(0, true);
				this.drawOne(tInfo,0);
				this.setPosition(0,loc3);
				this.setVisible(0, true);
				this.drawOne(tInfo,0);
				break;
			default:
			}
		}


		return this;
	}



}
