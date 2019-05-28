package main.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Point2D;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

public class Menu extends GameItem {
	private boolean menuTime;
	private int nowChoice;
	private String[] menuText= {"SAVE","LOAD","EXIT"};
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.BOLD,25);

	private Point2D.Double[] loc= {
			new Point2D.Double(280,80),
			new Point2D.Double(280,190),
			new Point2D.Double(280,300)
	};

	private int img_width;
	private int img_height;

	public boolean isMenuTime() {
		return this.menuTime;
	}


	@Override
	public void first() {
		this.img_width=this.getImage(1).getWidth();
		this.img_height=this.getImage(1).getHeight();
		return;

	}

	@Override
	public void control(TWInfo tInfo) {
		return;

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(key==KEY_STATE.Z) {
			if(this.menuTime==false) {

					this.menuTime=true;//メニュー表示状態にする

			}else if(this.menuTime==true) {
				this.setVisible(0, false);
				this.menuTime=false;
				this.nowChoice=0;
			}
		}
		if(key==KEY_STATE.UP) {
			if(this.nowChoice>0) {
				this.nowChoice-=1;
			}
		}else if(key==KEY_STATE.DOWN) {
			if(this.nowChoice<2) {
				this.nowChoice+=1;
			}
		}
		return;

	}

	public void drawText(TWInfo tInfo) {
		tInfo.g.setColor(Color.BLACK);
		tInfo.g.setFont(this.font);
		FontMetrics fm=tInfo.g.getFontMetrics();
		int sw;//文字の長さ
		int sh;
		for(int i=0;i<this.menuText.length;i++) {
			sw=fm.stringWidth(this.menuText[i]);
			sh=fm.getHeight();
			tInfo.g.drawString(this.menuText[i],
					(int)this.loc[i].x+this.img_width/2-sw/2,
					(int)this.loc[i].y+this.img_height/2+sh/2 -5);
		}
	}

	@Override
	public GameItem draw(TWInfo tInfo) {
		if(this.menuTime==true) {
			this.setPosition(0, loc[0]);
			this.setVisible(0, true);
			this.drawOne(tInfo, 0);

			this.setPosition(1, loc[this.nowChoice]);
			this.setVisible(1, true);
			this.drawOne(tInfo,1);

			this.drawText(tInfo);
		}

		return this;
	}

}
