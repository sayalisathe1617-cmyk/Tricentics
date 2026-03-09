package Project_Testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automobile_Vehicle_Insurance 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		wd.manage().window().maximize();
		//Open Web site tricentis vehicle insurance Application
		wd.get("https://sampleapp.keeley.nz/101/");
		//To locate automobile option
		wd.findElement(By.linkText("Automobile")).click();
		//---------1 Page--------------
		//After clicking automobile Enter Vehicle Data will be appears
		//Select Make name below Drop down list
		WebElement ddli =wd.findElement(By.id("make"));
		Select sel = new Select(ddli);
		List <WebElement> li = sel.getOptions();
		sel.selectByVisibleText("Honda");
		//Enter EnginePerformane [KW]
		wd.findElement(By.id("engineperformance")).sendKeys("1800");
		//Enter Date of Manufactures MM/DD/YYYY format
		wd.findElement(By.id("dateofmanufacture")).sendKeys("08/17/2021");
		//Select Number of Seats
		WebElement nli =wd.findElement(By.id("numberofseats"));
		Select seatNo = new Select(nli);
		List <WebElement> lino = seatNo.getOptions();
		seatNo.selectByValue("4");
		//Select Fuel Type
		WebElement fuelli =wd.findElement(By.id("fuel"));
		Select FuelType = new Select(fuelli);
		List <WebElement> ft = FuelType.getOptions();
		FuelType.selectByValue("Gas");
		//List Price[$]
		wd.findElement(By.id("listprice")).sendKeys("80000");
		//License Plate Number
		wd.findElement(By.id("licenseplatenumber")).sendKeys("MH12SB6677");
		//Annual Mileage [mi]
		wd.findElement(By.id("annualmileage")).sendKeys("20000");
		//Click on Next Button
		wd.findElement(By.id("nextenterinsurantdata")).click();
		
		//-------------2 Page--------------------
		//Next Page Form Will be appears Enter Insurance Data
		//Enter First Name
		wd.findElement(By.id("firstname")).sendKeys("XYZ");
		//Enter Last Name
		wd.findElement(By.id("lastname")).sendKeys("ABC");
		//Enter Date of Birth
		wd.findElement(By.id("birthdate")).sendKeys("12/10/1986");
		//Select Gender
		wd.findElement(By.xpath("//p[@class='group']/label[2]")).click();
		//Enter Street Address
		wd.findElement(By.id("streetaddress")).sendKeys("Karve Nagar");
		//select Country 
		WebElement country =wd.findElement(By.id("country"));
		Select coun = new Select(country);
		List <WebElement> conli = coun.getOptions();
		coun.selectByVisibleText("India");
		//Enter Zip Code 
		wd.findElement(By.id("zipcode")).sendKeys("411016");
		//Enter City
		wd.findElement(By.id("city")).sendKeys("Pune");
		//Select Occupation
		WebElement  occ=wd.findElement(By.id("occupation"));
		Select  occli= new Select(occ);
		List <WebElement>  lio= occli.getOptions();
		occli.selectByIndex(4);
		//Select Hobbies
		wd.findElement(By.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p/label[5]")).click();
		//Enter Website
		wd.findElement(By.id("website")).sendKeys("https://one.in");
		
		//click next button
		wd.findElement(By.id("nextenterproductdata")).click();
		
		//---------------3 Page----------
		//Start Date
		wd.findElement(By.id("startdate")).sendKeys("12/08/2025");
		//Select Insurance Sum [$]
		WebElement insum =wd.findElement(By.id("insurancesum"));
		Select  insu= new Select(insum);
		List <WebElement> ins = insu.getOptions();
		insu.selectByIndex(1);
		//Select Merit Rating
		WebElement  mr=wd.findElement(By.id("meritrating"));
		Select  rating= new Select(mr);
		List <WebElement>  merit= rating.getOptions();
		rating.selectByValue("Malus 10");
		//Select Damage Insurance
		WebElement  di =wd.findElement(By.id("damageinsurance"));
		Select  damin= new Select(di);
		List <WebElement>  dam_insu= damin.getOptions();
		damin.selectByValue("Partial Coverage");
		//select Optional Products
		wd.findElement(By.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p/label[2]")).click();
		//select Courtesy Car
		WebElement  ccar =wd.findElement(By.id("courtesycar"));
		Select  car= new Select(ccar);
		List <WebElement> courtesy= car.getOptions();
		car.selectByValue("Yes");
		//Click next button
		wd.findElement(By.id("nextselectpriceoption")).click();
		//select price option page appears
		//--------4 page------------
		Thread.sleep(5000);
		//Excepted Values
		String expectedGoldPrice = "1,198.00";
		String actualGoldPrice = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr/td[3]/span")).getText();
		String expectedGoldClaim = "Submit";
		String actualGoldClaim = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[3]")).getText();
		String expectedGoldDiscount = "2";
		String actualGoldDiscount = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[3]")).getText();
		String expectedGoldCover = "Limited";
		String actualGoldCover = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[3]")).getText();
		
		if (actualGoldPrice.equals(expectedGoldPrice) && actualGoldClaim.equals(expectedGoldClaim) && 
				actualGoldDiscount.equals(expectedGoldDiscount) && actualGoldCover.equals(expectedGoldCover)) 
		{
		    System.out.println("Here Expected Value and Actual Value Are Matched--");
		    wd.findElement(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label[2]")).click();
		} 
		else 
		{
		    System.out.println("Here Expected Value and Actual Value Are Not matched--");
		}
		
		//click Next Button
		wd.findElement(By.id("nextsendquote")).click();
		//-----------5 Page-------------
		//SendQuote Page will be appears
		//Enter E-mail
		wd.findElement(By.id("email")).sendKeys("xyz@abc.com");
		//Enter phone number
		wd.findElement(By.id("phone")).sendKeys("7896541230");
		//Enter Username
		wd.findElement(By.id("username")).sendKeys("xyzabc");
		//Enter Password
		wd.findElement(By.id("password")).sendKeys("Abc1xy");
		//Enter Confirm Password
		wd.findElement(By.id("confirmpassword")).sendKeys("Abc1xy");
		//Click send button
		wd.findElement(By.id("sendemail")).click();
		
		Thread.sleep(1100);
		//Capture Screenshot
		File srcfile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:\\Seed Infotech CourseWare\\8 Automation Testing\\Project_Automobile_ss.jpg"));
		System.out.println("sucessfully saved ScreenShot");
		
		//Click Ok button
		wd.findElement(By.xpath("//div[@class='sa-button-container']/div/button")).click();
		//Back To MainPage
		wd.findElement(By.id("backmain")).click();
	}

}
