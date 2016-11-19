package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import br.com.bom.sangue.sangue_bom_android.R;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.back_home);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backToHome();
            }
        });
    }

    private void backToHome () {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
