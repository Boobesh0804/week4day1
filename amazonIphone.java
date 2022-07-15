package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonIphone {
	
	public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" , Keys.ENTER);
		List<WebElement> iphones = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement iphn : iphones) {
			
			
			if (iphn.getText().contains("128GB")) {
				System.out.println(iphn.getText());
			}
			
			
		}
		
		
		
	
	}

}
