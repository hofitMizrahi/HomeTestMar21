package com.hofit.hofitcellcomtest.repository.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Country : Serializable{
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("topLevelDomain")
    @Expose
    var topLevelDomain: List<String>? = null

    @SerializedName("alpha2Code")
    @Expose
    var alpha2Code: String? = null

    @SerializedName("alpha3Code")
    @Expose
    var alpha3Code: String? = null

    @SerializedName("callingCodes")
    @Expose
    var callingCodes: List<String>? = null

    @SerializedName("capital")
    @Expose
    var capital: String? = null

    @SerializedName("altSpellings")
    @Expose
    var altSpellings: List<String>? = null

    @SerializedName("region")
    @Expose
    var region: String? = null

    @SerializedName("subregion")
    @Expose
    var subregion: String? = null

    @SerializedName("population")
    @Expose
    var population: Int? = null

    @SerializedName("latlng")
    @Expose
    var latlng: List<Double>? = null

    @SerializedName("demonym")
    @Expose
    var demonym: String? = null

    @SerializedName("area")
    @Expose
    var area: Double? = null

    @SerializedName("gini")
    @Expose
    var gini: Double? = null

    @SerializedName("timezones")
    @Expose
    var timezones: List<String>? = null

    @SerializedName("borders")
    @Expose
    var borders: List<String>? = null

    @SerializedName("nativeName")
    @Expose
    var nativeName: String? = null

    @SerializedName("numericCode")
    @Expose
    var numericCode: String? = null

    @SerializedName("currencies")
    @Expose
    var currencies: List<Currency>? =
        null

    @SerializedName("languages")
    @Expose
    var languages: List<Language>? =
        null

    @SerializedName("translations")
    @Expose
    var translations: Translations? = null

    @SerializedName("flag")
    @Expose
    var flag: String? = null

    @SerializedName("regionalBlocs")
    @Expose
    var regionalBlocs: List<RegionalBloc>? = null

    @SerializedName("cioc")
    @Expose
    var cioc: String? = null

    fun getBordersList() : String{
        return borders?.let { list ->

            var codes = ""

            if(list.isNotEmpty()){
                codes += list[0]
                for (item in list.subList(1, list.size)){
                    codes += ";$item"
                }
            }
            codes

        }?: kotlin.run {
            ""
        }
    }
}