package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {
	
	// reading data from file ^
	// creating User Array
	// validating input
	
	public User[] readFile(String filePath) {
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String line;
		int index = 0;
		User[] userArray = new User[4];;
		try {
			while ((line = fileReader.readLine()) != null) {
				String[] stringArray = line.split(",");
				User user = new User();
				user.setUsername(stringArray[0]);
				user.setPassword(stringArray[1]);
				user.setName(stringArray[2]);
				userArray[index] = user;
				index++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return userArray;
		}
	
	public String validateInput(User[] userArray) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email: ");
		String emailInput = scanner.nextLine();
		System.out.println("Enter your password: ");
		String passwordInput = scanner.nextLine();
		String output = "";
		for (int i = 0; i < 6; i++) {		
			for(int j = 0; j < userArray.length; j++) {
				if (userArray[j].getUsername().equalsIgnoreCase(emailInput)  && 
						userArray[j].getPassword().equalsIgnoreCase(passwordInput)) {
					output = ("Welcome: " + userArray[j].getName());
					break;
				} else {
					System.out.println("Invalid login, please try again");
				}
			}
			if (output == "") {
				output = "Too many failed login attempts, you are now locked out";
			} else {
				break ;
			}
		}
		scanner.close();
		return output;
	}
}
