package by.off.surefriend.presentation.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import by.off.surefriend.core.di.ViewModelFactory
import by.off.surefriend.core.di.ViewModelKey
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presentation.clients.ClientInfoViewModel
import by.off.surefriend.presentation.clients.ClientsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@PerScreen
abstract class ClientsModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ClientsViewModel::class)
    internal abstract fun postListViewModel(viewModel: ClientsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ClientInfoViewModel::class)
    internal abstract fun postClientInfoViewModel(viewModel: ClientInfoViewModel): ViewModel

}