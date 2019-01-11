package by.off.surefriend.presenter.di

import android.content.Context
import by.off.surefriend.core.di.scopes.PerScreen
import by.off.surefriend.presenter.InsuranceFragment
import by.off.surefriend.storage.di.CoreStorageApi
import dagger.Component

@Component(
    modules = [InsuranceScreenModule::class],
    dependencies = [InsuranceScreenComponent.InsuranceScreenDependencies::class]
)
@PerScreen
interface InsuranceScreenComponent {
    companion object {
        fun get(appContext: Context) = DaggerInsuranceScreenComponent
            .builder()
            .insuranceScreenDependencies((appContext as InsuranceScreenProvider).provideInsuranceScreenDependencies())
            .build()
    }

    fun inject(insuranceFragment: InsuranceFragment)

    interface InsuranceScreenDependencies : CoreStorageApi

    interface InsuranceScreenProvider {
        fun provideInsuranceScreenDependencies(): InsuranceScreenDependencies
    }
}