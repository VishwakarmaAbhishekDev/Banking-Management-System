package test;

import java.util.Scanner;

import daoImpl.AccountDaoimpl;
import daoImpl.AccountManageDaoimpl;
import daoImpl.UserDaoimpl;
import pojo.AccountClass;
import pojo.UserClass;

public class MainTest {

	public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

UserClass uc;
UserDaoimpl udi;
AccountDaoimpl adi;
AccountClass ac;



System.out.println("1. Register");
System.out.println("2. Login");


System.out.println("Enter choice");
int choice = sc.nextInt();

if(choice == 1) {

System.out.println("Enter Name");
String name = sc.next();

System.out.println("Enter age ");
int age = sc.nextInt();

System.out.println("Enter Email");
String email = sc.next();

System.out.println("Enter Password");
String pass = sc.next();

uc = new UserClass(name, age , email, pass);

udi = new UserDaoimpl();

if(udi.registerUser(uc)) {
	
	System.out.println("Register successfully");
	
}else {
	
	System.out.println("Register Failed");
	
}

}else {
	
	System.out.println("Enter Email");
	String email = sc.next();
	
	System.out.println("Enter password");
	String pass = sc.next();
	
	udi = new UserDaoimpl();
	
	if(udi.loginUser(email, pass)){
		
		System.out.println("Login successfully");
		
		adi = new AccountDaoimpl();
		
		
		if(!adi.accountExists(email)) {
		
		System.out.println();
		System.out.println("1. Open Account");   
		
	
		
		System.out.println("Enter Choice");
		int cho = sc.nextInt();
		
	
		
		if(cho == 1) {
			
			System.out.println("Enter Name");
			String name = sc.next();
			
			System.out.println("Enter Email");
			String email1 = sc.next();
			
			System.out.println("Enter Current Amount");
			double amount = sc.nextDouble();
			
			System.out.println("Enter pin");
			int pin = sc.nextInt();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			
			ac = new AccountClass(name, email1, amount, pin, password);
			adi = new AccountDaoimpl();
			
		
		adi.openAccount(ac);
		
		}else {
			
			System.exit(0);
		}
		
		}
		
	else {
			

	
		
		System.out.println("-------------------------------------------------");
		System.out.println("1. Get Account Number");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposite Money");
		System.out.println("4. Transfer Money");
		System.out.println("5. Exit");
		
		System.out.println("Enter key");
		int key = sc.nextInt();
		
		AccountManageDaoimpl amd;
		
		
		switch(key) {
		
		
		case 1:
			
			System.out.println("Enter Email");
			String ea = sc.next();
			
			System.out.println("Enter pin");
			int p  = sc.nextInt();
			
			adi = new AccountDaoimpl();
			
			adi.getAccountNumber(ea, p);
			
			break;
			
		case 2:
			
			System.out.println("Enter Account Number ");
			long account = sc.nextLong();
			
			System.out.println("Enter Pin");
			int sec = sc.nextInt();
			
			System.out.println("Enter Amount");
			double  amt = sc.nextDouble();
			
			
			amd = new AccountManageDaoimpl();
			
			amd.withdrawMoney(account, sec, amt);
			
			break;
			
			
			
		case 3:
			
			System.out.println("Enter Account Number ");
			long an = sc.nextLong();
			
			System.out.println("Enter Pin");
			int se = sc.nextInt();
			
			System.out.println("Enter Amount");
			double  amto = sc.nextDouble();
			
			
			amd = new AccountManageDaoimpl();
			
			amd.depositeMoney(an, se, amto);
			
			break;
		
		
		case 4:
			
			System.out.println("Enter Your Account number");
			long you = sc.nextLong();
			
			System.out.println("Enter reciver Account number");
			long rec = sc.nextLong();
			
			System.out.println("Enter ddeposite Amount");
			double paisa = sc.nextDouble();
			
			System.out.println("Enter Pin");
			int cli = sc.nextInt();
			
			amd = new AccountManageDaoimpl();
			
			amd.transferMoney(you, cli, rec, paisa);
			break;
			
			
		case 5:
			
			System.exit(0);
			return;
			
			
		}
		

		}

		
		
	}else {
		
		System.out.println("Login Failed");
		
	}
	
	
	
	
	
}



	}

}
