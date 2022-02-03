package d01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
	
//		Napisati program koji :
//		Ucitava stranicu https://www.udemy.com/courses/search/?src=ukw&q=slksd
//		Klikce na dugme za jezik i proverava da li se prikazuje dijalog za promenu jezika
//		Stampa u konzoli tekst “Dijalog se prikazao”

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		driver.manage().window().maximize();

		driver.findElement(By.xpath(("//button[contains(@class, 'language-selector-button--button--1wgoL')][1]")))
				.click();
		WebDriverWait wait= new WebDriverWait(driver, 5);


		boolean prikazDijaloga;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[contains(@class, 'udlite-modal-title udlite-heading-lg')]")));
			prikazDijaloga = true;
		} catch (Exception e) {
			prikazDijaloga= false;
		}

		if (prikazDijaloga) {
			System.out.println("Dijalog se prikazuje.");
		} else {
			System.out.println("Dijalog se ne prikazuje.");
		}

		Thread.sleep(3000);
		driver.close();

	}


}
