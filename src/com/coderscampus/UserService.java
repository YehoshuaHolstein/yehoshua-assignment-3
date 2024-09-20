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
		User[] userArray = new User[4];
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

	
	public String[] acceptInput() {
		String[] inputArray = new String[2];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email: ");
		String e = scanner.nextLine();
		inputArray[0] = e;
		System.out.println("Enter your password: ");
		String p = scanner.nextLine();
		inputArray[1] = p;
		scanner.close();
		return inputArray;
		
	}	
	
	public void validateInput(User[] userArray, String[] inputArray) {
		String output = "";
		for (int i = 0; i < 6; i++) {	
			
			for(int j = 0; j < userArray.length; j++) {
				if (userArray[j].getUsername().equalsIgnoreCase(inputArray[0])  && 
						userArray[j].getPassword().equalsIgnoreCase(inputArray[1])) {
					output = ("Welcome: " + userArray[j].getName());
					break;
				} else { 
					continue;
				}
			}
			if (output == "") {
				System.out.println("Invalid login, please try again");
				acceptInput();
			}
		}
		
		if (output == "") {
				System.out.println("Too many failed login attempts, you are now locked out");
			} 
	
	}
}
