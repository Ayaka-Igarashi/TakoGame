package main.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.data.TextData;
import main.supers.GameItem;
import main.supers.SoundBox;

//選択肢
public class Choice extends GameItem{
	private ArrayList<String[]> choiceText=new ArrayList<String[]>();
	private int nowText;
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.BOLD,30);

	private Point2D.Double[] loc= {
			new Point2D.Double(40,60),
			new Point2D.Double(40,140),
			new Point2D.Double(40,220)
	};

	private boolean choiceTime;//選択肢が出ている状態か
	private int choiceNum;//選択肢の数
	private int nowChoice=0;//選択しようとしている選択肢番号

	private int img_width;
	private int img_height;

	public Choice() {
		this.choiceText.add(TextData.choice0);
		this.choiceText.add(TextData.choice1);
		this.choiceText.add(TextData.choice2);
		this.choiceText.add(TextData.choice3);
		this.choiceText.add(TextData.choice4);
		this.choiceText.add(TextData.choice5);
	}

	public boolean isChoiceTime() {
		return this.choiceTime;
	}

	//セーブ用のセッター
	public int getChoiceTimeInt() {
		if(this.choiceTime==true) {
			return 1;
		}else {
			return 0;
		}
	}
	public int getChoiceText() {
		return this.nowText;
	}

	//データ適用
	public void applyChoiceTime(int choiceTime,int choiceText) {
		if(choiceTime==1) {
			this.choiceTime=true;
			this.nowText=choiceText;
			this.choiceNum=this.choiceText.get(this.nowText).length;
		}else {
			this.choiceTime=false;
		}
		this.nowChoice=0;
	}


	//初期画像設定
	@Override
	public void first() {
		this.img_width=this.getImage(0).getWidth();
		this.img_height=this.getImage(0).getHeight();
		this.choiceTime=false;
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
				tInfo.choice[this.nowText]=this.nowChoice;//選択した選択肢を保存
				this.setVisible(0, false);
				this.setVisible(1, false);
				this.choiceTime=false;
				this.nowChoice=0;
			}
		}
		if(key==KEY_STATE.UP) {
			if(this.choiceTime==true) {
				if(this.nowChoice>0) {
					this.nowChoice-=1;
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			}
		}else if(key==KEY_STATE.DOWN) {
			if(this.choiceTime==true) {
				if(this.nowChoice<this.choiceNum-1) {
					this.nowChoice+=1;
				}
				SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
			}
		}
	}

	public void drawText(TWInfo tInfo) {
		tInfo.g.setColor(new Color(0, 25, 132));
		tInfo.g.setFont(this.font);
		FontMetrics fm=tInfo.g.getFontMetrics();
		int sw;//文字の長さ
		int sh;
		for(int i=0;i<this.choiceText.get(this.nowText).length;i++) {
			sw=fm.stringWidth(this.choiceText.get(this.nowText)[i]);
			sh=fm.getHeight();
			this.drawStr(tInfo,
					this.choiceText.get(this.nowText)[i],
					(int)this.loc[i].x+this.img_width/2-sw/2-260,
					(int)this.loc[i].y+this.img_height/2+sh/2 -285);
		}
	}


	@Override
	public GameItem draw(TWInfo tInfo) {

		if(this.choiceTime==true) {
			this.setVisible(0, true);
			this.drawOne(tInfo,0);
			this.setPosition(1, loc[this.nowChoice]);
			this.setVisible(1, true);
			this.drawOne(tInfo,1);

			/*
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
			*/
			this.drawText(tInfo);
		}

		return this;
	}

}
