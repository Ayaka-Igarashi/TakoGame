package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2F_NO extends TWEvent{
	public Scene2F_NO() {
		this.label=SCENE_NUM.TWO_F_NO;
		this.next=SCENE_NUM.THREE;

		this.sceneText=TextData.s2_F_no_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
