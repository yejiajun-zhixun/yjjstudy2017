package study;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class KeyCode {
	private AndroidDriver<AndroidElement> driver;
	private Wait wait;
	
	@Before
	public void setUp() throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");//启动移动设备
		capabilities.setCapability("platformVersion", "4.4");
		//以下配置为链接真机
		capabilities.setCapability("automationName", "huawei-kiw_ul00-XGC4C16520003965");//华为荣耀		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.xiaorong.lightning");
		capabilities.setCapability("appActivity", "com.xiaorong.lightning.ui.activity.WelcomeActivity");
	    capabilities.setCapability("automationName","uiautomator2");//调用uiautomator2,获取toast 
	    capabilities.setCapability("unicodeKeyboard", true);      
	    capabilities.setCapability("resetKeyboard", true);  
	    capabilities.setCapability("noReset", true);  
	    capabilities.setCapability("noSign", true);  
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
        System.out.println("The Test is starts!~~");
		wait = new Wait(driver);
		
	}
	
	@After
	public void tearDown() throws Exception{
        System.out.println("The Test is finish!~~");
//		driver.quit();
	}
	
	@Test
	public void keyCode(){
		//进入引导页，滑动，进入首页
				wait.waitFor(8000);
				driver.swipe(1000, 1442, 10, 1442, 1500); //坐标（1000,1442）左滑到（10,1442），滑动1500
				wait.waitFor(1500);
				driver.swipe(1000, 1442, 10, 1442, 1500);
				wait.waitFor(1500);
				WebElement start=driver.findElement(By.id("com.xiaorong.lightning:id/iv_start"));
				start.click();
				wait.waitFor(1500);
				
				WebElement permissionallow=driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
				permissionallow.click();
				wait.waitFor(1500);
				permissionallow.click();
				wait.waitFor(1500);
				permissionallow.click();
				wait.waitFor(1500);
				permissionallow.click();
				wait.waitFor(1500);
				permissionallow.click();
				wait.waitFor(1500);
		        System.out.println("初始化 成功!~~");
	        
				//登陆
				WebElement jieqian =driver.findElement(By.id("com.xiaorong.lightning:id/ly_jieqian"));
				jieqian.click();
				wait.waitFor(1500);
				WebElement etname=driver.findElement(By.id("com.xiaorong.lightning:id/et_name"));
//				etname.sendKeys("15990027607");
				etname.click();
				driver.sendKeyEvent(8);//1
				driver.sendKeyEvent(12);//5
				driver.sendKeyEvent(16);//9
				driver.sendKeyEvent(16);//9
				driver.sendKeyEvent(7);//0
				driver.sendKeyEvent(7);//0
				driver.sendKeyEvent(9);//2
				driver.sendKeyEvent(14);//7
				driver.sendKeyEvent(13);//6
				driver.sendKeyEvent(7);//0
				driver.sendKeyEvent(14);//7
				wait.waitFor(1500);
				driver.sendKeyEvent(66);//回车键
				wait.waitFor(1500);
				WebElement etpsd=driver.findElement(By.id("com.xiaorong.lightning:id/et_psd"));
//				etpsd.sendKeys("123456");
				etpsd.click();
				driver.sendKeyEvent(8);//1
				driver.sendKeyEvent(9);//2
				driver.sendKeyEvent(10);//3
				driver.sendKeyEvent(11);//4
				driver.sendKeyEvent(12);//5
				driver.sendKeyEvent(13);//6
				wait.waitFor(1500);
				driver.sendKeyEvent(4);//返回键
				wait.waitFor(1500);
				WebElement tvlogin=driver.findElement(By.id("com.xiaorong.lightning:id/tv_login"));
				tvlogin.click();
				wait.waitFor(1500);

				System.out.println("login 登陆 测试成功");
				
	}
}

