package com.goodseva.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	public static Logger log = LogManager.getLogger();
	public static String getProperty(String filePath, String property) {
        FileReader reader = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/" + filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Getting "+property+" from "+filePath);
		log.info(property+" value is: "+p.getProperty(property));
		return p.getProperty(property);
	}
}
