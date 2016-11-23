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

import org.json.JSONException;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Adapters.ActiveIntentDonationsAdapter;
import br.com.bom.sangue.sangue_bom_android.Adapters.RankingDonationAdapter;
import br.com.bom.sangue.sangue_bom_android.Callbacks.ActiveIntentDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.RankingDonations;
import br.com.bom.sangue.sangue_bom_android.Providers.IntentDonationProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class ActiveIntentDonationsActivity extends AppCompatActivity {

    IntentDonationProvider intentDonationProvider = new IntentDonationProvider();

    private RecyclerView recyclerView;

    private ActiveIntentDonationsAdapter activeIntentDonationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_intent_donations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            findAllIntentDonations();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findAllIntentDonations() throws JSONException {
        ActiveIntentDonationsCallback activeIntentDonationsCallback = new ActiveIntentDonationsCallback() {
            @Override
            public void findAllIntentDonations(String json) {
                Gson gson = new Gson();
                List<IntentDonation> intentDonations = gson.fromJson(json, new TypeToken<List<IntentDonation>>(){}.getType());

                loadingList(intentDonations);
            }
        };

        intentDonationProvider.findAll(this, activeIntentDonationsCallback);
    }

    private void loadingList (List<IntentDonation> intentDonations) {
        recyclerView = (RecyclerView) findViewById(R.id.intent_donations_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        activeIntentDonationsAdapter = new ActiveIntentDonationsAdapter(intentDonations, this);
        recyclerView.setAdapter(activeIntentDonationsAdapter);
        activeIntentDonationsAdapter.notifyDataSetChanged();
    }

}
