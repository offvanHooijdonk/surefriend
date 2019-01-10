package by.off.surefriend.storage.impl

import by.off.surefriend.db.ClientDao
import by.off.surefriend.db.InsuranceDao
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.model.Insurance
import by.off.surefriend.storage.StorageService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import java.math.BigDecimal
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random

class StorageServiceImpl @Inject constructor(private val clientDao: ClientDao, private val insDao: InsuranceDao) : StorageService {

    override suspend fun initTestData() {
        val random = Random(1)

        CoroutineScope(EmptyCoroutineContext).async {
            for (i in 1..7)
                clientDao.save(ClientInfo(null, "John Doe ${random.nextInt(0, 100)}", random.nextInt(18, 70)))

            for (i in 1..4)
                insDao.save(Insurance(null, "An Insurance offer ${random.nextInt(1, 500)}", null, random.nextInt(50, 299)))
        }.await()
    }
}