
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test22 {

	public static void main(String[] args) {
		String shinyaBirthday = "1998/03/19";
		String minamiBirthday = "2000/02/14";
		String furuyamaBirthdayStr = "1998/09/12";

		//改行
		System.out.println("問１");
		//問題1:現在の時刻を出力してください

		Date date = new Date();

		System.out.println(date.toString());

		//改行
		System.out.println("問２");
		//問題2:shinyaBirthdayとminamiBirthdayを日付型に変更し条件式で誕生日を比較し早い方の日付を文字列型で出力しなさい。

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate date1 = LocalDate.parse(shinyaBirthday, formatter);
		LocalDate date2 = LocalDate.parse(minamiBirthday, formatter);

		LocalDate earlierDate = date1.isBefore(date2) ? date1 : date2;

		String result = earlierDate.format(formatter);

		System.out.println(result);

		//改行
		System.out.println("問３");
		//問題3:furuyamaBirthdayに５年2ヶ月追加した値を文字列型で表示しなさい

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate furuyamaBirthday = LocalDate.parse(furuyamaBirthdayStr, formatter1);

		LocalDate newDate = furuyamaBirthday.plusYears(5).plusMonths(2);

		String result1 = newDate.format(formatter);

		// 結果を出力
		System.out.println(result1);

	}

}
