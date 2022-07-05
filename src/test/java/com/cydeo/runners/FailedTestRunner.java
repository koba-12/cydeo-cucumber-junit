package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cydeo/step_definitions",
        features = "@target/rerun.txt"//rerun çalıştırmak için burası.oradan reportları da görüyoruz.(sadece failed testler)
//hatalı dosyaları ayrı şekilde görüp kalabalık test topluluğunda kolayca bulup işlem yapabilmek için.
)
public class FailedTestRunner {
}
