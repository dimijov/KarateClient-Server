/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author HP
 */
public class Util {
    
    private Properties properties;
    private static Util instance;
    
    private Util() throws FileNotFoundException, IOException{

    	/*
        FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
        properties=new Properties();
        properties.load(fis);
        */
    	properties=new Properties();
    	properties.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
    }
    
    public static Util getInstance() throws IOException{
        if(instance==null){
            instance=new Util();
        }
        return instance;
    }
    
   
    public String getURL(){
        return properties.getProperty("url");
    }
    
    public String getUser(){
        return properties.getProperty("user");
    }
    
    public String getPassword(){
        return properties.getProperty("password");
    }
    
}
