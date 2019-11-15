package com.edureka.common;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharedActions implements IConstants
{
	protected WebDriver driver = null;
	protected Logger log = Logger.getLogger(SharedActions.class);

	public SharedActions(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			log.info("Clicked on "+element);
		}
		catch(Exception e)
		{
			log.error("Unable to click on "+element + " " +e.getMessage());
		}
	}
	public void verifyElementPresent(WebElement element) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void mouseHover(WebElement element) throws Exception
	{
		Actions action = null;
		try
		{
			action = new Actions(driver);
			action.moveToElement(element).build();
			log.info("Moved mouse over "+ element);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void windowScroll(int scrollAmount)
	{
		JavascriptExecutor jse = null;
		try
		{
			jse = (JavascriptExecutor) driver;
			driver.switchTo().activeElement();
			//jse.executeScript("arguments[0].scrollTop = arguments[1];", driver.findElement(By.xpath("//div[@class = 'modal-body']")), 100);
			//jse.executeScript("window.scroll(0," + scrollAmount +")");
			jse.executeScript("scroll(0, 250);");
		}
		catch(Exception e)
		{
			log.error("Unable to scroll window");
		}
	}
	public void scrollIntoElementView(WebElement element)
	{
		JavascriptExecutor jse = null;
		try
		{
			jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();", element);
		}
		catch(Exception e)
		{
			log.error("Unable to scroll to get element into the view");
		}
	}
	public void exeAutoITForImage(String autoITFileName, String profileImgName) throws IOException
	{
		String currentDirPath = System.getProperty("user.dir");
		String autoITPath = AUTOITFILE_PATH + autoITFileName;
		String profileImgPath = currentDirPath + INPUPT_PATH.substring(1) + profileImgName;
		String cmdParameter = autoITPath +" "+ profileImgPath;
		Runtime.getRuntime().exec(cmdParameter);
	}
}
