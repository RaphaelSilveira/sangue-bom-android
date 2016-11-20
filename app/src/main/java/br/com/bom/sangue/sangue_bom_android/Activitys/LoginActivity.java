package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.bom.sangue.sangue_bom_android.Callbacks.LoginCallback;
import br.com.bom.sangue.sangue_bom_android.Providers.LoginProvider;
import br.com.bom.sangue.sangue_bom_android.R;

public class LoginActivity extends AppCompatActivity {

    LoginProvider loginProvider = new LoginProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Button button = (Button) findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login () {

        final ProgressDialog progressDialog = ProgressDialog.show(this, "Aguarde...", "Verificando sua senha...", true);
        progressDialog.setCancelable(true);

        EditText email = (EditText) findViewById(R.id.input_email_login);
        EditText password = (EditText) findViewById(R.id.input_password);

        LoginCallback loginCallback = new LoginCallback() {
            @Override
            public void login(Boolean mayComeIn) {
                progressDialog.dismiss();
                if (mayComeIn) {
                    openAdministrator();
                } else {
                    wrongPassword();
                }
            }
        };

        loginProvider.login(email.getText().toString(), password.getText().toString(), this, loginCallback);
    }

    private void openAdministrator () {
        Intent intent = new Intent(this, AdministratorActivity.class);
        startActivity(intent);
    }

    private void wrongPassword () {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Usuário ou senha incorretos!");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });

        alert.show();
    }

}
