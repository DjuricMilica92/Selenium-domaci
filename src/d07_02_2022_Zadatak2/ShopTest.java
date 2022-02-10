package d07_02_2022_Zadatak2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private Main_page mainPage;
	private Product_page productPage;
	private Cart_page cartPage;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("https://cms.demo.katalon.com/");
		wait = new WebDriverWait(driver, 10);

		mainPage = new Main_page(driver, wait);
		productPage = new Product_page(driver, wait);
		cartPage = new Cart_page(driver, wait);
	}

	@Test
	public void testShop() throws InterruptedException {
		mainPage.getShop().click();
		mainPage.getFirstProduct().click();
		productPage.getQuantityUp().click();
		productPage.getAddToCart().click();
		Assert.assertTrue(productPage.isTextFound(), "No message shown.");
		productPage.getViewCart().click();
		Assert.assertTrue(cartPage.isProductInTheCart(), "Cart empty.");
		Thread.sleep(2000);
		cartPage.getRemove().click();
		Thread.sleep(2000);
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty.");
	}
}
