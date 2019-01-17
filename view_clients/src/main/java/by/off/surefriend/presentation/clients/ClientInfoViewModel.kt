package by.off.surefriend.presentation.clients

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.storage.ClientService
import javax.inject.Inject

class ClientInfoViewModel @Inject constructor(private  val clientService: ClientService) : ViewModel() {
    private var clientInfoLiveData: LiveData<ClientInfo>? = null

    suspend fun getClient(id: Long): LiveData<ClientInfo> = clientInfoLiveData ?: clientService.get(id).also { clientInfoLiveData = it }
}