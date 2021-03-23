package com.hofit.hofitcellcomtest.ui.flow.dashboard.view.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hofit.hofitcellcomtest.interfaces.IExecutable
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import kotlinx.android.synthetic.main.item_country.view.*

class CountryViewHolder(itemView : View, private val mListener: IExecutable<Int>?) : RecyclerView.ViewHolder(itemView){

    fun onBind(
        country: Country?
    ) {
        itemView.englishName.text = country?.name ?: ""
        itemView.name.text = country?.nativeName ?: ""

        itemView.root_item.setOnClickListener {
            mListener?.let {
                it.execute(adapterPosition)
            }
        }
    }
}