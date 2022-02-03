package uz.example.news.retrofit

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.example.news.Models.Article
import uz.example.news.Models.NewsModel

interface Api {

        @GET("top-headlines")
        fun getNews(
            @Query("country") country: String,
            @Query("category") category: String,
            @Query("apiKey") api_key: String
        ): Observable<NewsModel<List<Article>>>

}