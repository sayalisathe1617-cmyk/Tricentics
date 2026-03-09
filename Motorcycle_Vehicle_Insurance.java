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

public class Motorcycle_Vehicle_Insurance {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		wd.manage().window().maximize();
		//Open Web site tricentis vehicle insurance Application
		wd.get("https://sampleapp.keeley.nz/101/");
		//To locate automobile option
		wd.findElement(By.linkText("Motorcycle")).click();
		//---------1 Page--------------
		//After clicking automobile Enter Vehicle Data will be appears
		//Select Make name below Drop down list
		WebElement ddli =wd.findElement(By.id("make"));
		Select sel = new Select(ddli);
		List <WebElement> li = sel.getOptions();
		sel.selectByVisibleText("Suzuki");
		//Select Model
		WebElement mod =wd.findElement(By.id("model"));
		Select model = new Select(mod);
		List <WebElement> mli = model.getOptions();
		model.selectByIndex(4);
		//Cylinder Capacity [ccm]
		wd.findElement(By.id("cylindercapacity")).sendKeys("1500");
		//Enter EnginePerformane [KW]
		wd.findElement(By.id("engineperformance")).sendKeys("180");
		//Enter Date of Manufactures MM/DD/YYYY format
		wd.findElement(By.id("dateofmanufacture")).sendKeys("12/25/1990");
		//Select Number of Seats
		WebElement nli =wd.findElement(By.id("numberofseatsmotorcycle"));
		Select seatNo = new Select(nli);
		List <WebElement> lino = seatNo.getOptions();
		seatNo.selectByValue("2");
		//List Price[$]
		wd.findElement(By.id("listprice")).sendKeys("99000");
		//Annual Mileage [mi]
		wd.findElement(By.id("annualmileage")).sendKeys("100000");
		//Click on Next Button
		wd.findElement(By.id("nextenterinsurantdata")).click();
		
		//-------------2 Page--------------------
		//Next Page Form Will be appears Enter Insurance Data
		//Enter First Name
		wd.findElement(By.id("firstname")).sendKeys("abcdef");
		//Enter Last Name
		wd.findElement(By.id("lastname")).sendKeys("defcv");
		//Enter Date of Birth
		wd.findElement(By.id("birthdate")).sendKeys("12/17/1997");
		//Select Gender
		wd.findElement(By.xpath("//p[@class='group']/label[2]")).click();
		//Enter Street Address
		wd.findElement(By.id("streetaddress")).sendKeys("Mauli Nagar");
		//select Country 
		WebElement country =wd.findElement(By.id("country"));
		Select coun = new Select(country);
		List <WebElement> conli = coun.getOptions();
		coun.selectByVisibleText("India");
		//Enter Zip Code 
		wd.findElement(By.id("zipcode")).sendKeys("400005");
		//Enter City
		wd.findElement(By.id("city")).sendKeys("Mumbai");
		//Select Occupation
		WebElement  occ=wd.findElement(By.id("occupation"));
		Select  occli= new Select(occ);
		List <WebElement>  lio= occli.getOptions();
		occli.selectByIndex(2);
		//Select Hobbies
		wd.findElement(By.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p/label[4]")).click();
		//Enter Website
		wd.findElement(By.id("website")).sendKeys("https://two.in");
		//select img png,jpeg format
		//wd.findElement(By.id("open")).click();
		
		//click next button
		wd.findElement(By.id("nextenterproductdata")).click();
		
		//---------------3 Page----------
		//Start Date
		wd.findElement(By.id("startdate")).sendKeys("10/12/2025");
		//Select Insurance Sum [$]
		WebElement insum =wd.findElement(By.id("insurancesum"));
		Select  insu= new Select(insum);
		List <WebElement> ins = insu.getOptions();
		insu.selectByIndex(3);
		//Select Damage Insurance
		WebElement  di =wd.findElement(By.id("damageinsurance"));
		Select  damin= new Select(di);
		List <WebElement>  dam_insu= damin.getOptions();
		damin.selectByValue("Full Coverage");
		//select Optional Products
		wd.findElement(By.xpath("//div[@class='field idealforms-field idealforms-field-checkbox']/p/label[2]")).click();
		//Click next button
		wd.findElement(By.id("nextselectpriceoption")).click();
		//select price option page appears
		//--------4 page------------
		Thread.sleep(5000);
		//Excepted Values
		String expectedSilverPrice = "697.00";
		String actualSilverPrice = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr/td/span")).getText();
		String expectedSilverClaim = "No";
		String actualSilverClaim = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[2]/td[2]")).getText();
		String expectedSilverDiscount = "No";
		String actualSilverDiscount = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[3]/td[2]")).getText();
		String expectedSilverCover = "No";
		String actualSilverCover = wd.findElement(By.xpath("//table[@id='priceTable']/tbody/tr[4]/td[2]")).getText();
		
		if (actualSilverPrice.equals(expectedSilverPrice) && actualSilverClaim.equals(expectedSilverClaim) && 
				actualSilverDiscount.equals(expectedSilverDiscount) && actualSilverCover.equals(expectedSilverCover)) 
		{
		    System.out.println("Here Expected Value and Actual Value Are Matched--");
		    wd.findElement(By.xpath("//table[@id='priceTable']/tfoot/tr/th[2]/label")).click();
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
		
		Thread.sleep(11000);
		//Capture Screenshot
		File srcfile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:\\Seed Infotech CourseWare\\8 Automation Testing\\Project_Motorcycle_ss.jpg"));
		System.out.println("sucessfully saved ScreenShot");
		
		//Click Ok button
		wd.findElement(By.xpath("//div[@class='sa-button-container']/div/button")).click();
		//Back To MainPage
		wd.findElement(By.id("backmain")).click();

	}

}
