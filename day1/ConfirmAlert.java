package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ConfirmAlert {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//span[(text() = 'Show')])[2]")).click();
		
		Thread.sleep(6000);
				
		Alert confirmalert = driver.switchTo().alert();
		String alerttext = confirmalert.getText();
		System.out.println("Confirm Alert Message is : "+alerttext);
		
		confirmalert.dismiss();
		
		String result = driver.findElement(By.id("result")).getText();
		
		if(result.contains("Cancel")) {
			System.out.println("Alert is dismissed");
		}
		else
			System.out.println("Alert is not dismissed or not handled at all");

	}

}
