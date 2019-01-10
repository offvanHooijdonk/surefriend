package by.off.surefriend.di.app

import by.off.surefriend.core.di.ToolsProvider
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ToolsModule::class])
@Singleton
interface ToolsComponent : ToolsProvider {
    companion object {
        fun get(): ToolsProvider = DaggerToolsComponent.builder().build()
    }
}