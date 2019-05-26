package main.items;

import java.awt.Color;
import java.awt.Font;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.functions.TextEffect;

//テキスト
public class GameText {
	private String[][] gameTexts;
	private int nowTextNum;//現在のテキスト番号
	private String[] nowText=new String[3];//現在の表示テキスト
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,20);
	private boolean endFlg;//テキストが終わりかどうか

	//テキスト設定
	public void setTexts(String[][] sceneTexts) {
		this.gameTexts=sceneTexts;
		return;
	}

	//テキスト番号の初期化
	public void resetNowTextNum() {
		this.nowTextNum=0;
	}

	//初期設定
	public void first() {
		this.nowTextNum=0;
		TextEffect.nowLine=0;
		TextEffect.strFin=true;
		this.endFlg=false;
		return;
	}

	//テキストを表示する
	public void draw(TWInfo tInfo) {
		tInfo.g.setColor(new Color(50,80,255));
		tInfo.g.setFont(this.font);
		this.calcText(tInfo);
		for(int i=0;i<gameTexts[nowTextNum].length;i++) {
			tInfo.g.drawString(this.nowText[i],155,470+i*27);
		}
		return;
	}

	//現在の表示テキストを求める
	private void calcText(TWInfo tInfo) {
		this.nowText=TextEffect.textAnim(tInfo,this.gameTexts[nowTextNum]);
		return;
	}

	public void control(TWInfo tInfo) {
		return;
	}

	//押された瞬間の処理
	public void keyControl(TWInfo tInfo, int key,int action) {
		if(key==KEY_STATE.Z) {
			if(TextEffect.strFin==true) {
				if(this.nowTextNum<gameTexts.length-1) {//次の文章へ
					this.nowTextNum+=1;
					TextEffect.firstPrm(tInfo);
				}else if(this.nowTextNum==gameTexts.length-1) {//テキストの終了
					this.endFlg=true;
					TextEffect.nowLine=0;
				}
			}else if(TextEffect.strFin==false) {
				TextEffect.strFin=true;
			}
		}
		return;
	}

	//テキストが終わりかどうか
	public boolean isEnd() {
		return this.endFlg;
	}
}
