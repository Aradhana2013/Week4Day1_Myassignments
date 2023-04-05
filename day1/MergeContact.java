package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");


		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text() = 'Contacts']")).click();
		driver.findElement(By.xpath("//a[text() = 'Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();

		String Ptitle = driver.getTitle();		
		String Pwindow = driver.getWindowHandle();		
		System.out.println("Parent Window : " + Ptitle);

		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles.size());

		for (String each : windowhandles) {
			System.out.println(each);

		}

		List<String> listofwindows = new ArrayList<>(windowhandles);
		String parentwindow = listofwindows.get(0);
		String childwindowone = listofwindows.get(1);

		driver.switchTo().window(childwindowone);

		String Ctitle = driver.getTitle();
		String Cwindow = driver.getWindowHandle();
		System.out.println("Child Window One : " + Ctitle);

		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();

		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();



		Set<String> windowhandlestwo = driver.getWindowHandles();
		System.out.println(windowhandlestwo.size());

		for (String eachtwo : windowhandlestwo) {
			System.out.println(eachtwo);

		}

		List<String> listofwindowstwo = new ArrayList<>(windowhandlestwo);
		String parentwindowtwo = listofwindowstwo.get(0);
		String childwindowtwo = listofwindowstwo.get(1);

		driver.switchTo().window(childwindowtwo);


		String Ctitletwo = driver.getTitle();
		String Cwindowtwo = driver.getWindowHandle();
		System.out.println("Child Window Two : " + Ctitletwo);

		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();

		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		Alert confirmalert = driver.switchTo().alert();

		String alerttext = confirmalert.getText();

		System.out.println("Alert message : "+alerttext);

		Thread.sleep(6000);

		confirmalert.accept();

		driver.switchTo().window(parentwindow);


		String pagetitle = driver.getTitle();

		if(driver.getTitle().contains("opentaps CRM")){
			System.out.println("The title of the page is correct and is : " + pagetitle);
		}

		driver.quit();
		
	}
}
