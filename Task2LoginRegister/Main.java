package part5;

import java.util.*;
import java.io.*;

public class Main {
		
	static final Scanner sc = new Scanner(System.in);
	static final ManageUser admin = new ManageUser();
	
	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			System.out.println("");
			showMenu();
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println("");
			
			switch (option) {
			case 1: doRegister();
			break;
			case 2: doViewUsers();
			break;
			case 3: running = doLogin();
			break;
			case 4: running = false;
			break;
				default: System.out.println("Invalid option.");
			}
		}
		System.out.println("Stop.");
		sc.close();
	}
	
	static void showMenu() {
		System.out.println("Options: ");
		System.out.println("1. Register");
		System.out.println("2. View User Accounts");
		System.out.println("3. Login");
		System.out.println("4. Exit");
		System.out.print("Enter a number: ");
	}
	
	static void doRegister() {
		System.out.println("\n REGISTER PAGE");
		
		System.out.print("Enter your First Name: ");
		String firstName = sc.nextLine().trim();
		System.out.println("");
		System.out.print("Enter your Last Name: ");
		String lastName = sc.nextLine().trim();
		System.out.println("");
		System.out.print("Enter your Date of birth: ");
		String dateOfBirth = sc.nextLine().trim();	
		System.out.println("");
		System.out.print("Enter your Username: ");
		String username = sc.nextLine().trim();
		System.out.println("");
		System.out.print("Enter your Password: ");
		String password = sc.nextLine().trim();
		System.out.println("");
		
		if (admin.checkDuplicate(username)) {
		    System.out.println("Username '" + username + "' is already taken. Please choose another.");
		} else if (admin.save(new User(firstName, lastName, dateOfBirth, username, password))) {
		    System.out.println("Register Successfully !");
		} else {
		    System.out.println("Register Fail. Try again.");
		}
		
		sc.close();
	}
	
	static void doViewUsers() {
		System.out.println("\n SEARCHING PAGE");
		System.out.println("1. Show all");
		System.out.println("2. Find by name");
		System.out.print("Enter a number: ");		
		int option = sc.nextInt();
		sc.nextLine();
		System.out.println("");
		
		if (option == 1) {
			List<User> users = admin.loadAll();
			if (users.isEmpty()) {
				System.out.println("You have 0 users to view");
			} else {
				System.out.println("\n" + users.size() + " users: ");
				for (int i = 0; i < users.size(); i++) {
					System.out.println("" + (i + 1) + ". " + users.get(i));
				}
			}
		} else if (option == 2) {
			System.out.print("Enter keywords: ");
			String keyWord = sc.nextLine().trim();
			System.out.println("");
			
			List<User> search = admin.findByName(keyWord);
			
			if (search.isEmpty()) {
				System.out.println("No users found for '" + keyWord + "'.");
			} else {
				System.out.println("\nFound " + search.size() + " user(s)");
				for (int i = 0; i < search.size(); i++) {
					System.out.println((i + 1) +". " + search.get(i));
				}
			}
		}
		sc.close();
	}	

	static boolean doLogin() {
		System.out.println("\n LOGIN PAGE");
		final int TRIES = 4;
		
		for (int attempt = 1; attempt <= TRIES; attempt++) {
			System.out.println("");
			System.out.print("Enter username: ");
			String username = sc.nextLine().trim();
			System.out.println("");
			System.out.print("Enter password: ");
			String password = sc.nextLine().trim();
			System.out.println("");
			
			if (admin.checkLogin(username, password)) {
				System.out.println("Login Successfully! Hello, " + username);
				return false;
			}
			
			int remainingAttempt = TRIES - attempt;
			if (remainingAttempt > 0) {
				System.out.println("Wrong username or password. Please Try Again!");
				System.out.println("You have " + remainingAttempt + " attempt(s) to try. Account will be locked if you failed 3 times" );
			} else {
				System.out.println("Account LOCKED. Maximum attempts exceeded!");
			}
			
		}
		sc.close();
		return true;
	}
	
}