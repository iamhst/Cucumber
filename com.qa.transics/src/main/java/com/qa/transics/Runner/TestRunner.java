package com.qa.transics.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;


	@RunWith(Cucumber.class)
	@io.cucumber.junit.CucumberOptions(
			features = "/U:/Cucumber/com.qa.transics/src/main/java/com/qa/transics/Features/login.feature", //the path of the feature files
			glue={"com.qa.transics.StepDefinitions"}, //the path of the step definition files
			plugin={"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"})
public class TestRunner {

}
