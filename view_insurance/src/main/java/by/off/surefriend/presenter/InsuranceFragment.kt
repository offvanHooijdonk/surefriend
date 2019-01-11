package by.off.surefriend.presenter

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.off.surefriend.model.Insurance
import by.off.surefriend.presenter.di.InsuranceScreenComponent
import kotlinx.android.synthetic.main.fr_insurances.*
import kotlinx.android.synthetic.main.item_insurance.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.text.NumberFormat
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class InsuranceFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val insuranceList = mutableListOf<Insurance>()
    private val adapter = InsuranceAdapter(insuranceList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_insurances, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        InsuranceScreenComponent.get(requireActivity().applicationContext).inject(this)

        rvInsurances.adapter = adapter
        rvInsurances.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()

        loadData()
    }

    private fun loadData() {
        CoroutineScope(EmptyCoroutineContext).launch {
            val data = ViewModelProviders.of(requireActivity(), viewModelFactory)[InsuranceViewModel::class.java].get()
            onDataChange(data)
        }
    }

    private fun onDataChange(data: Array<Insurance>) {
        insuranceList.clear()
        insuranceList.addAll(data)
        adapter.notifyDataSetChanged()
    }
}

private class InsuranceAdapter(val insuranceList: List<Insurance>) : RecyclerView.Adapter<InsuranceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, type: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(container.context).inflate(R.layout.item_insurance, container, false))

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val ins = insuranceList[position]
        with(vh.itemView) {
            txtInsTitle.text = ins.title
            txtInsPrice.text = ins.price.toString()
        }
    }

    override fun getItemCount(): Int =
        insuranceList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}