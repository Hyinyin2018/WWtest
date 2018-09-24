package test2;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindMeeting {

	public static void main(String[] args) {
		
		//1. Navigate to https://www.weightwatchers.com/us/
		//System.setProperty("webdriver.chrome.driver", "C:\\WWtest\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.weightwatchers.com/us/");
		
		//2. Verify loaded page title matches “Weight Loss Program, Recipes & Help | Weight Watchers”
		String actual_title1 = driver.getTitle();
		String expect_title1 = "Weight Watchers: Weight Loss Program, Recipes & Help | WW USA";
		if (actual_title1.contentEquals(expect_title1))
		{
	            System.out.println("Test Passed on Main title check!\n");
	    } 
		else 
	    {
	            System.out.println("Test Failed on Main title check!\n");
	 	}
		
		//3. On the right corner of the page, click on “Find a Meeting”
		driver.findElement(By.xpath("//*[@id=\"ela-menu-visitor-desktop-supplementa_find-a-meeting\"]")).click();
		
		//4. Verify loaded page title contains “Get Schedules & Times Near You”
		String actual_title2 =  driver.getTitle();
		String expect_title2 = "Get Schedules & Times Near You";
		if (actual_title2.contains(expect_title2))
		{
	            System.out.println("Test Passed on Schedule title check!\n");
	    } 
		else 
	    {
	            System.out.println("Test Failed on Schedule title check!\n");
	 	}

		//5. In the search field, search for meetings for zip code: 10011
		driver.findElement(By.xpath("//*[@id=\"meetingSearch\"]")).sendKeys("10011");
		driver.findElement(By.xpath("//button[@class=\"btn btn-default form-blue-pill__btn\"]")).click();

		//6. Print the title of the first result and the distance (located on the right of location title/name)
		List<WebElement> location_list = driver.findElements(By.xpath("//div[@class='location__name']"));
		List<WebElement> distance_list = driver.findElements(By.xpath("//div[@class='location__distance']"));
		String first_location_result = location_list.get(0).getText();
		String first_distance_result = distance_list.get(0).getText();
		System.out.print("First Location is "+first_location_result+"====Distance is "+first_distance_result+"\n");
		
		//7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
		location_list.get(0).click();
		String first_location = driver.findElement(By.xpath("//div[@class=\"location__name\"]")).getText();
		if (first_location.contentEquals(first_location_result))
		{
            System.out.println("Test Passed on First location check!\n");
		} 
		else 
		{
            System.out.println("Test Failed on First location check!\n");
		}
		
		//8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK);
		String[] weekday=new String[] {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		System.out.println("Today is "+weekday[dayofweek-1]+"\n");
		if(dayofweek==1 || dayofweek==7)
		{
			System.out.println("There is no session on "+weekday[dayofweek-1]);
		}
		else
		{		
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String daypath="//div[text()=\""+weekday[dayofweek-1]+"\"]//following-sibling::div[@class=\"hours-list-item-hours\"]";
			List<WebElement> hours_list=driver.findElements(By.xpath(daypath));
			for(int i=0; i<hours_list.size(); i++)
			{
			System.out.println("Today's Hours Of Operation ====="+hours_list.get(i).getText()+"\n");	
			}

		}
		
		driver.quit();
		
	}

}
