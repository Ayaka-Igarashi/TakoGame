package main.scenes.one;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1F_1 extends TWEvent{
	public Scene1F_1() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_F1;
		this.next=SCENE_NUM.ONE_S;

		//テキスト設定
		this.sceneText=TextData.s1_F1_txt;
		this.sceneTextChara=TextData.s1_F1_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,s_nmL,b_nm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_activeR,s_nmL,b_nm)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
