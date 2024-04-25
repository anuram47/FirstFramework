package workingWithUnitTestingTool;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorkingWithDataProvider {

	
	@DataProvider(name="test")
	public String [][] getData() {
		String [][] data = new String [2][5];
		data[0][0] ="Anu";
		data[0][1] ="Shree";
		data[0][2] ="anuram47@gmail.com	";
		data[0][3] ="test1234";
		data[0][4] ="test1234";
		
		data[1][0] ="manu";
		data[1][1] ="Shree";
		data[1][2] ="manuram@gmail.com	";
		data[1][3] ="test12345678";
		data[1][4] ="test12345678";
		return data;
		
	}
	@Test(dataProvider = "test")
//	public void readData(String[][] regData) {
//		System.out.println(regData[0][0]);
//		System.out.println(regData[0][1]);
//		System.out.println(regData[0][2]);
//		System.out.println(regData[0][3]);
//		System.out.println(regData[0][4]);
//	}
	
	public void readData(String FN, String LN, String emailId, String Pwd, String conPwd) {
		System.out.println(FN);
		System.out.println(LN);
		System.out.println(emailId);
		System.out.println(Pwd);
		System.out.println(conPwd);
	}
	
}
