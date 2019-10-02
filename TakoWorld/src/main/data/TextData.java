package main.data;

import main.items.TextBox;
import main.struct.TextChara;

public class TextData {
	public static String[] choice0 = { "左の部屋", "前の部屋", "右の部屋" };//1F
	public static String[] choice1 = { "左の部屋", "前の部屋", "右の部屋" };//2F
	public static String[] choice2 = { "インク銃", "ダイナマイト", "とうめい薬" };
	public static String[] choice3 = { "入る", "入らない" };//2F右の部屋
	public static String[] choice4 = { "助ける", "助けない" };//1F助けるか
	public static String[] choice5 = { "助ける", "助けない" };//2F助けるか

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
			{"助ける？"},
			{ "" }
	};

	public static String[][] s1_F_yes_txt = {
			{ "" },
			{ "助けた" },
			{ "" }
	};

	public static String[][] s1_F_no_txt = {
			{ "" },
			{ "見捨てた" },
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
			{ "左の部屋1" },
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

	public static String[][] s2_F2_txt = {
			{ "" },
			{ "前の部屋2" },
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
			{ "えっと・・・・・・・・・・・・・・・・" },
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
