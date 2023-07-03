package souledstore;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.mongodb.assertions.Assertions;

public class validate__cartpage {
	
	
	WebDriver driver;
	

	validate__cartpage(WebDriver dr) {
		driver = dr;

	}
	
	
	//followed locators for cart page
	//login with otp
	By click__onloginbtn = By.xpath("(//*[@class='hicon fa fa-user-o'])");
	By click__onphonenum = By.xpath("//input[@class='form-control login-input-field']");
	By click__onproceedbtn = By.xpath("//*[@type='submit']");
	By click__onotpbtn = By.xpath("//button[contains(text(),'LOG IN')]");
	
	 // scrolling to cart page
	By click1__onscrollimage= By.xpath("//img[@title='artists/naruto-merchandise']");
    By click2__ondviewscroll = By.xpath("(//*[@class='listhoverimg'])[1]");
    
	//cartpage function to add
	By click__onsizelist = By.xpath("//*[@class='sizelist']/li");
	By click__ondropdown = By.xpath("//*[@class='qtyOption']");
    By click__onquantitysize = By.xpath("//*[@class='qtyOption']/option");
    By click__oncartbtn = By.xpath("//*[contains(text(),'Add to cart')]");
    
    // cartpage to handle popup message
    By click__oncarticon = By.xpath("//*[@class='headercart']");
    By click__onpopupcartmessage = By.xpath("(//*[contains(text(),'No, I want to continue shopping at full prices')])");
	By click__onproductnameverification = By.xpath("//*[text()='Naruto: Akatsuki Pattern']");
	By click__ontotalamount = By.xpath("//*[@class='gm-added gm-loaded gm-observing gm-observing-cb']");
	 
	// remove the product from cart
    By click__onremovebtn = By.xpath("(//*[contains(text(),'Remove')])[1]");
	By click__onemptycartpopup = By.xpath("(//*[@class='move'])");
	By click__onemptycartmessgae = By.xpath("(//*[@class='emptyCartTitle'])");
	
	// wave back to homepage by logo od souled store
	By click__onemptycartlogo = By.xpath("(//*[@class='gm-added gm-observing gm-observing-cb'])");
	By click__onwelcomelogo = By.xpath("//*[@class='pointer navbar-brand closeeys']");
	
	// logout from login
	By click__onlogoutbtn = By.xpath("(//span[@class='hicon fa fa-user-o'])");
	By click__ondropdownlogoutbtn=By.xpath("(//*[@class='dropdown-menu right'])/a");
	
	
	//followed locators for login to reach the payment form
	//(//*[@class='dropdown-menu right'])/a[8] dropdown
//	By click__onphonenum = By.xpath("//input[@class='form-control login-input-field']");
//	By click__onproceedbtn = By.xpath("//*[@type='submit']");
//	
//	By click__onotpbtn = By.xpath("//button[contains(text(),'LOG IN')]");
	//requested for popup message
	//By click2__onpopupcartmessage = By.xpath("//button[@class='btn btn-primary btn-block btn-no-full-price pointer']");
	
	
	
	//By click__onplaceorder = By.xpath("(//*[@class='fbold']/span)[4]");
	//followed locators for the logout page
	
	
	
	public void perform__onloginbtn() {
		driver.findElement(click__onloginbtn).click();
		
	}
	
	public void perform__onphonenum(String number) {
		   driver.findElement(click__onphonenum).sendKeys(number);
			
		}
	public void perform__onproceedbtn(){
		   driver.findElement(click__onproceedbtn).click();
			
		}
	
	//wait for otp
	public void perform__onotpbtn() {
		   driver.findElement(click__onotpbtn).click();
			
		}
	 public void scroll1(){
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window,scrollBy(0,400)");
	 }
	
	public void perform__onscroollimage() {
		
		
		driver.findElement(click1__onscrollimage).click();
		
	}
	
	 public void scroll2(){
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window,scrollBy(0,600)");
	 }
   public void perform__onscrollview() {
		
		
		driver.findElement(click2__ondviewscroll).click();
		
	}
	// to get the size and select
	
	public void perform__onsize() {
		
		
	 List<WebElement> wb=driver.findElements(click__onsizelist);
	 int count=wb.size();
	 System.out.println("Total number size are :" + count);
	 wb.get(1).click();
	 
		
	}
	
