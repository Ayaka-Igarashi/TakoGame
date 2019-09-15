package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2R_4 extends TWEvent{
	public Scene2R_4() {
		this.label=SCENE_NUM.TWO_R4;
		this.next=SCENE_NUM.TWO_S;

		this.sceneText=TextData.s2_R4_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
