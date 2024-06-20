package com.kenapps.sahamkuapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kenapps.sahamkuapp.companiesData.Companies
import com.kenapps.sahamkuapp.companiesData.Results
import com.kenapps.sahamkuapp.databinding.FragmentStockIndexBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StockIndexFragment : Fragment(), StockIndexAdapter.onStockClickListener {

    lateinit var apiService: ApiInterface
    lateinit var binding: FragmentStockIndexBinding
    lateinit var adapter: StockIndexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStockIndexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StockIndexAdapter(this)
        binding.recylerview.adapter = adapter
        binding.recylerview.layoutManager = LinearLayoutManager(context)

        apiService = ApiService().getService()

        getCompaniesData()
    }

    fun getCompaniesData(){
        apiService.getCompanyName().enqueue(object : Callback<Companies> {
            override fun onResponse(p0: Call<Companies>, data: Response<Companies>) {
                Log.e("Home Fragment", "onResponse : ${data.body()}")
                if (data.body() != null){
                    adapter.items = data.body()!!.dataResponse!!.results
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(p0: Call<Companies>, data: Throwable) {
                Log.e("MainActivity", "onFailure : ${data.message}",)
            }
        })
    }

//    override fun onClick(stock: Result, Index: Int) {
//
//    }

    override fun onClick(stock: Results, Index: Int) {
        val bundle = Bundle()
        bundle.putParcelable("data", stock)
        findNavController().navigate(R.id.detailStockFragment, bundle)
    }


}
