package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Adapters.RankingDonationAdapter;
import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.R;

public class RankingDonationsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RankingDonationAdapter rankingDonationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_donations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadingList (List<BloodDonator> bloodDonators) {
        recyclerView = (RecyclerView) findViewById(R.id.ranking_donations);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        rankingDonationAdapter = new RankingDonationAdapter(bloodDonators, this);
        recyclerView.setAdapter(rankingDonationAdapter);
        rankingDonationAdapter.notifyDataSetChanged();
    }

}
