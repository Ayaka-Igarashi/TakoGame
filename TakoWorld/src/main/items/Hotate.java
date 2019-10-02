package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameChara;

//ホタテ
public class Hotate extends GameChara{
	public static final int REMOVE=0;
	public static final int NORMAL_HUMAN=1;
	public static final int SWEATED_HUMAN=2;
	public static final int NORMAL_L=3;
	public static final int NORMAL_R=4;
	public static final int ACTIVE_L=5;
	public static final int ACTIVE_R=6;
	public static final int CRY_L=7;
	public static final int CRY_R=8;
	public static final int HAPPY_L=9;
	public static final int HAPPY_R=10;
	public static final int LAZY_L=11;
	public static final int LAZY_R=12;
	public static final int SERIOUS_L=13;
	public static final int SERIOUS_R=14;

	//初期設定
	@Override
	public void first() {
		this.nowState=Hotate.REMOVE;
		this.isChange=false;
		for(int i=0;i<this.imgList.size();i++) {
			this.setVisible(i, false);
		}
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==Hotate.REMOVE) {
				for(int i=0;i<this.imgList.size();i++) {
					this.setVisible(i, false);
				}
			}else {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==this.nowState-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}
			/*
			else if(this.nowState==Hotate.NORMAL_HUMAN) {
				this.setVisible(0, true);
				this.setVisible(1, false);
				for(int i=2;i<this.imgList.size();i++) {
					this.setVisible(i, false);
				}
			}else if(this.nowState==Hotate.SWEATED_HUMAN) {
				this.setVisible(0, false);
				this.setVisible(1, true);
				for(int i=2;i<this.imgList.size();i++) {
					this.setVisible(i, false);
				}
			}else if(this.nowState==Hotate.NORMAL_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.NORMAL_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.NORMAL_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.NORMAL_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.ACTIVE_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.ACTIVE_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.ACTIVE_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.ACTIVE_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.CRY_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.CRY_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.CRY_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.CRY_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.HAPPY_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.HAPPY_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.HAPPY_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.HAPPY_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.LAZY_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.LAZY_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.LAZY_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.LAZY_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.SERIOUS_L) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.SERIOUS_L-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}else if(this.nowState==Hotate.SERIOUS_R) {
				for(int i=0;i<this.imgList.size();i++) {
					if(i==Hotate.SERIOUS_R-1) {this.setVisible(i, true);}
					else {this.setVisible(i, false);}
				}
			}
			*/
			this.isChange=false;
		}
		return;
	}

	//キーが押された瞬間の画像処理
	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		if(key==KEY_STATE.Z) {
			this.nowState=action;
			this.isChange=true;
		}
		return;
	}

}
