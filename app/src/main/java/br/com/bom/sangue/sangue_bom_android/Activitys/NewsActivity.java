package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.json.JSONException;

import java.text.ParseException;

import br.com.bom.sangue.sangue_bom_android.Callbacks.NewsCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.Administrator;
import br.com.bom.sangue.sangue_bom_android.Entities.News;
import br.com.bom.sangue.sangue_bom_android.Providers.NewsProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class NewsActivity extends AppCompatActivity {
    NewsProvider newsProvider = new NewsProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.post_news:
                try {
                    mountObject();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    private void mountObject () throws ParseException {
        Administrator administrator = new Administrator();
        News news = new News();
        long id = 2;

        EditText title = (EditText) findViewById(R.id.input_titulo);
        EditText text = (EditText) findViewById(R.id.input_text);

        news.setTitle(title.getText().toString());
        news.setText(text.getText().toString());

        administrator.setId(id);
        news.setAdministrator(administrator);
    }

    private void createNews (News news) throws JSONException {
        NewsCallback newsCallback = new NewsCallback() {
            @Override
            public void create() {

            }
        };
        newsProvider.create(news, this, newsCallback);
    }
}
