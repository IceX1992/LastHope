package com.test.dion.lasthope;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Dashboard extends AppCompatActivity {
 //    Spinner genre = (Spinner) findViewById(R.id.genre);



    private void onArrive() {
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView textView = (TextView) findViewById(R.id.welcomeMessage);
        textView.setText(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        onArrive();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logoutUser) {
            logoutUser();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void logoutUser() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


String notification1;


   //Switch toggleSwitch = (Switch)findViewById(R.id.switch_view);

    public void onSwitchClicked(View view){
      //  toggleSwitch.isChecked();

  //      String castIs = String.valueOf(toggleSwitch.isChecked());
    //    Toast.makeText(this, castIs, Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) view).isChecked();
       // genre.setEnabled(false);
      //  genre.setClickable(false);
        if(on){
            //on
            notification1 = "De spinner is aan";
            Toast.makeText(this, notification1, Toast.LENGTH_LONG).show();
        }else{
            //off

            notification1 = " De spinner is uit";
            Toast.makeText(this, notification1, Toast.LENGTH_LONG).show();
         //genre.setEnabled(true);
        //    genre.setClickable(true);
        }
    }




    private MovieExpert expert = new MovieExpert();
    public void onClickFindMovie(View view){
        //reference to textview
        TextView movie = (TextView) findViewById(R.id.movie);
        //reference to spinner
        Spinner genre = (Spinner) findViewById(R.id.genre);
        //get selected item in spinner
        String movieType = String.valueOf(genre.getSelectedItem());
        //display selected item
        movie.setText(movieType);
        //get recommended movieexpert class
        List<String> movieList =expert.getMovie(movieType);
        StringBuilder moviesFormatted = new StringBuilder();
        for (String movies : movieList){
            moviesFormatted.append(movies).append('\n');
        }
        //display the movies
        movie.setText(moviesFormatted);
    }

}
