package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();//pagei bağladık

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");//sayfaya gittik
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikiSearchPage.searchBox.sendKeys(string);
//pagesten bulduğumuz searchBoxa burada istediğimizi yazdırdık.(scenarioda string içinde ne varsa odur.)
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikiSearchPage.searchButton.click();
//pageste bulduğumuz searchButtona tıklattık
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        //verify actual title contains string (coming from feature file)
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));//scenariodaki "" içini içerir mi?
//title istenen mi diye check ettik.
    }

        @Then("User sees {string} is in the main header")//string kullanacğız artık burası için hep.aşağıda argument yazmayı unutmayalım.DİKKAT!
    public void userSeesSteveJobsIsInTheMainHeader(String string) {

        Assert.assertTrue(wikiSearchPage.mainHeader.isDisplayed());

        Assert.assertTrue(wikiSearchPage.mainHeader.getText().equals(string));//stringi yani scenarioda "" içindekini içerir mi?
//bu üsttekilerden farklı olarak, başka bir scenarionun theni ama diğer istenenler aynı olduğu(ve string kullandığımız için
//o scenarionun stringinde ne varsa o kullanıldı ayrı ayrı olarak yani karışıklık çıkmadı.) için sadece then yazmamız yeter.
//burada öncekinin theninden farklı olarak main header istenmekte.pageste bulduğumuz main headerı burada check ettik.
    }
}
