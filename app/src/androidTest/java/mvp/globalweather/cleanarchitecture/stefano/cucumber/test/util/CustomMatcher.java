package mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import mvp.globalweather.cleanarchitecture.stefano.model.cities.Postalcodes;

import static com.android.support.test.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.equalTo;


public class CustomMatcher {



    public static Matcher<View> withAdaptedData(final Matcher<Object> dataMatcher) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("with class name: ");
                dataMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof AdapterView)) {
                    return false;
                }
                @SuppressWarnings("rawtypes")
                Adapter adapter = ((AdapterView) view).getAdapter();
                for (int i = 0; i < adapter.getCount(); i++) {
                    if (dataMatcher.matches(adapter.getItem(i))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }




    public static Matcher<Object> withName(final String item) {
        return new BoundedMatcher<Object, Postalcodes>(Postalcodes.class) {
            @Override
            protected boolean matchesSafely(Postalcodes city) {
                return item.equals(city.getPlaceName());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with id: " + item);
            }
        };
    }


}