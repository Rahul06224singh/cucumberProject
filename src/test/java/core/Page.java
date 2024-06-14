package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Page 
{
	public static WebDriver driver = null;
	
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
  
 
  public void beforeTest(String browser,String url,String reportname) 
  {
	  		  
		  // report initialize....
		  String reportpath = System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html";
			report = new ExtentReports();
			spark = new ExtentSparkReporter(reportpath );
			report.attachReporter(spark);
			spark.config().setDocumentTitle(reportname);
	        // Name of the report
	        spark.config().setReportName(reportname);
	        // Dark Theme
	        spark.config().setTheme(Theme.STANDARD);
	          test =report.createTest("Report");
		  
		  // browser open.............
		  
		  if(browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			
			driver.navigate().to(url); // recommend -> can go back/forward/refresh
			
			PageFactory.initElements(driver, this); // for external xpath..
			
			// report log
			
			test.log(Status.PASS, MarkupHelper.createLabel( "Browser "+browser+" url "+url +" opens..", ExtentColor.GREEN));

			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.manage().window().maximize();

	  }
  

  
  public void afterTest() 
  {
	  report.flush();
	  driver.quit();
  }

}
