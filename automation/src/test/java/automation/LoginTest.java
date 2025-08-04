package automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	

		    @Test
		    public void loginWith_ValidCredentials() {
		    	System.out.println(driver);
		    	 driver.get("https://demowebshop.tricentis.com");
		        driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
		        driver.findElement(By.id("Email")).sendKeys("princegupta88746@gmail.com");
		        driver.findElement(By.id("Password")).sendKeys("12345678");
		        driver.findElement(By.cssSelector("input.button-1.login-button")).click();
		
		        // Assertion
		        String account = driver.findElement(By.className("account")).getText();
		        assert account.contains("princegupta88746@gmail.com");
		    }
		    
    @Test
    public void loginWith_ValidEmail_WrongPassCredentials() {
   	 driver.get("https://demowebshop.tricentis.com");
       driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
       driver.findElement(By.id("Email")).sendKeys("princegupta88746@gmail.com");
       driver.findElement(By.id("Password")).sendKeys("12345679");
       driver.findElement(By.cssSelector("input.button-1.login-button")).click();

       // Assertion
       String errorEle = driver.findElement(By.className("validation-summary-errors")).getText();
       System.out.println("Actual :"+errorEle);
       System.out.println("Expected :Login was unsuccessful. Please correct the errors and try again. The credentials provided are incorrect");

      assert errorEle.contains("Login was unsuccessful. Please correct the errors and try again.");
      assert errorEle.contains("The credentials provided are incorrect");
   }
		    @Test
		    public void loginWith_UnregisteredEmail_ValidPassCredentials() {
		   	 driver.get("https://demowebshop.tricentis.com");
		       driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
		       driver.findElement(By.id("Email")).sendKeys("princegupta86@gmail.com");
		       driver.findElement(By.id("Password")).sendKeys("12345678");
		       driver.findElement(By.cssSelector("input.button-1.login-button")).click();
		
		       // Assertion
		       String errorEle = driver.findElement(By.className("validation-summary-errors")).getText();
		       System.out.println("Actual :"+errorEle);
		         System.out.println("Expected :Login was unsuccessful. Please correct the errors and try again. No customer account found");
		      assert errorEle.contains("Login was unsuccessful. Please correct the errors and try again.");
		      assert errorEle.contains("No customer account found");
		   }
    
    @Test
    public void loginWith_WrongEmail_ValidPassCredentials() {
   	 driver.get("https://demowebshop.tricentis.com");
       driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
       driver.findElement(By.id("Email")).sendKeys("princegupta86gmail.com");
       driver.findElement(By.id("Password")).sendKeys("12345678");
       driver.findElement(By.cssSelector("input.button-1.login-button")).click();

       // Assertion
       String errorEle = driver.findElement(By.className("field-validation-error")).getText();
       System.out.println("Actual :"+errorEle);
       System.out.println("Expected :Please enter a valid email address.");
      assert errorEle.contains("Please enter a valid email address.");
      
   }
    
		    @Test
		    public void loginWith_BlankCredentials() {
		      	 driver.get("https://demowebshop.tricentis.com");
		          driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
		          driver.findElement(By.id("Email")).sendKeys("");
		          driver.findElement(By.id("Password")).sendKeys("");
		          driver.findElement(By.cssSelector("input.button-1.login-button")).click();
		
		          // Assertion
		          
		         String errorEle = driver.findElement(By.className("validation-summary-errors")).getText();
		         System.out.println("Actual :"+errorEle);
		         System.out.println("Expected :Email and Password is required");
		         
		        assert errorEle.contains("Email and Password is required");
		        
		      }
		    
		    
    @Test
    public void loginWith_OnlyEmail_BlankPass_Credentials() {
    	 driver.get("https://demowebshop.tricentis.com");
         driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
         driver.findElement(By.id("Email")).sendKeys("princegupta88746@gmail.com");
         driver.findElement(By.id("Password")).sendKeys("");
         driver.findElement(By.cssSelector("input.button-1.login-button")).click();
          // Assertion
         String errorEle = driver.findElement(By.className("validation-summary-errors")).getText();
         System.out.println("Actual :"+errorEle);
         System.out.println("Expected :Password is required");
         
         assert errorEle.contains("Password is required");
      }
    
			    @Test
			    public void loginWith_BlankEmail_OnlyPass_Credentials() {
			    	 driver.get("https://demowebshop.tricentis.com");
			         driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
			         driver.findElement(By.id("Email")).sendKeys("");
			         driver.findElement(By.id("Password")).sendKeys("12345678");
			         driver.findElement(By.cssSelector("input.button-1.login-button")).click();
			          // Assertion
			         String errorEle = driver.findElement(By.className("validation-summary-errors")).getText();
			         System.out.println("Actual :"+errorEle);
			         System.out.println("Expected :Email is required");
			         
			         assert errorEle.contains("Email is required");
			      }
			    
    @Test
    public void loginWith_SQL_InjectionInEmail_ValidPass_Credentials() {
    	 driver.get("https://demowebshop.tricentis.com");
         driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a")).click();
         driver.findElement(By.id("Email")).sendKeys("' OR 1=1 --");
         driver.findElement(By.id("Password")).sendKeys("12345678");
         driver.findElement(By.cssSelector("input.button-1.login-button")).click();

       
          // Assertion
          
         String errorEle = driver.findElement(By.className("field-validation-error")).getText();
         System.out.println("Actual :"+errorEle);
         System.out.println("Expected :Please enter a valid email address.");
         
           
        assert errorEle.contains("Please enter a valid email address.");
      }
    
    
    
		    
		    
    
    
    
    
}
