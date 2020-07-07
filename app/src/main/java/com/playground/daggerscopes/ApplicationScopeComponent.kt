package com.playground.daggerscopes

import com.playground.daggerscopes.appstuff.AppModule
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.di.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface ApplicationScopeComponent {
    fun getTracker(): Tracker
    fun getConfiguration(): AppConfiguration
}
