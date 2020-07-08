package com.playground.daggerscopes.appstuff.configuration

import com.playground.daggerscopes.di.ApplicationScope

@ApplicationScope
class AppConfiguration(val secret: String, val rootUrl: String)