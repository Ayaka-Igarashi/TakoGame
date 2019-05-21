package main.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;

import main.KEY_STATE;
import main.TWInfo;

public class GameText {
	private String[][] gameTexts= {
			{""},
			{"やほーー","おはおは","こんにちは"},
			{"はろー"},
			{"私は今、","どこにいるの？"}
	};
	private int nowTextNum=0;//現在のテキスト番号
	private String[] nowText=new String[3];//現在の表示テキスト
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,25);
	private boolean strFin=true;//次のテキストに行ってよいか
	private long lastTime;
	private int nowLine;//文字送り行数
	private Point2D.Double pointer;

	//テキストデータを外部から読み込む
	public void getTexts() {

		return;
	}

	//テキストを表示する
	public void draw(TWInfo tInfo) {
		tInfo.g.setColor(new Color(50,80,255));
		tInfo.g.setFont(this.font);
		this.calcText(tInfo);
		for(int i=0;i<gameTexts[nowTextNum].length;i++) {
			tInfo.g.drawString(this.nowText[i],160,480+i*35);
		}
		return;
	}

	//現在の表示テキストを求める
	private void calcText(TWInfo tInfo) {
		int charNum;
		int nowNum;
		int num;
		//文字送り済みの行
		for(int i=0;i<this.nowLine;i++) {
			this.nowText[i]=this.gameTexts[nowTextNum][i];
		}
		//文字送りが未の行の初期化
		for(int i=this.nowLine;i<gameTexts[nowTextNum].length;i++) {
			this.nowText[i]="";
		}
		//文字送りをする
		if(this.nowLine<gameTexts[nowTextNum].length) {
			char[] c=gameTexts[nowTextNum][this.nowLine].toCharArray();
			charNum=c.length;//文字の数
			nowNum=(int)((double)(tInfo.currentTime-this.lastTime)/100);//文字送りスピード
			num=Math.min(charNum,nowNum);
			for(int j=0;j<num;j++) {
				this.nowText[this.nowLine]+=String.valueOf(c[j]);
			}
			//文字送りの終了&次の行へ
			if(charNum<nowNum) {
				//次の行を文字送りする
				if(this.nowLine<gameTexts[nowTextNum].length) {
					this.nowLine+=1;
				}

				this.lastTime=tInfo.currentTime;//時間の更新
			}
		}
		//文字送り終了処理
		if(this.nowLine==gameTexts[nowTextNum].length) {
			this.strFin=true;//次の文にいってよい
			tInfo.g.setBackground(new Color(50,80,255));
			tInfo.g.fillRect(750, 550, 15, 15);
		}
		return;
	}


	public void control(TWInfo tInfo) {
		return;
	}

	public void keyControl(TWInfo tInfo) {

		if(tInfo.keyState[KEY_STATE.Z]&&this.strFin==true) {
			if(this.nowTextNum<gameTexts.length-1) {this.nowTextNum+=1;}
			this.lastTime=tInfo.currentTime;
			this.nowLine=0;
			this.strFin=false;
		}
		return;
	}
}
