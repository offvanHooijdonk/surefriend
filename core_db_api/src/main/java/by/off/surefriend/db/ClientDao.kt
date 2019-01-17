package by.off.surefriend.db

import android.arch.lifecycle.LiveData
import by.off.surefriend.model.ClientInfo

interface ClientDao {
    fun save(client: ClientInfo)
    fun get(id: Long): LiveData<ClientInfo>
    fun list(): LiveData<Array<ClientInfo>>
}