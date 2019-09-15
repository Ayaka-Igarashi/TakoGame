package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2F_2 extends TWEvent{
	public Scene2F_2() {
		this.label=SCENE_NUM.TWO_F2;
		this.next=SCENE_NUM.S2;

		this.sceneText=TextData.s2_F2_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
