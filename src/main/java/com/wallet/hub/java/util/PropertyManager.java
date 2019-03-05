package com.wallet.hub.java.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance;
	private static String propertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\configuration.properties";
	private static String BaseUrl;
	private static String usernameVal;
	private static String passwordVal;

	// Create a Singleton instance. We need only one instance of Property
	// Manager.
	public static PropertyManager getInstance() {
		if (instance == null) {
				instance = new PropertyManager();
				instance.loadData();
			}
		
		return instance;
	}

	private void loadData() {

		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(propertyFilePath));
			// prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			System.out.println("Configuration properties file cannot be found");
		}

		// Get properties from configuration.properties
		BaseUrl = prop.getProperty("BASEURL");
		usernameVal = prop.getProperty("TrelloUserName");
		passwordVal = prop.getProperty("TrelloPassword");
	}

	public String getBaseUrl() {
		return BaseUrl;
	}

	public String getTrelloUserName() {
		return usernameVal;
	}

	public String getTrelloPassword() {
		return passwordVal;
	}

}