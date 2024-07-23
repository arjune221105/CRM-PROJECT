package GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import GenericUtility.BaseClass;
import GenericUtility.JavaFileUlitiy;
import GenericUtility.WebdriverUtility;

public class ListunerImplementation  implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--start--");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--Pass--");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--Fail--");
		WebdriverUtility wutil=new WebdriverUtility();
		JavaFileUlitiy jutil=new JavaFileUlitiy();
		String screenshotname = methodname+"-"+jutil.toGetSystemDateandStringTime();
		try {
			wutil.toTakeScreenShot(BaseClass2.sDriver, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--Skip--");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println(context+"--Suit execution star--");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
		System.out.println(context+"---Finish---");
		
	}
	
	
	
	

}
