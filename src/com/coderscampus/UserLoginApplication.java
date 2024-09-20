package com.coderscampus;

import java.util.Arrays;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		UserService userService = new UserService();
		
		User[] user = userService.readFile(new String("C:\\Users\\15204\\OneDrive\\Documents\\"
				+ "GitHub\\bootcamp_workspace\\yehoshua-assignment-3\\data.txt"));
		
		String[] inputArray = userService.acceptInput();
		userService.validateInput(user, inputArray);
	} 

}
