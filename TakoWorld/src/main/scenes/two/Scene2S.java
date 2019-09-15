package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2S extends TWEvent{
	public Scene2S() {
		//ラベル設定
		this.label=SCENE_NUM.TWO_S;

		//テキスト設定
		this.sceneText=TextData.s2_S_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		Action c1=new Action(ITEM_NUM.CHOICE,1);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h,b_nm,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c1)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[1]==-1)return;
		if(tInfo.choice[1]==0) {
			this.next=SCENE_NUM.TWO_L1;
		}else if(tInfo.choice[1]==1) {
			this.next=SCENE_NUM.TWO_F2;
		}else if(tInfo.choice[1]==2) {
			this.next=SCENE_NUM.TWO_R1;
		}
	}

}
