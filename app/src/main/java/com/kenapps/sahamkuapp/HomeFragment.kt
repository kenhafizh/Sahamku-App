package com.kenapps.sahamkuapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kenapps.sahamkuapp.companiesData.Companies
import com.kenapps.sahamkuapp.databinding.FragmentHomeBinding
import com.kenapps.sahamkuapp.trendingData.TrendingData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var apiService: ApiInterface
    lateinit var binding: FragmentHomeBinding
    lateinit var adapter: HomeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeFragmentAdapter()
        binding.recylerView.adapter = adapter
        binding.recylerView.layoutManager  = LinearLayoutManager(context)

        apiService = ApiService().getService()
        getTrending()

    }


    fun getTrending(){
        apiService.getTrending().enqueue(object : Callback<TrendingData>{
            override fun onResponse(p0: Call<TrendingData>, data: Response<TrendingData>) {
                Log.e("Home Fragment", "onResponse : ${data.body()}")
                if (data.body() != null){
                    adapter.trend = data.body()!!.data!!.results
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(p0: Call<TrendingData>, data: Throwable) {
                Log.e("MainActivity", "onFailure : ${data.message}",)
            }
        })
    }

}
