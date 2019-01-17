package by.off.surefriend.storage

import android.arch.lifecycle.LiveData
import by.off.surefriend.model.ClientInfo

interface ClientService {
    suspend fun save(client: ClientInfo)
    suspend fun get(id: Long): LiveData<ClientInfo>
    suspend fun list(): LiveData<Array<ClientInfo>>
}