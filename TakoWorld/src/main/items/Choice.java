package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.supers.GameItem;

//選択肢
public class Choice extends GameItem{

	//初期画像設定
	@Override
	public void first() {
	}

	//毎回呼び出される
	@Override
	public void control(TWInfo tInfo) {
		return;
	}

	//キーが押された時の処理
	@Override
	public void keyControl(TWInfo tInfo, int key,int action) {
		if(key==KEY_STATE.Z) {
			if(action==1) {

			}else if(action==2) {

			}else if(action==3) {

			}

			this.setVisible(0, true);
			this.setVisible(1, true);
		}
		if(key==KEY_STATE.UP) {

		}else if(key==KEY_STATE.DOWN) {

		}

	}

	@Override
	public GameItem draw(TWInfo tInfo) {

		return this;
	}



}
