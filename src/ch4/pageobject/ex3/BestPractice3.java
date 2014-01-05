package ch4.pageobject.ex3;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BestPractice3 {
	WebDriver selenium;
	
	@Before
	public void setUp() {
		selenium = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		selenium.quit();
	}
	
	@Test
	public void ShouldLoadTheHomePageAndThenCheckButtonOnChapter2(){
		selenium.get("http://book.theautomatedtester.co.uk");
		HomePage hp = new HomePage(selenium);
		Chapter2 ch2 = hp.clickChapter2();
		assertTrue(ch2.isButtonPresent("but1"));
	}

}
