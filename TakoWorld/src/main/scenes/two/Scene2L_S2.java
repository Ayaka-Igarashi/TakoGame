package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2L_S2 extends TWEvent{
	public Scene2L_S2() {
		this.label=SCENE_NUM.TWO_LS2;
		this.next=SCENE_NUM.TWO_LS;

		this.sceneText=TextData.s2_LS2_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_nmL)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
