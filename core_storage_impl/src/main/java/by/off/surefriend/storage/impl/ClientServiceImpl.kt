package by.off.surefriend.storage.impl

import android.arch.lifecycle.LiveData
import android.util.Log
import by.off.surefriend.core.LOGCAT
import by.off.surefriend.db.ClientDao
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.storage.ClientService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class ClientServiceImpl @Inject constructor(private val clientDao: ClientDao) : ClientService {
    override suspend fun save(client: ClientInfo) {
        CoroutineScope(EmptyCoroutineContext).async {
            clientDao.save(client)
        }.await()
    }

    override suspend fun get(id: Long): LiveData<ClientInfo> = coroutineScope {
        Log.i(LOGCAT, "Call for a client with ID=$id")
        this.async(Dispatchers.IO) {
            clientDao.get(id)
        }.await()
    }

    override suspend fun list(): LiveData<Array<ClientInfo>> = coroutineScope {
        this.async(Dispatchers.IO) {
            Log.i(LOGCAT, "Load clientsø")
            clientDao.list()
        }.await()
    }

}