package com.test.dion.lasthope;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    public void ShowMessage(View view) {
     //   photo.setImageResource(image);
        EditText username =(EditText) findViewById(R.id.username);
        String usernameValue = String.valueOf(username.getText());

        EditText password = (EditText) findViewById(R.id.password);
        String passwordValue = String.valueOf(password.getText());

        String notification = "";

        if(usernameValue.equals("user") && passwordValue.equals("user")){
           // notification = "U bent ingelogd " + usernameValue;
            onClick(usernameValue);
        }else{
            notification = "Niet ingelogd, voer opnieuw in";
        }

        Toast.makeText(this, notification, Toast.LENGTH_LONG).show();
    }

    public void onClick(String username){
        Intent intent = new Intent(this,Dashboard.class);
        String welcomeMessage = "Welcome " + username;
        intent.putExtra("message", welcomeMessage);
        startActivity(intent);
    }
}
