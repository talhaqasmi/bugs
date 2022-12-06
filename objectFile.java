package autoTest1;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class objectFile {
	WebDriver driver;
	Logger logger=Logger.getLogger("objectFile");
	
	@FindBy(xpath="//input[@name='vchLogin_Name']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='vchPassword']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement login;
	
	@FindBy(xpath="//a[@id='patientBtn']")
	WebElement patient;
	
	
	@FindBy(xpath="//input[@name='txtLast_Name']")
	WebElement lastname;
	
	@FindBy(xpath="//iframe[@id='fra_Menu_CureMD']")
	WebElement frame1;
	
	
	@FindBy(xpath="//iframe[@id='fraCureMD_Body']")
	WebElement frame2;
	
	@FindBy(xpath="//a[@id='PersonalBtn']")
	WebElement personal;
	
objectFile (WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver,this);
	}
public void login1() throws InterruptedException {
	//driver.manage().window().maximize();
	username.sendKeys("ChargeNDC");
	Thread.sleep(3000);
	logger.info("userName entered");
	password.sendKeys("SuPPort.2014");
	Thread.sleep(3000);
	logger.info("password entered");
	login.click();
	Thread.sleep(3000);
	logger.info("clicked on login");
	logger.info("logged in successfully");
		}
public void patient1() throws InterruptedException {
	String origional=driver.getWindowHandle();
	Set<String> window=driver.getWindowHandles();
	for(String shift:window) {
		if(!shift.equals(origional)) {
			driver.switchTo().window(shift);
			driver.switchTo().frame(frame1);
			Thread.sleep(5000);
			patient.click();
			Thread.sleep(3000);
			logger.info("clicked on patient");
			}
		}
	}
}
