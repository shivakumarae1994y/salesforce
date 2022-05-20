package salesforce_assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateEvent {
	public static void main(String[] args)
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); 
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com"); driver.findElement(By.name("pw")).sendKeys("Tuna@123"); driver.findElement(By.id("Login")).click();
		String title = driver.getTitle(); System.out.println(title);
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
		Thread.sleep(1000); driver.findElement(By.
		xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']")).click(
		);
		Thread.sleep(2000); }
		driver.findElement(By.xpath("//div[@class='createNewModule sidebarModule']")).click();
		//driver.findElement(By.xpath("//a[@class='menuButtonMenuLink firstMenuItem eventMru']")).click();
		driver.findElement(By.linkText("Event")).click();
		//driver.findElement(By.id("evt1")).sendKeys("Derrick Dsouza");
		driver.findElement(By.xpath("//input[@spellcheck=\"true\"]")).sendKeys("testcase");
		driver.findElement(By.xpath("//input[@value='Attach File']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator(); String parentId = it.next(); String childId = it.next(); driver.switchTo().window(childId);
		System.out.println(driver.switchTo().window(childId).getTitle());
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file']"));
		uploadFile.sendKeys("C:\\Users\\HK454BY\\OneDrive - EY\\Desktop\\gy.txt");
		/*
		driver.findElement(By.xpath("//input[@id='Attach']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>windows1=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows1.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.switchTo().window(windows1.get(0)); driver.findElement(By.xpath("(//input[@class='btn'])[2]")).click(); driver.findElement(By.name("save")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value=' Done ']")).click();
		//driver.findElement(By.xpath("(//input[@name='save'])[1]")).click();
		driver.findElement(By.name("save")).click(); */
		// driver.findElement(By.xpath("//input[@name='attachFile']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>windows1=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows1.get(1));
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(By.name("file")).sendKeys("C:\\Users\\HK454BY\\OneDrive - EY\\Desktop");
		//Thread.sleep(3000);
		//driver.findElement(By.id("Attach")).click(); Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@title='Done']")).click();
		//System.out.println(driver.findElement(By.id("head_1_ep")).isDisplayed());
		/*if(driver.findElement(By.id("head_1_ep")).isDisplayed()) {
		driver.findElement(By.xpath("//input[@name='cancel']")).click();
		}*/
		driver.switchTo().window(windows1.get(0));
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

}
