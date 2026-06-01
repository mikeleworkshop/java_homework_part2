package part5;

import java.util.*;
import java.io.*;

public class Task2 {
	static class User {
        String firstName, lastName, dob, username, password;
 
        User(String fn, String ln, String dob, String user, String pass) {
            this.firstName = fn;
            this.lastName  = ln;
            this.dob       = dob;
            this.username  = user;
            this.password  = pass;
        }
        
    String toCSV() {
        return firstName + "," + lastName + "," + dob + "," + username + "," + password;
    }
    
    static User fromCSV(String line) {
        String[] p = line.split(",");
        return (p.length == 5) ? new User(p[0], p[1], p[2], p[3], p[4]) : null;
    }
    
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName
             + " | DOB: " + dob + " | Username: " + username;
    }
}
	static class UserManager {
        private static final String FILE = "users.txt";
 
        boolean save(User user) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE, true))) {
                pw.println(user.toCSV());
                return true;
            } catch (IOException e) {
                return false;
            }
        }
 
        List<User> loadAll() {
            List<User> list = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        User u = User.fromCSV(line.trim());
                        if (u != null) list.add(u);
                    }
                }
            } catch (IOException ignored) { }
            return list;
        }
 
        List<User> findByName(String keyword) {
            String kw = keyword.toLowerCase();
            List<User> results = new ArrayList<>();
            for (User u : loadAll()) {
                if (u.firstName.toLowerCase().contains(kw)
                 || u.lastName.toLowerCase().contains(kw)) {
                    results.add(u);
                }
            }
            return results;
        }
        
        boolean authenticate(String username, String password) {
            for (User u : loadAll()) {
                if (u.username.equals(username) && u.password.equals(password)) return true;
            }
            return false;
        }
    }
	
	static final Scanner sc  = new Scanner(System.in);
    static final UserManager mgr = new UserManager();
 
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            switch (sc.nextLine().trim()) {
                case "1": doRegister();            break;
                case "2": doViewUsers();           break;
                case "3": running = doLogin();     break;
                case "0": running = false;         break;
                default:  System.out.println("  Invalid option. Please try again.");
            }
        }
        System.out.println("Goodbye!");
    }
 
    static void showMenu() {
        System.out.println("\n======= MENU =======");
        System.out.println("1. Register");
        System.out.println("2. View Registered Users");
        System.out.println("3. Login");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }
    
    static void doRegister() {
        System.out.println("\n--- Register ---");
        String fn   = prompt("First Name      : ");
        String ln   = prompt("Last Name       : ");
        String dob  = prompt("Date of Birth   : ");
        String user = prompt("Username        : ");
        String pass = prompt("Password        : ");
 
        if (mgr.save(new User(fn, ln, dob, user, pass))) {
            System.out.println(">> Registered successfully!");
        } else {
            System.out.println(">> Registration failed. Please try again.");
        }
    }
    
    static void doViewUsers() {
        System.out.println("\n--- View Registered Users ---");
        System.out.println("1. Show all");
        System.out.println("2. Find by name");
        System.out.print("Choose: ");
        String opt = sc.nextLine().trim();
 
        if (opt.equals("1")) {
            List<User> users = mgr.loadAll();
            if (users.isEmpty()) {
                System.out.println("No users registered yet.");
            } else {
                System.out.println("\n-- All Users (" + users.size() + ") --");
                for (int i = 0; i < users.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + users.get(i));
                }
            }
 
        } else if (opt.equals("2")) {
            String kw = prompt("Enter search keyword: ");
            List<User> res = mgr.findByName(kw);
            if (res.isEmpty()) {
                System.out.println("No users found for '" + kw + "'.");
            } else {
                System.out.println("\n-- Found " + res.size() + " result(s) --");
                for (int i = 0; i < res.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + res.get(i));
                }
            }
        }
    }
    
    static boolean doLogin() {
        System.out.println("\n--- Login ---");
        final int MAX = 3;
 
        for (int attempt = 1; attempt <= MAX; attempt++) {
            String user = prompt("Username: ");
            String pass = prompt("Password: ");
 
            if (mgr.authenticate(user, pass)) {
                System.out.println(">> Login successful! Welcome, " + user + "!");
                System.out.println(">> Program finished.");
                return false;
            }
 
            int left = MAX - attempt;
            if (left > 0) {
                System.out.println(">> Wrong credentials. " + left + " attempt(s) remaining.");
            } else {
                System.out.println(">> Account LOCKED! Maximum attempts exceeded.");
            }
        }
        return true;
    }
    
    static String prompt(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}