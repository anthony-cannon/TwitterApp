package com.amc.twitterapp.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.amc.twitterapp.util.AndroidTestUtil.postLatestStatusesResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


/**
 * This class was created by Anthony M Cannon on 27/08/2018.
 */
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Mock
    private lateinit var viewModel: MainViewModel

    private lateinit var fragment: MainFragment

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        `when`(viewModel.getList()).thenReturn(postLatestStatusesResponse())

        fragment = activityRule.activity.fragment as MainFragment

        fragment.viewModel = viewModel
    }

    @Test
    fun recyclerView_CorrectItems() {
        onView(withText("Mon Aug 20 15:51:15 +0000 2018")).check(matches(isDisplayed()))
        onView(withText("Thu Jul 26 10:50:19 +0000 2018")).check(matches(isDisplayed()))
    }
}