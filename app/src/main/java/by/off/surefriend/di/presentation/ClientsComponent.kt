package by.off.surefriend.di.presentation

import by.off.surefriend.app.SureApp
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presentation.ClientsFragment
import by.off.surefriend.storage.di.CoreStorageApi
import dagger.Component

@Component(modules = [ClientModule::class], dependencies = [CoreStorageApi::class])
@PerScreen
interface ClientsComponent {
    companion object {
        fun get() = DaggerClientsComponent.builder().coreStorageApi(SureApp.getComponent()).build()
    }
    fun inject(clientsFragment: ClientsFragment)
}