package com.playground.daggerscopes.ui.profile

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.playground.daggerscopes.MyAppClass
import com.playground.daggerscopes.R
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.user.UserRepository
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    @Inject
    lateinit var tracker: Tracker

    @Inject
    lateinit var configuration: AppConfiguration

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setTitle(this.javaClass.simpleName)
        val profileActivityComponent: ProfileActivityComponent = DaggerProfileActivityComponent.builder()
                .userScopeComponent(
                        (application as MyAppClass).getUserScopeComponent())
                .build()
        profileActivityComponent.inject(this)

        tracker.track()

        userRepository.fetchUser()

        Log.d(TAG,"Configuration: ${configuration.toString()}")
    }

    companion object {
        const val TAG = "daggerapp"
    }

    fun logout(view: View) {
        (application as MyAppClass).resetUserScope()
        finish()
    }
}