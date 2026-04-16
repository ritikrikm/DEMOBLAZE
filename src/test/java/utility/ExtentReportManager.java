package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseTest;

public class ExtentReportManager implements ITestListener {
	String repName;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestStart(result);
}
@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSuccess(result);
	test = extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.PASS, result.getName()+"Succ Executed");
}
@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestFailure(result);
	test = extent.createTest(result.getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.FAIL, result.getName()+" FAILED");
	test.log(Status.INFO, result.getThrowable().getMessage());
	
	String imgPath = new BaseTest().captureScreen(result.getName());
	test.addScreenCaptureFromPath(imgPath);
}
@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSkipped(result);
}
@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onStart(context);
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	repName = "Report" + timestamp + ".html";
	extent = new ExtentReports();
	spark = new ExtentSparkReporter("./reports/"+repName);
	extent.attachReporter(spark);
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("Demoblaze Report");
	spark.config().setReportName(repName);
}
@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	ITestListener.super.onFinish(context);
	extent.flush();
}


}
