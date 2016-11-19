package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.github.pinball83.maskededittext.MaskedEditText;

import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bom.sangue.sangue_bom_android.Callbacks.BloodDonatorCallback;
import br.com.bom.sangue.sangue_bom_android.Callbacks.IntentDonationCallback;
import br.com.bom.sangue.sangue_bom_android.Entities.Address;
import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.Telephone;
import br.com.bom.sangue.sangue_bom_android.Providers.BloodDonatorProvider;
import br.com.bom.sangue.sangue_bom_android.Providers.IntentDonationProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class IntentDonationActivity extends AppCompatActivity {
    IntentDonationProvider intentDonationProvider = new IntentDonationProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_donation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        verificationValues(extras.getString("EXTRA_CPF"), extras.getString("EXTRA_BLOOD_DONATOR"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intent_donation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.save_intent_donation:
                try {
                    mountObject();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    private void verificationValues (String cpf, String bloodDonatoJson) {
        MaskedEditText cpfFiel = (MaskedEditText) findViewById(R.id.input_cpf);
        cpfFiel.setMaskedText(cpf);
    }

    private void mountObject () throws ParseException, JSONException {
        BloodDonator bloodDonator = new BloodDonator();
        Telephone telephone = new Telephone();
        Address address = new Address();
        IntentDonation intentDonation = new IntentDonation();

        MaskedEditText cpf = (MaskedEditText) findViewById(R.id.input_cpf);
        EditText nickname = (EditText) findViewById(R.id.input_nickname);
        Spinner bloodType = (Spinner) findViewById(R.id.input_blood_type);
        Spinner bloodFactor = (Spinner) findViewById(R.id.input_blood_factor);
        EditText name = (EditText) findViewById(R.id.input_name);
        EditText email = (EditText) findViewById(R.id.input_email);
        MaskedEditText birthDate = (MaskedEditText) findViewById(R.id.input_birth_date);
        MaskedEditText cellphone = (MaskedEditText) findViewById(R.id.input_cellphone);
        MaskedEditText telephoneField = (MaskedEditText) findViewById(R.id.input_telephone);
        EditText street = (EditText) findViewById(R.id.input_street);
        EditText number = (EditText) findViewById(R.id.input_number);
        EditText neighborhood = (EditText) findViewById(R.id.input_neighborhood);
        MaskedEditText cep = (MaskedEditText) findViewById(R.id.input_cep);
        EditText complement = (EditText) findViewById(R.id.input_complement);
        EditText city = (EditText) findViewById(R.id.input_city);
        Spinner state = (Spinner) findViewById(R.id.input_state);

        bloodDonator.setCPF(cpf.getUnmaskedText());
        bloodDonator.setNickname(nickname.getText().toString());
        bloodDonator.setBloodType(bloodType.getSelectedItem().toString());
        bloodDonator.setBloodFactor(bloodFactor.getSelectedItem().toString());
        bloodDonator.setName(name.getText().toString());
        bloodDonator.setEmail(email.getText().toString());

        String originalDate = birthDate.getText().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(originalDate);
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        bloodDonator.setBirthDate(simpleDateFormat.format(date));

        String phone = telephoneField.getUnmaskedText().toString();
        String dd = phone.substring(0, 1);
        String finalNumber = phone.substring(2, 9);;
        telephone.setDdi(55);
        telephone.setDdd(Integer.parseInt(dd));
        telephone.setNumber(finalNumber);

        bloodDonator.setTelephone(telephone);

        address.setStreet(street.getText().toString());
        address.setNumber(Integer.parseInt(number.getText().toString()));
        address.setNeighborhood(neighborhood.getText().toString());
        address.setCep(cep.getUnmaskedText().toString());
        address.setComplement(complement.getText().toString());
        address.setCity(city.getText().toString());
        address.setState(state.getSelectedItem().toString());

        bloodDonator.setAddress(address);

        intentDonation.setBloodDonator(bloodDonator);
        intentDonation.setStatus(1);

        SimpleDateFormat simpleDateFormatIntent = new SimpleDateFormat("yyyy-MM-dd");
        Date dateIntent = new Date();
        intentDonation.setCreatedAt(simpleDateFormatIntent.format(dateIntent));

        createIntentDonation(intentDonation);
    }

    private void createIntentDonation (IntentDonation intentDonation) throws JSONException {
        IntentDonationCallback intentDonationCallback = new IntentDonationCallback() {
            @Override
            public void create() {

            }
        };

        intentDonationProvider.create(intentDonation, this, intentDonationCallback);
    }

}
