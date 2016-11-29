package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Adapters.ActiveIntentDonationsAdapter;
import br.com.bom.sangue.sangue_bom_android.Adapters.GrantIntentDonationsAdapter;
import br.com.bom.sangue.sangue_bom_android.Callbacks.ActiveIntentDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Callbacks.GrantIntentDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Providers.IntentDonationProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class GrantIntentDonationActivity extends AppCompatActivity {

    IntentDonationProvider intentDonationProvider = new IntentDonationProvider();

    private RecyclerView recyclerView;

    private GrantIntentDonationsAdapter grantIntentDonationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant_intent_donation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        try {
            findAllIntentDonations();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void findAllIntentDonations() throws JSONException {
        GrantIntentDonationsCallback grantIntentDonationsCallback = new GrantIntentDonationsCallback() {
            @Override
            public void findAllIntentDonations(String json) {
                Gson gson = new Gson();
                List<IntentDonation> intentDonations = gson.fromJson(json, new TypeToken<List<IntentDonation>>(){}.getType());

                loadingList(intentDonations);
            }
        };

        intentDonationProvider.findAllGrant(this, grantIntentDonationsCallback);
    }

    private void loadingList (List<IntentDonation> intentDonations) {
        recyclerView = (RecyclerView) findViewById(R.id.grant_intent_donations_recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        grantIntentDonationsAdapter = new GrantIntentDonationsAdapter(intentDonations, this);
        recyclerView.setAdapter(grantIntentDonationsAdapter);
        grantIntentDonationsAdapter.notifyDataSetChanged();
    }

}
