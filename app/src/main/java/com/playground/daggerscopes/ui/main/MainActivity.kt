package com.playground.daggerscopes.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.playground.daggerscopes.MyAppClass
import com.playground.daggerscopes.R
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.ui.login.LoginActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var animator: SplashScreenAnimator

    @Inject
    lateinit var tracker: Tracker

    @Inject
    lateinit var configuration: AppConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainActivityComponent: MainActivityComponent = DaggerMainActivityComponent.builder()
                .applicationScopeComponent(
                        (application as MyAppClass).getAppScopeComponent())
                .build()
        mainActivityComponent.inject(this)

        animator.animateSplashScreen()

        tracker.track()

        Log.d(TAG,"Configuration: ${configuration.toString()}")
        findViewById<TextView>(R.id.text_view).setText(configuration.rootUrl)
    }

    fun gotoLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    companion object {
        const val TAG = "daggerapp"
    }
}