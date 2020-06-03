package ui.pages.produtos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SacolaPage {
	WebDriver driver;
	
	public SacolaPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public String getQuantity () {
		return quantity().getText();
	}
	
	private WebElement header () {
		WebElement  header = driver.findElement(By.xpath("//div[@id='pre-checkout']//div[text()='SACOLA']"));
		return header;
	}
	
	private WebElement quantity () {
		WebElement  quantity = driver.findElement(By.xpath("//div[@id='total-qty-products']"));
		return quantity;
	}
	
	public void wait(int millis)
	{
		if (!exists(millis))
		{
			throw new TimeoutException("Sacola Page did not load after " + millis + " milliseconds.");
		}
	}
	
	public boolean exists(int millis)
	{
		long end = System.currentTimeMillis() + millis;
		while(System.currentTimeMillis() < end)
		{
			if (exists())
			{
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean exists ()
	{
		try 
		{
			boolean header = header().isDisplayed();
			return header;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
}
