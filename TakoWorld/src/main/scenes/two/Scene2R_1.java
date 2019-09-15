package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2R_1 extends TWEvent{
	public Scene2R_1() {
		this.label=SCENE_NUM.TWO_R1;

		this.sceneText=TextData.s2_R1_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		Action c3=new Action(ITEM_NUM.CHOICE,3);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c3)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[3]==-1)return;
		if(tInfo.choice[3]==0) {
			this.next=SCENE_NUM.TWO_R3;
		}else if(tInfo.choice[3]==1) {
			this.next=SCENE_NUM.TWO_R4;
		}
	}
}
