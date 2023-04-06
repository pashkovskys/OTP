package untils;

import java.io.IOException;
import java.util.Properties;

public class SuiteConfiguration {

    private static final String APPLICATION_PROPERTIES = "/application.properties";
    private final Properties properties;

    public SuiteConfiguration() throws IOException {
        properties = new Properties();
        properties.load(SuiteConfiguration.class.getResourceAsStream(System.getProperty("application.properties", APPLICATION_PROPERTIES)));
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }
}
