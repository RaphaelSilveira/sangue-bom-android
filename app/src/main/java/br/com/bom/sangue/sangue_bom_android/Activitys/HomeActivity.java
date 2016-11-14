package br.com.bom.sangue.sangue_bom_android.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import com.github.pinball83.maskededittext.MaskedEditText;

import br.com.bom.sangue.sangue_bom_android.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.save_intent_donation:

                //TODO

                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.donators_ranking) {

        } else if (id == R.id.news) {

        } else if (id == R.id.login) {
            Intent intent = new Intent(this, AdministratorActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ridingObject () {

        /*EditText cpf = (EditText) findViewById(R.id.input_cpf);
        EditText nickname = (EditText) findViewById(R.id.input_nickname);
        Spinner bloodType = (Spinner) findViewById(R.id.input_blood_type);
        Spinner bloodFactor = (Spinner) findViewById(R.id.input_blood_factor);
        EditText name = (EditText) findViewById(R.id.input_name);
        EditText email = (EditText) findViewById(R.id.input_email);
        EditText birthDate = (EditText) findViewById(R.id.input_birth_date);
        EditText cellphone = (EditText) findViewById(R.id.input_cellphone);
        EditText telephone = (EditText) findViewById(R.id.input_telephone);
        EditText street = (EditText) findViewById(R.id.input_street);
        EditText number = (EditText) findViewById(R.id.input_number);
        EditText neighborhood = (EditText) findViewById(R.id.input_neighborhood);
        EditText cep = (EditText) findViewById(R.id.input_cep);
        EditText complement = (EditText) findViewById(R.id.input_complement);
        EditText city = (EditText) findViewById(R.id.input_city);
        Spinner state = (Spinner) findViewById(R.id.input_state);*/

    }
}
