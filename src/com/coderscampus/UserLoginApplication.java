package com.coderscampus;

import java.util.Arrays;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);

		User[] user = userService.readFile(new String("data.txt"));

		String[] inputArray = userService.acceptInput(scanner);
		userService.validateInput(user, inputArray, scanner);

		scanner.close();
	}

}
