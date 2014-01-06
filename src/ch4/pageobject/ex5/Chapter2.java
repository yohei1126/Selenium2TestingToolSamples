package ch4.pageobject.ex5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Chapter2 extends LoadableComponent<Chapter2> {

	private WebDriver selenium;
	@FindBy(how = How.NAME, using = "verifybutton")
	private WebElement verifyButton;

	public Chapter2(WebDriver selenium) {
		this.selenium = selenium;
		PageFactory.initElements(selenium, this);
	}
	
	public boolean isButtonPresent(String button) {
		return this.selenium.findElements(By.xpath("//input[@id='" + button + "']")).size() > 0;
	}

	@Override
	protected void isLoaded() throws Error {
		String url = selenium.getCurrentUrl();
		if (url != "http://book.theautomatedtester.co.uk/chapter2") {
			throw new Error("The wrong page has loaded.");
		}
	}

	@Override
	protected void load() {
		this.selenium.get("http://book.theautomatedtester.co.uk/chapter2");					
	}
}
