package by.off.surefriend.presentation.di

import android.content.Context
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presentation.main.MainActivity
import by.off.surefriend.storage.di.CoreStorageApi
import dagger.Component

@Component(dependencies = [MainComponent.MainComponentDependencies::class])
@PerScreen
interface MainComponent {
    companion object {
        fun get(appContext: Context): MainComponent =
            DaggerMainComponent
                .builder()
                .mainComponentDependencies((appContext as MainComponentProvider).provideMainDependencies())
                .build()
    }
    fun inject(mainActivity: MainActivity)

    interface MainComponentDependencies : CoreStorageApi

    interface MainComponentProvider {
        fun provideMainDependencies(): MainComponentDependencies
    }
}