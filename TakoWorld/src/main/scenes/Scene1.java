package main.scenes;

import java.util.ArrayList;
import java.util.Arrays;

import main.Action;
import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.supers.TWEvent;

public class Scene1 extends TWEvent{
	public Scene1() {
		//ラベル設定
		this.label=SCENE_NUM.ONE;

		//テキスト設定
		this.sceneText=TextData.s1_txt;

		Action c0=new Action(ITEM_NUM.CHOICE,0);

		this.A.add(new ArrayList<Action>(Arrays.asList(h_rm,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm,b_nm,s_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw,b_nm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_nm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,h_sw)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c0)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[0]==-1)return;
		if(tInfo.choice[0]==0) {
			this.next=SCENE_NUM.TWO;
		}else if(tInfo.choice[0]==1) {
			this.next=SCENE_NUM.THREE;
		}else if(tInfo.choice[0]==2) {
			this.next=SCENE_NUM.FOUR;
		}

	}

}
