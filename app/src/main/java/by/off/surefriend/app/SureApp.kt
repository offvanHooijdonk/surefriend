package by.off.surefriend.app

import android.app.Application
import android.content.Context
import by.off.surefriend.di.app.AppComponent

class SureApp : Application() {
    companion object {
        private lateinit var appContext: Context
        private lateinit var component: AppComponent

        fun getApplicationContext() = appContext
        fun getComponent() = component
    }

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
        component = AppComponent.component
    }
}