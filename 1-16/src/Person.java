
public class Person {

	private String name;
	private int age;
	private String gender;

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 120) {
			this.age = age;
		} else if (age < 0) {
			System.out.println("無効な年齢です1");
		} else {
			System.out.println("無効な年齢です2");
		}
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("男性") || gender.equalsIgnoreCase("女性")) {
			this.gender = gender;
		} else {
			System.out.println("無効な性別です");
		}
	}

}
