package d04_02_2022;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Zadatak1{




		WebDriver driver;
		
		@BeforeMethod
		public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		@Test
		public void kupujemProdajem() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.navigate().to("https://www.kupujemprodajem.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.className("kpBoxCloseButton"))).click();
		driver.findElement(By.className("searchKeywordsInput")).sendKeys("Iphone");
		driver.findElement(By.className("searchKeywordsInput")).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("priceSecondSelection"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value = 'eur']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Primeni']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'orderSecondSelection']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-text = 'Jeftinije']"))).click();
		
		driver.findElement(By.xpath("//*[@id = 'searchKeywordsInput']")).sendKeys(Keys.ENTER);
	
		
		List<WebElement> cene = driver.findElements(By.className("priceSec/span"));

		ArrayList<Double> listaCene = new ArrayList<Double>();

		for (int i = 0; i < cene.size(); i++) {

//			String string = "004-034556";
//			 String[] parts = string.split("-");
//			 String part1 = parts[0]; // 004
//			 String part2 = parts[1]; // 034556
			String[] deoba = cene.get(i).getText().split(" ");
			String deo1 = deoba[0];
			String deo2= deoba[1];

			deo1 = deo1.replace(',', '.');
			double decimalniDeo1 = Double.valueOf(deo1);

			if (deo2.equals("€")) {
				decimalniDeo1 = decimalniDeo1 * 117.23;
			}

			listaCene.add(decimalniDeo1);
		}

		List<Double> sortirano = listaCene.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		Assert.assertEquals(sortirano, listaCene, "Lista nije sortirana");
		}
		
		
	}

