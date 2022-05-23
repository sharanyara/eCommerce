package com.walmart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getApplicationURL() {
		String url = pro.getProperty("signin.URL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("signin.username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("signin.password");
		return password;
	}

	public String getRegistrationURL() {
		String URL = pro.getProperty("registration.URL");
		return URL;
	}

	public String getRegistrationFirstName() {
		String firstName = pro.getProperty("registration.firstname");
		return firstName;
	}

	public String getRegistrationLastName() {
		String lastName = pro.getProperty("registration.lastname");
		return lastName;
	}

	public String getRegistrationPhoneNumber() {
		String phoneNumber = pro.getProperty("registration.phonenumber");
		return phoneNumber;
	}

	public String getRegistrationEmail() {
		String email = pro.getProperty("registration.email");
		return email;
	}

	public String getRegistrationPassword() {
		String password = pro.getProperty("registration.password");
		return password;
	}

	public String getAccountURL() {
		String URL = pro.getProperty("myAccount.url");
		return URL;
	}
	
	public String getPersonalSettingsURL() {
		String URL = pro.getProperty("personalsettings.url");
		return URL;
	}

}
