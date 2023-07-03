package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class v {

	WebDriver driver;

	v(WebDriver dr1) {
		driver = dr1;

	}

	By loginbtn = By.xpath("(//*[@class='hicon fa fa-user-o'])");

	

	// followed locators for login to reach the payment form

	By click__onphonenum = By.xpath("//input[@class='form-control login-input-field']");
	By click__onproceedbtn = By.xpath("//*[@type='submit']");
	By click__onotpbtn = By.xpath("//button[contains(text(),'LOG IN')]");

	By click1__onsizelist = By.xpath("//img[@title='artists/naruto-merchandise']");

	By click1__ondropdown = By.xpath("(//*[@class='listhoverimg'])[1]");
//    By click1__onquantitysize = By.xpath("//*[@class='qtyOption']/option");
//    By click1__oncartbtn = By.xpath("//*[contains(text(),'Add to cart')]");
//    By click1__oncarticon = By.xpath("//*[@class='headercart']");

	public void test0() {

		driver.findElement(loginbtn).click();

	}

	public void perform__onphonenum(String number) {
		driver.findElement(click__onphonenum).sendKeys(number);

	}

	public void perform__onproceedbtn() {
		driver.findElement(click__onproceedbtn).click();

	}

//wait for otp
	public void perform__onotpbtn() {
		driver.findElement(click__onotpbtn).click();

	}

	public void test01() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window,scrollBy(0,600)");
	}
	
		public void test1()  {
	
		driver.findElement(click1__onsizelist).click();
		
		

	}

	public void test2() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window,scrollBy(0,1000)");
	}
		public void test02() {
		
		driver.findElement(click1__ondropdown).click();

	}
}
