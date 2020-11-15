package assignment8_email;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String[] departments = new String[]{"none", "Sales", "Development", "Accounting"};
    private char[] passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%".toCharArray();
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private Scanner console;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.console = new Scanner(System.in);
    	System.out.println("New Worker: " + getName());
    	System.out.println("Department Codes: ");
    	System.out.println("1 for Sales\n" + 
    			"2 for Development\n" + 
    			"3 for Accounting\n" + 
    			"0 for none\n" + 
    			"Enter department code: ");
    	this.department = SetDepartment();
    	this.password = randomPassword(this.defaultPasswordLength);
    }

    // Ask for the department
    private String SetDepartment() {
    	String line = console.nextLine();
    	int code = 0;
    	try {
    		code = Integer.parseInt(line);
    		return departments[code];
    	} catch (Exception e) {
    		System.out.println("Unable to read. Please type only 0 - 3");
    		return SetDepartment();
    	}
    }

    // Generate a random password
    private String randomPassword(int length) {
    	Random rd = new Random();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < length; i++) {
    		sb.append(passwordSet[rd.nextInt(passwordSet.length)]);
    	}
    	return sb.toString();
    }
    
    private String getName() {
    	return firstName + " " + lastName;
    }
    
    private String getEmail() {
    	if (this.department.equals("none")) {
    		return firstName + "." + lastName + "@" + this.companySuffix;
    	}
    	return firstName + "." + lastName + "@" + department.toLowerCase() + "." + this.companySuffix;
    }

    protected String showInfo() {
    	return "DISPLAY NAME: " + getName() + "\n" + 
    	"DEPARTMENT: " + this.department + "\n" + 
    	"COMPANY EMAIL: " + getEmail() + "\n" + 
    	"PASSWORD: " + this.password + "\n" + 
    	"MAILBOX CAPACITY: " + this.mailboxCapacity;
    }
}
