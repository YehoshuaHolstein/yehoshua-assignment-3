package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserService {
	
	// reading data from file
	// creating User Array
	// validating input
	
	public User[] readFile(String filePath) {
		
		BufferedReader fileReader = null;
		fileReader = new BufferedReader(new FileReader(filePath));
		User user = new User();
		String line;
		int counter = 0;
		while ((line = fileReader.readLine()) != null) {
			String[] stringArray = line.split(",");
			user.setUsername(stringArray[0]);
			user.setPassword(stringArray[1]);
			user.setName(stringArray[2]);
			counter++;
		}
		
		User[] userArray = new User[counter + 1];
		return userArray;
		
		
		fileReader.close();
		
		
	}
	
}
