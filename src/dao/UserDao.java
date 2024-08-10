package dao;

import pojo.UserClass;

public interface UserDao {
	
	
	public boolean registerUser(UserClass uc);

	public boolean loginUser(String email, String password);
	
	public boolean userExist(String email);
	
}
