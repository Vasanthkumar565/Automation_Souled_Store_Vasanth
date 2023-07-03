package souledstore;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.annotations.Beta;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass_souledstore {

	WebDriver driver;
	
	validate__cartpage page;
	validate__logout logout;
	ExtentReports extent;
	ExtentTest extenttest;
	TakesScreenshot ts;
	File filesrc;
	
	
	String str1 = "https://www.thesouledstore.com/men";
	String str2 = "https://www.thesouledstore.com/product/naruto-akatsuki-pattern-summer-shirts?gte=1";
	String pay = "https://www.thesouledstore.com/product/naruto-akatsuki-pattern-summer-shirts?gte=1";
	

	@BeforeTest
	public void setup() {
		
		extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/souledstorepage.html");
		extent.loadConfig(new File(System.getProperty("user.dir") +"/Thesouledstore/src/test/java/souledstore/extent-config.xml"));
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver = new ChromeDriver(op);
		driver.get(str1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	driver.findElement(By.xpath("(//*[@class='fa fa-close'])")).click();

	}
//	@Test
//	public void test()
//	{
//		paymentpage pg = new paymentpage(driver);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window,scrollBy(0,600)");
//		pg.name1();
//		
//	}

	@Test(enabled = false)//(priority = 0)
	public void login() throws InterruptedException, IOException  
	{
		extenttest = extent.startTest("souledstore");
		
		page = new validate__cartpage(driver);
		extenttest.log(LogStatus.PASS, "Web page of souled store had opend successfully");
		
		
		page.perform__onloginbtn();
	    page.perform__onphonenum("8183014452");
		extenttest.log(LogStatus.PASS, "Phone number is filled");
		
		page.perform__onproceedbtn();
		Thread.sleep(20000);
		page.perform__onotpbtn();
		
	}

	@Test(priority = 1)
	public void Add_to_cart() throws InterruptedException, IOException  
		{
		extenttest = extent.startTest("souledstore");
		page = new validate__cartpage(driver);
		Thread.sleep(2000);
        page.perform__onscroollimage();
        Thread.sleep(3000);
		page.perform__onscrollview();
//		ts = (TakesScreenshot) driver;
//		filesrc = ts.getScreenshotAs(OutputType.FILE);
//		File filedest0 = new File("/Thesouledstore/test-output/screenshot0/loggin.png");
//
//		FileUtils.copyFile(filesrc, filedest0);
//		extenttest.log(LogStatus.PASS,
//		extenttest.addScreenCapture("/Thesouledstore/test-output/screenshot0/loggin.png")
//		+ "User logged in successfully with OTP");
			
		
		Thread.sleep(3000);
		page.perform__onsize();
		extenttest.log(LogStatus.PASS, "User has selected required size");
		page.perform_ondropdown();
		
		page.perform__onquantity();
		extenttest.log(LogStatus.PASS, "User has selected required quantity");
//		
//		Thread.sleep(4000);
//		page.scroll3();
		Thread.sleep(4000);
		page.perform__onproductdetails();
		
		
		page.perform__oncartbtn();
		extenttest.log(LogStatus.PASS, "User has added product to cart");
		
		
		Thread.sleep(3000);
		ts = (TakesScreenshot) driver;
		filesrc = ts.getScreenshotAs(OutputType.FILE);
		File filedest = new File("/Thesouledstore/test-output/screenshot1/addtocart.png");

		FileUtils.copyFile(filesrc, filedest);
		extenttest.log(LogStatus.PASS,
		extenttest.addScreenCapture("/Thesouledstore/test-output/screenshot1/addtocart.png")
		+ "Product added to the cart");
		
		}

		@Test(priority = 2)
		public void moved_to_cart() throws InterruptedException, IOException {

			Thread.sleep(3000);
			page.perform__oncarticon();
			extenttest.log(LogStatus.PASS, "User has navigated to cart page");
			// WebDriverWait wait1 = new WebDriverWait(driver, 4);
			Thread.sleep(3000);
			page.perform__onpopupcartmessage();
			extenttest.log(LogStatus.PASS, "User has handled the popup message");

			page.perform__onproductnameverification();
			extenttest.log(LogStatus.PASS, "User has validate the payment detials");

             
            page.perform__onbillingdetails();
         

			Thread.sleep(3000);
			page.perform__onremovbtn();
			extenttest.log(LogStatus.PASS, "User has remove the product from cartpage");

			Thread.sleep(3000);
			page.perform__oncartpopup();
			extenttest.log(LogStatus.PASS, "User has handled the cartpage Alert");
			
			Thread.sleep(3000);
			ts = (TakesScreenshot) driver;
			filesrc = ts.getScreenshotAs(OutputType.FILE);
			File filedest1 = new File("/Thesouledstore/test-output/screenshot2/productremoved.png");

			FileUtils.copyFile(filesrc, filedest1);
			extenttest.log(LogStatus.PASS,
			extenttest.addScreenCapture("/Thesouledstore/test-output/screenshot2/productremoved.png")
			+ "Product removed from the cart");

			Thread.sleep(3000);
			page.perform__onemptycartmessage();
			extenttest.log(LogStatus.PASS, "User has verified cart message");
		
			page.perform__onemptycartlogo();
			extenttest.log(LogStatus.PASS, "User has verified logo image of cart page");
		}
		 
		@Test(priority = 3)
		public void logout() throws InterruptedException, IOException {

			Thread.sleep(3000);
			page.perform__onwelcomlogo();
			extenttest.log(LogStatus.PASS, "User navigated back to home page");
			
			Thread.sleep(3000);
			ts = (TakesScreenshot) driver;
			filesrc = ts.getScreenshotAs(OutputType.FILE);
			File filedest2 = new File("/Thesouledstore/test-output/screenshot3/removeproduct.png");

			FileUtils.copyFile(filesrc, filedest2);
			extenttest.log(LogStatus.PASS,
			extenttest.addScreenCapture("/Thesouledstore/test-output/screenshot3/removeproduct.png")
			+ "User navigated back to homepage");

//			Thread.sleep(3000);
//			page.perform__onlogoutbtn();
//
//			Thread.sleep(4000);
//			page.perform__ondropdownlogout();
//			Thread.sleep(1000);
//			ts = (TakesScreenshot) driver;
//			filesrc = ts.getScreenshotAs(OutputType.FILE);
//			File filedest3 = new File("/Thesouledstore/test-output/screenshot4/logout.png");
//
//			FileUtils.copyFile(filesrc, filedest3);
//			extenttest.log(LogStatus.PASS,
//			extenttest.addScreenCapture("/Thesouledstore/test-output/screenshot4/logout.png")
//			+ "logout is captured");

		}

		@AfterTest
		public void endtest() {

			driver.close();
			extent.endTest(extenttest);
			extent.flush();
			extent.close();
		}
	}


     /*   payment model
        page.perform__onplaceorder();
        
        performing otp form
      Thread.sleep(3000);
        page.perform__onphonenum("8183014452");
        page.perform__onproceedbtn();
        
        //wait for otp
        Thread.sleep(20000);
        page.perform__onotpbtn();
        
        Thread.sleep(3000);
        page.perform2__onpopupcartmessage();
        
        page.perform__ontotalamount();
        end of cart page
        page.driver.quit();
        
        
        
        logout = new validate__logout(driver);
//        String lastwindow = "";
//        driver.switchTo().window(lastwindow);
        driver.get("https://www.thesouledstore.com/product/naruto-akatsuki-pattern-summer-shirts?gte=1");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
		logout.perform1__onsize();
		logout.perform1_ondropdown();
		logout.perform1__onquantity();
		logout.perform1__oncartbtn();
		logout.perform1__oncarticon();
		Thread.sleep(3000);
		logout.perform1__onpopupcartmessage();
		Thread.sleep(3000);
		logout.perform__onremovbtn();
		Thread.sleep(3000);
		logout.perform__oncartpopup();
		Thread.sleep(3000);
		logout.perform__onemptycartmessage();
		logout.perform__onemptycartlogo();*/
		
		
         

		        
		        
		        
		        
		  