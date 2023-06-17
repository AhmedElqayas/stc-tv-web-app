package dataProvider;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String configurationFilePath = "config/configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configurationFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not exit at " + configurationFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath =  properties.getProperty("driverPath");
        if(driverPath != null) return driverPath;
        else throw new RuntimeException("Driver path not specified in the configuration.properties file.");
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("URL not specified in the Configuration.properties file.");
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public Boolean getBrowserWindowSize() {
        String windowMaximize = properties.getProperty("windowMaximize");
        if (windowMaximize != null) return Boolean.valueOf(windowMaximize);
        return true;
    }

    public long getImplicitlyWait() {
        String implicitlyWait = (String) properties.get("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        return 30;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = (String) properties.get("testDataResourcePath");
        if (testDataResourcePath != null) return testDataResourcePath;
        else throw new RuntimeException("Test data resource path not specified in configuration.properties file.");
    }


}
