package Selenium_PageFactory.Page_Factory_Frameworks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.Home;
import ObjectRepository.Login;
import Utilities.CrossBrowser;
import Utilities.ExcelData;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	String[]data=new String[5];
	ExtentReports report=new ExtentReports();
	ExtentSparkReporter sparkreport=new ExtentSparkReporter("C:\\Users\\owner\\Workspace\\Shaidul\\Nexxvali\\Page_Factory_Frameworks\\target\\report.html");
	ExtentTest test=report.createTest("Login Application");
    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
    @Test
    public void application() throws IOException
    {
    	report.attachReporter(sparkreport);
    	CrossBrowser br=new CrossBrowser();
    	driver=br.browser_initiate();
    	Home h=new Home(driver);
    	h.signin();
    	test.log(Status.PASS, "welcome to home page");
    	ExcelData d=new ExcelData();
		data=d.readExcel();
		String user=data[0];
		String pass=data[1];
    	Login l=new Login(driver);
    	l.login_credentials(user,pass);
    	test.log(Status.PASS, "valid login");
    	report.flush();
    }
   
}
