package uz.example.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.example.news.Models.Article
import uz.example.news.R
import uz.example.news.databinding.ItemListBinding

class RvAdapter(var list: List<Article>,var onClickListenerItem: OnClickListenerItem):RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(itemView: View): RecyclerView.ViewHolder(itemView){
        fun onBind(article: Article) {
            val bind=ItemListBinding.bind(itemView)

            bind.basicText.text=article.title.toString()


                Picasso.get().load(article.urlToImage).into(bind.basicImage)


            itemView.setOnClickListener {

                onClickListenerItem.onClick(article)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClickListenerItem{
        fun onClick(list: Article)
    }
}