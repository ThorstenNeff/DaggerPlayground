package com.playground.daggerscopes

import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.di.UserScope
import com.playground.daggerscopes.user.UserRepository
import dagger.Component

@UserScope
@Component(dependencies = [ApplicationScopeComponent::class])
interface UserScopeComponent {
    fun getTracker(): Tracker
    fun getConfiguration(): AppConfiguration
    fun userRepository(): UserRepository
}