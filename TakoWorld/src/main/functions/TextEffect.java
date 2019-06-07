package main.functions;

import java.awt.Color;
import java.awt.geom.Point2D;

import main.TWFrame;
import main.TWInfo;
import main.items.GameText;

//一文を文字送り
public class TextEffect {

	public static int nowLine=0;
	public static boolean strFin=true;
	public static long lastTime;

	//変数の初期化（次のテキストにするたびに呼び出す）
	public static void firstPrm(TWInfo tInfo) {
		TextEffect.nowLine=0;
		TextEffect.strFin=false;
		TextEffect.lastTime=tInfo.currentTime;
	}
/*
	//アニメなしver
	public static String[] textAnim(TWInfo tInfo,String[] texts) {
		TextEffect.strFin=true;
		return texts;
	}
	*/

	//毎回呼び出される
	public static String[] textAnim(TWInfo tInfo,String[] texts) {
		String[] nowText=new String[GameText.gyoNum];
		Point2D.Double pointer=new Point2D.Double();
		int charNum;
		int nowNum;
		int num;
		if(TextEffect.strFin==true) {
			for(int i=0;i<texts.length;i++) {
				nowText[i]=texts[i];
			}
			TextEffect.nowLine=texts.length-1;
		}else {
			//文字送り済みの行
			for(int i=0;i<TextEffect.nowLine;i++) {
				nowText[i]=texts[i];
			}
			//文字送りが未遂な行の初期化
			for(int i=TextEffect.nowLine;i<texts.length;i++) {
				nowText[i]="";
			}
			//文字送りをする
			if(TextEffect.nowLine<texts.length) {
				char[] c=texts[TextEffect.nowLine].toCharArray();
				charNum=c.length;//文字の数
				//文字送りスピード調節
				nowNum=(int)((double)(tInfo.currentTime-TextEffect.lastTime)*0.05);
				num=Math.min(charNum,nowNum);
				for(int j=0;j<num;j++) {
					nowText[TextEffect.nowLine]+=String.valueOf(c[j]);
				}
				//文字送りの終了&次の行へ
				if(charNum<nowNum) {
					//次の行を文字送りする
					if(TextEffect.nowLine<texts.length-1) {
						TextEffect.nowLine+=1;
					}else if(TextEffect.nowLine==texts.length-1) {
						TextEffect.strFin=true;//次の文にいってよい
					}

					TextEffect.lastTime=tInfo.currentTime;//時間の更新
				}
			}
		}
		//文字送り終了時のポインターを描く
		if(TextEffect.nowLine==texts.length-1&&TextEffect.strFin==true) {
			//ポインターの位置
			pointer.x=165+texts[TextEffect.nowLine].length()*20;
			pointer.y=460+(TextEffect.nowLine)*GameText.gyoSp+TWFrame.title_bar_height;//////////
			tInfo.g.setBackground(new Color(50,80,255));
			tInfo.g.fillRect((int)pointer.x, (int)pointer.y, 12,12);
		}
		return nowText;
	}

/*
	//1行の処理
	public static String OneTextAnim(String text,long lastTime) {
		return text;
	}*/

}
