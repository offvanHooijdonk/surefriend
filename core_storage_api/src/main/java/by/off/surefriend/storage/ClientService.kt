package by.off.surefriend.storage

import by.off.surefriend.model.ClientInfo

interface ClientService {
    suspend fun save(client: ClientInfo)
    suspend fun get(id: String): ClientInfo
    suspend fun list(): Array<ClientInfo>
}