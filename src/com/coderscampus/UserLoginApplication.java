package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		//UserService userService = new UserService();
		
		// open file
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
					
			// read from file
			String line;
			
			try {
				while ((line = fileReader.readLine()) != null) {
					String[] stringArray = line.split(",");				

					for (String value : stringArray) {
						System.out.println(value);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					fileReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

	}

}
