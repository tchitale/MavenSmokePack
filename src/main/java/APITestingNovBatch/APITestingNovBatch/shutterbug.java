package APITestingNovBatch.APITestingNovBatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class shutterbug {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tushar.chitale\\Desktop\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-table/");
	   driver.findElement(By.xpath("//input[@value='Manual Tester']"));
		Thread.sleep(5000);
		Shutterbug.shootPage(driver).withName("test1").save();
		//Shutterbug.shootPage(driver).save("C:\\Users\\tushar.chitale\\Desktop\\screenshot\\");
		

	}

}