	// to click on the dropdown
	public void perform_ondropdown() {
		
		driver.findElement(click__ondropdown).click();
	}
	public void perform__onquantity() {
//		 WebElement qa = driver.findElement(quantitysize);
//		 Select sl = new Select(qa);
//		 sl.selectByIndex(3);
		List<WebElement> wb1=driver.findElements(click__onquantitysize);
		 int count1=wb1.size();
		 System.out.println("Total number size are :" + count1);
		 wb1.get(2).click();
		
	}
	
       public void scroll3() {
		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window,scrollBy(0,400)");
	}
       public void perform__onproductdetails() {
		
	//	driver.findElement(click__ontotalamount).click();
    	   JavascriptExecutor js = (JavascriptExecutor)driver;
           System.out.println(js.executeScript("return document.getElementsByClassName('card-block')[0].innerText"));
		
		}
	
	//to click on the quantity
	public void perform__oncartbtn() {
		driver.findElement(click__oncartbtn).click();
		
	}
      
	// moving to bagcartpage
	public void perform__oncarticon() {
		
		driver.findElement(click__oncarticon).click();
		
	}
	
	//popupmeassage handle
	public void perform__onpopupcartmessage() {
				
          driver.findElement(click__onpopupcartmessage).click();
        }
	
	// campare the product in before adding and after adding
	public void perform__onproductnameverification() {
		
		WebElement productNameElement1 = driver.findElement(By.xpath("//*[text()='Naruto: Akatsuki Pattern']"));
		WebElement productNameElement2 = driver.findElement(click__onproductnameverification);
		String productName1 = productNameElement1.getText();
		System.out.println("Product name BEFORE adding to cart is:" + productName1);
        String productName2 = productNameElement2.getText();
        System.out.println("Product name AFTER adding to cart is :" + productName2);
       
        
        

        // Compare the product names using assertion
        Assert.assertEquals(productName1, productName2,"Product name is not same");
	}
     public void perform__onbillingdetails() {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
         System.out.println(js.executeScript("return document.getElementsByClassName('sidebox')[0].innerText"));
		
	} //  document.getElementsByClassName('sidebox')[0].innerText
	
	
       public void perform__onremovbtn() {
			
           WebElement wb= driver.findElement(click__onremovebtn);
           wb.click();
          }
    	
    	public void perform__oncartpopup() {
    		
    	       WebElement wb= driver.findElement(click__onemptycartpopup);
    	       wb.click();
    	      }
    	public void perform__onemptycartmessage() {
    		
    		
    	   	
    		 WebElement emptyCartMessage = driver.findElement(click__onemptycartmessgae);

    	     String expectedMessage = "Your shopping cart is empty.";
    	     String actualMessage = emptyCartMessage.getText();
    	     
    	     if (actualMessage.equals(expectedMessage)) {
    	         System.out.println("Empty cart message is displayed correctly.");
    	     } else {
    	         System.out.println("Empty cart message is not displayed correctly.");
    	     }
    		}

			public void perform__onemptycartlogo() {

				WebElement logo = driver.findElement(click__onemptycartlogo);

				// Verify the logo is displayed
				if (logo.isDisplayed()) {
					System.out.println("Logo is displayed.");
				} else {
					System.out.println("Logo is not displayed.");
				}

			}
			
		public void perform__onwelcomlogo() {
			driver.findElement(click__onwelcomelogo).click();
			System.out.println("User have navigated back to homepage");
			
		}	
		
		public void perform__onlogoutbtn() {
			driver.findElement(click__onlogoutbtn).click();
			
		}
			
		public void perform__ondropdownlogout() {
			 //  driver.findElement(click__ondropdownlogoutbtn).click();
			   List<WebElement> wb1=driver.findElements(click__ondropdownlogoutbtn);
				 int count1=wb1.size();
				 System.out.println("Total number size are :" + count1);
				 wb1.get(7).click();
			   Assert.assertTrue(driver.getCurrentUrl().contains("https://www.thesouledstore.com/submit-art-work"));
			   System.out.println("User has logout successfully");
				
			}
}		
	



	/*check the totalamount
	public void perform__onplaceorder() {
	   driver.findElement(click__onplaceorder).click();
	   
		
	}
	
     //if requested to handlepopup
	public void perform2__onpopupcartmessage() {
		
        driver.findElement(click2__onpopupcartmessage).click();
      }
	
	vertify the total amount
	
	//end for cartpage
	
	
}*/


