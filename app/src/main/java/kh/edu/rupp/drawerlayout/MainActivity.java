package kh.edu.rupp.drawerlayout;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tlbMain= (Toolbar)findViewById(R.id.tlb_main);
        tlbMain.setTitle("Layout of drawer");

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_main);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, tlbMain, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();



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
}
