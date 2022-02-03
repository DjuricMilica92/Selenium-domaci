package d31_01_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon
//		klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		driver.manage().window().maximize();


		List<WebElement> x= driver.findElements(By.xpath("//*[@class='col-md-12']//button")); 

		for (int i=1;i<=x.size();i++) {
			driver.findElement(By.xpath("//*[@class='col-md-12']//div[last()]//button")).click();
			Thread.sleep(2000);
			
			List<WebElement> brisanje= driver.findElements(By.xpath("//*[@class='col-md-12']//button")); 
			if(brisanje.size()==x.size()-i) {
				System.out.println("Element je obrisan.");
			}else  {
				System.out.println("Element nije obrisan.");
			}

	}
}
