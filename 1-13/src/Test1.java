import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// 改行
		System.out.println("問１");

		//問題1:下記の条件を使ってfor文と条件文を組み合わせ結果が同じになるよう出力しなさい。for文ネスト3回（3回forを書くこと）
		//		例）
		//		for() {
		//			for() {
		//				for() {
		//					
		//				}
		//			}
		//		}
		//strArray1でfor文を回し3文字目(k)以降のものをstrArray2に格納する(1個目のfor文)
		//strArray2でfor文を回しkとaとoの物だけでstrArray3に格納する(2個目のfor文)
		//strArray3でfor文を回し「kakao」となるようにstrArray4に格納しstrArray4を出力する。(3個目のfor文)

		List<String> strArray1 = new ArrayList<>(
				Arrays.asList("f", "u", "k", "u", "d", "a", "k", "a", "n", "e", "k", "o"));
		List<String> strArray2 = new ArrayList<>();
		List<String> strArray3 = new ArrayList<>();
		List<String> strArray4 = new ArrayList<>();

		
		 // 1回目のfor文: strArray1の3文字目(k)以降のものをstrArray2に格納
        for (int i = 2; i < strArray1.size(); i++) {
            strArray2.add(strArray1.get(i));
//            System.out.println(strArray2); //デバック確認用(strArray2にどのように格納されてるか)

            // 2回目のfor文: strArray2からk, a, oだけをstrArray3に格納
            for (int j = 0; j < strArray2.size(); j++) {
                String s = strArray2.get(j);
                if (s.equals("k") || s.equals("a") || s.equals("o")) { // A ll B AかBのどちらかがtrueの場合にtrue OR演算子（または）
                    strArray3.add(s);
//                    System.out.println(strArray3); //デバック確認用(strArray3にどのように格納されてるか)

                    // 3回目のfor文: strArray3を使って「kakao」を作成しstrArray4に格納
                    if (strArray4.size() < 5) {
                        for (int k = 0; k < strArray3.size(); k++) {
                            if (strArray4.size() == 0 || strArray4.size() == 2) { //A == B	AとBが等しい時にtrue
                                strArray4.add("k");
                            } else if (strArray4.size() == 1 || strArray4.size() == 3) {
                                strArray4.add("a");
                            } else if (strArray4.size() == 4) {
                                strArray4.add("o");
                                break;  // kakaoが完成したらループを終了
                            }
                        }
                    }
                }
            }
        }

        // 結果を出力
        System.out.println(strArray4); 
    
	}	
}