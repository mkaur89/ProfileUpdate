package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class ProfilePage extends SharedActions 
{
	@FindBy(xpath = "//a[@id = 'personal_details']")
	private WebElement LNK_personalEdit;
	@FindBy(xpath = "//i[@class = 'icon-camera']")
	private WebElement LNK_cameraIcon;
	@FindBy(xpath = "//div[@class = 'file-upload']")
	private WebElement DIV_chooseFile;
	@FindBy(xpath = "//button[text() = 'Upload']")
	private WebElement BTN_uploadImg;
	@FindBy(xpath = "//li[@class = 'brand-logo']/a[@class = 'back-arrow']")
	private WebElement LNK_backArrow;

	public ProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickPersonalEditIcon()
	{
		click(LNK_personalEdit);
	}

	public void clickCameraIcon()
	{
		click(LNK_cameraIcon);
	}
	public void clickChooseFile()
	{
		try
		{
			verifyElementPresent(DIV_chooseFile);
			click(DIV_chooseFile);
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}
	public void uploadProfileImg()
	{
		try
		{
			Thread.sleep(2000);
			exeAutoITForImage("AutoITProfileImage.exe", "ProfileImage.jpg");
		}
		catch(Exception e)
		{
			log.error("Unable to upload profile picture "+ e);
		}
	}
	public void clickUploadBtn()
	{
		try
		{
			Thread.sleep(3000);
			scrollIntoElementView(BTN_uploadImg);
			click(BTN_uploadImg);
		}
		catch(Exception e)
		{
			log.error(e);
		}
	}
	public void clickBackArrow()
	{
		try
		{
			Thread.sleep(2000);
			click(LNK_backArrow);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}
}
