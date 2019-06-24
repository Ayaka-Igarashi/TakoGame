package main.items_b;

import main.constant.MUSIC_NUM;
import main.supers.SoundBox;

public class SpAttackAnim extends AnimItem {

	public SpAttackAnim(int size) {
		this.size=size;
		this.position.x=400;
		this.position.y=300;
	}

	@Override
	protected void stopClip() {
		SoundBox.singleton.stopClip(MUSIC_NUM.BOMB);

	}


}
