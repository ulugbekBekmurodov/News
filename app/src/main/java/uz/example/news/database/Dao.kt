package uz.example.news.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.example.news.Models.Article

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items:List<Article>)

    @Query("select*from news_db")
    fun getAllNews():List<Article>
}