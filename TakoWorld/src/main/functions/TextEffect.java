package main.functions;

import java.awt.Color;

import main.TWInfo;

//一文を文字送り
public class TextEffect {

	public static int nowLine=0;

	//毎回呼び出される
	public static String[] textAnim(TWInfo tInfo,String[] texts,boolean strFin,long lastTime) {

		String[] nowText;
		int charNum;
		int nowNum;
		int num;
		if(strFin==true) {
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
				nowNum=(int)((double)(tInfo.currentTime-lastTime)*0.025);
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
						strFin=true;//次の文にいってよい
					}

					lastTime=tInfo.currentTime;//時間の更新
				}
			}
		}
		//文字送り終了時のポインターを描く
		if(TextEffect.nowLine==texts.length-1&&strFin==true) {
			//ポインターの位置
			this.pointer.x=165+texts[TextEffect.nowLine].length()*20;
			this.pointer.y=460+(this.nowLine)*27;//////////
			tInfo.g.setBackground(new Color(50,80,255));
			tInfo.g.fillRect((int)this.pointer.x, (int)this.pointer.y, 12,12);
		}
		return nowText;
	}

	//1行の処理
	public static String OneTextAnim(String text,long lastTime) {
		return text;
	}

}
