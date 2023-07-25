package com.spartans.step_definitions;

import com.spartans.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static io.restassured.RestAssured.*;


public class SpartansAPI_practice {
    Response response;

    @When("Send A Get Request with the id of {int}")

    public void send_a_get_request_with_the_id_of(Integer int1) {
        response = given().accept(ContentType.JSON)
                .get("/api/spartans/");

        response.prettyPrint();

    }

    @Then("Assert response body")
    public void assert_response_body() {
        Assert.assertEquals("response status code does not match",200, response.statusCode());
        Assert.assertEquals("application/json", response.getContentType());

    }
}
