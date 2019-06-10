package main.data;

import main.constant.ITEM_NUM;
import main.struct.TextChara;

public class TextData {
	public static String[] choice1 = { "探し回る", "この場にいる", "叫ぶ" };

	//最初の文は便宜上空白にする
	public static TextChara[] intro_txt_chara = {
			new TextChara(-1, -1),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),//チョウドいい
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(-1, -1),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.UNKNOWN, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.SAME, TextChara.left),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
			new TextChara(ITEM_NUM.HOTATE, TextChara.right),
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
			{ "(上から目線だなぁ、そもそもこの人誰なんだろう？)" },
			{ "えっと思い出す限りでは私…そうだ、学校の帰り道に", "でっかいたこ焼き に襲われて…" },
			{ "その、気がついたらここにいました" },
			{ "なるほど たこ焼きに連れてこられたかもしれないと…", "それでその姿か" },
			{ "？" },
			{ "お前人間だったんだろ？" },
			{ "？？今も何も人間ですよ私？" },
			{ "これ鏡、どうぞー" },
			{ "あっどうも" },
			{ "…" },
			{ "" }
	};

	public static String[][] s1_txt = {
			{ "" },
			{ "・・・・・・・・・・" },
			{ "うーーーーーん・・・・・・・" },
			{ "はっ・・・・・・", "ここは・・・・どこ？" },
			{ "なんか・・・", "たこ焼きが喋ってた変な夢を見た気がする" },
			{ "そもそもなんだこの空間は", "謎の世界にやってきてしまったのか" },
			{ "どうしよう・・・・", "誰か助けてくれる人いないかな" },
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
