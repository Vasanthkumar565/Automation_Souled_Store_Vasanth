package demo;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pk1 {
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
        //Login valid credentials
//    WebElement signin=    driver.findElement(By.xpath("//*[text()='Sign In / Join AJIO']"));
//        act.click(signin).build().perform();
//    driver.findElement(By.name("username")).sendKeys("8801263346");
//        driver.findElement(By.className("login-btn")).click();
//        Thread.sleep(20000);
//        System.out.println(driver.findElement(By.xpath("//*[@class='ignore-sentence-case']")).getText());
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='ignore-sentence-case']")).getText(),"kishan");
//        driver.findElement(By.xpath("//*[@href='/']/img")).click();
        
     // menu bar-collecting in a list
        Thread.sleep(5000);

    List<WebElement> listofMenuBar=driver.findElements(By.xpath("//*[@class='level-first false']/li"));  //*[@class='level-first false']
    System.out.println(listofMenuBar.size());
        for(WebElement e:listofMenuBar)
        {
            if(e.getText().equals("MEN"))
            {
                e.click();
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ajio.com/shop/men"));
        // Logo of page
        Thread.sleep(5000);
        /*
         * driver.findElement(By.xpath("//*[@href='/']/img")).click();
         * Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ajio.com/"));
         * Thread.sleep(5000);
         */
     // coursole check- sponsered brand
        
        List<WebElement> listofCrousal=driver.findElements(By.xpath("(//*[@class='indicators'])[1]/div"));
        System.out.println(listofCrousal.size());
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        for(WebElement e:listofCrousal)
        {
            if(e.getText().equals("2"))
            {
                act.moveToElement(e).click().build().perform();
                //e.click();
                break;
            }
        }
        Thread.sleep(3000);
        
     // Collection of sections - 6
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[19]")).getAttribute("style"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[29]")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[44]")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[52]")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[62]")).getAttribute("src"));
        //System.out.println(driver.findElement(By.xpath("((//img[@name='main-banner'])[64]")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[126]")).getAttribute("src"));
        System.out.println(driver.findElement(By.xpath("(//img[@name='main-banner'])[134]")).getAttribute("src"));

        Thread.sleep(3000);
        
        // discount
        /*
         * driver.findElement(By.xpath(
         * "(//*[@data-gtm-bnr-id='8ae9c855-c96c-4f52-8062-db4acc31d85f'])[2]")).click()
         * ; String discountHeader=
         * driver.findElement(By.xpath("//*[@class='header2']")).getText();
         * Assert.assertEquals(discountHeader,"Up To 50 Percent Off");
         * Thread.sleep(3000);
         */
        
     // Search 
        driver.findElement(By.name("searchVal")).sendKeys("Shoes");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
         Thread.sleep(3000);

        driver.findElement(By.cssSelector("label[for='Men']")).click();
        String menFilter=driver.findElement(By.xpath("//*[@class='fnl-plp-afliter']/span")).getText(); 
        
         Assert.assertEquals(menFilter,"Men");
         
       //click on product
         Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded'])[1]")).click();
      
        Set<String> windows= driver.getWindowHandles();
      
             /*
              * Iterator<String> win= windows.iterator();
              * 
              * while(win.hasNext()) { String parentwindow=win.next();
              * driver.switchTo().window(parentwindow); String childwindow=win.next();
              * driver.switchTo().window(childwindow); }
              */
           
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
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@href='/wishlist']")).click(); 
        String wishlistproductcheck=driver.findElement(By.xpath("//*[@class='nameCls']")). getText();
        Assert.assertEquals(wishlistproductcheck, "Unisex Literide Clog");
        
// add to cart
        
        List<WebElement> sizelist1=driver.findElements(By.xpath("(//*[@class='slick-track'])[3]/div/div/span"));
        System.out.println(sizelist1.size());
        for(WebElement e:sizelist1)
        {
            if(e.getText().equals("6"))
            {
                  Thread.sleep(2000);

                e.click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@class='btn-gold']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@class='ic-cart ']")).click();
        Thread.sleep(3000);
        
        /*
         * Actions act=new Actions(driver);
         * act.moveToElement(driver.findElement(By.xpath("//div[@class='ic-cart']"))).
         * build().perform();
         * //driver.findElement(By.xpath("//*[@class='ic-cart ']")).click();
         * Thread.sleep(2000);
         */
        
         //  driver.findElement(By.xpath("//*[@class='mini-cart-btn']")).click();
        
        Thread.sleep(3000);
        
        List<WebElement> orderDetails=driver.findElements(By.xpath("//*[@class='order-summary-container']//section/span"));
        System.out.println(orderDetails.size());
        for(WebElement e: orderDetails)
        {
          System.out.println(e.getText());
        }
        Thread.sleep(3000);
        // delete a product
        driver.findElement(By.xpath("//*[@class='delete-btn']")).click();
        driver.findElement(By.xpath("(//*[@class='delete-btn'])[2]")).click();
        Thread.sleep(2000);
        String errorMesg=driver.findElement(By.xpath("//*[@class='empty-msg']")).getText();
        
        Assert.assertEquals(errorMesg,"Your Shopping Bag is Empty!!");
        driver.findElement(By.xpath("//*[@href='/']/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'Sign Out')]")).click();

            
            
       
       
    
    }
}


