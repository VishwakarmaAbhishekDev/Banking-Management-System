package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import helper.Connect;
import pojo.UserClass;

public class UserDaoimpl implements UserDao{
	
	Connection con = Connect.getConnection();
	
	PreparedStatement prest;

	@Override
	public boolean registerUser(UserClass uc) {
		
		
		
		if(userExist(uc.getEmail())) {
			
			
			System.out.println("User Already Exists");
			
		}
		
		

String q = "INSERT INTO USER (name, age , email,password) VALUES(?,?,?,?)";

try {
	prest = con.prepareStatement(q);
	
	prest.setString(1, uc.getName());
	prest.setInt(2, uc.getAge());
	prest.setString(3, uc.getEmail());
	prest.setString(4, uc.getPassword());
	
	int affect = prest.executeUpdate();
	
	if(affect > 0) {
		
		return true;
		
	}else {
		
		return false;
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
		
		return false;
	}

	
	
	
	@Override
	public boolean loginUser(String email, String password) {
		


String q = "SELECT * FROM USER WHERE email = ? AND password = ?";
		
try {
	prest = con.prepareStatement(q);
	
	prest.setString(1, email);
	prest.setString(2, password);
	
	ResultSet res = prest.executeQuery();
	
	if(res.next()) {
		
		return true;
		
	}
	
	else{
		
		return false;
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	



		return false;
	}

	
	
	
	
	
	@Override
	public boolean userExist(String email) {

String q = "SELECT * FROM USER WHERE email = ?";

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

}
