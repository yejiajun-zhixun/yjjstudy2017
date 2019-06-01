package study;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class BaiDuSelect {
	private WebDriver driver=null;
	private Browsers browser=null;

	@BeforeTest
	public void beforetest(){
		 //直接调用browsersType 开启浏览器
		browser=new Browsers(BrowsersType.ie);
		driver=browser.driver;
		System.out.println("测试开始");
	}
	
	@Test
	public void baiduyesy() throws InterruptedException{
		String url = "http://www.baidu.com";
		driver.get(url);
		//driver.navigate().to(url); // 打开指定的网站
		String title=driver.getTitle();
		System.out.println(title);
		
        try {
            /**
             * WebDriver自带了一个智能等待的方法。 dr.manage().timeouts().implicitlyWait(arg0, arg1）；
             * Arg0：等待的时间长度，int 类型 ； Arg1：等待时间的单位 TimeUnit.SECONDS 一般用秒作为单位。
             */
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String win = driver.getWindowHandle();  
        WebElement login = driver.findElement(By.id("kw"));
        String logintext=login.getText();
        if(logintext!= null){
        	System.out.println(logintext);
        }
        driver.findElement(By.id("kw")).sendKeys(new String[] { "hello" });
        
        driver.findElement(By.id("su"));
		String title2=driver.getCurrentUrl();
		System.out.println(title2);
		WebElement contents=driver.findElement(By.xpath("//div[@id='content_left']"));
		if(contents!=null){
			System.out.println("搜索成功");
		}
		driver.findElement(By.xpath("//div[@id='page']/a[2]")).click();
		String title3=driver.getCurrentUrl();
		System.out.println(title3);
		
		//下拉框进行点击操作
		WebElement setting=driver.findElement(By.xpath("//div[@id='u1']/a[@name='tj_settingicon']"));
		setting.click();
		
	}

	@AfterTest
	public void afteretest(){
		driver.quit();
		System.out.println("测试关闭");
	}

}
