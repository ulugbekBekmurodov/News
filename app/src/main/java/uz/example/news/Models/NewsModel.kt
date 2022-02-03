package uz.example.news.Models

data class NewsModel<T>(
    var status: String,
    var articles: T,
    var totalResults: Int


)

