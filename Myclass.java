package demo_package;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Myclass {
	
	@Test
	public void myfunc() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		WebDriver driver = new ChromeDriver();
		  driver.get("http://rtogujarat.gov.in/contactus_cot.php");
		  Thread.sleep(5000);  // Let the user actually see something!
		  List <WebElement> searchBox = driver.findElements(By.xpath("//th[contains(text(),'')]"));
	
		  int index_col = 0;
		  System.out.println(searchBox.size());
		  for(int i= 0; i < searchBox.size(); i++)
		  {
			  System.out.println(searchBox.get(i).getText());
			  if(searchBox.get(i).getText().equals("Email ID")) {
				  index_col = (i);
			  }
		  }
		  System.out.println(index_col);
		  
		  String s = "//table[@class='tableDiv']//td[normalize-space()][contains(text(),'Patel, I.A.S')]/following-sibling::*["+index_col+"][name()='td']";
		  
		  String wb = driver.findElement(By.xpath(s)).getText();
		  System.out.println(wb);
		  
		  
		  
		  Thread.sleep(5000);  // Let the user actually see something!
		  driver.quit();
	}
	

}
