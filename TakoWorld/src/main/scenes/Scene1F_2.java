package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1F_2 extends TWEvent{
	public Scene1F_2() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_F2;
		this.next=SCENE_NUM.S1;

		//テキスト設定
		this.sceneText=TextData.s1_F2_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		this.A.add(new ArrayList<Action>(Arrays.asList(h_rm,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h,b_nm,s_rm)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		return;
	}

}
