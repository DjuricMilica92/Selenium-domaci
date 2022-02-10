package d07_02_2022_Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_page {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	public Cart_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public boolean isProductInTheCart() {
		boolean isProductInTheCart;
		String value = driver.findElement(By.xpath("//*[@for= 'quantity_620438f0917fe']")).getAttribute("value");
		if (value.equals("2")) {
			return isProductInTheCart = true;
		}
		return isProductInTheCart = false;
	}

	public WebElement getRemove() {
		return driver.findElement(By.className("remove"));
	}

	public boolean isCartEmpty() {

		boolean isCartEmpty = false;
		try {
			driver.findElement(By.xpath("//*[contains(text(),'Your cart is currently empty.')]"));
			isCartEmpty = true;
		} catch (Exception e) {
			isCartEmpty = false;
		}
		return isCartEmpty;
}
}