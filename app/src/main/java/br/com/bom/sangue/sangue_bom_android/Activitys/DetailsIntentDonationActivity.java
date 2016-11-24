package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;

import br.com.bom.sangue.sangue_bom_android.Callbacks.IntentDonationCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.Address;
import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.Telephone;
import br.com.bom.sangue.sangue_bom_android.Providers.IntentDonationProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class DetailsIntentDonationActivity extends AppCompatActivity {

    IntentDonation intentDonation = new IntentDonation();

    IntentDonationProvider intentDonationProvider = new IntentDonationProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_intent_donation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.confirm_donation);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    setGrantDate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        populateViews(extras.getString("EXTRA_INTENT_DONATION"));
    }

    private void populateViews (String intentDonationJson) {
        Gson gson = new Gson();
        intentDonation = gson.fromJson(intentDonationJson, IntentDonation.class);

        TextView name = (TextView) findViewById(R.id.name_detail);
        name.setText(intentDonation.getBloodDonator().getName());

        TextView bloodType = (TextView) findViewById(R.id.blood_type_detail);
        bloodType.setText(intentDonation.getBloodDonator().getBloodType() + intentDonation.getBloodDonator().getBloodFactor());

        TextView nickname = (TextView) findViewById(R.id.nickname_age_detail);
        nickname.setText(intentDonation.getBloodDonator().getNickname());

        Address address = intentDonation.getBloodDonator().getAddress();
        String finalAddress = address.getStreet() + ", " + address.getNumber() + ", " + address.getNeighborhood() + ".";
        TextView addressview = (TextView) findViewById(R.id.address_detail);
        addressview.setText(finalAddress);

        Telephone telephone = intentDonation.getBloodDonator().getTelephone();
        String finalTelephone = "(" + telephone.getDdd() + ") " + telephone.getNumber();
        TextView telephoneView = (TextView) findViewById(R.id.telephone_detail);
        telephoneView.setText(finalTelephone);

        TextView email = (TextView) findViewById(R.id.email_detail);
        email.setText(intentDonation.getBloodDonator().getEmail());
    }

    private void setGrantDate () throws JSONException {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Aguarde...", "Concluindo a ação...", true);
        progressDialog.setCancelable(true);

        IntentDonationCallback intentDonationCallback = new IntentDonationCallback() {
            @Override
            public void success() {
                progressDialog.dismiss();
                comeBackIntentDonationList();
            }
        };

        intentDonationProvider.setGrantDate(intentDonation, this, intentDonationCallback);
    }

    private void comeBackIntentDonationList () {
        Intent intent = new Intent(this, ActiveIntentDonationsActivity.class);
        startActivity(intent);
    }

}
