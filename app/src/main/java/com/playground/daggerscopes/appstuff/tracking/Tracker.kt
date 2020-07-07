package com.playground.daggerscopes.appstuff.tracking

import android.util.Log
import com.playground.daggerscopes.MyAppClass.Companion.TAG
import com.playground.daggerscopes.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class Tracker @Inject constructor(){
    fun track() {
        Log.d(TAG, "Tracker $this tracks")
    }
}