package by.off.surefriend.storage.di

import by.off.surefriend.core.di.scopes.PerFeature
import by.off.surefriend.storage.ClientService
import by.off.surefriend.storage.InsuranceService
import by.off.surefriend.storage.StorageService
import by.off.surefriend.storage.impl.ClientServiceImpl
import by.off.surefriend.storage.impl.InsuranceServiceImpl
import by.off.surefriend.storage.impl.StorageServiceImpl
import dagger.Binds
import dagger.Module

@Module
@PerFeature
abstract class CoreStorageModule {

    @Binds
    abstract fun provideStorageService(storageServiceImpl: StorageServiceImpl): StorageService

    @Binds
    abstract fun provideClientService(clientServiceImpl: ClientServiceImpl): ClientService

    @Binds
    abstract fun provideInsuranceService(insuranceServiceImpl: InsuranceServiceImpl): InsuranceService
}