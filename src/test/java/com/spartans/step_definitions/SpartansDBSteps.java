package com.spartans.step_definitions;

import com.spartans.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SpartansDBSteps {

    String query;
    Map<String, Object> row;
    public static String DBname;

    @When("User gets info of the Spartan with id of {int}")
    public void user_gets_info_of_the_spartan_with_id_of(Integer int1) {
        query = "select * from spartans where spartan_id=" + int1;
        row = DBUtils.getRowMap(query);
        DBname = (String) row.get("NAME");
    }

    @Then("Spartan name should be {string}")
    public void spartan_name_should_be(String expectedName) {

        String actualName=DBname;
        Assert.assertEquals("Name doesn't match with DB",expectedName,actualName);
        String query2="select * from spartans";
        List<Map<String, Object>> column= DBUtils.getQueryResultMap(query2);
        System.out.println("column.get(2) = " + column.get(2));

        List<String> sutun = DBUtils.getColumnNames(query2);

        System.out.println("sutun.get(4) = " + sutun.get(2));

    }

    @Then("Spartan name should be {string}, gender should be {string}, and phone number should be {string}")
    public void spartan_name_should_be_gender_should_be_and_phone_number_should_be(String expectedName, String expectedGender, String expectedPhone) {

        String actualName=(String) row.get("NAME");
        String actualGender=(String) row.get("GENDER");
        String actualPhone=(String) row.get("PHONE");

        Assert.assertEquals("Name doesn't match with DB", expectedName,actualName);
        Assert.assertEquals("Gender doesn't match with DB", expectedGender,actualGender);
        Assert.assertEquals("Name doesn't match with DB", expectedPhone,actualPhone);

        System.out.println(row.toString());
    }



    @Then("Spartan {string}, {string} and {string} number should fit with the following data")
    public void spartan_and_number_should_fit_with_the_following_data(String expectedName, String expectedGender, String expectedPhone) {

        String actualName=(String) row.get("NAME");
        String actualGender=(String) row.get("GENDER");
        String actualPhone=(String) row.get("PHONE");

        Assert.assertEquals("Name doesn't match with DB", expectedName,actualName);
        Assert.assertEquals("Gender doesn't match with DB", expectedGender,actualGender);
        Assert.assertEquals("Name doesn't match with DB", expectedPhone,actualPhone);
    }



}
