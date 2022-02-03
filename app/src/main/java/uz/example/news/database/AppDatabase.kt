package uz.example.news.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.example.news.Models.Article

@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun  getDao(): Dao

    companion object {
        var instance: AppDatabase? = null

        fun initDatabase(context: Context) {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "general_news_db"
                    ).build()
                }
            }
        }

        fun getDatabase(): AppDatabase {
            return instance!!
        }
    }


}