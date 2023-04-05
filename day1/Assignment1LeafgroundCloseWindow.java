package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1LeafgroundCloseWindow {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");


		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String Ptitle = driver.getTitle();
		String Pwindow = driver.getWindowHandle();
		System.out.println("Parent window handle : "+Pwindow);
		System.out.println("Parent window title : "+Ptitle);
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		
		List<String> listofwindows = new ArrayList<>(windowHandles);
		for (String each : listofwindows) {
			System.out.println(each);
			
			if (!each.equals(Pwindow)) {
				
				driver.switchTo().window(each);
				driver.close();
								
			}
		}

		Thread.sleep(6000);
		driver.quit();
	}

}
