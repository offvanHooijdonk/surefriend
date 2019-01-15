package by.off.surefriend.presentation.di

import android.content.Context
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presentation.clients.ClientInfoFragment
import by.off.surefriend.presentation.clients.ClientsFragment
import by.off.surefriend.presentation.clients.ClientsViewModel
import by.off.surefriend.storage.di.CoreStorageApi
import dagger.Component

@Component(modules = [ClientsModule::class], dependencies = [ClientsComponent.ClientsComponentDependencies::class])
@PerScreen
interface ClientsComponent {
    companion object {
        fun get(appContext: Context) = DaggerClientsComponent
            .builder()
            .clientsComponentDependencies((appContext as ClientsDependenciesProvider).provideClientsDependencies())
            .build()
    }
    fun inject(clientsFragment: ClientsFragment)

    fun inject(clientInfoFragment: ClientInfoFragment)

    interface ClientsComponentDependencies : CoreStorageApi

    interface ClientsDependenciesProvider {
        fun provideClientsDependencies(): ClientsComponentDependencies
    }
}