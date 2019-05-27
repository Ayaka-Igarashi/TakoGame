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

public class Scene1 extends TWEvent{
	public Scene1() {
		//ラベル設定
		this.label=SCENE_NUM.ONE;
		this.next=SCENE_NUM.END;//次はエンディング

		//テキスト設定
		this.sceneText=TextData.s1_txt;

		Action nextText=new Action(ITEM_NUM.TEXT,1);

		Action b2=new Action(ITEM_NUM.BACK, Haikei.CASTLE);

		Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);
		Action h1= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL);
		Action h2=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED);

		this.A.add(new ArrayList<Action>(Arrays.asList(b2,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		//this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));//ending
	}

	@Override
	public boolean isFinished(int pushNum) {
		if(pushNum==A.size()) {
			return true;
		}
		return false;
	}

}
