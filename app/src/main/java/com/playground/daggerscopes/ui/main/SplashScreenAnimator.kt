package com.playground.daggerscopes.ui.main

import android.util.Log
import com.playground.daggerscopes.MyAppClass.Companion.TAG
import com.playground.daggerscopes.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class SplashScreenAnimator @Inject constructor() {

    fun animateSplashScreen() {
        Log.d(TAG, "SplashScreenAnimator $this animates")
    }
}