package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2L_S3 extends TWEvent{
	public Scene2L_S3() {
		this.label=SCENE_NUM.TWO_LS3;
		this.next=SCENE_NUM.TWO_LS;

		this.sceneText=TextData.s2_LS3_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_nm,h_happyR,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_nmL)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
