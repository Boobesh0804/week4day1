package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class snapDeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
        WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().window();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		
	    //1. Launch https://www.snapdeal.com/
		driver.navigate().to("https://www.snapdeal.com/");
		
		//2. Search on  Training Shoes  //input[@id='inputValEnter']
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys("Training Shoes", Keys.ENTER);
		
		Thread.sleep(5000);
		//3. Get the count of the Training ShoesActions builder1 = new Actions(driver);
		
		WebElement count = driver.findElement(By.xpath("(//div[text()='19'])[2]"));
		System.out.println(count.getText());
		
		Thread.sleep(5000);
		//4. Click on Sort by  and select Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[3]")).click();
		
		//6. Enter the price range (900-1500)
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1500");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		
		Thread.sleep(5000);
		//7. Filter with color Blue
		driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).click();
		
		//8. Verify the Blue check box is enabled
		
		Thread.sleep(5000);
		//9.Click on first resulting Training shoes
		WebElement firstElement = driver.findElement(By.xpath("//div[@class='product-tuple-image ']/a"));
		firstElement.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lst=new ArrayList<String>(windowHandles );
		driver.switchTo().window(lst.get(1));
		
		Thread.sleep(2000);
		String url = driver.getTitle();
		System.out.println(url);
		Thread.sleep(5000);
		//10. Print the cost and the discount percentage
		WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println("Rs."+ cost.getText());
		
		WebElement dis = driver.findElement(By.xpath("//span[@class='pdpDiscount ']/span"));
		System.out.println(dis.getText() + "% off");
		
		//11. Take the snapshot of the shoes.
		//WebElement shoe = driver.findElement(By.xpath("//ul[@id='bx-slider-left-image-panel']//img[@class='cloudzoom'][1]"));
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/shoe1.jpg");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
		driver.switchTo().defaultContent();
		
		String url1 = driver.getTitle();
		System.out.println(url1);
		
		
		driver.close();
		
		
		
		
	}

}
