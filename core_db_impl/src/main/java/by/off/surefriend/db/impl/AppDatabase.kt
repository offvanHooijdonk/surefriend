package by.off.surefriend.db.impl

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.model.Insurance

@Database(entities = [ClientInfo::class, Insurance::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "sure-friend-db-0.01"
        fun buildDB(ctx: Context) = Room.databaseBuilder(ctx, AppDatabase::class.java, DB_NAME).build()
    }

    abstract fun clientDao(): ClientRoomDao

    abstract fun insuranceDao(): InsuranceRoomDao
}

