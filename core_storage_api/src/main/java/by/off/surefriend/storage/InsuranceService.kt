package by.off.surefriend.storage

import by.off.surefriend.model.Insurance

interface InsuranceService {
    suspend fun save(ins: Insurance)
    suspend fun get(id: String): Insurance
    suspend fun list(): Array<Insurance>
}