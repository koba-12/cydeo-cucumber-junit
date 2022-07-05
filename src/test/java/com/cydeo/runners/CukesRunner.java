package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",//html report için
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },

        features = "src/test/resources/features",//features kısmına ulaşıp orayla bağlantı kurabilmek için.bu sayede
//oradaki senaryoya ulaşabileceğiz
        glue = "com/cydeo/step_definitions",//step definitionslara ulaşabilmek için.bu sayede neleri yürüteceğimizi bileceiğiz.orada yazanları buradan runlayacağız
        dryRun = false,
        tags = "@wip",//başka taglerde eklenebilir.@wip(work in progress) hangi dosya veya dosyalar üzerinde çalışacağımız belli olsun diye
//featuredaki scenarioların üstüne de qwip veya diğer tagleri yazmalıyız
        publish = false
//buradakilerin hepsi farklı işlere yarıyor.uygulama kısmı burasıdır.
)
public class CukesRunner {
}
