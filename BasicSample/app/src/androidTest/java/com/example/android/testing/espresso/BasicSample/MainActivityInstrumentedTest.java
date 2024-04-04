package com.example.android.testing.espresso.BasicSample;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    private ActivityScenario<MainActivity> activityScenario;

    @Before
    public void setup() {
        activityScenario = ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testEditText() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    @Test
    public void testOpenActivityAndChangeTextBtn() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }


    @Test
    public void testChangeTextBtnWithEmptyInput() {
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    @Test
    public void testOpenActivityAndChangeTextBtnWithEmptyInput() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testChangeTextButtonWithAbcdefInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    @Test
    public void testOpenActivityAndChangeTextButtonWithAbcdefInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")));
    }

    @Test
    public void testCorrectStringInShowTextActivityTextViewNoTextPassed() {
        ActivityScenario.launch(ShowTextActivity.class);
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testCorrectStringInShowTextActivityTextViewAfterPassingText() {
        String textToPass = "Hello from MainActivity!";
        Intent intent = ShowTextActivity.newStartIntent(ApplicationProvider.getApplicationContext(), textToPass);
        ActivityScenario.launch(intent);
        onView(withId(R.id.show_text_view)).check(matches(withText(textToPass)));
    }
}




