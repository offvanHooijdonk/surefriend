package by.off.surefriend.di.app

import android.content.Context
import by.off.surefriend.app.SureApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class ToolsModule {
    @Provides
    fun provideAppContext(): Context = SureApp.getApplicationContext()
}