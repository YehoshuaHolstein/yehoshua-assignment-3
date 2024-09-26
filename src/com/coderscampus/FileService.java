package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readFile(String filePath) {
		String line;
		int index = 0;
		User[] userArray = new User[4];
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			while ((line = bufferedReader.readLine()) != null) {
				String[] userData = line.split(",");
				User user = new User(userData[0], userData[1], userData[2]);
				userArray[index] = user;
				index++;
			}
		} catch (IOException e) {
			System.out.println("There was a problem: " + e.getMessage());
		}

		return userArray;
	}

}
