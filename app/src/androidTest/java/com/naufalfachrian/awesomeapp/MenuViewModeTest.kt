package com.naufalfachrian.awesomeapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.naufalfachrian.awesomeapp.features.pexels_curated.PexelsCuratedActivity
import com.naufalfachrian.awesomeapp.utils.adapter.GridAdapter
import com.naufalfachrian.awesomeapp.utils.adapter.ListAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MenuViewModeTest {

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<PexelsCuratedActivity> = ActivityScenarioRule(PexelsCuratedActivity::class.java)

    @Test
    fun adapterReplacedOnModeGridClicked() {
        onView(withId(R.id.menu_view_mode_grid)).perform(click())
        activityScenarioRule.scenario.onActivity {
            assert(it.adapter is GridAdapter)
        }
    }

    @Test
    fun adapterReplacedOnModeListClicked() {
        onView(withId(R.id.menu_view_mode_list)).perform(click())
        activityScenarioRule.scenario.onActivity {
            assert(it.adapter is ListAdapter)
        }
    }

}
