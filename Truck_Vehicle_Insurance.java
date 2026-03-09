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

public class Truck_Vehicle_Insurance 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		WebDriver wd= new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		wd.manage().window().maximize();
		wd.get("https://sampleapp.keeley.nz/101/");
		//To Click on Truck and form will be appear
		wd.findElement(By.linkText("Truck")).click();
		//---------1 Page-------------
		//Select locate Make
		WebElement  we =wd.findElement(By.id("make"));
		Select sel = new Select(we);
		List <WebElement> li = sel.getOptions();
		sel.selectByVisibleText("Nissan");
		//Enter Engine Performance[kw]
		wd.findElement(By.id("engineperformance")).sendKeys("2000");		
		//Enter Date of Manufacture
		wd.findElement(By.id("dateofmanufacture")).sendKeys("01/01/2000");
		//Select Numbers of Seats
		WebElement nli =wd.findElement(By.id("numberofseats"));
		Select seatNo = new Select(nli);
		List <WebElement> lino = seatNo.getOptions();
		seatNo.selectByValue("2");
		//Select Fuel Type
		WebElement fuelli =wd.findElement(By.id("fuel"));
		Select FuelType = new Select(fuelli);
		List <WebElement> ft = FuelType.getOptions();
		FuelType.selectByValue("Diesel");
		//Enter Payload [kg]
		wd.findElement(By.id("payload")).sendKeys("1000");
		//Enter Total Weight [kg]
		wd.findElement(By.id("totalweight")).sendKeys("50000");
		//Enter List Price [$]
		wd.findElement(By.id("listprice")).sendKeys("99000");
		//Enter License Plate Number
		wd.findElement(By.id("licenseplatenumber")).sendKeys("KA01SB6767");
		//Enter Annual Mileage [mi]
		wd.findElement(By.id("annualmileage")).sendKeys("80000");
		//Click on Next Button
		wd.findElement(By.id("nextenterinsurantdata")).click();
		//------------2 Page-----------
		//Next Page Form Will be appears Enter Insurance Data
		//Enter First Name
		wd.findElement(By.id("firstname")).sendKeys("ABC");
		//Enter Last Name
		wd.findElement(By.id("lastname")).sendKeys("EFG");
		//Enter Date of Birth
		wd.findElement(By.id("birthdate")).sendKeys("01/16/1989");
		//Select Gender
		wd.findElement(By.xpath("//p[@class='group']/label")).click();
		//Enter Street Address
		wd.findElement(By.id("streetaddress")).sendKeys("Anand Nagar");
		//select Country 
		WebElement country =wd.findElement(By.id("country"));
		Select coun = new Select(country);
		List <WebElement> conli = coun.getOptions();
		coun.selectByIndex(15);
		//Enter Zip Code 
		wd.findElement(By.id("zipcode")).sendKeys("484660");
		//Enter City
		wd.findElement(By.id("city")).sendKeys("Baroda");
		//Select Occupation
		WebElement  occ=wd.findElement(By.id("occupation"));
		Select  occli= new Select(occ);
		List <WebElement>  lio= occli.getOptions();
		occli.selectByIndex(5);
		//Select Hobbies
		wd.findElement(By.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p/label[3]")).click();
		//Enter Website
		wd.findElement(By.id("website")).sendKeys("https://one.in");
		//select img png,jpeg format
		//wd.findElement(By.id("open")).click();
				
		//click next button
		wd.findElement(By.id("nextenterproductdata")).click();
				
		//---------------3 Page----------
		//Start Date
		wd.findElement(By.id("startdate")).sendKeys("09/09/2025");
		//Select Insurance Sum [$]
		WebElement insum =wd.findElement(By.id("insurancesum"));
		Select  insu= new Select(insum);
		List <WebElement> ins = insu.getOptions();
		insu.selectByIndex(5);
		//Select Damage Insurance
		WebElement  di =wd.findElement(By.id("damageinsurance"));
		Select  damin= new Select(di);
		List <WebElement>  dam_insu= damin.getOptions();
		damin.selectByValue("Full Coverage");
		//select Optional Products
		wd.findElement(By.xpath("html/body/div/div/div/div/div/form/div/section[3]/div[4]/p/label")).click();
		wd.findElement(By.xpath("html/body/div/div/div/div/div/form/div/section[3]/div[4]/p/label[2]")).click();
		//Click next button
		wd.findElement(By.id("nextselectpriceoption")).click();
		//select price option page appears
		//--------4 page------------
		Thread.sleep(5000);
		//Excepted Values
		String expectedPlatinumPrice = "5,832.00";
		String actualPlatinumPrice = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr/td[4]/span")).getText();
		String expectedPlatinumClaim = "Submit";
		String actualPlatinumClaim = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[4]")).getText();
		String expectedPlatinumDiscount = "5";
		String actualPlatinumDiscount = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[4]")).getText();
		String expectedPlatinumCover = "Limited";
		String actualPlatinumCover = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[4]")).getText();
				
		if (actualPlatinumPrice.equals(expectedPlatinumPrice) && actualPlatinumClaim.equals(expectedPlatinumClaim) && 
			actualPlatinumDiscount.equals(expectedPlatinumDiscount) && actualPlatinumCover.equals(expectedPlatinumCover)) 
		{
		    System.out.println("Here Expected Value and Actual Value Are Matched--");
		    wd.findElement(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label[3]")).click();
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
		wd.findElement(By.id("email")).sendKeys("abc@efg.com");
		//Enter phone number
		wd.findElement(By.id("phone")).sendKeys("9876541230");
		//Enter Username
		wd.findElement(By.id("username")).sendKeys("xyzabc");
		//Enter Password
		wd.findElement(By.id("password")).sendKeys("Abc1ef");
		//Enter Confirm Password
		wd.findElement(By.id("confirmpassword")).sendKeys("Abc1ef");
		//Enter Comment
		
		
		//Click send button
		wd.findElement(By.id("sendemail")).click();		
		Thread.sleep(11000);
		//Capture Screenshot
		File srcfile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:\\Seed Infotech CourseWare\\8 Automation Testing\\Project_Truck_ss.jpeg"));
		System.out.println("sucessfully saved ScreenShot");
		Thread.sleep(7000);		
		//Click Ok button
		wd.findElement(By.xpath("//div[@class='sa-button-container']/div/button")).click();
		//Back To MainPage
		wd.findElement(By.id("backmain")).click();
		
	}

}
