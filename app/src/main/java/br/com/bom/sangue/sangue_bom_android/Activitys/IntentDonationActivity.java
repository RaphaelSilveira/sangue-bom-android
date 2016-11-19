package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import br.com.bom.sangue.sangue_bom_android.Callbacks.BloodDonatorCallback;
import br.com.bom.sangue.sangue_bom_android.Providers.BloodDonatorProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class IntentDonationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_donation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        Log.i("EXTRA_CPF", extras.getString("EXTRA_CPF"));
        Log.i("EXTRA_BLOOD_DONATOR", extras.getString("EXTRA_BLOOD_DONATOR"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.save_intent_donation:


                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

}
