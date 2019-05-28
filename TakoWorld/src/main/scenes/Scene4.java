package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.supers.TWEvent;

public class Scene4 extends TWEvent {

	public Scene4() {
		this.label=SCENE_NUM.FOUR;
		this.next=SCENE_NUM.END;

		this.sceneText=TextData.s4_txt;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;

	}
}
