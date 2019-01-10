package by.off.surefriend.db.impl

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import by.off.surefriend.db.ClientDao
import by.off.surefriend.model.ClientInfo

@Dao
interface ClientRoomDao : ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(client: ClientInfo)

    @Query("select * from ClientInfo where id = :id")
    override fun get(id: String): ClientInfo

    @Query("select * from ClientInfo order by fullName")
    override fun list(): Array<ClientInfo>
}