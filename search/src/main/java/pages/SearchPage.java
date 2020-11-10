package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
	@FindBy(id="search12")
	private WebElement searchTerm;
	@FindBy (id="search102")
	private WebElement searchContent;
	@FindBy (id="123")
	private WebElement find;
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	public void setSearchTerm(String sT)
	{
		searchTerm.sendKeys(sT);
	}

	public void setSearchContent(String sC)
	{
		searchContent.sendKeys(sC);
	}
	public void find()
	{
		find.click();
	}

	

}
