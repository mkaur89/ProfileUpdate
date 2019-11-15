package com.edureka.testscripts;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.pages.MyClassroomPage;
import com.edureka.pages.ProfilePage;

public class PersonalDetailsUpdate extends BaseTest 
{
	MyClassroomPage mcrPage = null;
	ProfilePage profilePage = null;
	
	@Test
	public void tc_01_ProfileUpdate()
	{
		mcrPage = new MyClassroomPage(driver);
		profilePage = new ProfilePage(driver);
		mcrPage.clickUserImage();
		mcrPage.clickProfileMenuItem();
	}
	@Test
	public void tc_02_PersonalDetailsEdit()
	{
		profilePage.clickPersonalEditIcon();
		profilePage.clickCameraIcon();
		profilePage.clickChooseFile();
		profilePage.uploadProfileImg();
		profilePage.clickUploadBtn();
		profilePage.clickBackArrow();
	}
}
