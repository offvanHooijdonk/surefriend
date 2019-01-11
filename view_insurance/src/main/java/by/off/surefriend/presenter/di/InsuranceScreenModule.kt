package by.off.surefriend.presenter.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import by.off.surefriend.core.di.ViewModelFactory
import by.off.surefriend.core.di.ViewModelKey
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presenter.InsuranceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@PerScreen
abstract class InsuranceScreenModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(InsuranceViewModel::class)
    internal abstract fun postListViewModel(viewModel: InsuranceViewModel): ViewModel
}