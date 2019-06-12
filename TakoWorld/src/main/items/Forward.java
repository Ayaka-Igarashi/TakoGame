package main.items;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import main.TWFrame;
import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Forward extends GameItem {
	private int effectNum;

	private boolean isEffectOn;
	private boolean isEffectOff;//オフアニメ中か
	private boolean isEffectNow;
	private long effectStartTime;

	public static final int BLACK=1;
	public static final int WHITE=2;
	public static final int WHITE_2=3;

	//アニメーション中か
	public boolean getIsEffect() {
		return isEffectOn||isEffectOff||isEffectNow;
	}

	//アニメーション中か
		public boolean getIsAnime() {
			return isEffectOn||isEffectOff;
		}

	@Override
	public void first() {
		this.effectNum=0;
		this.isEffectOn=false;
		this.isEffectOff=false;
		this.isEffectNow=false;

	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		if(this.effectNum==Forward.BLACK) {
			if(this.isEffectOn==true) {
				float alpha =(float)(tInfo.currentTime-this.effectStartTime)/1000;
				if(alpha>=1) {
					alpha=1;
					this.isEffectOn=false;
					this.isEffectNow=true;
				}
				tInfo.g.setColor(new Color(0, 0, 0, alpha));
				tInfo.g.fill(new Rectangle2D.Double(0,TWFrame.title_bar_height,800,600));
			}else if(this.isEffectNow==true) {
				tInfo.g.setColor(new Color(0, 0, 0, 1.0f));
				tInfo.g.fill(new Rectangle2D.Double(0,TWFrame.title_bar_height,800,600));
			}else if(this.isEffectOff==true) {
				float alpha =1-(float)(tInfo.currentTime-this.effectStartTime)/500;
				if(alpha<=0) {
					alpha=0;
					this.isEffectOff=false;
					this.effectNum=0;
				}
				tInfo.g.setColor(new Color(0, 0, 0, alpha));
				tInfo.g.fill(new Rectangle2D.Double(0,TWFrame.title_bar_height,800,600));
			}

		}else if(this.effectNum==Forward.WHITE) {
			if(tInfo.currentTime-this.effectStartTime<40) {
				tInfo.g.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
				tInfo.g.fill(new Rectangle2D.Double(0,TWFrame.title_bar_height,800,600));
			}else if(tInfo.currentTime-this.effectStartTime>=40) {
				this.effectNum=0;
				this.isEffectOn=false;
			}
		}else if(this.effectNum==Forward.WHITE_2) {
			if(tInfo.currentTime-this.effectStartTime<50||
					(tInfo.currentTime-this.effectStartTime>80&&tInfo.currentTime-this.effectStartTime<110)) {
				tInfo.g.setColor(new Color(1.0f, 1.0f, 1.0f, 1.0f));
				tInfo.g.fill(new Rectangle2D.Double(0,TWFrame.title_bar_height,800,600));
			}else if(tInfo.currentTime-this.effectStartTime>=110) {
				this.effectNum=0;
				this.isEffectOn=false;
			}
		}
		return this;
	}

	@Override
	public void control(TWInfo tInfo) {

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(key==KEY_STATE.Z) {
			if(action==Forward.BLACK) {
				this.effectNum=Forward.BLACK;
				if(this.isEffectOn==false&&this.isEffectNow==false) {
					this.isEffectOn=true;
					this.effectStartTime=tInfo.currentTime;
				}else if (this.isEffectNow==true) {
					this.effectStartTime=tInfo.currentTime;
					this.isEffectNow=false;
					this.isEffectOff=true;
				}
			}else if(action==Forward.WHITE) {
				this.effectNum=Forward.WHITE;
				this.isEffectOn=true;
				this.effectStartTime=tInfo.currentTime;
			}else if(action==Forward.WHITE_2) {
				this.effectNum=Forward.WHITE_2;
				this.isEffectOn=true;
				this.effectStartTime=tInfo.currentTime;
			}

		}
		return;
	}

}
