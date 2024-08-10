package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.AccountManageDao;
import helper.Connect;

public class AccountManageDaoimpl implements AccountManageDao{
	
	
	Connection con = Connect.getConnection();
	
	PreparedStatement prest ;

	@Override
	public void withdrawMoney(long account, int pin , double amount) {

		String q = "SELECT * FROM account WHERE account_number = ? AND  pin =?" ;

		try {
			con.setAutoCommit(false);
			prest = con.prepareStatement(q);
			
			if(account != 0) {
			
			prest.setLong(1, account);
			prest.setInt(2, pin);
			
			ResultSet res = prest.executeQuery();
			
			while(res.next()) {
				
				double amt = res.getDouble("balance");
				
				if(amount <= amt) {
					
					String query = "UPDATE account SET balance  = balance - ? WHERE account_number = ?";
					
					prest = con.prepareStatement(query);
					
					prest.setDouble(1, amount);
					prest.setLong(2, account);
					
					int affect = prest.executeUpdate();
					
					if(affect > 0) {
						
						System.out.println("Money Withdraw Successfully");
						System.out.println("Total Witdraw Amount is :" + amount);
						con.commit();
						con.setAutoCommit(true);
						
					}
					
					
				}
				else {
					
					System.out.println(" Money not Withdraw Total Balance : "+amt);
					con.setAutoCommit(true);
					con.rollback();
					
				}
				
			}
			
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}		
		
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

	@Override
	public void depositeMoney(long account, int pin, double amount) {

String q = "SELECT * FROM account WHERE account_number = ? AND pin = ?";

try {
	con.setAutoCommit(false);
	prest = con.prepareStatement(q);
	
	if(account != 0) {
	
	prest.setLong(1, account);
	prest.setInt(2, pin);
	
	ResultSet res = prest.executeQuery();
	
	while(res.next()) {
		
	String query = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
	
	
	prest = con.prepareStatement(query);
	
	prest.setDouble(1, amount);
	prest.setLong(2, account);
	
	int affect = prest.executeUpdate();
	
	if(affect > 0) {
		
		System.out.println("Money Depoiste Successfully");
		System.out.println("Deoiste money :"+amount);
		con.commit();
		con.setAutoCommit(true);
		
	}
		
	}
	
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
	con.setAutoCommit(true);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
	}

	
	
	
	
	@Override
	public void transferMoney(long sender, int pin, long reciver, double amount) {

String q = "SELECT * FROM account WHERE account_number = ? AND pin = ?";

try {
	
	con.setAutoCommit(false);
	prest = con.prepareStatement(q);
	
	if(sender != 0 && reciver != 0) {
	
	prest.setLong(1, sender);
	prest.setInt(2, pin);
	
	
	ResultSet res = prest.executeQuery();
	
	if(res.next()) {
		
		double paisa = res.getDouble("balance");
		
		if(amount <= paisa) {
			
			String query = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
			String query1 = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
			
			prest = con.prepareStatement(query);
			
			PreparedStatement pre = con.prepareStatement(query1);
			
			prest.setDouble(1, amount);
			prest.setLong(2, sender);
			
			pre.setDouble(1, amount);
			pre.setLong(2, reciver);
			
			int affect = prest.executeUpdate();
			
			int affect1 = pre.executeUpdate();
			
			if(affect > 0 && affect1 > 0) {
				
				System.out.println("Amount Transfer Successfully");
				System.out.println("Total "+amount+" Transfer");
				con.commit();
				con.setAutoCommit(true);
				
				
			}
			else {
				
				con.rollback();
				con.setAutoCommit(true);
				
			}
			
			
			
		}
		
	}
	
	
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

try {
	con.setAutoCommit(true);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}



}
