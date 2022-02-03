package d31_01_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) {
//		2.Zadatak
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//		Bira proizvoljan Country, State i City
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://geodata.solutions/");
		
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id='countryId']")));
		s.selectByVisibleText("Serbia");
		Select s1 = new Select(driver.findElement(By.xpath("//*[@id='stateId']")));
		s1.selectByVisibleText("Central Serbia");
		Select s2 = new Select(driver.findElement(By.xpath("//*[@id='cityId']")));
		s2.selectByVisibleText("Nis");

	}

}
