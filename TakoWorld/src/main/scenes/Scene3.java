package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene3 extends TWEvent {

	public Scene3() {
		this.label=SCENE_NUM.THREE;
		this.next=SCENE_NUM.END;

		this.sceneText=TextData.s3_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		//Action c0=new Action(ITEM_NUM.CHOICE,0);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		//this.A.add(new ArrayList<Action>(Arrays.asList(c0)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
