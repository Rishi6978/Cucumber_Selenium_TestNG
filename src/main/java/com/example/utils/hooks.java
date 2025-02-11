package com.example.utils;

import com.example.pom.login;
import io.cucumber.java.After;

import static com.example.base.driver;



public class hooks {

    public login logIn;
    public  hooks(login login) {
        this.logIn = login;

    }


    @After
    public void teardown() {

        driver.quit();
    }

}
