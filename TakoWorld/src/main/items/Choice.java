package main.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.data.TextData;
import main.supers.GameItem;

//選択肢
public class Choice extends GameItem{
	private ArrayList<String[]> choiceText=new ArrayList<String[]>();
	private int nowText;
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,20);

	private Point2D.Double[] loc= {
			new Point2D.Double(200,80),
			new Point2D.Double(200,200),
			new Point2D.Double(200,320)
	};

	private boolean choiceTime=false;//選択肢が出ている状態か
	private int choiceNum;//選択肢の数
	private int nowChoice;//選択しようとしている選択肢番号

	public Choice() {
		this.choiceText.add(TextData.choice1);
	}

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
				if(action<this.choiceText.size()) {
					this.nowText=action;
					this.choiceNum=this.choiceText.get(this.nowText).length;

					this.choiceTime=true;//選択肢表示状態にする
				}
			}else if(this.choiceTime==true) {
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.choiceTime=false;
				this.nowChoice=0;
			}
		}
		if(key==KEY_STATE.UP) {
			if(this.nowChoice>0) {
				this.nowChoice-=1;
			}
		}else if(key==KEY_STATE.DOWN) {
			if(this.nowChoice<this.choiceNum-1) {
				this.nowChoice+=1;
			}
		}
	}

	public void drawText(TWInfo tInfo) {
		tInfo.g.setColor(new Color(50,80,255));
		tInfo.g.setFont(this.font);
		for(int i=0;i<this.choiceText.get(0).length;i++) {
			tInfo.g.drawString(this.choiceText.get(0)[i],(int)this.loc[i].x+40,(int)this.loc[i].y+40);
		}
	}


	@Override
	public GameItem draw(TWInfo tInfo) {
		if(this.choiceTime==true) {
			for(int i=0;i<this.choiceNum;i++) {
				if(i==this.nowChoice) {
					this.setPosition(1, loc[i]);
					this.setVisible(1, true);
					this.drawOne(tInfo,1);
				}else {
					this.setPosition(0, loc[i]);
					this.setVisible(0, true);
					this.drawOne(tInfo,0);
				}
			}
			this.drawText(tInfo);
		}

		return this;
	}

}
