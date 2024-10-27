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

public class Assesment_Oct27 {

	public static void main(String args[]) throws InterruptedException, MalformedURLException {

	/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // Disable pop-ups and notifications
		options.addArguments("--disable-popup-blocking"); // Disable blocking for pop-ups

		ChromeDriver driver = new ChromeDriver(options);*/
		
		// Set Remote WebDriver and Desired Capabilities for GRID Execution
    	// UI Console - http://20.40.48.160:4444/ui/#/sessions - click on Video - secret is the password
    	
    	// Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
         
    	DesiredCapabilities dc = new DesiredCapabilities();
    			dc.setBrowserName("chrome");
    			dc.setPlatform(Platform.LINUX);
    			dc.setCapability(ChromeOptions.CAPABILITY, options);
    		  //dc.merge(options);
    			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);

           

		// Step 1: Login to Sales-force Application
		driver.manage().deleteAllCookies();
		driver.get("https://www.nba.com/stats");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

		// Step 2. Click on 'See All Player Stats'
		driver.findElement(By.xpath("//a[text()='See All Player Stats']")).click();

		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fileElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='bx-wrap']/button[@data-click='close'])[2]")));
		fileElement.click();*/
		
		
		// Step 3. Choose 'Season' as '2023-24'

		WebElement dropdownElement = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[1]"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("2023-24");

		// Step 4. Choose 'Season Type' as 'NBA Cup'
		WebElement seasonTypeDropdown = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[2]"));
		Select seasonTypeSelect = new Select(seasonTypeDropdown);
		seasonTypeSelect.selectByVisibleText("NBA Cup");

		// Step 5. Choose 'Per Mode' as 'Per Game'
		WebElement perModeDropdown = driver.findElement(By.xpath("(//select[@class='DropDown_select__4pIg9'])[3]"));
		Select perModeSelect = new Select(perModeDropdown);
		perModeSelect.selectByVisibleText("Per Game");

		// Step 6. Choose 'Season Segment' as 'Last Game'
		WebElement seasonSegmentDropdown = driver
				.findElement(By.xpath("//select[@class='SplitComboDropDown_select__G7wsG']"));
		Select seasonSelect = new Select(seasonSegmentDropdown);
		seasonSelect.selectByValue("LastNGames=1");

		
		// WebElement CloseBanner =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bx-wrap']//span[text()='close
		// email sign up banner']")));
		// CloseBanner.click();

		//driver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		int pixelsToScroll = 500;
		driver.executeScript("window.scrollBy(0, " + pixelsToScroll + ")");

		Thread.sleep(10);
		// Step 7. Click on the player name with lowest age
		driver.findElement(By.xpath("//table[@class='Crom_table__p1iZz']//th[4]")).click();

		
		//driver.findElement(By.xpath("//th[@field='AGE']")).click();
		
		WebElement closeBanner = driver
				.findElement(By.xpath("(//div[@class='bx-wrap']/button[@data-click=\"close\"])[1]"));
		driver.executeScript("arguments[0].click();", closeBanner);

		// Step 8. Click on the Profile
		driver.findElement(By.xpath("(//tbody[@class=\"Crom_body__UYOcU\"]//td[2])[1]")).click();

		// Step 9. Get the Experience of the player
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fileElement = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='bx-wrap']/button[@data-click='close'])[2]")));
		fileElement.click();*/
		// Step 10. Verify the player experience as 1.
		
		String Exp = driver.findElement(By.xpath("//p[text()='EXPERIENCE']/following-sibling::p")).getText();
		System.out.println(Exp);
		
		if(Exp.equals("1 Year")) {
			System.out.println("Test case Passed");
		}

	}
}
