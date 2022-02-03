package uz.example.news.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.example.news.Models.Article
import uz.example.news.Models.NewsModel
import uz.example.news.adapter.RvAdapter
import uz.example.news.database.AppDatabase
import uz.example.news.repository.NewsRepository
import uz.example.news.retrofit.Api
import uz.example.news.retrofit.NetWorkManager

class MainViewModel : ViewModel() {


    var newsRepository = NewsRepository()

    val error = MutableLiveData<String>()
    val generalNews = MutableLiveData<List<Article>>()
    val sportNews = MutableLiveData<List<Article>>()
    val businessNews = MutableLiveData<List<Article>>()
    val entertainmentNews = MutableLiveData<List<Article>>()
    val healthNews = MutableLiveData<List<Article>>()
    val scienceNews = MutableLiveData<List<Article>>()
    val technologyNews = MutableLiveData<List<Article>>()
    var proggress = MutableLiveData<Boolean>()


    fun getGeneralNews() {
        newsRepository.getGeneralNews(error, generalNews, proggress)
    }

    fun getSportNews() {
        newsRepository.getSportNews(error, sportNews, proggress)
    }

    fun getBusinessNews() {
        newsRepository.getBusinessNews(error, businessNews, proggress)
    }

    fun getEntertainmentNews() {
        newsRepository.getEntertainmentNews(error, entertainmentNews, proggress)
    }

    fun getHealthNews() {
        newsRepository.getHealthNews(error, healthNews, proggress)
    }

    fun getScienceNews() {
        newsRepository.getScienceNews(error, scienceNews, proggress)
    }

    fun getTechnologyNews() {
        newsRepository.getTechnologyNews(error, technologyNews, proggress)
    }

    fun insertAllView(items: List<Article>) {
        CoroutineScope(Dispatchers.IO).launch {
            AppDatabase.getDatabase().getDao().insertAll(items)
        }

    }

    fun getAllView() {
        CoroutineScope(Dispatchers.Main).launch {
            generalNews.value =
                withContext(Dispatchers.IO){ AppDatabase.getDatabase().getDao().getAllNews() }!!
        }

    }
}