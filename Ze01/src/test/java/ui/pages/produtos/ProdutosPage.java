package ui.pages.produtos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutosPage {
	WebDriver driver;
	
	public ProdutosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCervejas() {
		cervejasButton().click();
	}
	
	private WebElement cervejasButton() {
		WebElement button = driver.findElement(By.xpath("//div[@id='category-Cervejas']"));
		return button;
	}
	
	public void wait(int millis)
	{
		if (!exists(millis))
		{
			throw new TimeoutException("Produtos Page did not load after " + millis + " milliseconds.");
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
			boolean cervejas = cervejasButton().isDisplayed();
			
			return cervejas;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
}
