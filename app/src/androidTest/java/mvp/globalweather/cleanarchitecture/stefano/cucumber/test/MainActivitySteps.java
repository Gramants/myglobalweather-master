package mvp.globalweather.cleanarchitecture.stefano.cucumber.test;

import android.database.sqlite.SQLiteCursor;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mvp.globalweather.cleanarchitecture.stefano.MainActivity;
import mvp.globalweather.cleanarchitecture.stefano.R;

import mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util.PollingTimeoutIdler;
import mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util.ViewActions;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.android.support.test.deps.guava.base.Preconditions.checkNotNull;
import static mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util.CustomMatcher.withAdaptedData;
import static mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util.CustomMatcher.withName;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.StringStartsWith.startsWith;


@CucumberOptions(features = "features",tags = "@go")
public class MainActivitySteps extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivitySteps() {
        super(MainActivity.class);

    }

    @Given("^I am on the main page$")
    public void I_have_a_MainActivity() {
        assertNotNull(getActivity());
    }

    @When("^I click on GPS icon$")
    public void I_press_button_GPS() {
                onView(withId(R.id.currentlocation)).perform(click());
        }

    @When("^I type \"([^\"]*)\" in the search field$")
    public void i_type_string(String typed) {

        onView(withId(R.id.search))
                .check(matches(isDisplayed()))
                .perform(typeText(typed), closeSoftKeyboard());
         waitInMillisecondsForAppToBeIdle(onView(withId(R.id.citylist)), matches(isDisplayed()), 1000);
    }

    @And("^I click on \"([^\"]*)\" in the list$")
    public void i_click_on_my_item(String item) {
        onView(withId(R.id.citylist)).check(matches(withAdaptedData(withName(item)))).perform(click());
        //
    }


    @Then("^I should see \"([^\"]*)\" on the display$")
    public void i_should_see_on_the_display(final String match) {
        waitInMillisecondsForAppToBeIdle(onView(withId(R.id.location_name)), matches(isDisplayed()), 2000);
        onView(withId(R.id.location_name)).check(matches(withText(match)));

    }

    public static void waitInMillisecondsForAppToBeIdle(ViewInteraction viewInteraction, ViewAssertion viewAssertion, long timeout) {
        PollingTimeoutIdler idler = new PollingTimeoutIdler(viewInteraction, viewAssertion, timeout);
        Espresso.registerIdlingResources(idler);
        viewInteraction.check(viewAssertion);
        Espresso.unregisterIdlingResources(idler);
    }



}
