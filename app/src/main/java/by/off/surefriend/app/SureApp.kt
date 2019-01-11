package by.off.surefriend.app

import android.app.Application
import android.content.Context
import by.off.surefriend.di.app.AppComponent
import by.off.surefriend.presentation.di.ClientsComponent
import by.off.surefriend.presentation.di.MainComponent

class SureApp : Application(),
    MainComponent.MainComponentProvider,
    ClientsComponent.ClientsDependenciesProvider {

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

    override fun provideMainDependencies(): MainComponent.MainComponentDependencies {
        return component
    }

    override fun provideClientsDependencies(): ClientsComponent.ClientsComponentDependencies {
        return component
    }
}