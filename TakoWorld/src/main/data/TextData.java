package main.data;

import main.items.TextBox;
import main.struct.TextChara;

public class TextData {
	public static String[] choice0 = { "左のドア", "前のドア", "右のドア" };
	public static String[] choice1 = { "左の部屋", "前の部屋", "右の部屋" };
	public static String[] choice2 = { "木の板", "おおきなばね", "水晶玉" };
	public static String[] choice3 = { "入る", "入らない" };

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
			{ "たこ焼きをたおした" },
			{ "2階" },
			{ "" }
	};

	public static String[][] s2_S_txt = {
			{ "" },
			{ "どの部屋に入る？" },
			{ "" }
	};

	public static String[][] s2_L1_txt = {
			{ "" },
			{ "左の部屋1" },
			{ "" }
	};

	public static String[][] s2_LS_txt = {
			{ "" },
			{ "何を選ぶ？" },
			{ "" }
	};

	public static String[][] s2_LS1_txt = {
			{ "" },
			{ "木の板にした" },
			{ "これなら大丈夫そうだ" },
			{ "" }
	};

	public static String[][] s2_LS2_txt = {
			{ "" },
			{ "ばねにした" },
			{ "これはだめだろ" },
			{ "" }
	};

	public static String[][] s2_LS3_txt = {
			{ "" },
			{ "水晶にした" },
			{ "これはないだろ" },
			{ "" }
	};

	public static String[][] s2_L2_txt = {
			{ "" },
			{ "もうここは大丈夫だろ" },
			{ "" }
	};

	public static String[][] s2_F1_txt = {
			{ "" },
			{ "前の部屋1" },
			{ "大きな穴があいていて進めない！" },
			{ "" }
	};

	public static String[][] s2_F2_txt = {
			{ "" },
			{ "前の部屋2" },
			{ "" }
	};

	public static String[][] s2_R1_txt = {
			{ "" },
			{ "なんか不穏な空気がする・・・" },
			{ "本当にいくのか？" },
			{ "" }
	};

	public static String[][] s2_R2_txt = {
			{ "" },
			{ "もうここはいいだろ","次行くぞ" },
			{ "" }
	};

	public static String[][] s2_R3_txt = {
			{ "" },
			{ "右のドアを開けたら、そこにはおぞましい姿のたこがいた" },
			{ "きゃーーーーー" },
			{ "" }
	};

	public static String[][] s2_R4_txt = {
			{ "" },
			{ "やっぱやめとこう" },
			{ "" }
	};

	public static String[][] s2_R5_txt = {
			{ "" },
			{ "おぞましいたこを倒した！" },
			{ "" }
	};

	public static String[][] s3_txt = {
			{ "" },
			{ "たこさんウインナーを倒した！", "おみごと！" },
			{ "いえい" },
			{ "やったー" },
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
