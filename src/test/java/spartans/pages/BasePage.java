package spartans.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartans.utilities.Driver;

public abstract class BasePage {
    public BasePage(){ PageFactory.initElements(Driver.get(),this);}

    @FindBy(linkText = "/spartans")
    public WebElement web;

    @FindBy(linkText = "/swagger-ui/#/Spartan%20Controller")
    public WebElement api;

    @FindBy(linkText = "/images/Oracle_Connection_Info.jpg")
    public WebElement database;
}
