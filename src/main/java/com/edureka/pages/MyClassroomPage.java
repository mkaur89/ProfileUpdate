package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.common.SharedActions;

public class MyClassroomPage extends SharedActions 
{
	@FindBy(xpath = "//img[@class='user_image']")
	private WebElement IMG_user;
	@FindBy(xpath = "//li[@role = 'menuitem']/a[text() = 'My Profile']")
	private WebElement LNK_profile;

	public MyClassroomPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickUserImage()
	{
		click(IMG_user);
	}
	
	public void clickProfileMenuItem()
	{
		click(LNK_profile);
	}
}
