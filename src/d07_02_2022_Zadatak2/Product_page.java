package d07_02_2022_Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_page {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	public Product_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void scrollToAddToCart() {
		js = (JavascriptExecutor) driver;
		WebElement addToCart = driver.findElement(By.name("add-to-cart"));
		js.executeScript("arguments[0].scrollIntoView", addToCart);
	}

	public WebElement getQuantityUp() {
		return driver.findElement(By.xpath("//*[contains(@class, 'quantity-button quantity-up')]"));
	}

	public WebElement getAddToCart() {
		return driver.findElement(By.name("add-to-cart"));
	}

	public boolean isTextFound() {
		boolean isTextFound = false;
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'woocommerce-message')]")));
		try {
			driver.findElement(By.xpath("//*[contains(@class,'woocommerce-message')]"));
			isTextFound = true;
		} catch (Exception e) {
			isTextFound = false;
		}
		return isTextFound;
	}

	public WebElement getViewCart() {
		return driver.findElement(By.xpath("//*[contains(@class, 'button wc-forward')]"));
	}


}
