package tests;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//It will be listening to all the test case which are running
//We need to make some connection between test case and listener 

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Base;

public class TestListner extends Base implements ITestListener {
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestStart(result);
		 test = reports.startTest(result.getMethod().getMethodName());
	System.out.println("*******Starting the test*******"+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		test.log(LogStatus.PASS, "Title is displayed successfully");
		System.out.println("*******Test case is passed*******"+result.getMethod().getMethodName());
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailure(result);
		WebDriver driver=null;
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loc=captureScreenShot(driver);
		test.log(LogStatus.FAIL,test.addScreenCapture(loc) ,"There is some exception occur");
		test.log(LogStatus.FAIL,result.getThrowable());
		System.out.println("*******Test case is failed*******"+result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("*******Test case is skip*******"+result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
		reports = new ExtentReports("C:\\Users\\LENOVO\\eclipse-workspace\\end2end\\reports"+"\\ExtentReportResults.html");
		
	
		
		reports.loadConfig(new File("C:\\Users\\LENOVO\\eclipse-workspace\\end2end\\config-report.xml"));
		
		
		System.out.println("*******Test case suite is started******");
	
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onFinish(context);
		System.out.println("*******Test case suite is completed******");
		reports.endTest(test); 
		reports.flush(); 
	}
}
