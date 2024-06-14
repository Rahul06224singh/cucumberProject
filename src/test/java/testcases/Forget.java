package testcases;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forget extends Hook
{

	@Given("browser {string} with url {string} is open and report name {string}")
	public void browser_with_url_is_open_and_report_name(String browser, String url, String reportname) 
	{
		beforeTest(browser,url,reportname);
		 test =report.createTest("forget test");
	}
	@Given("click on signin link")
	public void click_on_signin_link() 
	{
	    signin.click();
	}
	@Given("click on help link")
	public void click_on_help_link() 
	{
	    needhelp.click();
	}
	@Given("click on forget pwd link")
	public void click_on_forget_pwd_link() 
	{
	   forgetlink.click();
	}
	@When("enter userid {string} to recover pwd")
	public void enter_userid_to_recover_pwd(String mob) 
	{
	    uid.sendKeys(mob);
	}
	@When("enter click button")
	public void enter_click_button() 
	{
	    ctnbtn.click();
	}
	@Then("message should get")
	public void message_should_get() 
	{
	    System.out.println("done");
	    report.flush();
	}



}
