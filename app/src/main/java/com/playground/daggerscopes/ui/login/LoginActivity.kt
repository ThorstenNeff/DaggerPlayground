package com.playground.daggerscopes.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.playground.daggerscopes.MyAppClass
import com.playground.daggerscopes.R
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.ui.profile.ProfileActivity
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var tracker: Tracker

    @Inject
    lateinit var configuration: AppConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitle(this.javaClass.simpleName)
        
        val loginActivityComponent: LoginActivityComponent = DaggerLoginActivityComponent.builder()
                .applicationScopeComponent(
                        (application as MyAppClass).getAppScopeComponent())
                .build()
        loginActivityComponent.inject(this)

        tracker.track()

        Log.d(TAG,"Configuration: ${configuration.toString()}")
    }

    companion object {
        const val TAG = "daggerapp"
    }

    fun doLogin(view: View) {
        startActivity(Intent(this, ProfileActivity::class.java))
    }
}