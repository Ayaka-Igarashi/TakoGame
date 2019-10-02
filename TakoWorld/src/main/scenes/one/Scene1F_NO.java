package main.scenes.one;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1F_NO extends TWEvent{
	public Scene1F_NO() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_F_NO;
		this.next=SCENE_NUM.TWO;

		//テキスト設定
		this.sceneText=TextData.s1_F_no_txt;
		this.sceneTextChara=TextData.s1_F_no_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_cryR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_cryR,s_nmL)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
