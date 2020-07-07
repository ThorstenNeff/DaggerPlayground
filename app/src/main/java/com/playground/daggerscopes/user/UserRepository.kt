package com.playground.daggerscopes.user

import android.util.Log
import com.playground.daggerscopes.MyAppClass
import com.playground.daggerscopes.di.UserScope
import javax.inject.Inject

@UserScope
class UserRepository @Inject constructor() {
    private val userData = UserData("Hans","Muster","hansmuster@gmail.com")

    fun fetchUser(): UserData {
        Log.d(MyAppClass.TAG, "UserRepository $this fetches user")
        return userData
    }
}