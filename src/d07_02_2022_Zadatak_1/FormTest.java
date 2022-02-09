package d07_02_2022_Zadatak_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest {
	private WebDriver driver;
	private FormPage formPage;
	private WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("file:///D:/Internet%20download/form.html");
		wait = new WebDriverWait(driver, 10);

		formPage = new FormPage(driver, wait);
	}

	@Test
	public void formTest() throws InterruptedException {
		formPage.getFullNameInput().sendKeys("Milica Djuric");
		formPage.getGenderRadioButton("female").click();
		formPage.getDOBInput().sendKeys("22.08.1992.");
		formPage.getEmailInput().sendKeys("milicadjuricrs@gmail.com");
		formPage.roleSelect("QA");
		formPage.getCheckboxInput(1).click();
		formPage.getCommentInput().sendKeys("Hello.");
		formPage.getSubmitButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(formPage.isDataSaved(), "Data is not saved.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.quit();
	}


}
