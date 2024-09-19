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


        
        List<String> strArray1 = new ArrayList<>(Arrays.asList("f", "u", "k", "u", "d", "a", "k", "a", "n", "e", "k", "o"));
        List<String> strArray2 = new ArrayList<>();
        List<String> strArray3 = new ArrayList<>();
        List<String> strArray4 = new ArrayList<>();

        // 1個目のfor文: strArray1で3文字目(k)以降のものをstrArray2に格納
        for (int i = 2; i < strArray1.size(); i++) {
            strArray2.add(strArray1.get(i));
        }

        // 2個目のfor文: strArray2でkとaとoの物だけをstrArray3に格納
        for (String s : strArray2) {
            if (s.equals("k") || s.equals("a") || s.equals("o")) {
                strArray3.add(s);
            }
        }

        // 3個目のfor文: strArray3で「kakao」となるようにstrArray4に格納
        String target = "kakao";
        int targetIndex = 0;

        for (String s : strArray3) {
            if (s.equals(String.valueOf(target.charAt(targetIndex)))) {
                strArray4.add(s);
                targetIndex++;
            }
            if (targetIndex == target.length()) {  
                break;
            }
        }

        // strArray4を出力
        System.out.println("{"+String.join("", strArray4)+"}"); 
    }
}