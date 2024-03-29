package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene4 extends TWEvent {

	public Scene4() {
		this.label=SCENE_NUM.FOUR;
		this.next=SCENE_NUM.S2;

		this.sceneText=TextData.s4_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;

	}
}
