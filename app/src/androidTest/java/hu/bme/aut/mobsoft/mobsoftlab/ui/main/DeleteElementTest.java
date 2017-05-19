package hu.bme.aut.mobsoft.mobsoftlab.ui.main;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import hu.bme.aut.mobsoft.mobsoftlab.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DeleteElementTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void deleteElementTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.left_drawer),
                                withParent(withId(R.id.drawer_layout))),
                        1),
                        isDisplayed()));
        relativeLayout.perform(click());

        ViewInteraction relativeLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recipe_list_view),
                                withParent(withId(R.id.drawer_layout))),
                        1),
                        isDisplayed()));
        relativeLayout2.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.detail_delete), withText("Törlés"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction relativeLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.left_drawer),
                                withParent(withId(R.id.drawer_layout))),
                        1),
                        isDisplayed()));
        relativeLayout3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.recipe_list_item_title), withText("Stout"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Stout")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.recipe_list_item_description), withText("It's a wounderful description"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("It's a wounderful description")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.recipe_list_item_title), withText("Pilsner"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Pilsner")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.recipe_list_item_description), withText("It's a wounderful description"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        1),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("It's a wounderful description")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.recipe_list_item_title), withText("Some kind of Lager"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        2),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Some kind of Lager")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.recipe_list_item_description), withText("It's a wounderful description"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recipe_list_view),
                                        2),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("It's a wounderful description")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
