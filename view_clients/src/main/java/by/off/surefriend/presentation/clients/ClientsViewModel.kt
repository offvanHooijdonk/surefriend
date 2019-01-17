package by.off.surefriend.presentation.clients

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.presentation.di.ClientsComponent
import by.off.surefriend.storage.ClientService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClientsViewModel @Inject constructor(private val clientService: ClientService) : ViewModel() {
    private var clientsLiveData: LiveData<Array<ClientInfo>>? = null

    suspend fun loadUsers(): LiveData<Array<ClientInfo>> {
        //CoroutineScope(Dispatchers.Main).launch {
            /*clientsLiveData =*/ return clientsLiveData ?: clientService.list().also { clientsLiveData = it }
        //}
        //return clientsLiveData!!
    }

}