# SauceDemo
This file contains a basic cucumber BDD incremental test framework for https://www.saucedemo.com/ 

It contains one test scenario with a background scenario
I will keep on improving it 

Execute it with maven or use below command from project folder:
mvn clean install -Denv=env_config_test "-Dcucumber.options=--tags @test" 

Tools required : a)Java 1.8 or above b)maven c)IDE 

Properties file is used to mention the url in test and should be provided in command line.
Test data is provided in Excel which is fected as Map and used
