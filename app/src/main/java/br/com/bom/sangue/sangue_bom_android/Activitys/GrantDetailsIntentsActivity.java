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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bom.sangue.sangue_bom_android.Entities.Address;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.Telephone;
import br.com.bom.sangue.sangue_bom_android.R;

public class GrantDetailsIntentsActivity extends AppCompatActivity {

    IntentDonation intentDonation = new IntentDonation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant_details_intents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        try {
            populateViews(extras.getString("EXTRA_INTENT_DONATION"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void populateViews (String intentDonationJson) throws ParseException {
        Gson gson = new Gson();
        intentDonation = gson.fromJson(intentDonationJson, IntentDonation.class);

        TextView name = (TextView) findViewById(R.id.name_detail_grant);
        name.setText(intentDonation.getBloodDonator().getName());

        TextView bloodType = (TextView) findViewById(R.id.blood_type_detail_grant);
        bloodType.setText(intentDonation.getBloodDonator().getBloodType() + intentDonation.getBloodDonator().getBloodFactor());

        TextView nickname = (TextView) findViewById(R.id.nickname_age_detail_grant);
        nickname.setText(intentDonation.getBloodDonator().getNickname());

        Address address = intentDonation.getBloodDonator().getAddress();
        String finalAddress = address.getStreet() + ", " + address.getNumber() + ", " + address.getNeighborhood() + ".";
        TextView addressview = (TextView) findViewById(R.id.address_detail_grant);
        addressview.setText(finalAddress);

        Telephone telephone = intentDonation.getBloodDonator().getTelephone();
        String finalTelephone = "(" + telephone.getDdd() + ") " + telephone.getNumber();
        TextView telephoneView = (TextView) findViewById(R.id.telephone_detail_grant);
        telephoneView.setText(finalTelephone);

        TextView email = (TextView) findViewById(R.id.email_detail_grant);
        email.setText(intentDonation.getBloodDonator().getEmail());

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formato.parse(intentDonation.getGrantDate());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String grantDate = dateFormat.format(data);
        TextView grantDateView = (TextView) findViewById(R.id.grant_date);
        grantDateView.setText("Data da doação: " + grantDate);

    }

}
