package by.off.surefriend.presentation.clients

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.off.surefriend.core.LOGCAT
import by.off.surefriend.core.ui.setupDefault
import by.off.surefriend.model.ClientInfo
import by.off.surefriend.presentation.R
import by.off.surefriend.presentation.di.ClientsComponent
import kotlinx.android.synthetic.main.fr_clients.*
import kotlinx.android.synthetic.main.item_client.view.*
import kotlinx.coroutines.*
import javax.inject.Inject

class ClientsFragment : Fragment() {
    private var job: Job? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val clientList = mutableListOf<ClientInfo>()
    private val adapter = ClientsAdapter(clientList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_clients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ClientsComponent.get(requireActivity().applicationContext).inject(this)

        rvClients.adapter = adapter
        rvClients.layoutManager = LinearLayoutManager(context)

        refreshClients.setupDefault {
            loadData()
        }
    }

    override fun onStart() {
        super.onStart()

        try {
            loadData()
        } catch (th: Throwable) {
            Log.e(LOGCAT, "Error loading data", th)
        }
    }

    override fun onStop() {
        super.onStop()

        job?.cancel()
    }

    private fun loadData() {
        job?.cancel()
        job = CoroutineScope(Dispatchers.Main).launch {
            val data = ViewModelProviders.of(requireActivity(), viewModelFactory).get(ClientsViewModel::class.java)
                .loadUsers()
            onDataChanged(data)
        }
    }

    private fun onDataChanged(data: Array<ClientInfo>) {
        Log.d(LOGCAT, "Rewriting data")
        clientList.clear()
        clientList.addAll(data)

        Log.d(LOGCAT, "Notifying adapter")
        adapter.notifyDataSetChanged()
        refreshClients.isRefreshing = false
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


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}