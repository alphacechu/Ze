package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickYes() {
		yesButton().click();
	}
	
	public void getAddress() {
		addressInput().getAttribute("value");
	}
	
	public void setAddress(String address) {
		fakeAddressInput().click();
		addressInput().clear();
		addressInput().sendKeys(address);
		addressItem().click();
		noComplementBox().click();
	}
	
	public void clickVerProdutosDisponiveis () {
		verProdutosButton().click();
	}
	
	private WebElement yesButton()
	{
		WebElement button = driver.findElement(By.xpath("//div[p[text()='Você tem 18 anos ou mais?']]//button[text()='Sim']"));
		return button;
	}
	
	private WebElement fakeAddressInput()
	{
		WebElement address = driver.findElement(By.xpath("//input[@name='fake-address-search-input']"));
		return address;
	}
	
	private WebElement addressInput()
	{
		WebElement address = driver.findElement(By.xpath("//input[@name='address-search-input-address']"));
		return address;
	}
	
	private WebElement addressItem()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@itemid='google-address']")));
		WebElement item = driver.findElement(By.xpath("//li[@itemid='google-address']"));
		return item;
	}
	
	private WebElement noComplementBox()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Não tenho complemento']")));
		WebElement box = driver.findElement(By.xpath("//span[text()='Não tenho complemento']"));
		return box;
	}
	
	private WebElement verProdutosButton()
	{
		WebElement button = driver.findElement(By.xpath("//button[text()='Ver produtos disponíveis']"));
		return button;
	}
}
