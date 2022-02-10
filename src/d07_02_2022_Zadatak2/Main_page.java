package d07_02_2022_Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main_page {
	WebDriver driver;
	WebDriverWait wait;

	public Main_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getShop() {
		return driver.findElement(By.xpath("//*[@id= 'primary-menu']//li[5]/a"));
	}

	public WebElement getFirstProduct() {
		return driver.findElement(
				By.xpath("//*[contains(@class, 'woocommerce-LoopProduct-link woocommerce-loop-product__link')]"));
	}
}
