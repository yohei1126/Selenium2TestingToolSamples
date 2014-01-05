package ch4.pageobject.ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver selenium;

	public HomePage(WebDriver selenium) {
		this.selenium = selenium;
	}
	
	public Chapter2 clickChapter2() {
		clickChapter("2");
		return new Chapter2(selenium);
	}

	private void clickChapter(String number) {
		selenium.findElement(By.linkText("Chapter" + number)).click();		
	}
}
