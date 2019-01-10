package by.off.surefriend.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Insurance(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String,
    val desc: String?,
    val price: Int // TODO make a converter for BigDecimal
)
