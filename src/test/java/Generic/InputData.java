package Generic;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class InputData {
	
	@DataProvider(name="logInCreds")
	public Object[][] loginCredentials() throws IOException
	{
		
		ExcelManager e=new ExcelManager("C:/Users/Sapna/workspace/sampleproject/SampleTest/src/test/java/Resources/TestData.xlsx");
		 int getRowCount = e.GetRowCount("creds");
		 Object[][] obj=new Object[getRowCount][2];
		 for(int i=1;i<=getRowCount;i++)
		 { 
			 obj[i-1][0] = e.GetCellValue("creds", i, 0);
			 obj[i-1][1] = e.GetCellValue("creds", i, 1);
		 }
				 
		return obj;
		
		
	}
	
}
