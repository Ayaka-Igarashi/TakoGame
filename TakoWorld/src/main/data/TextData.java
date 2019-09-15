package main.data;

import main.items.TextBox;
import main.struct.TextChara;

public class TextData {
	public static String[] choice1 = { "左のドア", "前のドア", "右のドア" };

	//最初の文は便宜上空白にする
	public static TextChara[] intro_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.TAKO_UN, TextChara.left),
			new TextChara(TextBox.TAKO_UN, TextChara.left),//チョウドいい
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE_UN, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.NON,TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.NON,TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.NON,TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(-1, -1),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.SAME_UN, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
	};

	//最初の文は便宜上空白にする
	public static String[][] intro_txt = {
			{ "" },
			{ "私はタコが嫌いです。ぬめぬめしているし、", "吸盤ぺたぺたしているし、" },
			{ "そんなのが腕によじ登ってきたらと思うと", "ゾッとします。" },
			{ "なんでみんながタコ焼なんかをを美味しそうに", "食べているのか、わかりません、" },
			{ "ありえません、冒涜的です。" },
			{ "そんなことを考えながら歩いていたいつもの通学路、", "海の見える丘でその事件は起こります…" },
			{ "ミツケタゾ、アイツダ。" },
			{ "今日、雨降るなんて聞いてないよー", "折り畳み傘持ってきておいてよかった。" },
			{ "さっさと家に帰ろ" },
			{ "オイ、ソコノオマエ。" },
			{ "えっ" },
			{ "オマエダ、オマエ、ミツケタゾ" },
			{ "たこ焼き…？" },
			{ "ソウダ、オマエダ" },
			{ "たこ焼きが…喋ってるっ！！" },
			{ "キズクノガ、オソイゾ。" },
			{ "なんで、どうして、どうやって！", "疲れてるのかな…本の読みすぎ？TRPGのやりすぎ？" },
			{ "そしてなんでよりにもよってたこ焼きなの！", "私の一番苦手な料理、”た・こ・や・き”！" },
			{ "カタマッタゾ、" },
			{ "ドウスルカ。" },
			{ "チョウドイイ、コノママ、ハコンデイコウ。" },
			{ "" },
			{ "ヨウコソ、”たこわーるど”へ…" },
			{ "" },
			{ "…きろ" },
			{ "うーん…" },
			{ "…きろ" },
			{ "たこ焼きが…頭の上を回って…" },
			{ "起きろって！！！！" },
			{ "はい！すみません！起きます！！！ ", "ってあれ…？？" },
			{ "…" },
			{ "もしやさっきのたこ焼き？！お願い食べないで", "わたしもあなたを食べる気は無いのー！！" },
			{ "…" },
			{ "ほんとに苦手なので！これ以上ないほどタコ苦手なので！", "なにとぞ！" },
			{ "一ついいか？" },
			{ "はい！何ですか！" },
			{ "私がたこ焼きに見えるか？" },
			{ "えっと…" },
			{ "全然そんな風には見えません！" },
			{ "…" },
			{ "…" },
			{ "えっあなた誰！？" },
			{ "私がそれを聞こうと思ってたんだが", "まあいい、ここがどこだかわかるか？" },
			{ "えっと" },
			{ "どうやってここに来た？" },
			{ "そんないっぺんに聞かれても困ります！" },
			{ "じゃあ思い出せることを話せ" },
			{ "(上から目線だなぁ、","そもそもこの人誰なんだろう？)" },
			{ "えっと思い出す限りでは私…そうだ、学校の帰り道に", "でっかいたこ焼き に襲われて…" },
			{ "その、気がついたらここにいました" },
			{ "なるほど たこ焼きに連れてこられたかもしれないと…", "それでその姿か" },
			{ "？" },
			{ "お前人間だったんだろ？" },
			{ "？？今も何も人間ですよ私？" },
			{ "これ鏡、どうぞー" },
			{ "あっどうも" },
			{ "…" },
			{ "な" },
			{"なんじゃこりゃあああああああああああああああ","あああああああああ！！！！！！！"},
			{"これ？！！なに！！！？どういうこと！？？？"},
			{"どういうことも何も…そういうことだ"},
			{"そういうことって、どういうこと！？"},
			{"(足がない…黄色い体…","なんか触手みたいなの付いてるし…"},
			{"(なんか貝殻の上乗っちゃってるし…"},
			{"ホタテだな"},
			{"へ？"},
			{"ホタテみたいだなと思って"},
			{"納得したように言われても…"},
			{"ホタテ、とにかくだ、ここはお前が来ていい","ところじゃない。早く立ち 去るんだな、ホタテ"},
			{"ホタテを連呼するなー！！","私はホタテじゃない！人間だー！！"},
			{"…"},
			{"あれ？"},
			{"…"},
			{"いない！"},
			{"話は最後まで聞いてー","どこいったんですかーーもー"},
			{"おーい"},
			{"…"},
			{"お、おいてかないでー"},
			{""},
			{"おりゃああああ！！！"},
			{"ベシッ"},
			{"ハハハ、ドウシタドウシタ"},
			{"バシッ"},
			{"くっ…力が…"},
			{"やっと見つけた！"},
			{"ってえええええええ！？あれたこ焼き！？"},
			{"やっぱり夢じゃなかった…","私はあいつらにさらわれたんだ！"},
			{"オモウヨウニカラダ、ウゴカナイヨウダナ"},
			{"くそっ…どうして…"},
			{"(どうしようあの人たこ焼きに襲われてる！","助けなきゃ！"},
			{"(でっでもどうやって…"},
			{"コレデ、トドメダ"},
			{"あああああ！もうどうにでもなれーーー"},
			{"おい！！そこの…動くたこ焼き！"},
			{"！！！！！"},
			{"…！！ホタテ？！"},
			{"…"},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
	};

	public static String[][] s1_txt = {
			{ "" },
			{ "・・・・・・・・・・" },
			{ "うわーーー、ここがお城の中かあ・・・" },
			{ "なんかきれいですね", "（わくわく）" },
			{ "この城の中に親玉がいるんだな", "はやくいくぞ" },
			{ "ちょっ・・・待ってくださいーーー！", "少しゆっくり行きましょうよー！" },
			{ "相変わらずせっかちだなぁ" },
			{ "" },
			{ "大広間にでた" },
			{ "この部屋すごい広いですね！" },
			{ "前と左と右　3つドアがあるな・・・","どの部屋に行けばいいんだ？" },
			{ "ぅもう・・・なんも聞いてないな" },
			{ "とりあえず1つずつ入ってみましょうか" },
			{ "" }
	};


	public static String[][] s1_S_txt = {
			{ "" },
			{ "どの部屋に入る？" },
			{ "" }
	};

	public static String[][] s1_L_txt = {
			{ "" },
			{ "左の部屋" },
			{ "" }
	};

	public static String[][] s1_F1_txt = {
			{ "" },
			{ "前の部屋1" },
			{ "" }
	};

	public static String[][] s1_F2_txt = {
			{ "" },
			{ "前の部屋2" },
			{ "" }
	};

	public static String[][] s1_R1_txt = {
			{ "" },
			{ "右の部屋1" },
			{ "" }
	};

	public static String[][] s1_R2_txt = {
			{ "" },
			{ "右の部屋2" },
			{ "" }
	};

	public static String[][] s2_txt = {
			{ "" },
			{ "きょろきょろ" },
			{ "だれか他にいたりするかな？" },
			{ "" }
	};

	public static String[][] s3_txt = {
			{ "" },
			{ "とりあえずこわいから、", "この場にいよう。" },
			{ "待つこと数十分" },
			{ "だれもこないなあ" },
			{ "" }
	};

	public static String[][] s4_txt = {
			{ "" },
			{ "おーーーーーーーい" },
			{ "だれかいませんかーーーーーーーー？" },
			{ "いたら返事下さーーーーーーーーい！" },
			{ "" }
	};

}
