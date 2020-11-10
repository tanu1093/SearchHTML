package Assignment.search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Base implements AutoConstants
{
	public static  int count(String searchTerm, String searchContent)
     {
         if (searchTerm == null ||  searchContent== null) 
         {
             throw new IllegalArgumentException("The given fields cannot be null");
         }
         if (searchTerm.isEmpty() || searchContent.isEmpty())
         {
             return 0;
         }
         String a[]=searchContent.split(" ");
         int ctr = 0;
        for (int i = 0; i < a.length; i++)
        {
		 if(searchTerm.equals(a[i]))
			 ctr++;
		}
         return ctr;
     }
	WebDriver driver;
	
	 public static  int pass=0,fail=0;
	    
	    public void browser(String browser) 
		{
		   if (browser.equals("chrome"))
		   {
			driver=new ChromeDriver();
		   }
		   else
		   {
	        driver=new InternetExplorerDriver();
		   }
		   driver.manage().window().maximize();
		}

	    public void closeBrowser(ITestResult res)
	    {
	    	
	    	int status=res.getStatus();
	    	String methodname = res.getName();
	    	if (status==1)
	    	{
	    		pass++;
				
			}
	    	else
			{
	    		fail++;
	    		String path=PHOTOPATH+methodname+".png";
	    		FWUtils.takeScreenshot(driver,path);
			}
	    	driver.close();
	    }
}
