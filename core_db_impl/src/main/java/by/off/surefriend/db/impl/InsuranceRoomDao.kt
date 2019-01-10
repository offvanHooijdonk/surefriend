package by.off.surefriend.db.impl

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import by.off.surefriend.db.InsuranceDao
import by.off.surefriend.model.Insurance

@Dao
interface InsuranceRoomDao : InsuranceDao {
    @Query("select * from Insurance where id = :id")
    override fun get(id: String): Insurance

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun save(ins: Insurance)

    @Query("select * from Insurance order by title")
    override fun list(): Array<Insurance>
}