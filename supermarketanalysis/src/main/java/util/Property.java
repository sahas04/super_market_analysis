package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
    private static final Properties properties=new Properties();
    static {
        try(InputStream inputStream=Property.class.getClassLoader().getResourceAsStream("db.properties")) {
            if(inputStream==null){
                System.out.println("no file found");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }
    public static String get(String a){
        return properties.getProperty(a);
    }
}
