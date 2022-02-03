package uz.example.news.Models


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "news_db")
class Article : Serializable {

    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null


    var author: String? = null
    var content: String? = null
    var description: String? = null
    var publishedAt: String? = null
    var title: String? = null
    var url: String? = null
    var urlToImage: String? = null


    constructor()
    constructor(
        author: String?,
        content: String?,
        description: String?,
        publishedAt: String?,

        title: String?,
        url: String?,
        urlToImage: String?
    ) {
        this.author = author
        this.content = content
        this.description = description
        this.publishedAt = publishedAt

        this.title = title
        this.url = url
        this.urlToImage = urlToImage
    }
}

