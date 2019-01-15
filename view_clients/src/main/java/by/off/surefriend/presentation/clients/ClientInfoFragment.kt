package by.off.surefriend.presentation.clients

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.off.surefriend.presentation.R
import by.off.surefriend.presentation.databinding.FrClientInfoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClientInfoFragment : Fragment() {
    companion object {
        const val EXTRA_CLIENT_INFO = "extra_client_info" // TODO move to resources
        private const val EMPTY_ID = ""
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var clientId: String
    private lateinit var binding: FrClientInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fr_client_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clientId = arguments?.getString(EXTRA_CLIENT_INFO) ?: EMPTY_ID
    }

    override fun onStart() {
        super.onStart()

        loadData()
    }

    private fun loadData() {
        if (clientId == EMPTY_ID) {
            Toast.makeText(requireContext(), "No info passed!", Toast.LENGTH_LONG).show()
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            val clientInfo =
                ViewModelProviders.of(this@ClientInfoFragment, viewModelFactory)[ClientInfoViewModel::class.java]
                    .getClient(clientId)

            binding.client = clientInfo
        }
    }
}