package study;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestTest1 {
	private AndroidDriver<AndroidElement> driver;
	private Wait wait;
	
	@Before
	public void setUp() throws Exception{
		wait = new Wait(driver);
		wait.waitFor(1500);
		//set up appium
		File classpathRoot=new File(System.getProperty("user.dir"));
		File appDir=new File(classpathRoot,"/apps");
		File app=new File(appDir,"app-OPPO-release.apk");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");//启动移动设备
		capabilities.setCapability("platformVersion", "4.4");
		//以下配置为链接真机
		capabilities.setCapability("automationName", "huawei-kiw_ul00-XGC4C16520003965");//华为荣耀		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsoluteFile());//app的路径，需要写绝对路径
		capabilities.setCapability("appPackage", "com.xiaorong.lightning");
		capabilities.setCapability("appActivity", "com.xiaorong.lightning.ui.activity.WelcomeActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        
        System.out.print("The Test is starts!~~");
		
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
		wait.waitFor(2000);
		permissionallow.click();
		wait.waitFor(2000);
		permissionallow.click();
		wait.waitFor(2000);
		permissionallow.click();
		wait.waitFor(2000);
		permissionallow.click();
		wait.waitFor(2000);
        System.out.print("初始化 成功!~~");
        
		///登陆
		WebElement jieqian =driver.findElement(By.id("com.xiaorong.lightning:id/ly_jieqian"));
		jieqian.click();
		wait.waitFor(1500);
		WebElement etname=driver.findElement(By.id("com.xiaorong.lightning:id/et_name"));
//		etname.sendKeys("15990027607");
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
//		etpsd.sendKeys("123456");
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
		
		System.out.print("login 登陆 测试成功");
	}
	
	@After
	public void tearDown() throws Exception{
        System.out.print("The Test is finish!~~");
		System.out.println("");
		driver.quit();
	}
	
	@Test
	public void leftMenu(){
		//左侧菜单栏，个人中心，我的借款，我的优惠劵，邀请好友，黑名单
		WebElement btleft=driver.findElement(By.id("com.xiaorong.lightning:id/bt_left"));
		btleft.click();
		WebElement ivcenter=driver.findElement(By.id("com.xiaorong.lightning:id/iv_center"));
		ivcenter.click();
		wait.waitFor(2000);
		WebElement left=driver.findElement(By.id("com.xiaorong.lightning:id/left_image"));
		left.click();
		wait.waitFor(2000);
		WebElement myjiekuan=driver.findElement(By.name("我的借款"));
		myjiekuan.click();
		wait.waitFor(2000);
		left.click();
		wait.waitFor(2000);
		WebElement mydiscount=driver.findElement(By.name("我的优惠券"));
		mydiscount.click();
		wait.waitFor(2000);
		left.click();
		wait.waitFor(2000);
		WebElement Invitingfriends=driver.findElement(By.name("邀请好友"));
		Invitingfriends.click();
		wait.waitFor(2000);
		left.click();
		wait.waitFor(2000);
		WebElement blacklist=driver.findElement(By.name("黑名单"));
		blacklist.click();
		wait.waitFor(2000);
		left.click();
		wait.waitFor(2000);
		System.out.print("leftMenu 左侧菜单 测试成功");
	}
	
	@Test
	public void left_helpFaceback(){
		//
		WebElement btleft=driver.findElement(By.id("com.xiaorong.lightning:id/bt_left"));
		btleft.click();
		wait.waitFor(1500);
		WebElement lyhelp=driver.findElement(By.id("com.xiaorong.lightning:id/ly_help"));
		lyhelp.click();
		wait.waitFor(1500);
		WebElement tabshenqing=driver.findElement(By.id("com.xiaorong.lightning:id/id_tab_shenqing_ll"));
		tabshenqing.click();
		wait.waitFor(1500);
		WebElement tabyuqi=driver.findElement(By.id("com.xiaorong.lightning:id/id_tab_yuqi_ll"));
		tabyuqi.click();
		wait.waitFor(1500);
		WebElement tabys=driver.findElement(By.id("com.xiaorong.lightning:id/id_tab_ys_ll"));
		tabys.click();
		wait.waitFor(1500);
		WebElement tabbase=driver.findElement(By.id("com.xiaorong.lightning:id/id_tab_base_ll"));
		tabbase.click();
		wait.waitFor(1500);
		//反馈页面，输入反馈内容，选择图片，点击提交
		WebElement btnfk=driver.findElement(By.id("com.xiaorong.lightning:id/btn_fk"));
		btnfk.click();
		wait.waitFor(1500);
		WebElement tvfk=driver.findElement(By.id("com.xiaorong.lightning:id/tv_fk"));
		tvfk.click();
		wait.waitFor(1500);
		WebElement etfk=driver.findElement(By.id("com.xiaorong.lightning:id/et_fk"));
		etfk.sendKeys("叶佳俊提交测试数据");;
		wait.waitFor(1500);
//		WebElement iv1=driver.findElement(By.id("com.xiaorong.lightning:id/iv_1"));
//		iv1.click();
//		WebElement listitemcontent=driver.findElement(By.id("com.android.gallery3d:id/list_item_content"));
//		listitemcontent.click();
//		wait.waitFor(1500);
//		wait.waitFor(1500);
		WebElement tvfk1=driver.findElement(By.name("提交反馈"));
		tvfk1.click();
		wait.waitFor(1500);
		System.out.print("lefthelpFcaeback 帮助反馈 测试成功");
	}
	
	@Test
	public void left_SetUp(){
		//左侧菜单，设置
		WebElement btleft=driver.findElement(By.id("com.xiaorong.lightning:id/bt_left"));
		btleft.click();
		wait.waitFor(1500);
		WebElement lysetting=driver.findElement(By.id("com.xiaorong.lightning:id/ly_setting"));
		lysetting.click();
		wait.waitFor(1500);
		WebElement left=driver.findElement(By.id("com.xiaorong.lightning:id/left_image"));
		left.click();
		System.out.print("leftSetUp 设置 测试成功");
	}
	
	@Test
	public void news(){
		//通知
		WebElement btright=driver.findElement(By.id("com.xiaorong.lightning:id/bt_right"));
		btright.click();
		wait.waitFor(1500);
		WebElement newtextview2=driver.findElement(By.name("公告"));
		newtextview2.click();
		wait.waitFor(1500);
		WebElement righttext=driver.findElement(By.id("com.xiaorong.lightning:id/right_text"));
		righttext.click();
		wait.waitFor(1500);
		WebElement newtextview3=driver.findElement(By.name("活动"));
		newtextview3.click();
		wait.waitFor(1500);
		WebElement newtextview1=driver.findElement(By.name("通知"));
		newtextview1.click();
		wait.waitFor(1500);
		righttext.click();
		wait.waitFor(1500);
		WebElement left=driver.findElement(By.id("com.xiaorong.lightning:id/left_image"));
		left.click();
		System.out.print("news 通告 测试成功");
	}
	
	@Test
	public void advancedCertification(){
		//提额，跳转到基础认证
		WebElement mytie=driver.findElement(By.name("提额"));
		mytie.click();
		wait.waitFor(2000);
		WebElement btleft=driver.findElement(By.id("com.xiaorong.lightning:id/bt_left"));
		btleft.click();
		System.out.print("advancedCertification提额测试成功");
	}
	
}

