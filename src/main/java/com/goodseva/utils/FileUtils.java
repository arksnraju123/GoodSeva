package com.goodseva.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
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

    public  static void deleteFileFromFolder(String filePath){
        try {
            File file = new File(filePath);
            if (file.exists()) {
                if (file.delete()) {
                    log.info("File deleted in: " + filePath);
                } else {
                    log.info("Failed to delete file in: " + filePath);
                }
            }else{
                log.info("File not exist to delete in: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPDFFileData(String filePath){
        String text = "";
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);  // extract all text
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
