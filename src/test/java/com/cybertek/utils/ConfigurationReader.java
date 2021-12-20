package com.cybertek.utils;


// this util class is used to read values from configuration.properties file

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            // open the file using inputStream
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            // load to properties object
            properties.load(inputStream);

            //close file after loading
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");
        }

    }
    // method is used to read value from a configuration.properties file
    // @param key --> key name in properties file
    // @return --> value for the keky. returns null if key not found
    // EX: driver.get( ConfigurationReader.getProperty("url"));

    public static String getProperty(String key){
        return  properties.getProperty(key);
    }

}
