package core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hook extends Page
{
	
	public void beforeTest(String browser,String url,String reportname) 
	  {
		super.beforeTest(browser, url, reportname);
	  }
	
// login..
	
	@FindBy(xpath = externalxpath.AmazonXPath.signin)
	public static WebElement signin;
	
	@FindBy(xpath = externalxpath.AmazonXPath.uid)
	public static WebElement uid;
	
	@FindBy(xpath = externalxpath.AmazonXPath.ctnbtn)
	public static WebElement ctnbtn;
	
	@FindBy(xpath = externalxpath.AmazonXPath.err1)
	public static WebElement err1;
	
	@FindBy(xpath = externalxpath.AmazonXPath.pwd)
	public static WebElement pwd;
	
	@FindBy(xpath = externalxpath.AmazonXPath.submit)
	public static WebElement submit;
	
	@FindBy(xpath = externalxpath.AmazonXPath.err2)
	public static WebElement err2;
	
	// product search
	@FindBy(xpath = externalxpath.AmazonXPath.productsearchbox)
	public static WebElement productsearchbox;
	
	@FindBy(xpath = externalxpath.AmazonXPath.productresult)
	public static List <WebElement> productresult;
	
	// forget
	@FindBy(xpath = externalxpath.AmazonXPath.needhelp)
	public static WebElement needhelp;
	
	@FindBy(xpath = externalxpath.AmazonXPath.forgetlink)
	public static WebElement forgetlink;
	
	
}
