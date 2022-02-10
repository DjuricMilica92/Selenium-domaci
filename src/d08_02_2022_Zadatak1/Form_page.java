package d08_02_2022_Zadatak1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form_page {
	private WebDriver driver;
	private WebDriverWait wait;

	public Form_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getFullName() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getGender(String radioValue) {
		return driver.findElement(By.xpath("//input[@name= 'gender'][@value= '" + radioValue + "']"));
	}

	public WebElement getDOB() {
		return driver.findElement(By.id("dob"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}


	public WebElement getCheckbox(String waysOfDev) {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'col-sm-10 development-ways')]/div[" + waysOfDev + "]//input"));
	}

	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}

	public WebElement getSubmitButton() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return driver.findElement(By.id("submit"));
	}

	public boolean isDataSaved() {
		boolean isDataSaved = false;
		String message = driver.findElement(By.className("poruka")).getAttribute("style");
		if (message.equals("visibility: visible;")) {
			isDataSaved = true;
		}
		return isDataSaved;
	}


}
