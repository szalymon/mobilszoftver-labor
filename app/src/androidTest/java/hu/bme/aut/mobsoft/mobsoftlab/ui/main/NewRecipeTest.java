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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import hu.bme.aut.mobsoft.mobsoftlab.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewRecipeTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void newRecipeTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.left_drawer),
                                withParent(withId(R.id.drawer_layout))),
                        0),
                        isDisplayed()));
        relativeLayout.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.name), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.name), isDisplayed()));
        appCompatEditText2.perform(replaceText("radish"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.description), isDisplayed()));
        appCompatEditText3.perform(replaceText("peo"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.bitterhop), isDisplayed()));
        appCompatEditText4.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.bitterhop), withText("5"), isDisplayed()));
        appCompatEditText5.perform(pressImeActionButton());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.flavour), isDisplayed()));
        appCompatEditText6.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.flavour), withText("5"), isDisplayed()));
        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.water), isDisplayed()));
        appCompatEditText8.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.water), withText("5"), isDisplayed()));
        appCompatEditText9.perform(pressImeActionButton());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.malt), isDisplayed()));
        appCompatEditText10.perform(replaceText("5"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.malt), withText("5"), isDisplayed()));
        appCompatEditText11.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.save), withText("Mentés"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("MobSoftLab"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.container_toolbar)))),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction relativeLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.left_drawer),
                                withParent(withId(R.id.drawer_layout))),
                        1),
                        isDisplayed()));
        relativeLayout2.perform(click());

        ViewInteraction relativeLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recipe_list_view),
                                withParent(withId(R.id.drawer_layout))),
                        4),
                        isDisplayed()));
        relativeLayout3.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.recipe_detail_title), withText("radish"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("radish")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.recipe_detail_description), withText("peo"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("peo")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.recipe_detail_bitterhop), withText("Keserű komló: 5.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Keserű komló: 5.0")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.recipe_detail_aromahop), withText("Aroma komló: 5.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                3),
                        isDisplayed()));
        textView4.check(matches(withText("Aroma komló: 5.0")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.recipe_detail_water), withText("Víz: 5.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                4),
                        isDisplayed()));
        textView5.check(matches(withText("Víz: 5.0")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.recipe_detail_malt), withText("Maláta: 5.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                5),
                        isDisplayed()));
        textView6.check(matches(withText("Maláta: 5.0")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.recipe_detail_malt), withText("Maláta: 5.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                        0),
                                5),
                        isDisplayed()));
        textView7.check(matches(withText("Maláta: 5.0")));

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
