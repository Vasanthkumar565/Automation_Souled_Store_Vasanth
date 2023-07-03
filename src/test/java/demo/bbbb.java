package demo;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.asn1.x509.V1TBSCertificateGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import souledstore.validate__cartpage;
import souledstore.validate__logout;

public class bbbb {
WebDriver driver;
	
	
v v1;
	String str2 = "https://www.thesouledstore.com/men";
	

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver = new ChromeDriver(op);
		driver.get(str2);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(enabled = true)
	public void Addcart() throws InterruptedException {
		
		v1 = new v(driver);
		v1.test0();
		v1.perform__onphonenum("8183014452");
		v1.perform__onproceedbtn();
		Thread.sleep(20000);
		v1.perform__onotpbtn();
		
		v1.test01();
		Thread.sleep(4000);
		v1.test1();
		Thread.sleep(4000);
		v1.test2();
		
	
		Thread.sleep(4000);

		v1.test02();
	}

}
