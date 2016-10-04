package mvp.globalweather.cleanarchitecture.stefano.cucumber.test.util;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.view.View;

import junit.framework.AssertionFailedError;

    public class PollingTimeoutIdler implements IdlingResource {

        private final ViewAssertion mViewAssertion;
        private final long mTimeout;
        private final long mStartTime;
        private ResourceCallback mCallback;
        private volatile View mTestView;

        public PollingTimeoutIdler(ViewInteraction viewInteraction, ViewAssertion viewAssertion, long timeout) {
            mViewAssertion = viewAssertion;
            mTimeout = timeout;
            mStartTime = System.currentTimeMillis();

            viewInteraction.check(new ViewAssertion() {
                @Override
                public void check(View view, NoMatchingViewException noViewFoundException) {
                    mTestView = view;
                }
            });
        }

        @Override
        public String getName() {
            return getClass().getSimpleName();
        }

        @Override
        public boolean isIdleNow() {

            long elapsed = System.currentTimeMillis() - mStartTime;
            boolean timedOut = elapsed >= mTimeout;

            boolean idle = testView() || timedOut;
            if(idle) {
                mCallback.onTransitionToIdle();
            }

            return idle;
        }

        private boolean testView() {

            if(mTestView != null) {
                try {
                    mViewAssertion.check(mTestView, null);
                    return true;
                }
                catch(AssertionFailedError ex) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        @Override
        public void registerIdleTransitionCallback(ResourceCallback callback) {
            mCallback = callback;
        }

}
