package main.items;

import main.TWInfo;
import main.constant.KEY_STATE;
import main.struct.TextChara;
import main.supers.GameItem;

public class TextBox extends GameItem {

	TextChara[] textChara;//データ
	int nowTextNum;//現在のテキスト番号

	public static final int SAME_L=9;
	public static final int SAME_R=10;
	public static final int HOTATE_L=11;
	public static final int HOTATE_R=12;
	public static final int UNKNOWN_L=13;
	public static final int UNKNOWN_R=14;
	public static final int TAKO_L=15;
	public static final int TAKO_R=16;



	public static final int NON=100;
	public static final int HOTATE_UN=101;
	public static final int HOTATE=102;
	public static final int SAME_UN=103;
	public static final int SAME=104;
	public static final int TAKO_UN=105;
	public static final int TAKO=106;


	public static final int COLOR_YELLOW=200;
	public static final int COLOR_PINK=201;
	public static final int COLOR_GREEN=202;
	public static final int COLOR_NON=203;

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
		this.setVisible(13, false);
		this.setVisible(14, false);
		this.setVisible(15, false);
		this.setVisible(16, false);
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
				this.setColor(TextChara.left, TextBox.COLOR_NON);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, false);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE) {
				this.setColor(TextChara.left, TextBox.COLOR_YELLOW);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, true);
				this.setVisible(TextBox.UNKNOWN_L, false);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE_UN) {
				this.setColor(TextChara.left, TextBox.COLOR_YELLOW);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, true);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME) {
				this.setColor(TextChara.left, TextBox.COLOR_PINK);

				this.setVisible(TextBox.SAME_L, true);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, false);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME_UN) {
				this.setColor(TextChara.left, TextBox.COLOR_PINK);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, true);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.TAKO_UN) {
				this.setColor(TextChara.left, TextBox.COLOR_GREEN);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, true);
				this.setVisible(TextBox.TAKO_L, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.TAKO) {
				this.setColor(TextChara.left, TextBox.COLOR_GREEN);

				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, false);
				this.setVisible(TextBox.TAKO_L, true);
			}else if(this.textChara[nowTextNum].chara==-1) {
				this.setVisible(TextBox.SAME_L, false);
				this.setVisible(TextBox.HOTATE_L, false);
				this.setVisible(TextBox.UNKNOWN_L, false);
				this.setVisible(TextBox.TAKO_L, false);
			}

		}else if(this.textChara[nowTextNum].pos==TextChara.right) {
			this.setVisible(1, true);
			this.setVisible(2, true);
			if(this.textChara[nowTextNum].chara==TextBox.NON) {
				this.setColor(TextChara.right, TextBox.COLOR_NON);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, false);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE) {
				this.setColor(TextChara.right, TextBox.COLOR_YELLOW);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, true);
				this.setVisible(TextBox.UNKNOWN_R, false);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.HOTATE_UN) {
				this.setColor(TextChara.right, TextBox.COLOR_YELLOW);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, true);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME) {
				this.setColor(TextChara.right, TextBox.COLOR_PINK);

				this.setVisible(TextBox.SAME_R, true);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, false);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.SAME_UN) {
				this.setColor(TextChara.right, TextBox.COLOR_PINK);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, true);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.TAKO_UN) {
				this.setColor(TextChara.right, TextBox.COLOR_GREEN);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, true);
				this.setVisible(TextBox.TAKO_R, false);
			}else if(this.textChara[nowTextNum].chara==TextBox.TAKO) {
				this.setColor(TextChara.right, TextBox.COLOR_GREEN);

				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, false);
				this.setVisible(TextBox.TAKO_R, true);
			}else if(this.textChara[nowTextNum].chara==-1) {
				this.setVisible(TextBox.SAME_R, false);
				this.setVisible(TextBox.HOTATE_R, false);
				this.setVisible(TextBox.UNKNOWN_R, false);
				this.setVisible(TextBox.TAKO_R, false);
			}
		}

	}

	private void setColor(int pos,int color) {
		if(pos==TextChara.left) {
			if(color==TextBox.COLOR_YELLOW) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, true);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, false);
			}else if(color==TextBox.COLOR_PINK) {
				this.setVisible(3, true);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, false);
			}else if(color==TextBox.COLOR_GREEN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, true);
				this.setVisible(8, false);
			}else if(color==TextBox.COLOR_NON) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, false);
			}
		}else if(pos==TextChara.right) {
			if(color==TextBox.COLOR_YELLOW) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, true);
				this.setVisible(7, false);
				this.setVisible(8, false);
			}else if(color==TextBox.COLOR_PINK) {
				this.setVisible(3, false);
				this.setVisible(4, true);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, false);
			}else if(color==TextBox.COLOR_GREEN) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, true);
			}else if(color==TextBox.COLOR_NON) {
				this.setVisible(3, false);
				this.setVisible(4, false);
				this.setVisible(5, false);
				this.setVisible(6, false);
				this.setVisible(7, false);
				this.setVisible(8, false);
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
