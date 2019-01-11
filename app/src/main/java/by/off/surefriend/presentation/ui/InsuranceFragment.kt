package by.off.surefriend.presentation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.off.surefriend.R
import by.off.surefriend.model.Insurance
import kotlinx.android.synthetic.main.fr_insurances.*
import kotlinx.android.synthetic.main.item_insurance.view.*
import java.text.NumberFormat

class InsuranceFragment: Fragment() {
    private val insuranceList = mutableListOf<Insurance>()
    private val adapter = InsuranceAdapter(insuranceList)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_insurances, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvInsurances.layoutManager = LinearLayoutManager(context)
        rvInsurances.adapter = adapter
    }
}

private class InsuranceAdapter(val insuranceList: List<Insurance>) : RecyclerView.Adapter<InsuranceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, type: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(container.context).inflate(R.layout.item_client, container, false))

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val ins = insuranceList[position]
        with(vh.itemView) {
            txtInsTitle.text = ins.title
            txtInsPrice.text = NumberFormat.getInstance().format(ins.price)
        }
    }

    override fun getItemCount(): Int =
        insuranceList.size


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}