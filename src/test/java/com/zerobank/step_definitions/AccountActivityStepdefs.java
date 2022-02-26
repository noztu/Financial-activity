package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.Dashboard;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepdefs {
    @Given("the user logs in")
    public void the_user_logs_in() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new Dashboard().signinButton.click();
        new LoginPage().login2();

    }

    @When("the page have the title Account Activity")
    public void the_page_have_the_title_Account_Activity() {
        BrowserUtils.waitFor(3);
        new AccountActivity().accountActivityButton.click();

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify title","Zero - Account Activity",actualTitle);
    }

    @Then("drop down default option should be {string}")
    public void drop_down_default_option_should_be(String expectedOption) {
        BrowserUtils.waitFor(3);
        AccountActivity accountActivity = new AccountActivity();
        Select dropdown = new Select(accountActivity.dropdownMenu);
        String actualOption = dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOption,actualOption);
    }
    @When("the user should see following options in dropdown")
    public void the_user_should_see_following_options_in_dropdown(List<String> dropdownList) {
        BrowserUtils.waitFor(3);
        List<String> actualListOfTable = new AccountActivity().accountDropdown();

        Assert.assertEquals(dropdownList, actualListOfTable);
        System.out.println("Actual table= "+ actualListOfTable);
        System.out.println("expected table= "+ dropdownList);
    }

    @Then("the user should be on the on the {string} table")
    public void the_user_should_be_on_the_on_the_table(String string) {
        BrowserUtils.waitFor(3);
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue("verify that transaction table", accountActivity.showTrans.isDisplayed());
    }
        @Then("the user should see following columns")
        public void the_user_should_see_following_columns(List<String> tableColoumn) {
            BrowserUtils.waitFor(3);
            List<String> actualListOfTable = BrowserUtils.getElementsText(new AccountActivity().tableColumn);

            Assert.assertEquals(tableColoumn, actualListOfTable);
            System.out.println("Actual table= "+ actualListOfTable);
            System.out.println("expected table= "+ tableColoumn);
        }

    }


