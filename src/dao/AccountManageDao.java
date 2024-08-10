package dao;

public interface AccountManageDao {
	
	public void withdrawMoney(long account, int pin , double amount);
	
	public void depositeMoney(long account, int pin, double amount);
	
	public void transferMoney(long sender , int pin , long reciver, double amount);

}
