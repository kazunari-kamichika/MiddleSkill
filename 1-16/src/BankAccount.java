
public class BankAccount {

	private String accountNumber;
	private double balance;

	public BankAccount(String accountNumber, double balance) {
		//アカウント名
		this.accountNumber = accountNumber;
		//初期残高
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
		}
	}

}
