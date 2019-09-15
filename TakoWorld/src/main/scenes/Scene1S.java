package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1S extends TWEvent{
	public Scene1S() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_S;

		//テキスト設定
		this.sceneText=TextData.s1_S_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		Action c0=new Action(ITEM_NUM.CHOICE,0);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm_h,b_nm,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c0)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[0]==-1)return;
		if(tInfo.choice[0]==0) {
			this.next=SCENE_NUM.ONE_L;
		}else if(tInfo.choice[0]==1) {
			this.next=SCENE_NUM.ONE_F2;
		}else if(tInfo.choice[0]==2) {
			this.next=SCENE_NUM.ONE_R1;
		}

	}

}
