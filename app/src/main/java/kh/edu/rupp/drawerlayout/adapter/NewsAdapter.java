package kh.edu.rupp.drawerlayout.adapter;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kh.edu.rupp.drawerlayout.R;
import kh.edu.rupp.drawerlayout.RecyclerViewItemClickListener;
import kh.edu.rupp.drawerlayout.datamodel.Article;

/**
 * Created by rattanak on 4/25/17.
 */
//creare view holder
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> implements View.OnClickListener{

    private Article[] articles;
    private RecyclerViewItemClickListener itemClickListener;

    public NewsAdapter(Article[] articles)
    {
        this.articles = articles;
    }

    public void setNewsArticle(Article[] articles)
    {
        this.articles = articles;
        notifyDataSetChanged();
    }
    //In function view holder we inflate veiew holder
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //load view holder or get
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_article,parent,false);
        //load view holder from layout or create new view holder
        ArticleViewHolder viewHolder = new ArticleViewHolder(view);
        //we should set on click in view holder
        //view.setOnClickListener();
        return viewHolder;

    }

    //get data to apply in view holder
    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = articles[position];
        holder.txtTitle.setText(article.getTitle());
        //if we set text as integer we should convert it to string
        holder.txtSize.setText(article.getSize()+ "");
    }

    @Override
    public int getItemCount() {
        return articles.length;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getItemCount());
    }
    public void setItemClick(RecyclerViewItemClickListener item)
    {
        this.itemClickListener = item;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgThumbnai;
        private TextView txtTitle, txtDate, txtSize;

        public ArticleViewHolder(View itemView) {
            super(itemView);

            imgThumbnai = (ImageView) itemView.findViewById(R.id.img_thumbnai);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtSize = (TextView) itemView.findViewById(R.id.txt_size);
            //set item click to view holder
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //get click from user on recycler view
            if (itemClickListener != null) itemClickListener.onClick(view, getAdapterPosition());
        }
    }
}
