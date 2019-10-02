package main.scenes.one;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1F_YES extends TWEvent{
	public Scene1F_YES() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_F_YES;
		this.next=SCENE_NUM.TWO;

		//テキスト設定
		this.sceneText=TextData.s1_F_yes_txt;
		this.sceneTextChara=TextData.s1_F_yes_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,takoyaki_L,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_happyR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,s_nmR,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
