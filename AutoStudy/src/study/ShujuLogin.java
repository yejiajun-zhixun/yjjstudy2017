package study;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShujuLogin {
	
	private WebDriver driver=null;
	private Browsers browser=null;
	private Wait wait;
	public static boolean flag = true;
	public static List<Error> errors = new ArrayList<Error>();
	
	@BeforeTest
	public void beforetest(){
		browser = new Browsers (BrowsersType.ie);
		driver=browser.driver;
		System.out.println("²âÊÔ¿ªÊ¼");
	}
	
	@Test
	public void test(){
		String url ="http://www.bqu.com/";
		driver.get(url);
		
		try{

		Thread.sleep(1000);
		
		}catch(InterruptedException e){
		
		e.printStackTrace();
		
		}
		
		WebElement urllogin=driver.findElement(By.xpath("//span[@class='login']/span/a[1]"));	
		String equalname=urllogin.getText();
		try{
			Assert.assertEquals(equalname,"µÇÂ¼");
			System.out.println(equalname);
		}catch(Error e){
			errors.add(e);
			flag =false;
		}
		if(flag==false){
			WebElement loginout=driver.findElement(By.xpath("//span[@class='login']/span/a[2]"));
			loginout.click();
		}

		try{

		Thread.sleep(5000);
		
		}catch(InterruptedException e){
		
		e.printStackTrace();
		
		}
		urllogin.click();

		WebElement moblie=driver.findElement(By.xpath("//input[@id='loginname']"));
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		WebElement moblietips=driver.findElement(By.xpath("//div[@class='err_tips']"));	
		WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='loginsubmit']"));
		//ÕËºÅ´íÎóÊ±£¬µã»÷µÇÂ¼,¼ì²é´íÎóÌáÊ¾
		moblie.clear();
		moblie.sendKeys("159900");
		loginsubmit.click();
		try{
			Assert.assertEquals(equalname,"µÇÂ¼");
		}catch(Error e){
			errors.add(e);
		}
		moblie.clear();
		moblie.sendKeys("15990027607");
		password.clear();
		password.sendKeys("123456");
		loginsubmit.click();
		
//		if( moblietips.equals("")){
//			System.out.println(moblietips.getText());
//		}
		try{

		Thread.sleep(5000);
		
		}catch(InterruptedException e){
		
		e.printStackTrace();
		
		}
		WebElement loginname=driver.findElement(By.xpath("//span[@class='login']/span/a[1]"));
		String loginname2=loginname.getText();
		System.out.println(loginname2);			
		WebElement loginout=driver.findElement(By.xpath("//span[@class='login']/span/a[2]"));
		loginout.click();
	
	}
	
	@AfterTest
	public void aftertest(){
		driver.close();
		System.out.println("Game Over");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
