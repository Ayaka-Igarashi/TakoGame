package main.data;

import main.items.TextBox;
import main.struct.TextChara;

public class TextData {
	public static String[] choice0 = { "左の部屋", "前の部屋", "右の部屋" };//1F
	public static String[] choice1 = { "左の部屋", "前の部屋", "右の部屋" };//2F
	public static String[] choice2 = { "インク銃", "ダイナマイト", "とうめい薬" };
	public static String[] choice3 = { "入る", "入らない" };//2F右の部屋
	public static String[] choice4 = { "助ける", "助けない" };//1F助けるか
	public static String[] choice5 = { "止める", "止めない" };//2F助けるか

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

	public static TextChara[] s1_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
	};

	public static TextChara[] s1_s_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1)
	};

	public static TextChara[] s1_L_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(-1, -1)
	};

	public static TextChara[] s1_F1_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
	};

	public static TextChara[] s1_F2_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(-1, -1)
	};

	public static TextChara[] s1_F3_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right)
	};

	public static TextChara[] s1_F_yes_txt_chara = {
			new TextChara(-1, -1),
			/***/
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.TAKO, TextChara.right),
			new TextChara(-1, -1)
	};

	public static TextChara[] s1_F_no_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
	};

	public static TextChara[] s1_R1_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(TextBox.HOTATE, TextChara.right),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(-1, -1),
			new TextChara(-1, -1)
			//do
	};

	public static TextChara[] s1_R2_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(TextBox.SAME, TextChara.left),
			new TextChara(-1, -1)
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
			{ "そのまままっすぐ歩いていったら","大広間にたどり着いた" },
			{ "この部屋すごい広いですね！" },
			{ "前と左と右　3つドアがあるな・・・","どの部屋に行けばいいんだ？" },
			{ "ぅもう・・・私の話なんも聞いてないな" },
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
			{ "左側の部屋に入った" },
			{ "この部屋もこまめに掃除しているのか","広く、仰々しい装いで綺麗な見た目だった" },
			{ "そして部屋の真ん中にはいかにも中世の貴族が使いそうな","細長いテーブルが1つある" },
			{ "どうやら誰か重鎮をもてなすのであろう","テーブルには溢れんばかりの量の食事が並べてある" },
			{ "ここはダイニングルームみたいですね" },
			{ "そうみたいだな","・・・ん？" },
			{ "もしかして、あれはたこ焼き！！？" },
			{ "ひゃーーー！！","またたこ焼き！？襲ってくるーー！！" },
			{ "違うぞホタテ、さっきの喋るたこ焼きヤローじゃなくて","本物の食べるたこ焼きだ" },
			{ "ふぇ・・・それならよかった"},
			{ "じゃあさっそくいただこうか","こんなところでたこ焼きを食えるなんてラッキーだな" },
			{ "勝手に食べたら怒られちゃわないですか！？","大事なお客さんのものかもしれないし！！" },
			{ "まー、まー","あとで話し合えばへーきだろ" },
			{ "肉体言語で話し合いをしそうだなぁ・・・" },
			{ "それはそうと、サメさんってなんでそんなに","たこ焼きが好きなんですか？" },
			{ "見た瞬間一目散に向かってくし" },
			{ "うーんとな、昔オオサカに旅行いったんだよ","オオサカってたこ焼き屋さん沢山あるだろ" },
			{ "気になって食べてみたら","あのたこ焼き、ものすんごいおいしかったんだよ" },
			{ "意外と単純な理由・・・" },
			{ "それ以来たこ焼きにどーもハマってしまった","どっぷりと" },
			{ "ほら、このたこ焼きおいしいぞ","沢山あるからホタテも食べてみろよ" },
			{ "私は、遠慮しときます","たこ焼きはあまり好きではないので" },
			{ "まじか、こんなおいしいもの嫌いな奴がいんのか","もったいない舌をしてるな" },
			{ "まず、タコの見た目から受け付けられないんで","口に入れるなんて鳥肌が立ちますっ" },
			{ "ここ、食べ物以外何もなさそうだし","サメさんが満足したら次の場所行きましょう" },
			{ "あと5分で食う"},
			{ "10分後" },
			{ "ふうぅ・・・満足した","これでめちゃめちゃ気力が湧いてきた！" },
			{ "それはよかったです","じゃあ次の部屋行きましょう" },
			{ "大広間に戻った" },
			{ "" }
	};

	public static String[][] s1_F1_txt = {
			{ "" },
			{ "前のドアの前まで来た" },
			{"ガチャガチャ"},
			{"あれ、開かないぞ"},
			{"どうやらロックがかかってるみたいです","ロックを解除しなきゃですね"},
			{"鍵じゃなくて電子ロックなんだな","この城意外と技術が進んでるな"},
			{"このままじゃ進めなさそうなので","ロックを解除するスイッチ的なのを探してみましょう"},
			{"・・・力ずくで開けられないか？"},
			{"やめてください！","器物損壊です！！"},
			{ "大広間に戻った" },
			{ "" }
	};

	public static String[][] s1_F2_txt = {
			{ "" },
			{ "前の部屋への扉は特にロックもかかっておらず","すんなり開いた" },
			{"あ、階段だ！","ここから上に行けますね！"},
			{"よし！どうせ親玉は最上階でのんびりしてんだろ","とっととのぼるか"},
			{"ミツケタゾ！"},
			{"ひゃあ！！！","本物の喋るたこ焼き！！！"},
			{"出たな喋るたこ焼き！","今度こそお前をメッタメタにして食してやる！"},
			{"ジャマモノ　メ","ココデ　シマツシテ　クレヨウ"},
			{ "" }
	};

	public static String[][] s1_F3_txt = {
			{ "" },
			{ "たこ焼きを倒した" },
			{ "ウオオオオオオオォォォォォ・・・・・","ナゼ　ヤラレタ・・・・" },
			{"ハッ・・・","たこ焼きの分際でに私の邪魔をするからだな！"},
			{"ウゥ・・・・"},
			{"よかったぁ","たこ焼きさんを倒せましたね！"},
			{"少し調子が戻ってきたみたいだ","・・・こんな敵普段なら一発だったがな"},
			{"このたこ焼きやっぱまずそうだし","さっさと上いくか"},
			{"ウゥ・・・　コノママデハ","ナカミガアフレテ　ナマゴミニ　ナッテシマウ・・・"},
			{"オマエタチ　スコシデイイ　タスケテクレ"},
			{"いやいや自業自得だろ、ドンマイだな"},
			{"で、でも生ごみにされちゃうのはひどい・・・"},
			{"助けたらまた襲ってくるだろうから行こうぜ"},
			{"どうすればいいのかな・・・？"},
			{"助けてあげる？"},
			{ "" }
	};

	public static String[][] s1_F_yes_txt = {
			{ "" },
			{"いくら襲ってきたやつとはいえ","このままじゃ・・・"},
			{"ホタテ、正気か！？","そいつなんかほっとけばいいだろ"},
			{"そうしたほうがいいとは思うんですけど・・・","こんな状態なので、少しだけでも"},
			{"たこ焼きさん、少しじっとしててくださいね"},
			{"ホタテはたこ焼きの中身が溢れないように","応急処置をしてあげた"},
			{"これで平気になったと思います！"},
			{"カンシャスル・・・"},
			{"お前、助けられたからって","調子乗ってまた襲ってくんなよ"},
			{"アンシン　シロ","ウゴケルタイリョクハ　ノコッテナイ"},
			{"ならよかった。さっさと次行くぞ"},
			{"は、はい！","待っててくれてありがとうございます！"},
			{"（こいつ、自分を襲ってきたやつを助けるとか","すごいな　お人よしなのか？）"},
			{"そういえば","私、なんでここに連れられてきたんですかね・・？"},
			{"学校に行く途中突然あのたこ焼きに襲われたんです","なにかしちゃったかな？"},
			{"災難だったな","ここの主の考えてることはわからんが"},
			{"お前を取って食おうとしたんじゃないか？"},
			{"ええええええ！！？？"},
			{"実際のことは知らんが"},
			{"まあ、ここの親玉にあってみればわかるんじゃないか"},
			{"それ、食べられないか不安だなぁ・・・","怖そうだけど先に進まなきゃですね"},
			{"（でも、さっきのたこ焼きさんは取って食うという","感じでもなさそうだったな）"},
			{"（助けた時も襲ってこずに感謝してくれたし）"},
			{ "" }
	};

	public static String[][] s1_F_no_txt = {
			{ "" },
			{"うーん・・・","襲ってきたら嫌ですし、やめときましょう"},
			{"そうだな、こんなやつほっといたほうがいいな"},
			{"（そういえば、このたこ焼き私ばっか襲ってきて","こいつには手を出そうとしなかったな）"},
			{"（よわっちそうだから相手にしなかっただけか？）"},
			{"にしても、なんで私はここに","連れられて来ちゃったんでしょう・・？"},
			{"学校に行く途中突然あのたこ焼きに襲われたんです","なにかしちゃったかな？"},
			{"災難だったな","ここの主の考えてることはわからんが"},
			{"お前を取って食おうとしたんじゃないか？"},
			{"ええええええ！！？？","私、食べられちゃうんですか！！？？？"},
			{"いやだ～！こわいよ～！！！！"},
			{"落ち着け、実際にそうかは知らん"},
			{"とりあえず、こうなった以上ここから","脱出するしかないだろ"},
			{"うぅ・・・","なんでこうなっちゃったんだろう"},
			{ "" }
	};

	public static String[][] s1_R1_txt = {
			{ "" },
			{ "右の部屋に入った" },
			{"そこには高そうなソファーがいくつも並べてある","客人を招くために作られた応接間のようだ"},
			{"ここにはヤツはいなさそうだな"},
			{"そうですね"},
			{"にしても、ここもまた立派な部屋ですね～","ひとまず探索してみましょうか"},
			{"探索すること少々"},
			{"おいホタテ、ここにかっこいいスイッチがあるぞ"},
			{"ほんとだ金塗りにされてて豪華ですね","なんのスイッチですかね？"},
			{"さあ、なんなんだろうな？"},
			{"にしても、こういうかっこいいスイッチって","つい押したくなっちゃうんだよな～"},
			{"いやいや、不用意に押したら敵がわらわら","出てきたり・・・・"},
			{"とりあえず押してみるか"},
			{"えっ・・・・・・・・・"},
			{"ぽちっ"},
			{"しかしボタンは押されたものの、","特に当たりに変わった様子はない"},
			{"！！！！！"},
			{"ちょっとおおお！！！","いきなり何押してるんですか！？"},
			{"・・・・・・・・・うーむ","何も起こんないな"},
			{"まあ、ヤバいこと起こんなかったし","大丈夫だろ"},
			{"そうですかね・・・？","変なことにならないといいんだけど"},
			{"ここには他に何にもなさそうだ","もう次いこうぜ"},
			{"大広間に戻った"},
			{ "" }
	};

	public static String[][] s1_R2_txt = {
			{ "" },
			{ "そこはもう大丈夫じゃないか？" },
			{ "" }
	};

	public static String[][] s2_txt = {
			{ "" },
			{ "話しているうちに２階の大広間へたどり着いた" },
			{"ここも１階と同じく広々としていて","３つの扉がそれぞれ前、左、右にある"},
			{"ただ１階と違うのは、前の扉の横に大きなタコの銅像が","２体立っている"},
			{"わぁ・・・すごくご立派なタコの銅像ですね"},
			{"気を付けろ、あれはただの銅像じゃない","近づいたら攻撃してくるぞ"},
			{"え！？攻撃してくるんですか！？"},
			{"ああ、昔コイツに一発やられそうになったことがある"},
			{"見た目は銅像だが、目の部分で敵を認識して","口の部分からスミ吐いて攻撃してくるんだ"},
			{"ここだけしっかり守っているってことは","この先に重要なのがあるんだろうな"},
			{"前の部屋に進むなら、対処法を考えないとですね・・・","ひとまず調べていきましょうか"},
			{ "" }
	};

	public static String[][] s2_S_txt = {
			{ "" },
			{ "どの部屋を調べる？" },
			{ "" }
	};

	public static String[][] s2_L1_txt = {
			{ "" },
			{ "左側の部屋へ入った" },
			{"はしご、ブラウン管テレビ、刀・・・","そこには沢山のものが無造作に置かれていた"},
			{"他の部屋とは違いあまり綺麗な状態とは言えない","ここは物置みたいだ"},
			{"このお城、隅々まできれいなのかなと思ってたけど","こんな場所もあるんですね～"},
			{"ほんとに散らかってんな"},
			{"タコの銅像をなんとかできるやつはありますかね"},
			{"この中から見つかるかわからんが、ひとまず探すぞ"},
			{"ごそごそ"},
			{"・・・・・・・","謎の機械の部品ばっかりでなんもないな"},
			{"そっちはなにかあったか？"},
			{"えっと、ここにあるものがもしかしたら使えるかもです","この中から探してみます！"},
			{"おっし、任せた"},
			{"うーん、この中だったらどれがいいかな？"},
			{ "" }
	};

	public static String[][] s2_LS_txt = {
			{ "" },
			{ "どれが銅像に使えそう？" },
			{ "" }
	};

	public static String[][] s2_LS1_txt = {
			{ "" },
			{"サメさん、インク銃とかどうですか？"},
			{"これであの銅像と戦うのか？"},
			{"いえ、“タコの目“を潰します","そうするためにインク銃が有効かもしれません"},
			{"どうすればいいんだ？"},
			{"タコの目にインクをぶつけられたら","銅像が私たちを認識できなくなるかな、と！"},
			{"なるほど、","もし出来たら攻撃されずに扉を通れるな"},
			{"でも、問題はうまくインクがヒットするかなんです","インクの弾も限りがありますし"},
			{"あそこに当てるくらい余裕だ、私に貸せ"},
			{"は、はい！ありがとうございます！"},
			{"にしても、この城こんなものまであんのな","ここのやつらはナワバリ争いでもすんのか？"},
			{"インク銃を手に入れた"},
			{"大広間に戻った"},
			{ "" }
	};

	public static String[][] s2_LS2_txt = {
			{ "" },
			{"サメさん、ダイナマイトがあったんですけど・・・"},
			{"お、いいのあんじゃん","やっぱ壊すのが一番楽だよな"},
			{"いや、でもこれは最終手段にしときましょう","もうちょっと知恵を使った方法はあるはずです！"},
			{"他に方法がなかったら、さっさと壊しにいこうぜ"},
			{"もっと安全な方法は無いかな？"},
			{ "" }
	};

	public static String[][] s2_LS3_txt = {
			{ "" },
			{"サメさん、すごいのがありました！"},
			{"体がとうめいになっちゃう薬！","ファンタジーみたいですよね！"},
			{"ここの世界もファンタジーだけど！"},
			{"急に興奮しすぎかよ・・・","タコのやつも変なもの持ってるのな"},
			{"これ飲めば銅像に気づかれずに前の部屋に進めるかもです！"},
			{"とうめいになったらどんな感じなんだろう","飲むの少し怖いけど・・・"},
			{"サメさんってとうめいになったことあります？"},
			{"いや、流石にない","こんな薬があること自体びっくりだ"},
			{"これ、飲んだら悪影響はないのか・・・？"},
			{"えーと、副作用どこかに書いてあるかな"},
			{"・・・・・"},
			{"・・・・・・・・・・・・"},
			{"・・・・・・・・・・・・・・・・・！"},
			{"・・・これは飲んだらアウトな薬です"},
			{"なにが書いてあった？"},
			{"「この薬を飲んだ場合、知能の著しい低下、記憶喪失など","脳に悪影響が出る可能性があります」"},
			{"「緊急時以外極力使用をお控えください」"},
			{"・・・ですって"},
			{"なんでこんな危険なものが置いてあるんだ・・・"},
			{"飲むのはやめときますか"},
			{"そうだな"},
			{ "" }
	};

	public static String[][] s2_L2_txt = {
			{ "" },
			{ "この部屋はもういいんじゃないか" },
			{ "" }
	};

	public static String[][] s2_F1_txt = {
			{ "" },
			{ "前の扉のほうに進み、銅像の近くまできた" },
			{"やはり近くで見るとその迫力は圧巻であり","この城の豪華さを象徴しているかのようであった"},
			{"これ以上近づくのは危険だな","これ、無理やり壊せないだろうか"},
			{"いやいや、こんなに大きいの壊せるんですか！？"},
			{"爆弾とかあればいけるかもな"},
			{"なんという暴力的解決"},
			{"それにしても、爆弾が必要だがな","こんなの眺めてても仕方ないからほかの部屋行こうぜ"},
			{"平和に通れる方法が見つかるといいなぁ・・・"},
			{ "" }
	};

	public static String[][] s2_F2_txt = {
			{ "" },
			{ "前の扉のほうに進み、銅像の近くまできた" },
			{"よっしゃ、さっそくインクをぶち込むか"},
			{"お願いします！"},
			{"バンッ、バンッ"},
			{"サメの放ったインク弾は一寸の狂いもなく","見事に銅像の目に命中した"},
			{"目の上にインクが覆いかぶさった今の銅像は","もはや侵入者を防ぐことはできないだろう"},
			{"こんなもんか？"},
			{"流石です、サメさん！","これで進んでも問題ないと思います！"},
			{"タコの銅像は特に反応もせず、","難なく前の部屋に入ることができた"},
			{"部屋の中には１階と同様、上へ続く階段がある"},
			{"ここから上の階に行けそうだな"},
			{"マテ、ソコマデダ！"},
			{"コレイジョウハ　ススマセヌ"},
			{"うおっと、出たな喋るタコ！"},
			{"たこさんウインナー・・・？","これはタコではないのでは・・・"},
			{"ズケズケト　ワレラノシロヲ　フミアラシオッテ","ブレイナ　ヤツメ"},
			{"それはここのセキュリティーが甘いせいだな","余裕でここまでこれたぞ"},
			{"ナンダト　コノシロヲ　バカニシオッテ","ココデ　オワリニ　シテヤル"},
			{"す、すごい剣幕・・・"},
			{"せいぜい細切れにされる覚悟でもしとくんだな"},
			{ "" }
	};

	public static String[][] s2_F3_txt = {
			{ "" },
			{ "助ける？" },
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{ "" }
	};

	public static String[][] s2_F_yes_txt = {
			{ "" },
			{ "助けた" },
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{ "" }
	};

	public static String[][] s2_F_no_txt = {
			{ "" },
			{ "見捨てた" },
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{ "" }
	};

	public static String[][] s2_R1_txt = {
			{ "" },
			{ "右の部屋の扉の前まで来た" },
			{ "おいっ、ここの部屋すごい嫌な感じがするぞ" },
			{"ズズズ・・・ズズズ・・・・"},
			{"扉の向こうから物々しい音がしますね","恐ろしい生物がいるのかも・・・"},
			{ "" }
	};

	public static String[][] s2_R2_txt = {
			{ "" },
			{ "もうここはいいだろ"},
			{ "" }
	};

	public static String[][] s2_R3_txt = {
			{ "" },
			{ "何がいるか知らんがいってみるか" },
			{ "大丈夫かな・・・" },
			{"右の部屋に入った"},
			{"前を見たらそこには巨大な冒涜的なタコの姿があった","８本の足をもぞもぞと動かし、なにか食べてる様子だ"},
			{"１歩踏み出した瞬間、こちらに気づいたのだろうか","タコはこちらに振り向いた"},
			{"ヒェッ・・・・・","（恐怖で言葉がでない）"},
			{"なんだこいつ、雰囲気がヤバいな"},
			{"ダレダ、オマエハ？"},
			{"私か？サメだ",""},
			{"ナノル　ヒツヨウハ　ナイ"},
			{"オマエガ　ジャマモノカ","チョウドイイ　ココデ　タオス"},
			{"はは、さっきちょうどウォーミングアップしてたんだよ","運動にはぴったりな相手だな"},
			{"やれるもんならやってみろ！"},
			{ "" }
	};

	public static String[][] s2_R4_txt = {
			{ "" },
			{ "ひとまず今は入らないでおきましょう" },
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
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{"",""},
			{ "" }
	};

	public static String[][] s4_txt = {
			{ "" },
			{ "おーーーーーーーい" },
			{ "だれかいませんかーーーーーーーー？" },
			{ "いたら返事下さーーーーーーーーい！" },
			{ "" }
	};

	public static String[][] end1_txt = {
			{ "" },
			{ "エンド１" },
			{ "です" },
			{ "サメは海の塵と化してしまった・・・" },
			{ "FIN" }
	};
	public static String[][] end2_txt = {
			{ "" },
			{ "エンド２" },
			{ "です" },
			{ "サメは強くなりすぎてしまった・・・・" },
			{ "FIN" }
	};
	public static String[][] end3_txt = {
			{ "" },
			{ "エンド３" },
			{ "です" },
			{ "みんな仲良くハッピーエンド" },
			{ "FIN" }
	};

}
