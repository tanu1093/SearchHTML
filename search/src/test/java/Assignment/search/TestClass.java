package Assignment.search;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import pages.SearchPage;

public class TestClass extends Base
{
	//public WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void practice(String browser)
	{
		browser("chrome");
	   driver.get(AutoConstants.URL);
	   String ST=FWUtils.readDataXl(PATH,"Sheet1", 1, 0);
	   System.out.println(ST);
		String SC=FWUtils.readDataXl(PATH,"Sheet1", 1, 1);
		System.out.println(SC);
	    SearchPage sp=new SearchPage(driver);
	    sp.setSearchTerm(ST);
	    sp.setSearchContent(SC);
	    sp.find();
	    Alert al=driver.switchTo().alert();
	    String msg=al.getText();
	    al.accept();
	    System.out.println(msg);
	    FWUtils.takeScreenshot(driver, PHOTOPATH);
	    Assert.assertTrue(msg.contains("2"));
	    driver.close();
	    
	}


}
