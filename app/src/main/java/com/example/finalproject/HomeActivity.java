package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.common.eventbus.EventBus;

public class HomeActivity extends AppCompatActivity {
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Adapter adapter;

    FrameLayout frameLayout;

    Button btnProceed;
    Button btnClrCrt;

    TextView headerName;
    TextView headerEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager);
        adapter = new Adapter(this);
        viewPager2.setAdapter(adapter);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);

        frameLayout = findViewById(R.id.framelayout);

        btnProceed = findViewById(R.id.btnProceed);
        btnClrCrt = findViewById(R.id.btnClrCrt);

        headerName = findViewById(R.id.headerName);
        headerEmail = findViewById(R.id.headerEmail);


        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_signout) {
                    UsersData.userName = "";
                    UsersData.userNumber = "";
                    UsersData.userAddress = "";
                    Intent j = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(j);
                } else {
                    return true;
                }
                return true;
            }
        });
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(UsersData.totalValue !=0) {
                    Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(HomeActivity.this, "Cart is empty", Toast.LENGTH_SHORT).show();
            }
        });
        btnClrCrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment.clearValFrappe();
                BlankFragment2.clearValIced();
                BlankFragment3.clearValPastry();
                UsersData.totalValue = 0;
                Toast.makeText(HomeActivity.this, "Cart cleared", Toast.LENGTH_SHORT).show();
            }
        });
        //BlankFragment.clearValFrappe();


        View hView = navigationView.getHeaderView(0);
        headerName = hView.findViewById(R.id.headerName);
        headerName.setText(UsersData.userName);
        View eView = navigationView.getHeaderView(0);
        headerEmail = eView.findViewById(R.id.headerEmail);
        headerEmail.setText(UsersData.userEmail);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}