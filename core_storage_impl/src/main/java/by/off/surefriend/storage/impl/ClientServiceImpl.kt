package by.off.surefriend.storage.impl

import android.util.Log
import by.off.surefriend.db.ClientDao
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.storage.ClientService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class ClientServiceImpl @Inject constructor(private val clientDao: ClientDao) : ClientService {
    override suspend fun save(client: ClientInfo) {
        CoroutineScope(EmptyCoroutineContext).async {
            clientDao.save(client)
        }.await()
    }

    override suspend fun get(id: String): ClientInfo =
        CoroutineScope(EmptyCoroutineContext).async { clientDao.get(id) }.await()

    override suspend fun list(): Array<ClientInfo> =
        CoroutineScope(EmptyCoroutineContext).async {
            Log.i("SFR", "async ${Thread.currentThread().name}")
            clientDao.list()
        }.await()

}