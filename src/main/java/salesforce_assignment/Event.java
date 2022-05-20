package salesforce_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Event {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.id("password")).sendKeys("Tuna@123");

		driver.findElement(By.id("Login")).click();

		Thread.sleep(20000);

		String title = driver.getTitle();
		System.out.println(title);


		if(title.contains("Home Page ~ Salesforce - Developer Edition")) {


		System.out.println("Inside IF");
		driver.findElement(By.xpath("//a[@title='Home Tab']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='No Thanks']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Send to Salesforce']")).click();


		}
		else {

		System.out.println("Inside else");


		driver.findElement(By.xpath("(//span[@class='uiImage'])[1]")).click();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']")).click();

		Thread.sleep(20000);
		}


		driver.findElement(By.id("createNewButton")).click();


		driver.findElement(By.xpath("//a[@class='menuButtonMenuLink firstMenuItem eventMru']")).click();

		driver.findElement(By.xpath("(//div[@class='requiredInput']//input[@type='text'])[2]")).sendKeys("event1");

		driver.findElement(By.xpath("//input[@name='attachFile']")).click();

		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>windows=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);


		driver.findElement(By.name("file")).sendKeys("C:/demo.txt");
		Thread.sleep(3000);
		driver.findElement(By.id("Attach")).click();
		Thread.sleep(3000);

		System.out.println(driver.findElement(By.id("head_1_ep")).isDisplayed());

		if(driver.findElement(By.id("head_1_ep")).isDisplayed()) {
		driver.findElement(By.xpath("//input[@name='cancel']")).click();
		}
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.name("save")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("edit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("EndDateTime")).clear();
		driver.findElement(By.id("EndDateTime")).sendKeys("5/21/2022");

		driver.findElement(By.name("save")).click();

		driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).click();

		driver.findElement(By.name("del")).click();

		String recent = driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).getText();

		if(!recent.contains("event1")) {
		System.out.println("Successfully deleted");
		}

	}

}
