package com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.interfaces.IExecutable
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.view_holder.CountryViewHolder

class CountriesAdapter  : RecyclerView.Adapter<CountryViewHolder>() , IExecutable<Int> {

    private var mList : List<Country>? = null
    private var mListener : IExecutable<Country?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view, this)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.onBind(mList?.get(position))
    }

    fun setData(data: List<Country>?, listener : IExecutable<Country?>?) {
        mList = data
        mListener = listener
    }

    override fun execute(p: Int) {
        mListener?.execute(mList?.get(p))
    }

    fun refreshData(list: List<Country>) {
        mList = list
    }
}