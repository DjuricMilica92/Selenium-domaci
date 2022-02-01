package d28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		// Zadatak 
//		Maksimizirati prozor
//		Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//		Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//		I izvrsite akciju klik na odgovarajuci element
//		Na kraju programa ugasite pretrazivac.

		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
		driver.manage().window().maximize();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Unesite broj zvezdica(1-5): ");
		int zvezdica=s.nextInt();
		
	
		driver.findElement(By.id("rating-star-" + zvezdica)).click();
		
		Thread.sleep(1000);
		
		driver.close();
	}

}
