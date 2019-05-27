package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.TWInfo;
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

		//テキスト設定
		this.sceneText=TextData.s1_txt;

		Action nextText=new Action(ITEM_NUM.TEXT,1);

		Action b2=new Action(ITEM_NUM.BACK, Haikei.CASTLE);

		Action h_rm=new Action(ITEM_NUM.HOTATE,Hotate.REMOVE);
		Action h1= new Action(ITEM_NUM.HOTATE,Hotate.NORMAL);
		Action h2=new Action(ITEM_NUM.HOTATE,Hotate.SWEATED);

		Action c0=new Action(ITEM_NUM.CHOICE,0);

		this.A.add(new ArrayList<Action>(Arrays.asList(b2,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h1)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h2)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c0)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c0)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[0]==-1)return;
		if(tInfo.choice[0]==0) {
			this.next=SCENE_NUM.TWO;
		}else {
			this.next=SCENE_NUM.END;
		}

	}

	@Override
	public boolean isFinished(int pushNum) {
		if(pushNum==A.size()) {
			return true;
		}
		return false;
	}

}