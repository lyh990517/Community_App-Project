package yunho.app.myapplication.Presentation.Adapter

import android.location.GnssAntennaInfo
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yunho.app.myapplication.Data.Entity.articleEntity
import yunho.app.myapplication.databinding.ItemArticleBinding

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    internal var articles = listOf<articleEntity>()
    private lateinit var listener: (articleEntity) -> Unit
    inner class ViewHolder(
        private val binding: ItemArticleBinding,
        private val listener: (articleEntity) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bindData(articleEntity: articleEntity){
            with(binding){
                //thumb.setImageResource()
                title.text = articleEntity.title
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleAdapter.ViewHolder {
        val view = ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.ViewHolder, position: Int) {
        holder.bindData(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    fun setData(list : List<articleEntity>, listener: (articleEntity) -> Unit){
        articles = list
        this.listener = listener
        notifyDataSetChanged()
    }

}