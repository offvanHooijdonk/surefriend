package by.off.surefriend.di.presentation

import by.off.surefriend.app.SureApp
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presentation.MainActivity
import by.off.surefriend.storage.di.CoreStorageApi
import dagger.Component

@Component(dependencies = [CoreStorageApi::class])
@PerScreen
interface MainComponent {
    companion object {
        fun get(): MainComponent = DaggerMainComponent.builder().coreStorageApi(SureApp.getComponent()).build()
    }
    fun inject(mainActivity: MainActivity)
}