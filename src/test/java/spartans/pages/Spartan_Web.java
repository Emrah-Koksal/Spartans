package spartans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spartans.utilities.Driver;

public class Spartan_Web extends BasePage {

    @FindBy(id="add_spartan_btn")
    public WebElement addSpartanButton;

    @FindBy(id="back_to_home_btn")
    public WebElement backToHome;

    @FindBy (id="total")
    public WebElement totalCount;

    public WebElement viewSpartan(String id){

        return Driver.get().findElement(By.xpath("//tbody//tr//td//a[@id=\"view_spartan_"+id+"\"]"));
    }


    public void addSpartan(String name, String Gender, Long phone) {


    }
}
