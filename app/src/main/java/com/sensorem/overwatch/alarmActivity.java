package com.sensorem.overwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class alarmActivity extends AppCompatActivity {

    protected Switch theSwitch;
    protected TextView movementText;
    protected TextView doorText;
    protected String isLogin = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        getSupportActionBar().setTitle("Alarm Activity");

        setupUI();
    }

    protected void setupUI(){
        theSwitch = findViewById(R.id.alarmSwitch);
        movementText = findViewById(R.id.movementDetectorTextView);
        doorText = findViewById(R.id.doorStatusTextView);
    }

    //To show the 3 dots button on the action bar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        //inflate menu
        getMenuInflater().inflate(R.menu.three_dots_drop_down, menu);
        return true;
    }

    // Function to handle the toggle button
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        // Menu item click handling

        if (id == R.id.alarmActivityButton){
            Intent alarmIntent = new Intent(this, alarmActivity.class);
            startActivity(alarmIntent);
        }
        if (id == R.id.historyButton){
            Intent historyIntent = new Intent(this, historyLogActivity.class);
            startActivity(historyIntent);
        }
        if (id == R.id.settingsButton){
            Intent settingIntent = new Intent(this, settingActivity.class);
            startActivity(settingIntent);
        }
        if (id == R.id.logOutButton){
            Intent logoutIntent = new Intent(this, MainActivity.class);
            logoutIntent.putExtra("loginState", isLogin);
            startActivity(logoutIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
