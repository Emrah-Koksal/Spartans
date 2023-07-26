package com.spartans.step_definitions;

import com.google.gson.Gson;
import com.spartans.pages.Spartans_POJO_2;
import com.spartans.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.cucumber.java.en.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class SpartansAPI_practice {
    Response response;
    String actualName;
    Integer actualspartanId;

    @When("Send A Get Request with the id of {int}")

    public void send_a_get_request_with_the_id_of(Integer int1) {
        response = given().accept(ContentType.JSON)
                .pathParam("id", int1)
                .get("/api/spartans/{id}");


        Map<String,Object> map = response.body().as(Map.class);
        Object actualName2=map.get("name");
        Assert.assertEquals("name does not match","Mikey2",actualName2);


        Spartans_POJO_2 spartans_pojo_2=response.body().as(Spartans_POJO_2.class);
        System.out.println(spartans_pojo_2.toString());
        Assert.assertEquals("Mikey2", spartans_pojo_2.getName());



        Gson gson=new Gson();

        String spartan101="{\n" +
                "    \"id\": 10,\n" +
                "    \"name\": \"Lorenza\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 3312820936\n" +
                "}";

        Spartans_POJO_2 pojo2=gson.fromJson(spartan101,Spartans_POJO_2.class);
        Assert.assertEquals("Lorenza", pojo2.getName());

        String newjson=gson.toJson(pojo2);
        System.out.println("newjson = " + newjson);


        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        actualName = jsonPath.getString("name");
        System.out.println(actualName);

        actualspartanId=jsonPath.getInt("id");
        Assert.assertEquals(int1, actualspartanId);


    }

    @Then("Assert response body {string}")
    public void assert_response_body(String expectedName) {
        Assert.assertEquals("response status code does not match", 200, response.statusCode());
        Assert.assertEquals("application/json", response.getContentType());
        Assert.assertEquals(expectedName, actualName);

    }

    @Then("Check with HamcrestMatchers")
    public void check_with_hamcrest_matchers() {

        given().accept(ContentType.JSON)
                .and().pathParam("id",10)
                .get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", Matchers.equalTo(10), "name", Matchers.equalTo("Lorenza"), "gender",Matchers.equalTo("Female"));



    }
}
