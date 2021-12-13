package Generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyCall {

	
	public String userNameProp;
	public String PasswordProp;
	public String baseURL;
	
	public void propertyValuesFetch() throws IOException
	{
	
	Properties prop=new Properties();
	FileInputStream fis= new FileInputStream("C:/Users/Sapna/workspace/sampleproject/SampleTest/src/test/java/Resources/config.properties");
	prop.load(fis);
	
	userNameProp=prop.getProperty("userName");
	PasswordProp=prop.getProperty("password");
	baseURL=prop.getProperty("baseURL");
	}
}
