package com.edureka.testscripts;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.edureka.common.BaseTest;
import com.edureka.common.ReadExcel;
import com.edureka.pages.HomePage;
import com.edureka.pages.LoginPage;

public class LogInScript extends BaseTest 
{
	HomePage homePage = null;
	LoginPage loginPage = null;

	@Test
	public void tc_01_login()
	{
		try
		{
			homePage = new HomePage(driver);
			loginPage = new LoginPage(driver);
			HashMap<String, String> data = ReadExcel.fetchData(INPUPT_PATH, "Credentials.xlsx", "Login");
			
			String email = data.get("Email");
			String password = data.get("Password");

			homePage.clickOnLogin();
			loginPage.fillEmailId(email);
			loginPage.fillPassword(password);
			loginPage.clickLoginBtn();
			log.info("TC_01_login has been executed successfully");
		}
		catch(Exception e)
		{
			log.error("TC_01_login has failed " + e);	
		}
	}
}
