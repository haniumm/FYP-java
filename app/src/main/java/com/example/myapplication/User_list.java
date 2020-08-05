package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.util.Calendar;

public class User_list extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btn_stocks;

//    <<<<<<<<<<<<<<<<<< har page py laga gii drawer>>>>>>>>>>>
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);


        //        <<<<<<<<<<<<<<<<<<<<<<<<<<Hooks of menu>>>>>>>>>>>>>>
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


//        <<<<<<<<<<<<<<<<<<<<<<<<<<tooolbar manu sy>>>>>>>>>>>>>>>>>>>>>>

        setSupportActionBar(toolbar);


//        <<<<<<<<<<<<<<<<<<<,navigation drawer Menu>>>>>>>>>>>>>>>>>>>>>>>
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);





        btn_stocks = findViewById(R.id.stocksbutton);
        btn_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensbooks();
                Toast.makeText(User_list.this, " Books____aStock Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        Calendar calendar = Calendar.getInstance();
        String issueDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView = findViewById(R.id.textView6);
        textView.setText(issueDate);


    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,menu ki coding>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<ya be menu ka liya hai>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_Contact) {

            Intent i = new Intent(User_list.this, Contact_US.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.nav_Feedback) {

            Intent i = new Intent(User_list.this, Feedback.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_About) {

            Intent i = new Intent(User_list.this,AboutUs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_Menu) {

            Intent i = new Intent(User_list.this,Homepage.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_Books_details) {

            Intent i = new Intent(User_list.this,User_list.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.nav_log_out) {

            Intent i = new Intent(User_list.this,MainActivity.class);
            startActivity(i);
            return true;
        }
        //or yaha end hora hai
        return true;
    }


    public void opensbooks() {
        Intent myIntent = new Intent(User_list.this, firstrecyler.class);
        User_list.this.startActivity(myIntent);

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}