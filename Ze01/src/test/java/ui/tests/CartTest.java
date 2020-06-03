package ui.tests;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ui.pages.MainPage;
import ui.pages.ProdutoPage;
import ui.pages.produtos.ProdutosPage;
import ui.pages.produtos.SacolaPage;
import ui.pages.produtos.categorias.CervejasPage;

@Test(groups = "ui")
public class CartTest {
	WebDriver driver;
	
	@Test(testName = "Buy a Beer - Add a Beer to the cart as an existing user",
			description = " As an existing user add a beer to the cart ",
			groups = { "positive", "regression"})
	public void buyABeer() {
		MainPage main = new MainPage(driver);
		ProdutosPage produtos = new ProdutosPage(driver);
		CervejasPage cervejas = new CervejasPage(driver);
		ProdutoPage produto = new ProdutoPage(driver);
		SacolaPage sacola = new SacolaPage(driver);
		
		main.clickYes();
		main.setAddress("Avenida Santo Amaro, 1001  Vila Nova Conceição, São Paulo - SP");
		main.clickVerProdutosDisponiveis();
		
		produtos.wait(15000);
		produtos.clickCervejas();
		
		cervejas.wait(5000);
		cervejas.clickProduct();
		
		produto.wait(5000);
		if (produto.requiresGarrafa()) {
			produto.clickPossuoGarrafa();
		}
		produto.clickAdicionar();
		
		sacola.wait(5000);
		assertEquals(sacola.getQuantity(),"1 produto");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void start() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.ze.delivery/");
	}
	
	@AfterMethod
	private void close() {
		  //Close driver
		  driver.quit();
	
	}
	
}
