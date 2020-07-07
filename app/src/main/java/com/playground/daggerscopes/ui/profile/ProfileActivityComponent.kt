package com.playground.daggerscopes.ui.profile

import com.playground.daggerscopes.UserScopeComponent
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import com.playground.daggerscopes.appstuff.tracking.Tracker
import com.playground.daggerscopes.di.ActivityScope
import com.playground.daggerscopes.user.UserRepository
import dagger.Component

@ActivityScope
@Component(dependencies = [UserScopeComponent::class])
interface ProfileActivityComponent {
    fun getTracker(): Tracker
    fun getConfiguration(): AppConfiguration
    fun getUserRepository(): UserRepository

    fun inject(profileActivity: ProfileActivity?)
}