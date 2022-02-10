package d08_02_2022_Zadatak1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




public class Form_test {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Form_page formPage;

	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("file:///D:/Internet%20download/form.html");
		wait = new WebDriverWait(driver, 10);

}
	
	@Test
	public void testForm() throws IOException, InterruptedException {
		
		File file =new File("data/FormData.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		 XSSFSheet sheet=wb.getSheet("form");
		 SoftAssert sf=new SoftAssert();
		 
		 for (int i = 1; i <7; i++) {

				String fullName = sheet.getRow(i).getCell(0).getStringCellValue();
				String gender = sheet.getRow(i).getCell(1).getStringCellValue();

				Date dateOfBirth = sheet.getRow(i).getCell(2).getDateCellValue();
				String email = sheet.getRow(i).getCell(3).getStringCellValue();
				String waysOfDev = sheet.getRow(i).getCell(5).getStringCellValue();
				String comment = sheet.getRow(i).getCell(6).getStringCellValue();
				
				formPage.getFullName().sendKeys(fullName);
				Thread.sleep(500);
				formPage.getGender(gender).click();
				Thread.sleep(500);
				
				DateFormat df = new SimpleDateFormat();
				String dateOfBirth1 = df.format(dateOfBirth);

				formPage.getDOB().sendKeys(dateOfBirth1);
				formPage.getEmail().sendKeys(email);
				Thread.sleep(500);
				formPage.getCheckbox(waysOfDev).click();
				Thread.sleep(500);
				formPage.getComment().sendKeys(comment);
				Thread.sleep(500);
				formPage.getSubmitButton().click();

				sf.assertTrue(formPage.isDataSaved(),  "Forma nije uspesno snimljena");
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.invisibilityOfElementWithText(
						By.xpath("//*[@class='message-element poruka']"), "Uspesno ste sacuvali podatke!"));

				

		      
				
				driver.navigate().refresh();

			}
			
			sf.assertAll();
	}
}
