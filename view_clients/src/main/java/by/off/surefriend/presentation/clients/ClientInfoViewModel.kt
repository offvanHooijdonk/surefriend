package by.off.surefriend.presentation.clients

import android.arch.lifecycle.ViewModel
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.storage.ClientService
import javax.inject.Inject

class ClientInfoViewModel @Inject constructor(private  val clientService: ClientService) : ViewModel() {
    suspend fun getClient(id: String): ClientInfo = clientService.get(id)
}