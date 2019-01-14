package by.off.surefriend.presentation.clients

import android.arch.lifecycle.ViewModel
import android.content.Context
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.presentation.di.ClientsComponent
import by.off.surefriend.storage.ClientService
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class ClientsViewModel @Inject constructor(private val clientService: ClientService) : ViewModel() {

    suspend fun loadUsers(): Array<ClientInfo> = clientService.list()


}