package by.off.surefriend.db

import by.off.surefriend.model.ClientInfo

interface ClientDao {
    fun save(client: ClientInfo)
    fun get(id: String): ClientInfo
    fun list(): Array<ClientInfo>
}