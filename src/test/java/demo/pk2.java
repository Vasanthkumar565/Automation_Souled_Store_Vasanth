package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pk2 {

	static WebDriver driver;
    static ChromeOptions co;
    static String url = "https://www.ajio.com/";
    static Actions act;

    
    //*[@id='appContainer']/div[1]/div/header/div[1]/ul/li[1]/span
    //*[text()='Sign In / Join AJIO']
    public static void main(String[] args) throws InterruptedException
    {
         WebDriverManager.chromedriver().setup();
         co=new ChromeOptions();
         co.addArguments("--disable-notifications");
        driver=new ChromeDriver(co);
        driver.get(url);   
        driver.manage().window().maximize();
         act=new Actions(driver);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
         
         driver.findElement(By.xpath("(//*[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded'])[1]")).click();
         
         Set<String> windows= driver.getWindowHandles();
         
         Thread.sleep(3000);
         
         // product details page
            ArrayList<String> va=new ArrayList<String>(windows);
            
            String parentwindow=va.get(0);
            driver.switchTo().window(parentwindow);
            String childwindow=va.get(1);
            driver.switchTo().window(childwindow);
            
          List<WebElement> prodDetails= driver.findElements(By.xpath("//*[@class='prod-list']/li"));
          for(WebElement e:prodDetails)  
          {
              System.out.println(e.getText());
          }
          String productprice= driver.findElement(By.xpath("//*[@class='prod-sp']")).getText();
          System.out.println(productprice);
          
          // save to wishlist
          Thread.sleep(3000);
          List<WebElement> sizelist=driver.findElements(By.xpath("(//*[@class='slick-track'])[3]/div/div/span"));
           System.out.println(sizelist.size()); for(WebElement e:sizelist) 
           {
               if(e.getText().equals("5"))
               {
                   Thread.sleep(2000);
                
                     
           e.click(); break; } }
           
           driver.findElement(By.xpath("//*[@class='btn-gold']")).click();
        

//         List<WebElement> listofMenuBar=driver.findElements(By.xpath("//*[@class='level-first false']/li"));  //*[@class='level-first false']
//         System.out.println(listofMenuBar.size());
//      
//             for(WebElement e:listofMenuBar)
//             {
//                 if(e.getText().equals("MEN"))
//                 {
//                     e.click();
//                     break;
//                 }
//             }
//             System.out.println(driver.getCurrentUrl());
//            Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ajio.com/shop/men"));
             // Logo of page,
//             
//            List<WebElement> listofCrousal=driver.findElements(By.xpath("(//*[@class='indicators'])[1]/div"));
//            int count = listofCrousal.size();
//            System.out.println(count);
//          
//            
//            listofCrousal.get(2).click();
 //        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[19]")).getAttribute("style"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[19]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[29]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[44]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[52]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[62]")).getAttribute("src"));
//            //System.out.println(driver.findElement(By.xpath("((//img[@name='main-banner'])[64]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[126]")).getAttribute("src"));
//            System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[134]")).getAttribute("src"));
           
 }
}
