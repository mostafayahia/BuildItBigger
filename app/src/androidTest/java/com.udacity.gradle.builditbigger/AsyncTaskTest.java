package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import elmasry.gradle.exercise.androidjokelib.JokeActivity;

import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private static final String JOKE = "funny joke from JokeFromJavaLib";

        @Test
    public void verifyAfterClickTellJokeButton_JokeActivityOpenWithCorrectExtraData() {

        Intents.init();

        Espresso.onView(ViewMatchers.withId(R.id.tell_joke_button))
                .perform(ViewActions.click());

        Intents.intended(allOf(
                IntentMatchers.hasComponent(JokeActivity.class.getName()),
                IntentMatchers.hasExtra(JokeActivity.EXTRA_JOKE, JOKE)
        ));

    }

    @Test
    public void verifyAfterClickTellJokeButton_JokeActivityDisplayValidJoke() {

        Espresso.onView(ViewMatchers.withId(R.id.tell_joke_button))
                .perform(ViewActions.click());

        // checking the joke is not empty
        Espresso.onView(ViewMatchers.withId(R.id.joke_text_view))
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.withText(""))));
    }
}