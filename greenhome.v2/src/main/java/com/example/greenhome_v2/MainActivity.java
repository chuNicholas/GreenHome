package com.example.greenhome_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Boolean firstPlay = true;
    //ffbghhgbf
    static public Integer num_Of_Bulbs = 0;
    static public String type_Of_Bulb = "LED";
    static public Double priceOfLightBulbs;
    static public Double priceOfWater;
    static public Double priceOfElectricity;
    static public Integer washing_Machine_Uses = 0;
    static public Boolean is_HE = false;
    static public Integer dish_Washer_Uses = 0;
    static public Boolean is_ES = false;
    static public double priceOfWasherWater;
    static public double priceOfDishWasherWater;
    static public double priceofWasherElectricity;
    static public double priceofDishWasherElectricity;
    static public double priceOfShowerWater;
    static public int people_in_Household = 1;
    static public int shower_Length = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstPlay = getIntent().getBooleanExtra("arg", true);
        if (firstPlay)
        {
            Intent myIntent = new Intent(MainActivity.this, openScreen.class);
            MainActivity.this.startActivity(myIntent);
            firstPlay = false;
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView electricConsumption = findViewById(R.id.ElectricMoney);
        TextView waterConsumption = findViewById(R.id.WaterMoney);
        lightBulbConsumption();
        electricConsumption.setText("Electricity per Month" + priceOfLightBulbs.toString());
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

    public void lightBulbConsumption() {
        //Average hours a light bulb is on for per month in Ontario households
        //int lightBulbDuration = 180;
        double costOfLED = 0.31;
        double costOfCFL = 0.32;
        double costOfIncan = 1.27;

        if (type_Of_Bulb == "CFL") {
            priceOfLightBulbs = costOfCFL * num_Of_Bulbs;
        }
        else if (type_Of_Bulb == "LED") {
            priceOfLightBulbs = costOfLED * num_Of_Bulbs;
        }
        else if (type_Of_Bulb == "Incandescent") {
            priceOfLightBulbs = costOfIncan * num_Of_Bulbs;
        }
    }

    public void waterConsumption() {
        if (is_HE == true) {
            priceOfWasherWater = washing_Machine_Uses * 0.43;
        }
        else if (is_HE == false) {
            priceOfWasherWater = washing_Machine_Uses * 0.65;
        }
        if (is_ES == true) {
            priceOfDishWasherWater = dish_Washer_Uses * 0.06;
        }
        else if (is_ES == false) {
            priceOfDishWasherWater = dish_Washer_Uses * 0.09;
        }
        priceOfWater = priceOfWasherWater + priceOfDishWasherWater;
    }

    public void electricityConsumption() {
        if (is_HE == true) {
            priceofWasherElectricity = washing_Machine_Uses * 0.54;
        }
        else if (is_HE == false) {
            priceofWasherElectricity = washing_Machine_Uses *  0.43;
        }
        if (is_ES == true) {
            priceofDishWasherElectricity = dish_Washer_Uses * 1.40;
        }
        else if (is_ES == false) {
            priceofDishWasherElectricity = dish_Washer_Uses * 1.12;
        }
        priceOfElectricity = priceofWasherElectricity + priceofDishWasherElectricity;
    }

    public void showerConsumption() {
        priceOfShowerWater = shower_Length * people_in_Household * 0.03 * 30;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            // Handle the camera action
            Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
            MainActivity.this.startActivity(myIntent);


        } else if (id == R.id.nav_Goals) {
            Intent myIntent = new Intent(MainActivity.this, Goals.class);
            MainActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_Analysis) {
            Intent myIntent = new Intent(MainActivity.this, activity_analysis.class);
            MainActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_Shopping_List) {
            Intent myIntent = new Intent(MainActivity.this, activity_shopping_list.class);
            MainActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_Input) {
            Intent myIntent = new Intent(MainActivity.this, activity_input.class);
            MainActivity.this.startActivity(myIntent);


        } else if (id == R.id.nav_Settings) {
            Intent myIntent = new Intent(MainActivity.this, activity_settings.class);
            MainActivity.this.startActivity(myIntent);

        } else if (id == R.id.nav_Connect_Device) {
            Intent myIntent = new Intent(MainActivity.this, activity_connect_to_device.class);
            MainActivity.this.startActivity(myIntent);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
