package ui.pages.produtos.categorias;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CervejasPage {
	WebDriver driver;
	
	public CervejasPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProduct() {
		product().click();
	}

	private WebElement product () {
		WebElement  product = driver.findElement(By.xpath("//div[@id='product-card']"));
		return product;
	}
	
	private WebElement breadcrumb () {
		WebElement  breadcrumb = driver.findElement(By.xpath("//ul[contains(@class,'Breadcrumb')]"));
		return breadcrumb;
	}
	
	public void wait(int millis)
	{
		if (!exists(millis))
		{
			throw new TimeoutException("Cervejas Page did not load after " + millis + " milliseconds.");
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
			boolean breadcrumb = breadcrumb().getAttribute("innerText").equals("Página Inicial‣Cervejas");
			
			return breadcrumb;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
	
}
