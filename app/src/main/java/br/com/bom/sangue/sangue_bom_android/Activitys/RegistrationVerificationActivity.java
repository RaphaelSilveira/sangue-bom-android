package br.com.bom.sangue.sangue_bom_android.Activitys;

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

import com.github.pinball83.maskededittext.MaskedEditText;

import br.com.bom.sangue.sangue_bom_android.Callbacks.BloodDonatorCallback;
import br.com.bom.sangue.sangue_bom_android.Providers.BloodDonatorProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class RegistrationVerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_verification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registration_verification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.next_registration_verification:
                BloodDonatorProvider bloodDonatorProvider = new BloodDonatorProvider();

                BloodDonatorCallback bloodDonatorCallback = new BloodDonatorCallback() {
                    @Override
                    public void findOneByCpfCallback() {
                        Log.d("REGISTRATION_VERIFICATI","CHAMOU CALLBACK");
                    }
                };

                bloodDonatorProvider.findOneByCpf(getValuesInForm(), this, bloodDonatorCallback);

                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    private String getValuesInForm () {
        MaskedEditText maskedEditTextCpf = (MaskedEditText) findViewById(R.id.input_cpf);

        return maskedEditTextCpf.getUnmaskedText();
    }

}
