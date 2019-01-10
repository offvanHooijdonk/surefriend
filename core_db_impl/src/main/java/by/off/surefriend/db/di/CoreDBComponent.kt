package by.off.surefriend.db.di

import by.off.surefriend.core.di.ToolsProvider
import by.off.surefriend.core.di.scopes.PerFeature
import dagger.Component

@Component(modules = [CoreDBModule::class], dependencies = [ToolsProvider::class])
@PerFeature
interface CoreDBComponent : CoreDBApi {
    companion object {
        fun get(toolsProvider: ToolsProvider): CoreDBComponent = DaggerCoreDBComponent
            .builder()
            .toolsProvider(toolsProvider)
            .build()
    }
}
