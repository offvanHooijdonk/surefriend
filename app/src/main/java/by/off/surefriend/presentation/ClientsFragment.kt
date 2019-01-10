package by.off.surefriend.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.off.surefriend.R
import by.off.surefriend.app.SureApp
import by.off.surefriend.di.presentation.ClientsComponent
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.storage.ClientService
import kotlinx.android.synthetic.main.fr_clients.*
import kotlinx.android.synthetic.main.item_client.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class ClientsFragment : Fragment() {
    private val clientList = mutableListOf<ClientInfo>()
    private val adapter = ClientsAdapter(clientList)

    @Inject
    lateinit var clientService: ClientService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ClientsComponent.get().inject(this)
        return inflater.inflate(R.layout.fr_clients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvClients.layoutManager = LinearLayoutManager(context)
        rvClients.adapter = adapter

        CoroutineScope(EmptyCoroutineContext).launch {
            onDataChanged(clientService.list())
        }
    }

    fun onDataChanged(data: Array<ClientInfo>) {
        clientList.clear()
        clientList.addAll(data)

        adapter.notifyDataSetChanged()
    }
}

private class ClientsAdapter(val clientsList: List<ClientInfo>) : RecyclerView.Adapter<ClientsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, type: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(container.context).inflate(R.layout.item_client, container, false))

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val client = clientsList[position]
        with(vh.itemView) {
            txtClientFullName.text = client.fullName
            txtClientAge.text = client.age.toString()
        }
    }

    override fun getItemCount(): Int =
        clientsList.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}