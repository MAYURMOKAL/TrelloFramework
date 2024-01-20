package com.info.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author MAYUR
 *
 */
public class FileUtilty {
/**
 * This method will be used to read the data from the property file
 * @author MAYUR
 * @param key
 * @return value
 * @throws IOException
 */
	public String readCommonData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trelloCommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		return value;
	}
	
}
