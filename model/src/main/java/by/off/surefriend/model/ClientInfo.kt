package by.off.surefriend.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class ClientInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val fullName: String,
    var age: Int
)