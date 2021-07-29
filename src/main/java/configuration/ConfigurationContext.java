package configuration;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationContext {

    private static Properties properties = new Properties();

    static String env_key = "env";
    static String baseURL_key = "ui_url";

    static String ENV = readConfigPropertyVar(env_key);
    public static String BASE_URL = readConfigPropertyFile(baseURL_key);

    private static String readConfigPropertyVar(String key){
        String value = System.getProperty(key);

        if (value == null)
            throw new IllegalArgumentException("Could not find value for property var: " +key);

        return value;
    }
    private static String readConfigPropertyFile(String key){
        if(properties.isEmpty()){
            loadProperties();
        }

        String value = properties.getProperty(key);
        if (value == null){
            throw new IllegalArgumentException("Could not find value for property var: " +key);
        }
        return value;
    }

    private static void loadProperties(){
        String propertyFilename = ENV + ".properties";
        InputStream inputStream = ConfigurationContext.class.getClassLoader().getResourceAsStream(propertyFilename);

        try{
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propertyFilename + "' not found in the classpath");
        }}catch (Exception e){
            System.out.println(e);
        }
    }

}
