package testcases;



import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UseridTest extends Hook
{
	
	public static boolean flag = false;
	
	@Given("I open browser {string} with url {string} and initialize report {string}")
	public void i_open_browser_with_url_and_initialize_report(String browser, String url, String reportname) 
	{
		beforeTest(browser,url,reportname);
		 test =report.createTest("userid test");
	}
	@Given("i click signin")
	public void i_click_signin() 
	{
	   signin.click();
	}
	@When("i enter valid userid {string}")
	public void i_enter_valid_userid(String mob) 
	{
	   uid.sendKeys(mob);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I validate the userid is valid")
	public void i_validate_the_userid_is_valid() 
	{
		  try {
				 test.log(Status.FAIL, MarkupHelper.createLabel( err1.getText(), ExtentColor.RED));

				 // Assert.fail("Uid is Valid but error message coming..");
				     }
				     catch(Exception e)
				     {
				    	 test.log(Status.PASS, MarkupHelper.createLabel( "user id is valid..", ExtentColor.GREEN));
                         flag = true;
				     }

	}
	
	

}
