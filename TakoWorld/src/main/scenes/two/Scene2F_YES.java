package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2F_YES extends TWEvent{
	public Scene2F_YES() {
		this.label=SCENE_NUM.TWO_F_YES;
		this.next=SCENE_NUM.THREE;

		this.sceneText=TextData.s2_F1_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
