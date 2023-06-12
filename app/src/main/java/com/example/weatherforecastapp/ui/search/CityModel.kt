package com.example.weatherforecastapp.ui.search

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.weatherforecastapp.R

@EpoxyModelClass(layout = R.layout.city_item)
abstract class CityModel : EpoxyModelWithHolder<CityModel.Holder>() {

    @EpoxyAttribute
    lateinit var cityName: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.cityName.text = cityName
    }

    class Holder : EpoxyHolder() {

        lateinit var cityName: TextView

        override fun bindView(itemView: View) {
            cityName = itemView.findViewById(R.id.tvCity)
        }

    }
}