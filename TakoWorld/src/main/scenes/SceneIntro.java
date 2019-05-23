package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.supers.TWEvent;

//イントロのイベントをここに書く
public class SceneIntro extends TWEvent{

	//インスタンスを作ったらAにいろいろ代入される(ここにイベントを書く)
		public SceneIntro() {
			this.label=SCENE_NUM.INTRO;

			Action a1_1= new Action(ITEM_NUM.HOTATE,1);
			Action a1_2=new Action(ITEM_NUM.BACK,1);
			ArrayList<Action> a1=new ArrayList<Action>(Arrays.asList(a1_1,a1_2));
			this.A.add(a1);
		}

}
