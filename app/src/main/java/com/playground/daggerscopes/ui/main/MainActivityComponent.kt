package com.playground.daggerscopes.ui.main

import com.playground.daggerscopes.ApplicationScopeComponent
import com.playground.daggerscopes.di.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationScopeComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity?)
}