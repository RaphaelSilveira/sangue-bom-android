package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Adapters.NewsListAdapter;
import br.com.bom.sangue.sangue_bom_android.Callbacks.NewsListCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.News;
import br.com.bom.sangue.sangue_bom_android.Providers.NewsProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class NewsListActivity extends AppCompatActivity {

    NewsProvider newsProvider = new NewsProvider();

    private RecyclerView recyclerView;

    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        try {
            findAllNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findAllNews () throws JSONException{
        NewsListCallback newsListCallback = new NewsListCallback() {
            @Override
            public void findAllNews(String json) {
                Gson gson = new Gson();
                List<News> newsList = gson.fromJson(json, new TypeToken<List<News>>(){}.getType());

                Log.d("", "" + newsList.size());

                loadingList(newsList);
            }
        };

        newsProvider.findAll(this, newsListCallback);
    }

    private void loadingList (List<News> newsList) {
        recyclerView = (RecyclerView) findViewById(R.id.news_list_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        newsListAdapter = new NewsListAdapter(newsList, this);
        recyclerView.setAdapter(newsListAdapter);
        newsListAdapter.notifyDataSetChanged();
    }
}
