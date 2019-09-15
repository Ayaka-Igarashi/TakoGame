package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2L_S extends TWEvent{
	public Scene2L_S() {
		//ラベル設定
		this.label=SCENE_NUM.TWO_LS;

		//テキスト設定
		this.sceneText=TextData.s2_LS_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		Action c2=new Action(ITEM_NUM.CHOICE,2);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h,b_nm,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c2)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[2]==-1)return;
		if(tInfo.choice[2]==0) {
			this.next=SCENE_NUM.TWO_LS1;
		}else if(tInfo.choice[2]==1) {
			this.next=SCENE_NUM.TWO_LS2;
		}else if(tInfo.choice[2]==2) {
			this.next=SCENE_NUM.TWO_LS3;
		}

	}

}
