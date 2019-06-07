package main.items;

import java.awt.Color;
import java.awt.Font;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.functions.TextEffect;
import main.supers.GameItem;

//テキスト
public class GameText extends GameItem{
	private String[][] gameTexts;
	private int nowTextNum;//現在のテキスト番号
	public static final int gyoNum=2;//行数
	public static final int gyoSp=45;//行間隔
	private String[] nowText=new String[GameText.gyoNum];//現在の表示テキスト
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,20);

	//テキスト設定
	public void setTexts(String[][] sceneTexts) {
		this.gameTexts=sceneTexts;
		return;
	}

	//テキスト番号の初期化
	public void resetNowTextNum() {
		this.nowTextNum=0;
	}

	public void setNowTextNum(int num) {
		this.nowTextNum=num;
	}

	@Override
	//初期設定
	public void first() {
		this.nowTextNum=0;
		TextEffect.nowLine=0;
		TextEffect.strFin=true;
		return;
	}

	@Override
	//テキストを表示する
	public GameItem draw(TWInfo tInfo) {
		tInfo.g.setColor(new Color(50,80,55));
		tInfo.g.setFont(this.font);
		this.calcText(tInfo);
		for(int i=0;i<gameTexts[nowTextNum].length;i++) {
			this.drawStr(tInfo, this.nowText[i], 155, 470+i*GameText.gyoSp);
			//tInfo.g.drawString(this.nowText[i],155,470+i*GameText.gyoSp);
		}
		return this;
	}

	//現在の表示テキストを求める
	private void calcText(TWInfo tInfo) {
		this.nowText=TextEffect.textAnim(tInfo,this.gameTexts[nowTextNum]);
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	@Override
	//押された瞬間の処理
	public void keyControl(TWInfo tInfo, int key,int action) {
		if(key==KEY_STATE.Z) {
			if(TextEffect.strFin==true) {
				if(this.nowTextNum<gameTexts.length-1) {//次の文章へ（表示テキストをaction(pushNumZ）に依存させたい?
					this.nowTextNum+=1;//this.nowTextNum=action;
					TextEffect.firstPrm(tInfo);
				}
			}else if(TextEffect.strFin==false) {
				TextEffect.strFin=true;
			}
		}
		return;
	}

}
