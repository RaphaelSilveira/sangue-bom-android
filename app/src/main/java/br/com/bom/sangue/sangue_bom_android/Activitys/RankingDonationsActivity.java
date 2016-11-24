package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Adapters.RankingDonationAdapter;
import br.com.bom.sangue.sangue_bom_android.Callbacks.RankingDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.RankingDonations;
import br.com.bom.sangue.sangue_bom_android.Providers.RankingDonationsProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class RankingDonationsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RankingDonationAdapter rankingDonationAdapter;

    private RankingDonationsProvider rankingDonationsProvider = new RankingDonationsProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_donations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RankingDonationsCallback rankingDonationsCallback = new RankingDonationsCallback() {
            @Override
            public void getRankingDonationsCallback(String response) {
                transformObject(response);
            }
        };

        rankingDonationsProvider.getRankingDonations(this, rankingDonationsCallback);
    }

    private void transformObject (String object) {
        Gson gerson = new Gson();
        List<RankingDonations> rankingDonationses = gerson.fromJson(object, new TypeToken<List<RankingDonations>>(){}.getType());

        loadingList(rankingDonationses);
    }

    private void loadingList (List<RankingDonations> rankingDonationses) {
        recyclerView = (RecyclerView) findViewById(R.id.ranking_donations);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        rankingDonationAdapter = new RankingDonationAdapter(rankingDonationses, this);
        recyclerView.setAdapter(rankingDonationAdapter);
        rankingDonationAdapter.notifyDataSetChanged();
    }

}
