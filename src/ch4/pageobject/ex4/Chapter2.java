package ch4.pageobject.ex4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;

public class Chapter2 {

	private WebDriver selenium;
	@FindBy(how = How.NAME, using = "verifybutton")
	private WebElement verifyButton;

	public Chapter2(WebDriver selenium) {
		this.selenium = selenium;
		if (! "Chapter 2".equalsIgnoreCase(this.selenium.getTitle())){
			this.selenium.get("http://book.theautomatedtester.co.uk/chapter2");			
		}
	}
	
	public boolean isButtonPresent(String button) {
		return this.selenium.findElements(By.xpath("//input[@id='" + button + "']")).size() > 0;
	}
}
