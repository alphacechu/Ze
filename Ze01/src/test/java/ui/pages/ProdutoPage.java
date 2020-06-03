package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage {

	WebDriver driver;
	
	public ProdutoPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean requiresGarrafa () {
		return possuoGarrafaBox().isDisplayed();
	}
	
	public void clickPossuoGarrafa () {
		possuoGarrafaBox().click();
	}
	
	public void clickAdicionar () {
		adicionarButton().click();
	}
	
	private WebElement minusButton () {
		WebElement  button = driver.findElement(By.xpath("//div[@id='minus-button']"));
		return button;
	}
	
	private WebElement plusButton () {
		WebElement  button = driver.findElement(By.xpath("//div[@id='plus-button']"));
		return button;
	}
	
	private WebElement plus6Button () {
		WebElement  button = driver.findElement(By.xpath("//div[text()='+ 6 un.']"));
		return button;
	}
	
	private WebElement plus10Button () {
		WebElement  button = driver.findElement(By.xpath("//div[text()='+ 10 un.']"));
		return button;
	}
	
	private WebElement plus15Button () {
		WebElement  button = driver.findElement(By.xpath("//div[text()='+ 15 un.']"));
		return button;
	}
	
	private WebElement possuoGarrafaBox () {
		WebElement  box = driver.findElement(By.xpath("//span[text()='Possuo garrafas retornáveis para trocar']"));
		return box;
	}
	
	private WebElement adicionarButton () {
		WebElement  button = driver.findElement(By.xpath("//div[@id='product-amount']"));
		return button;
	}
	
	public void wait(int millis)
	{
		if (!exists(millis))
		{
			throw new TimeoutException("Produto Page did not load after " + millis + " milliseconds.");
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
			boolean minus = minusButton().isDisplayed();
			boolean plus = plusButton().isDisplayed();
			boolean plus6 = plus6Button().isDisplayed();
			boolean plus10 = plus10Button().isDisplayed();
			boolean plus15 = plus15Button().isDisplayed();
			
			return minus && plus && plus6 && plus10 && plus15;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
	}
	
}
