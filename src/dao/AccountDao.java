package dao;

import pojo.AccountClass;

public interface AccountDao {
	
	
	public void openAccount(AccountClass ac);
	
	public long genrateAccount();
	
	public boolean accountExists(String email);
	
	public void getAccountNumber(String email, int pin);
	

}
