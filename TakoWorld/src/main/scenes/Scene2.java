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

public class Scene2 extends TWEvent{
	public Scene2() {
		this.label=SCENE_NUM.TWO;
		this.next=SCENE_NUM.END;//次はエンディング

		this.sceneText=TextData.s2_txt;

		Action nextText=new Action(ITEM_NUM.TEXT,1);

		Action b2=new Action(ITEM_NUM.BACK, Haikei.CASTLE);

		Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);
		Action h1= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL);
		Action h2=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b2,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h2)));

	}

	@Override
	public boolean isFinished(int pushNum) {
		if(pushNum==A.size()) {
			return true;
		}
		return false;
	}

}
