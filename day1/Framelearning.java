package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Framelearning {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.switchTo().frame("iframeResult");

		WebElement W1 = driver.findElement(By.xpath("//button[text() = 'Try it']"));

		W1.click();

		Alert confirmalert = driver.switchTo().alert();
		String alerttext = confirmalert.getText();
		System.out.println("Confirm Alert Message is : "+alerttext);

		confirmalert.dismiss();

		String result = driver.findElement(By.id("demo")).getText();

		if(result.contains("Cancel")) {
			System.out.println("Alert is dismissed");
		}
		else
			System.out.println("Alert is not dismissed or not handled at all");
		
		driver.close();

	 }
	
	



}


