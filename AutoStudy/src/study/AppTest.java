package study;


import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

public class AppTest {
	private WebDriver driver =null;
	private Browsers browser =null;
	
  @BeforeTest
  public void beforeTest(){
	  //直接调用browsersType 开启浏览器
		browser=new Browsers(BrowsersType.ie);
		driver=browser.driver;
		System.out.println("beforeTest");
  }
  
//	@BeforeTest
//	public void beforeTest(){
//		System.out.println("beforeTest");
//	}
	
  @BeforeClass
  public void beforeClass(){
	  System.out.println("beforeClass");
  }
//读取XML的参数进行  开启浏览器
//  @Parameters({"platform"})
//  @BeforeMethod(groups="browsers")
//  public void beforeMethod(String platform){
//		if(platform.equals("FF"))
//			browser = new Browsers(BrowsersType.firefox);
//		else if(platform.equals("chrome"))
//			browser = new Browsers(BrowsersType.chrome);
//		else{
//			browser = new Browsers(BrowsersType.ie);
//		}
//		driver =browser.driver;
//		System.out.println("beforeMethod");
//  }

 @Test(groups="test1")
  public void test1(){
	driver.get("https://www.baidu.com");
	System.out.println("page title:"+driver.getTitle());
   // throw new RuntimeException("Test not implemented");
	System.out.println("Test1");
  }

  @Test(groups="test2")
  public void test2(){
	  driver.get("http://www.hao123.com");
	  System.out.println("page title:"+driver.getTitle());
   // throw new RuntimeException("Test not implemented");
    System.out.println("Test2");
  }
 
  @Test(groups="test4")
  public void test4(){
	  driver.get("http://www.sohu.com");
	  System.out.println("page title:"+driver.getTitle());
   // throw new RuntimeException("Test not implemented");
    System.out.println("Test4");
  }
  
  @Test(groups="test3")
  public void test3(){
	  driver.get("http://fm.baidu.com");
	  System.out.println("page title:"+driver.getTitle());
   // throw new RuntimeException("Test not implemented");
    System.out.println("Test3");
  }
  
  @AfterMethod(groups="browsers")
  public void afterMethor(){
	  System.out.println("afterMethor");
  }
  
  @AfterClass
  public void afterClass(){
	  System.out.println("afterClass");
  }

  @AfterTest
  public void afterTest(){
	  System.out.println("afterTest");
  }
 
}