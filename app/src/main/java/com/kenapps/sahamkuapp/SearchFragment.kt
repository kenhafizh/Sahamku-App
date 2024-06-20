package com.kenapps.sahamkuapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kenapps.sahamkuapp.companiesData.Companies
import com.kenapps.sahamkuapp.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {

    lateinit var itemDatabase: ItemDatabase
    lateinit var itemDao: ItemDao

    lateinit var apiService: ApiInterface
    lateinit var binding: FragmentSearchBinding
    lateinit var adapter: SearchStockAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SearchStockAdapter()
        binding.recylerView.adapter = adapter
        binding.recylerView.layoutManager  = LinearLayoutManager(context)

//        getTrending()

        binding.btnSearch.setOnClickListener {
            getSearchStock(binding.inputText.text.toString())
            adapter.items = listOf()
            adapter.notifyDataSetChanged()
        }


        itemDatabase = ItemDatabase.getInstance(requireContext())
        itemDao = itemDatabase.itemDao()

        apiService = ApiService().getService()

    }


    fun getSearchStock(stock: String){
        apiService.getSearch().enqueue(object : Callback<Companies>{
            override fun onResponse(p0: Call<Companies>, data: Response<Companies>) {
                Log.e("SearchFragment", "onResponse : ${data.body()}")
                if (data.body() != null){
                    itemDao.searchCompanies(stock)
                    adapter.items
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(p0: Call<Companies>, data: Throwable) {
                Log.e("Search Fragment", "onFailure : ${data.message}",)
            }

        })
    }



//    fun getTrending(){
//        apiService.getTrending().enqueue(object : Callback<TrendingData> {
//            override fun onResponse(p0: Call<TrendingData>, data: Response<TrendingData>) {
//                Log.e("Home Fragment", "onResponse : ${data.body()}")
//                if (data.body() != null){
//                    adapter.trend = data.body()!!.data!!.results
//                    adapter.notifyDataSetChanged()
//                }
//            }
//            override fun onFailure(p0: Call<TrendingData>, data: Throwable) {
//                Log.e("MainActivity", "onFailure : ${data.message}",)
//            }
//        })
//    }

}