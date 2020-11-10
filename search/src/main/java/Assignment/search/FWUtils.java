package Assignment.search;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FWUtils 
{
	public static String readDataXl(String path,String sheet,int rowno,int cellno)
	{
		String data="";
		try
		{
		Workbook wb=WorkbookFactory.create(new  FileInputStream(path));	
		data=wb.getSheet(sheet).getRow(rowno).getCell(cellno).toString();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
		
	}
	public static void takeScreenshot(WebDriver driver,String path)
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des=new File(path);
			FileUtils.copyFile(src, des);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
