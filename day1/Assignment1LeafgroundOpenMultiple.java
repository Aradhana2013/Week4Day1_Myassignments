package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1LeafgroundOpenMultiple {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");


		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Total number of tabs are : "+windowHandles.size());

		List<String> listofwindows = new ArrayList<>(windowHandles);
		System.out.println("Window handles are : ");
		for (String each : listofwindows) {
			System.out.println(each);

		}
		
		Thread.sleep(3000);
		driver.quit();

	}

}
