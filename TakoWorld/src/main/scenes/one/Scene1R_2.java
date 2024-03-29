package main.scenes.one;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1R_2 extends TWEvent{
	public Scene1R_2() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_R2;
		this.next=SCENE_NUM.ONE_S;

		//テキスト設定
		this.sceneText=TextData.s1_R2_txt;
		this.sceneTextChara=TextData.s1_R2_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nmR,b_nm,s_nmL)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
