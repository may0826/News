package com.news.util.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;
    private static ConfigManager configManager=new ConfigManager();

    //属性也在初始化加载，同时只加载一次
   private ConfigManager(){
       String configFile="database.properties";
        InputStream inputStream=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
         properties=new Properties();
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //通过properties配置文件的属性名获得属性值
    public  static String getString(String key){
        return  properties.getProperty(key);

    }
//    实现单例 保持单例
//    public static ConfigManager  configManager(){
//        if (configManager==null){//保持单例
//            configManager=new ConfigManager();
//        }
//        return configManager;
//    }
    public static ConfigManager getInstance(){

        return configManager;
    }
}


