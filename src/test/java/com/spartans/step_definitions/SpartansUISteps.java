package com.spartans.step_definitions;

import com.spartans.pages.Spartan_Web;
import com.spartans.pages.Spartan_view_page;
import com.spartans.utilities.ConfigurationReader;
import com.spartans.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SpartansUISteps {

    public static String UI_name;

    @Given("Commander is at the main page")
    public void commander_is_at_the_main_page() {
        Driver.get().get(ConfigurationReader.get("spartan.webUrl"));
    }

    @When("Commander clicks on the view button with the Spartan ID number {string}")
    public void commander_clicks_on_the_view_button_with_the_spartan_id_number(String str) {

        new Spartan_Web().viewSpartan(str).click();
        UI_name = new Spartan_view_page().name.getAttribute("value");
        System.out.println(UI_name);

    }

    @Then("Verifies the name of Spartan is {string}")
    public void verifies_the_name_of_spartan_is(String expectedname) {
        String actualname = UI_name;
        Assert.assertEquals("Name does not match", expectedname, actualname);
        System.out.println("actualname = " + actualname);
    }

}
