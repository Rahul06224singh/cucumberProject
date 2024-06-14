package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Product 
{
public boolean x = false;
	 @Given("i am logged in")
	 public void i_am_logged_in()
	 {
		 if(PasswordTest.login == true)
		 {
			 x = true;
		 }
	 }
	 
	 @When("^i search for product (.*) in range (.*)")
	 public void i_search_for_product_shirt_in_range(String product , int price) 
	 {
		 if(x == true)
		 {
			 Hook.productsearchbox.clear();
			   Hook.productsearchbox.sendKeys(product+" in range "+price);
			   
			   Actions a = new Actions(Hook.driver);
			   a.sendKeys(Keys.ENTER).perform();
			   
		 }
		 {
			   Hook.test.log(Status.FAIL, MarkupHelper.createLabel( "Not Logged in to Search  ..Shirt ", ExtentColor.RED));

		   }

	 } 
	 
	@Then("results must come")
	 public void results_must_come()
	 {
		 Iterator <WebElement> it = Hook.productresult.iterator();
		   Hook.test.log(Status.INFO, MarkupHelper.createLabel( "Searching  ..Shirt ", ExtentColor.BLUE));

		   while(it.hasNext())
		   {
			   WebElement e = it.next();
			   Hook.test.log(Status.PASS, MarkupHelper.createLabel( "Products found .."+e.getText(), ExtentColor.GREEN));

		   }
		   
		  Hook. report.flush();

	 }
	 
}
