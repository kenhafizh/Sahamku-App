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
import com.kenapps.sahamkuapp.databinding.FragmentNewsBinding
import com.kenapps.sahamkuapp.newsData.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {

    lateinit var apiService: ApiInterface
    lateinit var binding: FragmentNewsBinding
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsAdapter()
        binding.recylerView.adapter = adapter
        binding.recylerView.layoutManager = LinearLayoutManager(context)

        apiService = ApiService().getService()

        getCompaniesData()
    }

    fun getCompaniesData(){
        apiService.getNews().enqueue(object : Callback<NewsData> {
            override fun onResponse(p0: Call<NewsData>, data: Response<NewsData>) {
                Log.d("News Fragment", "onResponse : ${data.body()}")
                if (data.body() != null){
                    adapter.items = data.body()!!.data
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(p0: Call<NewsData>, data: Throwable) {
                Log.e("News Fragment", "onFailure : ${data.message}",)
            }
        })
    }


}
