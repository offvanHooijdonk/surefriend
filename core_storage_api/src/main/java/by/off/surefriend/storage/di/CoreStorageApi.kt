package by.off.surefriend.storage.di

import by.off.surefriend.storage.ClientService
import by.off.surefriend.storage.InsuranceService
import by.off.surefriend.storage.StorageService

interface CoreStorageApi {
    fun storageService(): StorageService
    fun clientService(): ClientService
    fun insuranceService(): InsuranceService
}