package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Page;

public class ScreenShot extends Page
{

	public static void takescreenshot(String scrname) throws Exception // define
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File tmp = ts.getScreenshotAs(OutputType.FILE);
		String scrshotpath = System.getProperty("user.dir")+"//src//test//java//screenshot//"+scrname+".jpg";
	
	FileUtils.copyFile(tmp, new File(scrshotpath));
	
	test.log(Status.INFO, MarkupHelper.createLabel( "Screenshot taken..", ExtentColor.BLUE));

	}
}
