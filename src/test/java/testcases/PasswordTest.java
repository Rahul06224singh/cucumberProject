package testcases;



import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordTest 
{
	public boolean uid = false;
	public static boolean login = false;
	
	@Given("userid is valid")
	public void userid_is_valid() 
	{
	    if(UseridTest.flag == true)
	    {
	    	System.out.println("uid is valid");
	    	uid = true;
	    }
	}
	@When("i enter a valid password {string}")
	public void i_enter_a_valid_password(String passwd) 
	{
		  if(uid == true)
		  {
	    Hook.pwd.sendKeys(passwd);
	    Hook.submit.click();
		  }
	}
	@Then("i should login")
	public void i_should_login() throws Exception 
	{
		try {
			 Hook.test.log(Status.FAIL, MarkupHelper.createLabel( Hook.err2.getText(), ExtentColor.RED));

			  //Assert.fail("Pwdd is Valid but error message coming..");
			     }
			     catch(Exception e)
			     {
			    	 Hook.test.log(Status.PASS, MarkupHelper.createLabel( "password id is valid..", ExtentColor.GREEN));

			    	 utility.ScreenShot.takescreenshot("LoginSucsess");
			    	 
			    	 login = true;
			     }
	}

}
