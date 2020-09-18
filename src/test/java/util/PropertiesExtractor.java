package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExtractor {

    public static void readProperties() {
        InputStream input = null;
        try {
            Properties prop = new Properties();
            input = PropertiesExtractor.class.getClassLoader().getResourceAsStream("local.properties");

            // load a property file
            prop.load(input);

            for (String propName : prop.stringPropertyNames()) {
                System.setProperty(propName, prop.getProperty(propName));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
