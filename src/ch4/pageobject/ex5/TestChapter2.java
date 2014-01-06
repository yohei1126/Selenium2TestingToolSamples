package ch4.pageobject.ex5;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

// example that adopts Page Object Factories design pattern
public class TestChapter2 {
	WebDriver selenium;
	
	@Before
	public void setUp() {
		selenium = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		selenium.quit();
	}
	
	public Chapter2 clickChapter2() {
		clickChapter("2");
		return PageFactory.initElements(selenium, Chapter2.class);
	}

	private void clickChapter(String number) {
		selenium.findElement(By.linkText("Chapter" + number)).click();		
	}
	
	public boolean isButtonDisplayed(String button) {
		return selenium.findElement(By.id("button")).isDisplayed();
	}

	@Test
	public void ShouldLoadTheHomePageAndThenCheckButtonOnChapter2(){
		Chapter2 ch2 = new Chapter2(selenium).get();
		assertTrue(ch2.isButtonPresent("but1"));
	}

}
