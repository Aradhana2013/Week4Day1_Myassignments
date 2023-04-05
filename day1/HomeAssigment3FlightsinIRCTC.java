package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeAssigment3FlightsinIRCTC {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");


		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String Ptitle = driver.getTitle();
		String Pwindow = driver.getWindowHandle();
		System.out.println("Parent window handle : "+Pwindow);
		System.out.println("Parent window title : "+Ptitle);
		
		driver.findElement(By.xpath("//a[text() = ' FLIGHTS ']")).click();
		
		Set<String> Allwindows = driver.getWindowHandles();
		System.out.println(Allwindows.size());
		
		List<String> listofwindows = new ArrayList<>(Allwindows);
		String childwindow = listofwindows.get(1);
		
		driver.switchTo().window(childwindow);
		
		String Ctitle = driver.getTitle();
		String Cwindow = driver.getWindowHandle();
		System.out.println("Child window handle : "+Cwindow);
		System.out.println("Child window title : "+Ctitle);
		
		
		driver.quit();

	}

}
