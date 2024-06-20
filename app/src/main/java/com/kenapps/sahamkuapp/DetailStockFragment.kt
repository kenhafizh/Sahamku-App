package com.kenapps.sahamkuapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kenapps.sahamkuapp.companiesData.Results
import com.kenapps.sahamkuapp.databinding.FragmentDetailStockBinding
import com.kenapps.sahamkuapp.stockDetails.Result
import com.kenapps.sahamkuapp.stockDetails.StockDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailStockFragment : Fragment() {

    lateinit var binding: FragmentDetailStockBinding
    lateinit var apiService: ApiInterface
    var stock: Results? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            stock = it?.getParcelable("data")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailStockBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun getDetails(detail: Results){
        apiService.getDetails(detail.symbol!!).enqueue(object : Callback<StockDetails> {
            override fun onResponse(p0: Call<StockDetails>, data: Response<StockDetails>) {
                if (data.isSuccessful && data.body() != null){
                    val result = data.body()!!.result
                    Log.e("DetaiLActivity", "onResponse : ${result}")

                    val nameDetails = result?.name
                    val aboutDetails = result?.about

                    binding.stockName.text = nameDetails
                    binding.stockDetail.text = aboutDetails

                    Glide.with(this@DetailStockFragment)
                        .load(stock?.logo)
                        .into(binding.stockLogo)
                }

            }

            override fun onFailure(p0: Call<StockDetails>, data: Throwable) {
                Log.d("DetailActivity", "onFailure : ${data.message}",)
            }

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.stockName.text = stock?.name

        apiService = ApiService().getService()

        getDetails(stock!!)
    }

}