package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class LoginPage extends SharedActions 
{
	@FindBy(id = "si_popup_email")
	private WebElement INP_email;
	@FindBy(id = "si_popup_passwd")
	private WebElement INP_password;
	@FindBy(xpath = "//button[text() = 'Login']")
	private WebElement BTN_login;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void fillEmailId(String email)
	{
		try
		{
			verifyElementPresent(INP_email);
			INP_email.sendKeys(email);
			log.info("Entered data in "+INP_email);
		}
		catch(Exception e)
		{
			log.error("Unable to enter email " + e.getStackTrace());
		}
	}
	public void fillPassword(String password)
	{
		try
		{
			verifyElementPresent(INP_password);
			INP_password.sendKeys(password);
			log.info("Entered data in "+INP_password);
		}
		catch(Exception e)
		{
			log.error("Unable to enter password " + e.getMessage());
		}
	}
	public void clickLoginBtn()
	{
		try
		{
			verifyElementPresent(BTN_login);
			click(BTN_login);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
}
