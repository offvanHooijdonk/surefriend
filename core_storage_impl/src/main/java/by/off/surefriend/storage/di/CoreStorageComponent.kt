package by.off.surefriend.storage.di

import by.off.surefriend.core.di.scopes.PerFeature
import by.off.surefriend.db.di.CoreDBApi
import dagger.Component

@Component(modules = [CoreStorageModule::class], dependencies = [CoreDBApi::class])
@PerFeature
abstract class CoreStorageComponent : CoreStorageApi {
    companion object {
        fun get(coreDBApi: CoreDBApi): CoreStorageComponent =
            DaggerCoreStorageComponent.builder().coreDBApi(coreDBApi).build()
    }

}

