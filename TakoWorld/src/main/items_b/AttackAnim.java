package main.items_b;

import main.constant.MUSIC_NUM;
import main.supers.SoundBox;

public class AttackAnim extends AnimItem {

	public AttackAnim(int size) {
		this.size=size;
	}

	protected void stopClip() {
		SoundBox.singleton.stopClip(MUSIC_NUM.ATTACK);
		SoundBox.singleton.stopClip(MUSIC_NUM.HIT);
	}

}
