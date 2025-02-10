package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

<<<<<<< HEAD
@CucumberOptions(tags = "", features = {"src/test/resources/features/LoginPageSurya.feature"}, glue = {"com.example.definitions"},
=======
@CucumberOptions(tags = "", features = {"src/test/resources/features/Help.feature"}, glue = {"com.example.definitions"},
>>>>>>> main
        plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}