package Sprint_01;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assesment_Oct27 extends BaseClass {
 @Test
	public  void Assesment() throws InterruptedException, MalformedURLException {

	/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // Disable pop-ups and notifications
		options.addArguments("--disable-popup-blocking"); // Disable blocking for pop-ups

		ChromeDriver driver = new ChromeDriver(options);*/
		
		// Set Remote WebDriver and Desired Capabilities for GRID Execution
    	// UI Console - http://20.40.48.160:4444/ui/#/sessions - click on Video - secret is the password
    	
    	/*// Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
         
    	DesiredCapabilities dc = new DesiredCapabilities();
    			dc.setBrowserName("chrome");
    			dc.setPlatform(Platform.LINUX);
    			dc.setCapability(ChromeOptions.CAPABILITY, options);
    		  //dc.merge(options);
    			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);*/

     // Step 1: Accept cookies
     driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

     // Step 2: Click on 'See All Player Stats'
     driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();

     // Step 3: Choose 'Season' as '2023-24'
     Select seasonDropdown = new Select(driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[1]")));
     seasonDropdown.selectByVisibleText("2023-24");

     // Step 4: Choose 'Season Type' as 'NBA Cup'
     Select seasonTypeDropdown = new Select(driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[2]")));
     seasonTypeDropdown.selectByVisibleText("NBA Cup");

     // Step 5: Choose 'Per Mode' as 'Per Game'
     Select perModeDropdown = new Select(driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[3]")));
     perModeDropdown.selectByVisibleText("Per Game");

     // Step 6: Choose 'Season Segment' as 'Last Game'
     Select seasonSegmentDropdown = new Select(driver.findElement(By.xpath("//select[@class='SplitComboDropDown_select__G7wsG']")));
     seasonSegmentDropdown.selectByValue("LastNGames=1");

     // Remove unwanted elements
     driver.executeScript("document.querySelectorAll('.bx-align, .bx-shroud, .ad-class-name').forEach(el => el.remove());");

     // Scroll down the page
     driver.executeScript("window.scrollBy(0, 500)");

     // Step 7: Click on the player name with the lowest age
     driver.findElement(By.xpath("//table[@class='Crom_table__p1iZz']//th[4]")).click();

     // Step 8: Click on the player's profile
     driver.findElement(By.xpath("(//tbody[@class='Crom_body__UYOcU']//td[2])[1]")).click();

     // Step 9: Get the experience of the player
     String experienceText = driver.findElement(By.xpath("//p[text()='EXPERIENCE']/following-sibling::p")).getText();
     System.out.println(experienceText);

     // Step 10: Verify the player's experience is 1 year
     if (experienceText.equals("1 Year")) {
         System.out.println("Test case Passed");
     } else {
         System.out.println("Test case Failed");
     }    

		

		
	}
}
