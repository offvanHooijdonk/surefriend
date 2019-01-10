package by.off.surefriend.db.di

import by.off.surefriend.db.ClientDao
import by.off.surefriend.db.InsuranceDao

interface CoreDBApi {
    fun clientDao(): ClientDao

    fun insuranceDao(): InsuranceDao
}