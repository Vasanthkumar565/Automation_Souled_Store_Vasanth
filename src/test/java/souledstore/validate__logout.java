package souledstore;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class validate__logout {

	WebDriver driver;

	validate__logout(WebDriver dr1) {
		driver = dr1;

	}
	By click1__onsizelist = By.xpath("//*[@class='sizelist']/li");
	By click1__ondropdown = By.xpath("//*[@class='qtyOption']");
    By click1__onquantitysize = By.xpath("//*[@class='qtyOption']/option");
    By click1__oncartbtn = By.xpath("//*[contains(text(),'Add to cart')]");
    By click1__oncarticon = By.xpath("//*[@class='headercart']");
    By click1__onpopupcartmessage = By.xpath("//button[@class='btn btn-primary btn-block btn-no-full-price pointer']");
    
    By click__onremovebtn = By.xpath("(//*[contains(text(),'Remove')])[1]");
    By click__onemptycartmessgae = By.xpath("(//*[@class='emptyCartTitle'])");
    By click__onemptycartlogo = By.xpath("(//*[@class='gm-added gm-observing gm-observing-cb'])");
    By click__onemptycartpopup = By.xpath("(//*[@class='move'])");
	

	
	
    public void perform1__onsize() {
		
		
   	 List<WebElement> wb=driver.findElements(click1__onsizelist);
   	 int count=wb.size();
   	 System.out.println("Total number size are :" + count);
   	 wb.get(2).click();
   	 
   		
   	}
   	
   	// to click on the dropdown
   	public void perform1_ondropdown() {
   		
   		driver.findElement(click1__ondropdown).click();
   	}
   	public void perform1__onquantity() {
//   		 WebElement qa = driver.findElement(quantitysize);
//   		 Select sl = new Select(qa);
//   		 sl.selectByIndex(3);
   		List<WebElement> wb1=driver.findElements(click1__onquantitysize);
   		 int count1=wb1.size();
   		 System.out.println("Total number size are :" + count1);
   		 wb1.get(2).click();
   		
   	}
   	
   	//to click on the quantity
   	public void perform1__oncartbtn() {
   		driver.findElement(click1__oncartbtn).click();
   		
   	}
   	// moving to bagcartpage
   	public void perform1__oncarticon() {
   		
   		driver.findElement(click1__oncarticon).click();
   		
   	}
   	
   	//popupmeassage handle
   	public void perform1__onpopupcartmessage() {
   				
             driver.findElement(click1__onpopupcartmessage).click();
             Alert comfoemationalert = driver.switchTo().alert();
             comfoemationalert.accept();
           }
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
	

    

}
   


