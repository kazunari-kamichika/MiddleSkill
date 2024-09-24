import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test25 {

	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記条件になるようログの出力を行いなさい。

		//条件１　例外でヌルポが発生させヌルポをキャッチした場合のみログ出力がされるプログラムにする事
		//条件２　"middleskill log"という名前のログのインスタンスを生成する事
		//条件３　srcディレクトリ内に"middleskill.log"としてログ出力される設定にする事
		//条件４　ログの内容はコンソールに出ている赤文字と同じ内容のものが表示される事
		//条件５　格納するログメッセージは"ミドルスキルログが発生しました。"という文言にする事

		// 条件2: "middleskill log"という名前のログのインスタンスを生成
		Logger logger = Logger.getLogger("middleskill log");

		// 条件3: srcディレクトリ内に"middleskill.log"としてログ出力される設定
		try {
			// srcディレクトリに出力 (相対パス)
			FileHandler fh = new FileHandler("C:\\Users\\kazu-\\MiddleSkill\\1-25\\src\\middleskill.log", true); // trueで追記モード
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
			logger.setLevel(Level.INFO); // ログレベルをINFOに設定

			// 条件1: NullPointerExceptionを発生させキャッチした場合にログを出力
			try {
				throw new NullPointerException(); // 強制的にヌルポを発生
			} catch (NullPointerException e) {
				// 条件5: "ミドルスキルログが発生しました。"というメッセージをログに出力
				logger.log(Level.INFO, "ミドルスキルログが発生しました。", e);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}