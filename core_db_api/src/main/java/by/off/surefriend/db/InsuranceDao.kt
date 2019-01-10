package by.off.surefriend.db

import by.off.surefriend.model.Insurance

interface InsuranceDao {
    fun save(ins: Insurance)
    fun get(id: String): Insurance
    fun list(): Array<Insurance>
}