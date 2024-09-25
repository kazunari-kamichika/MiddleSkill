
public class test1 {

	public static void main(String[] args) {

		//		1.数字の5と9の変数を定義し、足した数字を出力しなさい。

		int i = 5;
		int s = 9;

		System.out.println(i + s);

		//		2.64ビット整数の「1111111111」を定義し2倍した値を出力しなさい。

		long t = 1111111111;

		System.out.println(t * 2);

		//		3.boolean型の変数の値に不正な文字列比較を入れてfalseを出力してください。
		
		 boolean str;

		String str1 = "HELLO";

		String str2 ="BYE";
		
		if (!(str1.equals(str2))) {
			System.out.println(!(str1.equals(str2)));
		} else {
			System.out.println(!(str1.equals(str2)));
		}
	}

}
