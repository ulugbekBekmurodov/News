package uz.example.news.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetWorkManager {

    var retrofit:Retrofit?=null


    var api:Api?=null

    fun getApiServices():Api{
        if (api==null){
            retrofit= Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .build()

            api=retrofit!!.create(Api::class.java)
        }

        return api!!
    }

}