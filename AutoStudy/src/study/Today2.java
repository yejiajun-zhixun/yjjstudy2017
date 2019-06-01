package study;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Today2 {

		private static AndroidDriver<MobileElement> driver;
		public static void main(String[] args) throws InterruptedException, MalformedURLException{
			File classpathRoot =new File(System.getProperty("user.dir"));
			//路径System.getProperty("user.dir")=E:\eclipse2017\shandaixia\；
			File appDir = new File(classpathRoot,"apps/ContactManager");
			File app = new File(appDir,"app-PP-release.apk");
			//判断apk
			if (!app.exists()){
				System.out.println("本次需要安装的APK，不存在！");
			}
			//设置启动参数
			DesiredCapabilities capabilities =new DesiredCapabilities();
			//设置浏览器类型，如果为空，就取用Appium中设定的浏览器
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			//设置硬盘使得支持中文输入
			capabilities.setCapability("unicodeKeyboard", "True");
			capabilities.setCapability("resetKeyboard", "true");
			//设置测试平台
			capabilities.setCapability("platformName", "Android");
			//设置设备名称
			capabilities.setCapability("deviceName", "Android Emulator");
			//设置Android 版本
			capabilities.setCapability("platformVersion", "7.0.0");
			//设置Android 版本
//			capabilities.setCapability("udid", "10.60.20.50:8080");
			//获取绝对路径
			capabilities.setCapability("app", app.getAbsolutePath());
			//设置启动包名
			capabilities.setCapability("app-package", "com.xiaorong.lightning");
			//设置启动主Activity
			capabilities.setCapability("app-activity", "com.xiaorong.lightning.ui.activity.WelcomeActivity");
			//初始化
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);  
			//设置隐式等待超时时间
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("22222");
			
			int width= driver.manage().window().getSize().width;
			int height=driver.manage().window().getSize().height;
			driver.swipe(width*4/5, height/2, width/5, height/2, 1000);
			Thread.sleep(10000);
			driver.swipe(width*4/5, height/2, width/5, height/2, 1000);
			Thread.sleep(10000);
			driver.swipe(width*4/5, height/2, width/5, height/2, 1000);
			Thread.sleep(10000);
			driver.swipe(width*4/5, height/2, width/5, height/2, 1000);
			driver.findElement(By.name("立即体验")).click();
			Thread.sleep(10000);
			
			driver.quit();
		}
		

}
