
public class Test18 {
	//問題1:上記変数のgetterとsetterメソッドを作成してください。※IDE（Eclipse）で自動生成で作成すること

	//問題2:RTC終了後の個人またはチーム開発ではgetterメソッドとsetterメソッドを変数に対して作成していないと思われますがですがそれはなぜですか？

	//ヒント：@Dataアノテーションを利用していた

	//回答2「　@Dataアノテーションを利用することによって、@Getter、@Setterアノテーションが付与された状態になるためGetterメソッドとSetterメソッドを作成する必要がなかった。」

	//問題3:getterメソッドとsetterメソッドをカプセル化しようとする時どのようなアクセス修飾子が適切ですか？

	//回答3「　public　」

	private String first_name;

	//getter
	public String getFirst_name() {
		return first_name;
	}

	//setter
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	private String last_name;

	//getter
	public String getLast_name() {
		return last_name;
	}

	//stetter
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	private String name;

	//getter
	public String getName() {
		return name;
	}

	//setter
	public void setName(String name) {
		this.name = name;
	}

	private int age;

	//getter
	public int getAge() {
		return age;
	}

	//setter
	public void setAge(int age) {
		this.age = age;
	}

	private int weight;

	//getter
	public int getWeight() {
		return weight;
	}

	//setter
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
