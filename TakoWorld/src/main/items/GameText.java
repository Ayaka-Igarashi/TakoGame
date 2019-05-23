package main.items;

import java.awt.Color;
import java.awt.Font;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.functions.TextEffect;
import main.supers.SoundBox;

//テキスト
public class GameText {
	private String[][] gameTexts= {
			{""},
			{"私はタコが嫌いです。ぬめぬめしているし、","吸盤ぺたぺたしているし、"},
			{"そんなのが腕によじ登ってきたらと思うと","ゾッとします。"},
			{"なんでみんながタコ焼なんかをを美味しそうに","食べているのか、わかりません、","ありえません、冒涜的です。"},
			{"そんなことを考えながら歩いていたいつもの通学路、","海の見える丘でその事件は起こります…"},
			{"ミツケタゾ、アイツダ。"},
			{"今日、雨降るなんて聞いてないよー","折り畳み傘持ってきておいてよかった。"},
			{"さっさと家に帰ろ"},
			{"オイ、ソコノオマエ。"},
			{"えっ"},
			{"オマエダ、オマエ、ミツケタゾ"},
			{"たこ焼き…？"},
			{"ソウダ、オマエダ"},
			{"たこ焼きが…喋ってるっ！！"},
			{"キズクノガ、オソイゾ。"},
			{"なんで、どうして、どうやって！","疲れてるのかな…本の読みすぎ？TRPGのやりすぎ？"},
			{"そしてなんでよりにもよってたこ焼きなの！","私の一番苦手な料理、”た・こ・や・き”！"},
			{"カタマッタゾ、"},
			{"ドウスルカ。"},
			{"チョウドイイ、コノママ、ハコンデイコウ。"},
			{""},
			{"ヨウコソ、”たこわーるど”へ…"}
	};
	private int nowTextNum;//現在のテキスト番号
	private String[] nowText=new String[3];//現在の表示テキスト
	private Font font=new Font("HG丸ｺﾞｼｯｸM-PRO",Font.PLAIN,20);
	private boolean endFlg;//テキストが終わりかどうか

	//テキストデータを外部から読み込む
	public void getTexts() {

		return;
	}

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
			tInfo.g.drawString(this.nowText[i],155,470+i*27);///////
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
					//TextEffect.nowLine=0;
				}
			}else if(TextEffect.strFin==false) {
				TextEffect.strFin=true;
			}
			SoundBox.singleton.playClip(MUSIC_NUM.CHOICE);//効果音を流す
		}
		return;
	}

	//テキストが終わりかどうか
	public boolean isEnd() {
		return this.endFlg;
	}
}
