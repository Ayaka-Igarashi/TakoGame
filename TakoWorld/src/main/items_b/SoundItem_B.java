package main.items_b;

import main.constant.MUSIC_NUM;
import main.items.SoundItem;

public class SoundItem_B extends SoundItem {

	@Override
	public void first() {
		this.isChange=true;
		this.nowState=MUSIC_NUM.BATTLE;
	}

}
