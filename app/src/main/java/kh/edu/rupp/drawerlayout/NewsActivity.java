package kh.edu.rupp.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import kh.edu.rupp.drawerlayout.adapter.NewsAdapter;
import kh.edu.rupp.drawerlayout.datamodel.Article;

/**
 * Created by rattanak on 4/25/17.
 */

public class NewsActivity extends Fragment implements RecyclerViewItemClickListener{

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView =  inflater.inflate(R.layout.recycler_view,container,false);
        //reference to RecyclerView
        recyclerView = (RecyclerView) fragmentView.findViewById(R.id.recyclerview);
        //layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NewsAdapter(loadArticle());
        recyclerView.setAdapter(adapter);
        adapter.setItemClick(this);
        //Temporary
        //Article article1  =  new Article();
        //article1.setTitle("i do not know how to do it");
        //article1.setDate("27 April 18");
        //loadArticle();
        //create apdapter


        //Adapter
        //NewsAdapter adaper = new NewsAdapter();

        return fragmentView;
    }

    private Article[] loadArticle()
    {
        Article a1 = new Article("ch. Introduction of andr",1,"");
        Article a2 = new Article("ch. Introduction of andr",1,"");
        Article a3 = new Article("ch. Introduction of andr",1,"");
        Article a4 = new Article("ch. Introduction of andr",1,"");
        Article a5 = new Article("ch. Introduction of andr",2,"");
        Article a6 = new Article("ch. Introduction of andr",3,"");
        Article a7 = new Article("ch. Introduction of andr",2,"");
        Article a8 = new Article("ch. Introduction of andr",2,"");


        Article[] articles = {a1,a2,a3,a4,a5,a6,a7,a8};
        return articles;
    }


    @Override
    public void onClick(View view, int position) {
        //pitch the interface
        Log.d("rupp", "Recycler item click: " + position);

    }
}
