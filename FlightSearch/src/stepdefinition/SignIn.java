package stepdefinition;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn {
	WebDriver driver;
	WebElement element;
	@Given("^User is on Sign In page$")
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","C:/chrome/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Jabatalks", title);
		System.out.println("Assersion Pass");
		}
	
	@When("^user clicks on Language drop down")
	public void clickLanguageDropDown(){
		element=driver.findElement(By.id("language"));
		if(element.isDisplayed()){
			System.out.println("Language Drop Down displayed");
			element.click();
		
		}
		else{
			driver.quit();
		}
	}
   
   @Then("^user should be dispalyed with English and Dutch$")
   public void languagesDisplayed(){	 
	List<WebElement> li= driver.findElements(By.xpath("//div[@class='ng-binding ng-scope']"));
	 int LanguageCount =li.size();
	 System.out.println(LanguageCount);
	 for(int i=0; i<LanguageCount;i++){
		 if(li.get(i).getText().equals("English")){
		  System.out.println("Englih is there in drop down");
		 }
		 else if(li.get(i).getText().equals("Dutch")){
			 System.out.println("Dutch is there in drop down");
		 }
		
	 }
   }
 @And("^user enters \"(.*)\" and \"(.*)\"$")
   public void enterUserNameAndPassword(String username, String organization){
	   driver.findElement(By.id("name")).sendKeys(username);
	   driver.findElement(By.id("orgName")).sendKeys(organization);
	 
	  	  
   }
   @Then("^user input \"(.*)\"$")
   public void enterEmailAddress(String emailAddress){
	   
	  driver.findElement(By.id("singUpEmail")).sendKeys(emailAddress);
	  	  
   }
   @Then("user clicks on terms and conditions checkbox$")
   public void termsAndConditions(){
	 WebElement checkbox=driver.findElement(By.xpath("//span[@class='black-color ng-binding']"));
	
	 checkbox.click();
   }
   @And("^user clicks on sign up button$")
   public void SignUp(){
	   element =driver.findElement(By.xpath("//*[contains(text(),'Get Started')]"));
	   boolean Submit =element.isEnabled();
	   Assert.assertEquals(Submit, true);
		 element.click(); 
   }
   @Then("user will login with \"(.*)\" and \"(.*)\" to check email received$")
   public void emailValidation(String emailAddress, String password){
	  
	   WebDriverWait wait=new WebDriverWait(driver, 20);
	   WebElement message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-custom']")));
	   System.out.println(message1.getText()); 	
	   driver.navigate().to("http://gmail.com");
	   driver.findElement(By.id("identifierId")).sendKeys(emailAddress);
	   driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
	   driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	   driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	 
	   List<WebElement> email= driver.findElements(By.xpath("//tr[@class='zA zE']"));
		 int EmailCount =email.size();
		 for(int i=0; i<EmailCount;i++){
			 if(email.get(i).getText().contains("JabaTalks")){
			  System.out.println("Email Received");
			 }
			 else {
				 System.out.println("Not Received");
			 }
	   
	   driver.quit();
   }
   
   }
}
