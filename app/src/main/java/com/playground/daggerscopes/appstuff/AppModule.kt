package com.playground.daggerscopes.appstuff

import android.content.Context
import com.playground.daggerscopes.MyAppClass
import com.playground.daggerscopes.appstuff.configuration.AppConfiguration
import dagger.Module
import dagger.Provides

@Module
class AppModule(val myApp: MyAppClass?) {

    @Provides
    fun providesMyApp(): MyAppClass? {
        return myApp
    }

    @Provides
    fun providesApplicationContext(): Context? {
        return myApp?.getApplicationContext()
    }

    @Provides
    fun provideConfiguration(): AppConfiguration
            = AppConfiguration("a", "http://tk.de")
}