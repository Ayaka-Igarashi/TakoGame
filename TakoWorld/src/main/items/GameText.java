package main.items;

import java.awt.Color;
import java.awt.Font;

import main.KEY_STATE;
import main.TWInfo;

public class GameText {
	private String[][] gameTexts= {
			{"やほーー","おはおは","こんにちは"},
			{"はろー"},
			{"私は今、","どこにいるの？"}
	};
	private int nowTextNum=0;//現在のテキスト番号
	private String[] nowText;//現在の表示テキスト
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,25);
	private boolean strFin=false;
	private long lastPushTime;

	//テキストデータを外部から読み込む
	public void getTexts() {

		return;
	}

	//テキストを表示する(文字送りしたい)
	public void draw(TWInfo tInfo) {
		tInfo.g.setColor(new Color(50,80,255));
		tInfo.g.setFont(this.font);
		for(int i=0;i<gameTexts[nowTextNum].length;i++) {
		tInfo.g.drawString(gameTexts[nowTextNum][i],150,480+i*35);
		}
		return;
	}

	//現在の表示テキストを求める
	private void calcText(TWInfo tInfo) {
		for(int i=0;i<gameTexts[nowTextNum].length;i++) {
			//gameTexts[nowTextNum][i]をcharに変換
			//int num=charの個数（文字数）
			//(int)(tInfo.currentTime-lastPushTime)/50
			//for文i<num
			//nowText[i]+=変換したやつ
		}


		return;
	}


	public void control(TWInfo tInfo) {
		return;
	}

	public void keyControl(TWInfo tInfo) {
		if(tInfo.keyState[KEY_STATE.Z]&&strFin==true) {
			if(nowTextNum<gameTexts.length-1) {nowTextNum+=1;}
			lastPushTime=tInfo.currentTime;
			strFin=false;
		}
		return;
	}
}
