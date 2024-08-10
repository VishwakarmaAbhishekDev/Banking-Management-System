package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.AccountDao;
import helper.Connect;
import pojo.AccountClass;

public class AccountDaoimpl implements AccountDao{

	Connection con = Connect.getConnection();
	
	PreparedStatement prest;
	
	
	@Override
	public void openAccount(AccountClass ac) {

		if(!accountExists(ac.getEmail_id())) {
			
String q = "INSERT INTO account(account_number , name, email_id, balance , pin, password) VALUES (? ,? ,? ,? ,?, ?)";

try {
	prest = con.prepareStatement(q);
	
	long co = genrateAccount();
	
	prest.setLong(1, co);
	prest.setString(2, ac.getName());
	prest.setString(3, ac.getEmail_id());
	prest.setDouble(4, ac.getBalance());
	prest.setInt(5, ac.getPin());
	prest.setString(6, ac.getPassword());
	
	int affect = prest.executeUpdate();
	
	if(affect > 0) {
		
		System.out.println("Your account Number : "+co);
		System.out.println("Account open Successfully");
		
	}
	else {
		
		System.out.println("Account Not Opened");
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
			
		}
	}

	
	
	
	@Override
	public long genrateAccount() {

try {

	Statement stmt= con.createStatement();
	
ResultSet res = stmt.executeQuery("SELECT account_number FROM account ORDER BY account_number DESC LIMIT 1");
	
	if(res.next()) {
		
		long account = res.getLong("account_number");
		
		return account +1 ;
		
	}
	
	else {
		
		return 1000100;
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return 1000100;
	}

	
	
	
	@Override
	public boolean accountExists(String email) {

String q = "SELECT * FROM account WHERE email_id = ?";

try {
	prest = con.prepareStatement(q);
	
	prest.setString(1, email);
	
	ResultSet res = prest.executeQuery();
	
	if(res.next()) {
		
		return true;
		
	}
	else {
		
		return false;
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		
		return false;
	}




	public void getAccountNumber(String email, int pin) {

String q = "SELECT account_number FROM account WHERE email_id = ? AND pin = ?";

try {
	prest = con.prepareStatement(q);
	
	prest.setString(1, email);
	prest.setInt(2, pin);
	
	ResultSet res = prest.executeQuery();
	
	if(res.next()) {
		
		long account = res.getLong("account_number");
		
		System.out.println("Account Number : "+account);
		
		
	}
	else {
		
	System.out.println("Email or pin is In correct");
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		

	}



}
