package uz.example.news.repository

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

import io.reactivex.schedulers.Schedulers


import uz.example.news.Models.Article
import uz.example.news.Models.NewsModel
import uz.example.news.retrofit.NetWorkManager

class NewsRepository {

    var compositeDisposable=CompositeDisposable()
    fun getGeneralNews(error:MutableLiveData<String>,success:MutableLiveData<List<Article>>,proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","general","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }

    fun getSportNews(error:MutableLiveData<String>,success:MutableLiveData<List<Article>>,proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","sport","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }


    fun getBusinessNews(error:MutableLiveData<String>, success:MutableLiveData<List<Article>>, proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","business","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }
    fun getEntertainmentNews(error:MutableLiveData<String>, success:MutableLiveData<List<Article>>, proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","entertainment","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }
    fun getHealthNews(error:MutableLiveData<String>, success:MutableLiveData<List<Article>>, proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","health","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }
    fun getScienceNews(error:MutableLiveData<String>, success:MutableLiveData<List<Article>>, proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","science","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles
                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }
    fun getTechnologyNews(error:MutableLiveData<String>, success:MutableLiveData<List<Article>>, proggress:MutableLiveData<Boolean>){
        proggress.value=true
        compositeDisposable.add(NetWorkManager.getApiServices()
            .getNews("us","technology","ab6b20773b21444a8d1762b9ec25c1e7")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableObserver<NewsModel<List<Article>>>(){
                override fun onNext(t: NewsModel<List<Article>>) {
                    proggress.value=false
                    success.value=t.articles

                }

                override fun onError(e: Throwable) {

                    proggress.value=false
                    error.value=e.localizedMessage
                }

                override fun onComplete() {

                }

            })
        )
    }
}

