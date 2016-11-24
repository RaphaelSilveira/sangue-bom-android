package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Activitys.DetailsIntentDonationActivity;
import br.com.bom.sangue.sangue_bom_android.Activitys.DetailsNewsActivity;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.News;
import br.com.bom.sangue.sangue_bom_android.R;

/**
 * Created by paulo on 23/11/16.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder> {

    private List<News> newsList;
    private Context context;

    public NewsListAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public NewsListAdapter.NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemActiveNews = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_news, parent, false);
        return new NewsListAdapter.NewsListViewHolder(itemActiveNews);
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.NewsListViewHolder holder, int position) {
        final News news = newsList.get(position);

        holder.title.setText(news.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsListViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public NewsListViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.news_title);
        }
    }

    private void openDetails (News news) {
        Intent intent = new Intent(context, DetailsNewsActivity.class);

        Gson gson = new Gson();
        String newsJson = gson.toJson(news);

        intent.putExtra("EXTRA_NEWS", newsJson);

        context.startActivity(intent);
    }

}
