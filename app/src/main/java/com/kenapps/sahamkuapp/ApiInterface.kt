package com.kenapps.sahamkuapp


import com.kenapps.sahamkuapp.trendingData.TrendingData
import com.kenapps.sahamkuapp.companiesData.Companies
import com.kenapps.sahamkuapp.newsData.NewsData

import com.kenapps.sahamkuapp.stockDetails.StockDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiInterface {

    @Headers("x-api-key: c94aeb5e-cb6c-5c38-33e8-55823016")
    @GET("stock/idx/companies")
    fun getCompanyName(): retrofit2.Call<Companies>

    @Headers("x-api-key: c94aeb5e-cb6c-5c38-33e8-55823016")
    @GET("stock/idx/trending")
    fun getTrending(): retrofit2.Call<TrendingData>

    @Headers("x-api-key: c94aeb5e-cb6c-5c38-33e8-55823016")
    @GET("stock/idx/{symbol}/profile")
    fun getDetails(@Path("symbol") symbol: String): retrofit2.Call<StockDetails>

    @Headers("x-api-key: c94aeb5e-cb6c-5c38-33e8-55823016")
    @GET("stock/idx/companies")
    fun getSearch(): retrofit2.Call<Companies>

    @GET("companies")
    fun getCompanies(): Call<List<Companies>>


    @Headers("x-api-key: c94aeb5e-cb6c-5c38-33e8-55823016")
    @GET("stock/idx/news")
    fun getNews(): retrofit2.Call<NewsData>



}


//harus gunakan json terluar