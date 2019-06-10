package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2 extends TWEvent{
	public Scene2() {
		this.label=SCENE_NUM.TWO;
		this.next=SCENE_NUM.END;//次はエンディング

		this.sceneText=TextData.s2_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h)));
		this.A.add(new ArrayList<Action>(Arrays.asList(h_sw_h)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}
}
