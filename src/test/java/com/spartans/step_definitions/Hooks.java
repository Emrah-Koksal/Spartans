package com.spartans.step_definitions;

import com.spartans.utilities.*;
import io.restassured.RestAssured;
import io.cucumber.java.*;
import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        RestAssured.baseURI= ConfigurationReader.get("spartan.apiUrl");
    }

    @After
    public void tearDown(){
     Driver.closeDriver();
    }

    @Before("@db")
    public void connectDB(){
        DBUtils.createConnection();
    }
    @After("@db")
    public void closeDB(){
        DBUtils.destroy();
    }

}
