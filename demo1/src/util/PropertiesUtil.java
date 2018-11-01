package util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public static String getProperty(String file,String name){
		Properties prop = new Properties();
		try {
			prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(name);
	}
}
