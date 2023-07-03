package souledstore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paymentpage {
	
	WebDriver driver;

	paymentpage(WebDriver dr2) 
	{
		driver = dr2;

	}
	
	public void name1() {
		
//		List<WebElement> productElements = driver.findElements(By.xpath("//div//b//br"));
//		//(//*[@class='card-block'])/p/div/div[1]/div/div/div/div/div/div/div/b
//         int count = productElements.size();
//         System.out.println(count);
         
//         for (WebElement brElement : productElements) {
//        	    WebElement parentDiv = brElement.findElement(By.xpath("./parent::div[1]"));
//        	    String text = parentDiv.getText();
//        	    System.out.println(text);
//        	}
         
//         for (WebElement brElement : productElements) {
//        	    String text = brElement.getAttribute("innerHTML");
//        	    System.out.println(text);
//        	}
		
		
         JavascriptExecutor js = (JavascriptExecutor)driver;
         System.out.println(js.executeScript("return document.getElementsByClassName('card-block')[0].innerText"));
         
//         List<WebElement> brElements = driver.findElements(By.xpath("//div//b//br"));
//
//         for (WebElement brElement : brElements) {
//             WebElement parentElement = brElement.findElement(By.xpath("//div//br")); // Get the parent element of <br>
//             String innerHTML = parentElement.getAttribute("innerHTML");
//             System.out.println(innerHTML);
//         }
//        
  //       System.out.println("ww");
//        WebElement dr = driver.findElement(By.xpath("//*[contains(text(),'100% Rayon')]"));
//        String productName = productElements.getText();
//        System.out.println("Product: " + productName);
//        String productName1 = productElements.getText();
//        System.out.println("Product: " + productName1);

           
           

           

           
            
           
        }
		
	}
	


