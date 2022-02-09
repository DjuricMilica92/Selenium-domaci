package d07_02_2022_Zadatak_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getFullNameInput() {
		return driver.findElement(By.id("first-name"));
	}

	public WebElement getGenderRadioButton(String radioValue) {
		return driver.findElement(By.xpath("//input[@name= 'gender'][@value= '" + radioValue + "']"));
	}

	public WebElement getDOBInput() {
		return driver.findElement(By.id("dob"));
	}

	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}

	public void roleSelect(String roleValue) {
		Select dropdownRole = new Select(driver.findElement(By.id("role")));
		dropdownRole.selectByVisibleText(roleValue);
	}

	public WebElement getCheckboxInput(int checkboxNumber) {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'col-sm-10 development-ways')]/div[" + checkboxNumber + "]//input"));
	}

	public WebElement getCommentInput() {
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

