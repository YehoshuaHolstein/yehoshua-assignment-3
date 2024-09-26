package com.coderscampus;

import java.util.Scanner;

public class UserService {

	private final FileService fileService = new FileService();

	public void login(String filePath) {
		try (Scanner scanner = new Scanner(System.in)) {
			String username;
			String password;
			int attempts = 0;
			int maxAttempts = 5;

			while (attempts < maxAttempts) {
				System.out.println("Enter your email: ");
				username = scanner.nextLine();
				System.out.println("Enter your password: ");
				password = scanner.nextLine();

				User validUser = validateUser(filePath, username, password);

				if (validUser != null) {
					System.out.println("Welcome: " + validUser.getName());
					break;
				} else {
					System.out.println("Invalid login, please try again");
					attempts++;
				}

				if (attempts == maxAttempts) {
					System.out.println("Too many failed login attempts, you are now locked out");
				}
			}

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

	}

	private User validateUser(String filePath, String username, String password) {
		User[] users = fileService.readFile(filePath);
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}