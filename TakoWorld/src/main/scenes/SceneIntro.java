package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
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

			//イベント作成
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_castle)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_nm)));/*
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));*/
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));//固まったぞ
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_castle)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_nm)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_castle,h_rm)));
		}

		@Override
		public void branch(TWInfo tInfo) {
			return;
		}

}
