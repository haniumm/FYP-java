package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button btn_admin, btn_book, btn_stocks, btn_contact, btn_rate, btn_msg, btn_about, btn_feed, btn_Login, btn_Close;


    EditText User_ID, Password;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

//        <<<<<<<<<<<<<<<<<<<<<<<<<<Hooks of menu>>>>>>>>>>>>>>
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


//        <<<<<<<<<<<<<<<<<<<<<<<<<<tooolbar manu sy>>>>>>>>>>>>>>>>>>>>>>

        setSupportActionBar(toolbar);


//<<<<<<<<<<<<<<<<<<<<<<<<<<,navigation drawer Menu>>>>>>>>>>>>>>>>>>>>>>>
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


        //<<<<<<<<<<<<<<<<<<<<<initialization of button>>>>>>>>>>>>>>>>>
        btn_stocks = findViewById(R.id.stocksbutton);
        btn_book = findViewById(R.id.bookbutton);
        btn_msg = findViewById(R.id.msgbutton);
        btn_contact = findViewById(R.id.contactbutton);
        btn_rate = findViewById(R.id.ratebutton);
        btn_about = findViewById(R.id.aboutbutton);
        btn_admin = findViewById(R.id.adminbutton);
        btn_feed = findViewById(R.id.feedbutton);
        btn_Login = findViewById(R.id.adminbutton);


//<<<<<<<<<<<<<<<apply toast on te button wic perfom onclick function.>>>>>>>>>>>>>
        btn_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this, " BooksStock Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this, "SearchBooks Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Homepage.this, "CheckMsgs Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "AdminsUse Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencontact_us();
                Toast.makeText(Homepage.this, "ContactUs Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openratepage();

                Toast.makeText(Homepage.this, "RateUs Clicked", Toast.LENGTH_SHORT).show();

            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openabout_us();
                Toast.makeText(Homepage.this, "AboutUs Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        btn_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfeedback();
                Toast.makeText(Homepage.this, "FeedbackUS Clicked ", Toast.LENGTH_SHORT).show();
            }
        });
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        //button working start of opening new page

    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<ya be drawer ki coding hai jo slide hori hai ous k liya >>>>>>>>>>>>>>>>>>>>
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<menu ki coding ko call kiya yaha>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<^^^ya end upr menu ki coding^^^>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<or  necha homepage sy Recycler ok call kiya tha for checking>>>>>>>>>>>>>>
    public void openratepage() {
        Intent myIntent = new Intent(Homepage.this,firstrecyler.class);
        Homepage.this.startActivity(myIntent);

        //run kro or crash hone do
    }

    public void opencontact_us() {

        Intent contactIntent = new Intent(Homepage.this, Contact_US.class);
        Homepage.this.startActivity(contactIntent);
    }

    public void openfeedback() {

        Intent feedbackIntent = new Intent(Homepage.this, Feedback.class);
        Homepage.this.startActivity(feedbackIntent);
    }

    public void openabout_us() {

        Intent aboutIntent = new Intent(Homepage.this, AboutUs.class);
        Homepage.this.startActivity(aboutIntent);
    }


    //<<<<<<<<<<<<ya neecha  popup wala code hai jo admin py ata hai>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private void showDialog() {
        AlertDialog.Builder alert;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alert = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            alert = new AlertDialog.Builder(this);
        }
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dailog, null);
        User_ID = view.findViewById(R.id.edUser_ID);
        Password = view.findViewById(R.id.edPassword_ID);
        btn_Login = view.findViewById(R.id.btn_Login);
        btn_Close=view.findViewById(R.id.btn_Close);
        alert.setView(view);
        alert.setCancelable(false);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = User_ID.getText().toString();
                Toast.makeText(getApplicationContext(), "NAME:" + userid, Toast.LENGTH_LONG).show();
            }
        });
        final AlertDialog dialog = alert.create();
        dialog.getWindow().requestFeature(getWindow().FEATURE_NO_TITLE);
        dialog.show();

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
               // Toast.makeText(getApplicationContext(), "Exit" + , Toast.LENGTH_LONG).show();
            }
        });

    }
//<<<<<<<<<<<<ya  nechha be menu ka liya hai jo menu slide hota or waha sy next page py jata hai>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_Contact) {

            Intent i = new Intent(Homepage.this, Contact_US.class);
            startActivity(i);
        return true;
    }

        if (id == R.id.nav_Feedback) {

            Intent i = new Intent(Homepage.this, Feedback.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_About) {

            Intent i = new Intent(Homepage.this,AboutUs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_Menu) {

            Intent i = new Intent(Homepage.this,Homepage.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.nav_Books_details) {

            Intent i = new Intent(Homepage.this,User_list.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.nav_log_out) {

            Intent i = new Intent(Homepage.this,MainActivity.class);
            startActivity(i);
            return true;
        }
    //or yaha end hora hai
        return true;
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<^^^^^^^^Yaha end upre wala menu ka code^^^^^^^^^^^>>>>>>>>>>>>>>>>>>>>>
}
//ye raha wo page