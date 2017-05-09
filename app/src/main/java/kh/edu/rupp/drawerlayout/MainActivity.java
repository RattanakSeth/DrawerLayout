package kh.edu.rupp.drawerlayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawerLayout;
    private TextView profilename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get user name from share reference
        profilename = (TextView) findViewById(R.id.profile_name);
       // profilename.setText("noname");


        //draw toolbar
        Toolbar tlbMain= (Toolbar)findViewById(R.id.tlb_main);
        tlbMain.setTitle("Layout of drawer");

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        // Navigation View Header or set onclick to header menu
        View navigationHeaderView = navigationView.getHeaderView(0);
        //navigationHeaderView.findViewById(R.id.txt_edit).setOnClickListener(this);
        navigationHeaderView.findViewById(R.id.txt_logout).setOnClickListener(this);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_main);

        //set toggle bar or sandwich bar
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, tlbMain, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        //get data that store in share reference
        SharedPreferences preferences = getSharedPreferences("user.pref",MODE_PRIVATE);
        String username = preferences.getString("name","Rattanak");
        TextView txtUsername = (TextView) navigationHeaderView.findViewById(R.id.profile_name);
        txtUsername.setText(username);


    }

    void callFragmentTraining()
    {
        FragmentTraining fragmentTraining = new FragmentTraining();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.lyt_content,fragmentTraining,"fragmentTraining");
        transaction.commit();
    }

    void callFragmentNewsActivity()
    {
        NewsActivity newsActivity = new NewsActivity();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.lyt_content,newsActivity,"fragmentRecyclerview");
        transaction.commit();
    }

    //do loged out from main activity
    private void doLogout() {
        // Clear username preference
        SharedPreferences preference = getSharedPreferences(Login.PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(Login.KEY_USERNAME, null);
        editor.commit();

        // Show login form
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        switch (item.getItemId())
        {
            case R.id.training_curse:
                callFragmentTraining();
                break;
            case R.id.book:
                callFragmentNewsActivity();
                break;
            case R.id.feedback:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.txt_logout:
                doLogout();
                break;
        }
    }
}
