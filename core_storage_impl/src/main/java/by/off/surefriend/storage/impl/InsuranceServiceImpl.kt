package by.off.surefriend.storage.impl

import by.off.surefriend.db.InsuranceDao
import by.off.surefriend.model.Insurance
import by.off.surefriend.storage.InsuranceService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class InsuranceServiceImpl @Inject constructor(private val insuranceDao: InsuranceDao): InsuranceService {
    override suspend fun save(ins: Insurance) {
        CoroutineScope(EmptyCoroutineContext).async {
            insuranceDao.save(ins)
        }.await()
    }

    override suspend fun get(id: String): Insurance = CoroutineScope(EmptyCoroutineContext).async { insuranceDao.get(id) }.await()

    override suspend fun list(): Array<Insurance> = CoroutineScope(EmptyCoroutineContext).async { insuranceDao.list() }.await()
}