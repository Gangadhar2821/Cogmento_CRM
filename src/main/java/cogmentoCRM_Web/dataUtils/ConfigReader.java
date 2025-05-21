package cogmentoCRM_Web.dataUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	public static void loadConfig() {
		try {
			FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			System.out.println("Could not load config file: " + e.getMessage());
		}
	}

	public static String get(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Missing config key: " + key);
		}
		return value;
	}

}
