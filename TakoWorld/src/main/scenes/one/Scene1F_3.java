package main.scenes.one;

import java.util.ArrayList;
import java.util.Arrays;

import main.TWInfo;
import main.constant.ITEM_NUM;
import main.constant.SCENE_NUM;
import main.data.TextData;
import main.struct.Action;
import main.supers.TWEvent;

public class Scene1F_3 extends TWEvent{
	public Scene1F_3() {
		//ラベル設定
		this.label=SCENE_NUM.ONE_F3;

		//テキスト設定
		this.sceneText=TextData.s1_F3_txt;
		this.sceneTextChara=TextData.s1_F3_txt_chara;

		Action c4=new Action(ITEM_NUM.CHOICE,4);

		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,b_nm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,takoyaki_R)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,e_rm,h_happyR)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,takoyaki_R,h_rm)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,e_rm,h_nmR)));//
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText)));
		this.A.add(new ArrayList<Action>(Arrays.asList(nextText,s_nmL)));
		this.A.add(new ArrayList<Action>(Arrays.asList(c4,h_rm,s_nmL,e_rm)));
	}

	@Override
	public void branch(TWInfo tInfo) {
		if(tInfo.choice[4]==-1)return;
		if(tInfo.choice[4]==0) {
			this.next=SCENE_NUM.ONE_F_YES;
			tInfo.help1Flg=1;
		}else if(tInfo.choice[4]==1) {
			this.next=SCENE_NUM.ONE_F_NO;
			tInfo.help1Flg=0;
		}

	}

}
