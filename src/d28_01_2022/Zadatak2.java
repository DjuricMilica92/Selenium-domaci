package d28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		Zadatak
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati red podataka - jedan red u jednoj iteraciji 
//		Kliknite na dugme Add New
//		Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//		Kliknite na zeleno Add dugme
//		Na kraju programa ugasite pretrazivac.

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate()
				.to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@class='btn btn-info add-new']")).click();

		Scanner s = new Scanner(System.in);
		System.out.println("Unesite ime i prezime: ");
		String imeIprezime = s.nextLine();

		System.out.println("Unesite departmant: ");
		String department = s.next();

		System.out.println("Unesite broj telefona: ");
		String brTel = s.next();

		driver.findElement(By.id("name")).sendKeys(imeIprezime);
		Thread.sleep(1000);
		driver.findElement(By.id("department")).sendKeys(department);
		driver.findElement(By.id("phone")).sendKeys(brTel);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@class='table table-bordered']/tbody/tr[4]/td[4]/a")).click();
		Thread.sleep(1000);
		driver.close();
	}

}