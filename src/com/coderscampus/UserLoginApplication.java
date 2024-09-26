package com.coderscampus;

import java.util.Arrays;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.login("data.txt");
	}

}
