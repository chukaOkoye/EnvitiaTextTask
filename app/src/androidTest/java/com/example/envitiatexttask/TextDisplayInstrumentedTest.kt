package com.example.envitiatexttask

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@RunWith(AndroidJUnit4::class)
class TextDisplayInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddTextAndClick() {
        val testText = "Hello, Instrumented Test!"

        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        Espresso.onView(ViewMatchers.withId(R.id.inputTextField))
            .perform(ViewActions.typeText(testText))

        Espresso.onView(ViewMatchers.withId(R.id.okButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.displayText))
            .check(ViewAssertions.matches(ViewMatchers.withText(containsString("[$currentTime] $testText"))))
    }

    @Test
    fun testEmptyTextAndClick() {
        val emptyText = ""

        Espresso.onView(ViewMatchers.withId(R.id.inputTextField))
            .perform(ViewActions.typeText(emptyText))

        Espresso.onView(ViewMatchers.withId(R.id.okButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.displayText))
            .check(ViewAssertions.matches(ViewMatchers.withText(emptyText)))
    }
}
