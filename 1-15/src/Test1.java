import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        // 改行
        System.out.println("問１");
        // 問1のメソッドを呼び出して出力してください（引数5と10）
        int sumResult = addNumbers(5, 10);
        System.out.println(sumResult);
        
        // 改行
        System.out.println("問２");
        // 問2のメソッドを呼び出して出力してください（引数"しんぶんし"）
        boolean isPalindrome = isPalindrome("しんぶんし");
        System.out.println(isPalindrome);
        
        // 改行
        System.out.println("問３");
        // 問3のメソッドを呼び出して出力してください（引数,配列[5,3,1,9,4,8]）
        Integer[] intArray = {5, 3, 1, 9, 4, 8};
        Integer[] sortedArray = sortDescending(intArray);
        System.out.println(Arrays.toString(sortedArray));
        
        // 改行
        System.out.println("問４");
        // 問4のメソッドを呼び出して出力してください（引数,配列[5,3,1,9,4,8]）
        int[] intArray2 = {5, 3, 1, 9, 4, 8};
        int minIndex = findMinIndex(intArray2);
        System.out.println(minIndex);
    }

    // 問題1: 2つの整数を受け取り、それらの和を返すメソッド
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    // 問題2: 文字列を受け取り、その文字列が回文であるかどうかを返すメソッド
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // 問題3: 整数の配列を受け取り、その配列の要素を降順にソートするメソッド (for文は利用しないこと)
    public static Integer[] sortDescending(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list, Collections.reverseOrder());
        return list.toArray(new Integer[0]);
    }

    // 問題4: 整数の配列を受け取り、その配列の中で最小値を持つ要素のインデックスを返すメソッド
    public static int findMinIndex(int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}