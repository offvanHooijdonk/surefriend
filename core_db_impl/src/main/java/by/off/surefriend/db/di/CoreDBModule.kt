package by.off.surefriend.db.di

import android.content.Context
import by.off.surefriend.core.di.scopes.PerFeature
import by.off.surefriend.db.ClientDao
import by.off.surefriend.db.InsuranceDao
import by.off.surefriend.db.impl.AppDatabase
import dagger.Module
import dagger.Provides

@Module
@PerFeature
class CoreDBModule {
    @Provides
    fun provideAppDB(ctx: Context): AppDatabase = AppDatabase.buildDB(ctx)

    @Provides
    fun provideClientDao(db: AppDatabase): ClientDao = db.clientDao()

    @Provides
    fun provideInsuranceDao(db: AppDatabase): InsuranceDao = db.insuranceDao()
}