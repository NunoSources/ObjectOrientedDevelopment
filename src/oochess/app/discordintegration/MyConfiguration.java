package oochess.app.discordintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyConfiguration {

	public static <T> T getClass(String chave) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("preferences.properties")));
			String klassName = (String) p.get(chave);
			Class<?> klass = Class.forName(klassName);
			@SuppressWarnings("unchecked")
			T s = (T) klass.getConstructor().newInstance();

			return s;

		} catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String getString(String chave) {
		Properties p = new Properties();

		try {
			p.load(new FileInputStream(new File("preferences.properties")));

			return (String) p.get(chave);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
