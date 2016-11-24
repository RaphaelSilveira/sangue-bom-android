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

import br.com.bom.sangue.sangue_bom_android.Adapters.ActiveIntentDonationsAdapter;
import br.com.bom.sangue.sangue_bom_android.Adapters.ActiveNewsListAdapter;
import br.com.bom.sangue.sangue_bom_android.Callbacks.ActiveNewsCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.News;
import br.com.bom.sangue.sangue_bom_android.Providers.NewsProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class ActiveNewsListActivity extends AppCompatActivity {

    NewsProvider newsProvider = new NewsProvider();

    private RecyclerView recyclerView;

    private ActiveNewsListAdapter activeNewsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_news_list);
        try {
            findAllNews();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findAllNews () throws JSONException{
        ActiveNewsCallback activeNewsCallback = new ActiveNewsCallback() {
            @Override
            public void findAllNews(String json) {
                Gson gson = new Gson();
                List<News> newsList = gson.fromJson(json, new TypeToken<List<News>>(){}.getType());

                Log.d("", "" + newsList.size());

                loadingList(newsList);
            }
        };

        newsProvider.findAll(this, activeNewsCallback);
    }

    private void loadingList (List<News> newsList) {
        recyclerView = (RecyclerView) findViewById(R.id.news_list_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        activeNewsListAdapter = new ActiveNewsListAdapter(newsList, this);
        recyclerView.setAdapter(activeNewsListAdapter);
        activeNewsListAdapter.notifyDataSetChanged();
    }
}
