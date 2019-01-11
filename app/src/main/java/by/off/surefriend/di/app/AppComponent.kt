package by.off.surefriend.di.app

import by.off.surefriend.db.di.CoreDBComponent
import by.off.surefriend.presentation.di.ClientsComponent
import by.off.surefriend.presentation.di.MainComponent
import by.off.surefriend.storage.di.CoreStorageApi
import by.off.surefriend.storage.di.CoreStorageComponent
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class], dependencies = [CoreStorageApi::class])
@Singleton
interface AppComponent : MainComponent.MainComponentDependencies, ClientsComponent.ClientsComponentDependencies {

    companion object {
        val component: AppComponent by lazy { create() }

        private fun create(): AppComponent = DaggerAppComponent.builder()
            .coreStorageApi(
                CoreStorageComponent
                    .get(CoreDBComponent.get(ToolsComponent.get()))
            )
            .build()
    }

    //fun clientsCompoent(): ClientsComponent
}