package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittorgarh {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window();
		
		// 1. Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		
		//2. Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		
		//3. Click on NSE bulk Deals
		driver.findElement(By.xpath("//a[@href='/newportal/stock-nse-bulk-deals.asp']")).click();
		
		
		//4. Get all the Security names	
		//List<WebElement> secnames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));
		
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		System.out.println("Security Names:: ");
		List<String> securityNames  = new ArrayList<String>();
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				if(j==2)
				{
					securityNames.add(columns.get(j).getText());
				}
			}
		}
		System.out.println(securityNames);
		Set<String> securityNamesWithoutDuplicates = new LinkedHashSet<String>();
		securityNamesWithoutDuplicates.addAll(securityNames);
		System.out.println(securityNamesWithoutDuplicates);
		driver.close();
		
	}
}
