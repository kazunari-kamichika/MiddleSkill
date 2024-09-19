
public class Test1 {

	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記の条件を満たすようにif文を3つネストして条件式を作成してください。
		//
		//変数x,y,zは正の整数であれば下の条件に続く。それ以外は”正の整数：NG”と表示する
		//xの値が10の倍数であれば下の条件に続く。それ以外は”10の倍数：NG”と表示する
		//x + y + z = 100であれば”プラス100：OK”それ以外は”プラス100：NG”と表示する

		int x = 10;
		int y = 80;
		int z = 15;

		 // 1つ目のif文: x, y, zが正の整数かどうかを確認
        if (x > 0 && y > 0 && z > 0) {
            // 2つ目のif文: xが10の倍数かどうかを確認
            if (x % 10 == 0) {
                // 3つ目のif文: x + y + zが100かどうかを確認
                if (x + y + z == 100) {
                    System.out.println("プラス100：OK");
                } else {
                    System.out.println("プラス100：NG");
                }
            } else {
                System.out.println("10の倍数：NG");
            }
        } else {
            System.out.println("正の整数：NG");
        }

		//改行
		System.out.println("問２");
		//問題2:問1と同じ内容で三項演算子で条件式を作成しなさい。最後に変数aを出力する。
		String a = "";

		a = (x < 0) && (y < 0) && (z < 0) ? "正の整数：NG"
				: (x % 10) == 1 ? "10の倍数：NG"
						: (x + y + z) == 100 ? "プラス100：OK" : "プラス100：NG";

		System.out.println(a);

	}

}
