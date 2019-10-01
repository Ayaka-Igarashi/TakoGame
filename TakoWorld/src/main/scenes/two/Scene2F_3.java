package main.scenes.two;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene2F_3 extends TWEvent{
	public Scene2F_3() {
		this.label=SCENE_NUM.TWO_F3;

		this.sceneText=TextData.s2_R1_txt;
		this.sceneTextChara=TextData.intro_txt_chara;

		Action c5=new Action(ITEM_NUM.CHOICE,5);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c5)));

	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[5]==-1)return;
		if(tInfo.choice[5]==0) {
			this.next=SCENE_NUM.TWO_F_YES;
			tInfo.help2Flg=1;
		}else if(tInfo.choice[5]==1) {
			this.next=SCENE_NUM.TWO_F_NO;
			tInfo.help2Flg=0;
		}
	}
}
