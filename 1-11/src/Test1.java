
public class Test1 {

	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:変数"numa"にインクリメント演算子を利用し1マイナスしたものを表示してください。

		int numa = 5;

		numa--;
		System.out.println(numa);

		//改行
		System.out.println("問２");
		//問題2:変数"numb"の値が正の場合は"positive"、負の場合は"negative"、0の場合は"zero"と出力するプログラムを三項演算子を用いて作成してください。
		//(String result変数を用いてそこに値を格納しそれを出力する形式でお願いいたします)
		int numb = 5;
		String result = "";

		result = (numb > 0) ? "positive" : (numb < 0) ? "negative" : (numb == 0) ? "zero" : "";

		System.out.println(result);

		//改行
		System.out.println("問３");
		//問題3:"numc","numd"2つの変数の大きい方の値を出力するプログラムを三項演算子を用いて作成してください。
		//(int intResult変数を用いてそこに値を格納しそれを出力する形式でお願いいたします)
		//※※必ず全パターン正常動作することをコンソールで確認して下さい。

		int numc = 1;
		int numd = 2;
		int intResult = 0;

		intResult = (numc > numd) ? numc : numd;

		System.out.println(intResult);

		//改行
		System.out.println("問４");
		//問題4:"nume"と"numf"の変数が両方の正の場合は "both positive"、どちらかの値が正の場合は"one positive"、
		//両方の値が負の場合は"both negative"、それ以外は"etc"と出力するプログラムを三項演算子を用いて作成してください。
		//(String results変数を用いてそこに値を格納しそれを出力する形式でお願いいたします)
		//※※必ず全パターン正常動作することをコンソールで確認して下さい。
		int nume = 4;
		int numf = -3;
		String results = "";

		results = (nume > 0) ? (numf > 0) ? "both positive" : "one positive" : "both negative";

		System.out.println(results);

	}

}
