package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2R_5 extends TWEvent{
	public Scene2R_5() {
		this.label=SCENE_NUM.TWO_R5;
		this.next=SCENE_NUM.TWO_S;

		this.sceneText=TextData.s2_R5_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		tInfo.extraFlg=true;
		return;
	}
}
