package by.off.surefriend.presenter

import android.arch.lifecycle.ViewModel
import by.off.surefriend.storage.InsuranceService
import javax.inject.Inject

class InsuranceViewModel @Inject constructor(private val insuranceService: InsuranceService) : ViewModel() {
    suspend fun get() = insuranceService.list()
}
