package com.playground.daggerscopes.ui.login

import com.playground.daggerscopes.ApplicationScopeComponent
import com.playground.daggerscopes.di.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationScopeComponent::class])
interface LoginActivityComponent {
    fun inject(loginActivity: LoginActivity?)
}