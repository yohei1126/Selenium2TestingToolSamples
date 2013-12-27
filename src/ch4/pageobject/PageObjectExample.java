package ch4.pageobject;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageObjectExample {
	private static WebDriver selenium;
	
	@BeforeClass
	public static void setupDriver() {
		selenium = new FirefoxDriver();
	}
	
	@AfterClass
	public static void quitDriver() {
		selenium.quit();
	}

	@Test
	public void shouldCheckButtonOnChapter2Page() {
		selenium.get("http://book.theautomatedtester.co.uk");
		selenium.findElement(By.linkText("Chapter2")).click();
		assertEquals(selenium.findElements(By.id("but1")).size(), 1);
	}

	@Test
	public void shouldCheckAnotherButtonOnChapter2Page() {
		selenium.get("http://book.theautomatedtester.co.uk");
		selenium.findElement(By.linkText("Chapter2")).click();
		assertEquals(selenium.findElements(By.id("divinthecenter")).size(), 1);
	}
}
