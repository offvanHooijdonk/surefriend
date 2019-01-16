package by.off.surefriend.presentation.clients

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.ChangeBounds
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.off.surefriend.core.ui.hide
import by.off.surefriend.core.ui.show
import by.off.surefriend.presentation.R
import by.off.surefriend.presentation.databinding.FrClientInfoBinding
import by.off.surefriend.presentation.di.ClientsComponent
import kotlinx.android.synthetic.main.fr_client_info.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClientInfoFragment : Fragment() {
    companion object {
        const val EXTRA_CLIENT_INFO = "extra_client_info" // TODO move to resources
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var clientId: Long? = null
    private lateinit var binding: FrClientInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fr_client_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ClientsComponent.get(requireActivity().applicationContext).inject(this)

        clientId = arguments?.getLong(EXTRA_CLIENT_INFO)
    }

    override fun onStart() {
        super.onStart()

        loadData()
    }

    private fun loadData() {
        val clientId = this.clientId
        if (clientId == null) {
            showNoDataProvided(true)
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            val clientInfo =
                ViewModelProviders.of(this@ClientInfoFragment, viewModelFactory)[ClientInfoViewModel::class.java]
                    .getClient(clientId)

            binding.client = clientInfo
        }
    }

    private fun showNoDataProvided(isShow: Boolean) {
        if (isShow) {
            blockInfoRoot.hide()
            txtNoDataProvided.show()
        } else {
            txtNoDataProvided.hide()
            blockInfoRoot.show()
        }
    }

}