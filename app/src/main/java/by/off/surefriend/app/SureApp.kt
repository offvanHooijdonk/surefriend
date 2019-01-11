package by.off.surefriend.app

import android.app.Application
import android.content.Context
import by.off.surefriend.di.app.AppComponent
import by.off.surefriend.presentation.di.ClientsComponent
import by.off.surefriend.presentation.di.MainComponent
import by.off.surefriend.presenter.di.InsuranceScreenComponent

class SureApp : Application(),
    MainComponent.MainComponentProvider,
    ClientsComponent.ClientsDependenciesProvider,
    InsuranceScreenComponent.InsuranceScreenProvider {


    companion object {
        private lateinit var appContext: Context
        private lateinit var component: AppComponent

        fun getApplicationContext() = appContext
    }


    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext
        component = AppComponent.component
    }

    override fun provideMainDependencies(): MainComponent.MainComponentDependencies = component


    override fun provideClientsDependencies(): ClientsComponent.ClientsComponentDependencies = component


    override fun provideInsuranceScreenDependencies(): InsuranceScreenComponent.InsuranceScreenDependencies = component

}