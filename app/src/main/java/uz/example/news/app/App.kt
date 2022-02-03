package uz.example.news.app

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import uz.example.news.database.AppDatabase
import uz.example.news.ui.MainViewModel

class App:MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)


        AppDatabase.initDatabase(this)
    }
}