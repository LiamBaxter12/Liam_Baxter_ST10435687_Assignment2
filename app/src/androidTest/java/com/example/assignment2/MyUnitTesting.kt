@file:Suppress("SameParameterValue", "DEPRECATION")

package com.example.assignment2

import android.widget.ProgressBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class GameTest {

    @get:Rule
    val activityRule = ActivityTestRule(Game::class.java)

    @Before
    fun setUp() {
        // Reset progress bars to initial state before each test
        resetProgressBars()
    }

    @Test
    fun testFeedButton() {
        onView(withId(R.id.feed)).perform(click())
        onView(withId(R.id.hungerBar)).check(matches(withProgress(5)))
    }

    @Test
    fun testCleanButton() {
        onView(withId(R.id.clean)).perform(click())
        onView(withId(R.id.cleanBar)).check(matches(withProgress(5)))
    }

    @Test
    fun testPlayButton() {
        onView(withId(R.id.plays)).perform(click())
        onView(withId(R.id.happyBar)).check(matches(withProgress(5)))
    }

    private fun withProgress(expectedProgress: Int): Matcher<Any> {
        return object : TypeSafeMatcher<Any>() {
            override fun describeTo(description: Description?) {
                description?.appendText("with progress: $expectedProgress")
            }

            override fun matchesSafely(item: Any?): Boolean {
                if (item !is ProgressBar) return false
                return item.progress == expectedProgress
            }
        }
    }
}

private fun resetProgressBars() {
    TODO("Not yet implemented")
}
