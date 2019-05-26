package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.items.Haikei;
import main.items.Hotate;
import main.supers.TWEvent;

//イントロのイベントをここに書く
public class SceneIntro extends TWEvent{

	//インスタンスを作ったらAにいろいろ代入される(ここにイベントを書く)
		public SceneIntro() {
			//ラベル設定
			this.label=SCENE_NUM.INTRO;
			this.next=SCENE_NUM.ONE;

			//テキスト設定
			this.sceneText=TextData.intro_txt;

			//アクション作成
			Action nextText=new Action(ITEM_NUM.TEXT,1);

			Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);
			Action h1= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL);
			Action h2=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED);

			Action b1=new Action(ITEM_NUM.BACK, Haikei.BLUE);
			Action b2=new Action(ITEM_NUM.BACK, Haikei.CASTLE);

			//イベント作成
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b2)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b1)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(h2)));//
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));//固まったぞ
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b2,h_rm)));
			//this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));//余分に一個必要
		}

		@Override
		public boolean isFinished(int pushNum) {
			if(pushNum==A.size()) {
				return true;
			}
			return false;
		}

}
