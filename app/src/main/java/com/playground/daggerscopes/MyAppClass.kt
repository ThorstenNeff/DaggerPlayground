package com.playground.daggerscopes

import android.app.Application
import com.playground.daggerscopes.appstuff.AppModule

class MyAppClass: Application() {

    private var appScopeComponent: ApplicationScopeComponent? = null
    private var userScopeComponent: UserScopeComponent? = null

    fun getAppScopeComponent(): ApplicationScopeComponent? {
        if (appScopeComponent == null) {
            appScopeComponent = DaggerApplicationScopeComponent.builder()
                    .appModule(AppModule(this))
                    .build()
        }
        return appScopeComponent
    }

    fun getUserScopeComponent(): UserScopeComponent? {
        if (userScopeComponent == null) {
            userScopeComponent = DaggerUserScopeComponent.builder()
                    .applicationScopeComponent(getAppScopeComponent())
                    .build()
        }
        return userScopeComponent
    }

    fun resetUserScope() {
        userScopeComponent = null
    }

    companion object {
        const val TAG = "daggerapp"
    }
}