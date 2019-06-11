package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.struct.TextChara;
import main.supers.GameItem;

public class TextBox extends GameItem {

	TextChara[] textChara;//データ
	int nowTextNum;//現在のテキスト番号

	public static final int NON=0;
	public static final int HOTATE_UN=1;
	public static final int HOTATE=2;
	public static final int SAME_UN=3;
	public static final int SAME=4;
	public static final int UNKNOWN=5;

	@Override
	public void first() {
		this.nowTextNum=0;
		this.setVisible(0, true);
		this.setVisible(1, false);
		this.setVisible(2, false);
		this.setVisible(3, false);
		this.setVisible(4, false);
		this.setVisible(5, true);
		this.setVisible(6, true);
		this.setVisible(7, false);
		this.setVisible(8, false);
		this.setVisible(9, false);
		this.setVisible(10, false);
		this.setVisible(11, false);
		this.setVisible(12, false);
		return;
	}

	@Override
	public void control(TWInfo tInfo) {
		if(this.textChara[nowTextNum].pos==-1) {
			this.setVisible(1, true);
			this.setVisible(2, true);
			for(int i=3;i<this.imgList.size();i++) {
				this.setVisible(i, false);
			}
		}else if(this.textChara[nowTextNum].pos==TextChara.left) {
			this.setVisible(1, true);
			this.setVisible(2, true);
			if(this.textChara[nowTextNum].chara==TextBox.NON) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(9, false);
				this.setVisible(11, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, true);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(9, true);
				this.setVisible(11, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE_UN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, true);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(9, false);
				this.setVisible(11, true);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME) {
				this.setVisible(3, true);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, true);
				this.setVisible(9, false);
				this.setVisible(11, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME_UN) {
				this.setVisible(3, true);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(9, false);
				this.setVisible(11, true);
			}else if(this.textChara[nowTextNum].chara==TextBox.UNKNOWN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(9, false);
				this.setVisible(11, true);
			}else if(this.textChara[nowTextNum].chara==-1) {
				this.setVisible(7, false);
				this.setVisible(8, false);
				this.setVisible(9, false);
			}

		}else if(this.textChara[nowTextNum].pos==TextChara.right) {
			this.setVisible(1, true);
			this.setVisible(2, true);
			if(this.textChara[nowTextNum].chara==TextBox.NON) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(8, false);
				this.setVisible(10, false);
				this.setVisible(12, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, true);
				this.setVisible(8, false);
				this.setVisible(10, true);
				this.setVisible(12, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE_UN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, true);
				this.setVisible(8, false);
				this.setVisible(10, false);
				this.setVisible(12, true);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME) {
				this.setVisible(3, false);
				this.setVisible(4, true);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(8, true);
				this.setVisible(10, false);
				this.setVisible(12, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME_UN) {
				this.setVisible(3, false);
				this.setVisible(4, true);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(8, false);
				this.setVisible(10, false);
				this.setVisible(12, true);
			}else if(this.textChara[nowTextNum].chara==TextBox.UNKNOWN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(8, false);
				this.setVisible(10, false);
				this.setVisible(12, true);
			}else if(this.textChara[nowTextNum].chara==-1) {
				this.setVisible(8, false);
				this.setVisible(10, false);
				this.setVisible(12, false);
			}
		}

	}

	@Override
	public void keyControl(TWInfo tInfo,int key,int action) {
		if(key==KEY_STATE.Z) {
			if(this.nowTextNum<textChara.length-1) {//次の文章へ
				this.nowTextNum+=1;
			}
		}
		return;
	}

}
