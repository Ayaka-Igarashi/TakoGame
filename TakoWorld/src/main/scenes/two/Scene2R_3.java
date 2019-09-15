package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2R_3 extends TWEvent{
	public Scene2R_3() {
		this.label=SCENE_NUM.TWO_R3;
		this.next=SCENE_NUM.SExtra;//Extraいくようにする

		this.sceneText=TextData.s2_R3_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
