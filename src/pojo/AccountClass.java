package pojo;

public class AccountClass {
	
	private long account_number;
	
	private String name ;
	
	private String email_id;
	
	private double balance;
	
	private int pin;
	
	private String password;

	public AccountClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountClass(String name, String email_id, double balance, int pin, String password) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.balance = balance;
		this.pin = pin;
		this.password = password;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountClass [account_number=" + account_number + ", name=" + name + ", email_id=" + email_id
				+ ", balance=" + balance + ", pin=" + pin + ", password=" + password + "]";
	}
	
	
	
	
	

}
