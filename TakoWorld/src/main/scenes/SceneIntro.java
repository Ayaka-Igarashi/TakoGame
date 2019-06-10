package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

//イントロのイベントをここに書く
public class SceneIntro extends TWEvent{

	//インスタンスを作ったらAにいろいろ代入される(ここにイベントを書く)
		public SceneIntro() {
			//ラベル設定
			this.label=SCENE_NUM.INTRO;
			this.next=SCENE_NUM.END;

			//テキスト設定
			this.sceneText=TextData.intro_txt;
			this.sceneTextChara=TextData.intro_txt_chara;

			//イベント作成
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h)));//固まったぞ
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw_h)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_rm)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_pp,h_lazyR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));//..きろ
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));//..きろ
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,s_nmL,h_activeR)));//起きろって
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));//本当に苦手なので
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));//えっと
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
			this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
		}

		@Override
		public void branch(TWInfo tInfo) {
			return;
		}

}
