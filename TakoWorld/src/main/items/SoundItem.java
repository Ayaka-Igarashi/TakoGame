package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.constant.MUSIC_NUM;
import main.supers.GameItem;
import main.supers.SoundBox;

//BGMを管理
public class SoundItem extends GameItem{

	@Override
	public void first() {
		this.isChange=true;
		this.nowState=MUSIC_NUM.QUESTION;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.isChange==true) {
			if(this.nowState==MUSIC_NUM.QUESTION) {
				SoundBox.singleton.stopClip(MUSIC_NUM.BATTLE);
				SoundBox.singleton.loopClip(MUSIC_NUM.QUESTION);
			}else if(this.nowState==MUSIC_NUM.BATTLE){
				SoundBox.singleton.stopClip(MUSIC_NUM.QUESTION);
				SoundBox.singleton.loopClip(MUSIC_NUM.BATTLE);
			}
			this.isChange=false;
		}

	}

	@Override
	public void keyControl(TWInfo tInfo, int key, int action) {
		if(key==KEY_STATE.Z) {
			if(this.nowState!=action) {
				this.nowState=action;
				this.isChange=true;
			}

		}

	}

	public void stopBGM() {
		SoundBox.singleton.stopClip(this.nowState);
	}

}
