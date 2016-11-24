package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import br.com.bom.sangue.sangue_bom_android.Entities.News;
import br.com.bom.sangue.sangue_bom_android.Providers.NewsProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class DetailsNewsActivity extends AppCompatActivity {

    News news = new News();

    NewsProvider newsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        populateViews(extras.getString("EXTRA_NEWS"));
    }

    private void populateViews (String newsJson) {
        Gson gson = new Gson();
        news = gson.fromJson(newsJson, News.class);

        TextView title = (TextView) findViewById(R.id.details_news_title);
        title.setText(news.getTitle());

        TextView text = (TextView) findViewById(R.id.details_news_text);
        text.setText(news.getText());
    }
}
