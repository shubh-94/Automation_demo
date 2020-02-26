package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;

	public ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop= new Properties();
			
			prop.load(fis);
		} catch(Exception e)
		{
			
			System.out.println("Not able to load config file" +e.getMessage());
		}
		
	}
	
	public String getDatafromconfig(String keytoSearch)
	{
		return prop.getProperty(keytoSearch);
	}
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	public String getQAurl()
	{
		return prop.getProperty("qaUrL");
	}
	
	
}
