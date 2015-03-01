package com.lcbs.theresistanceavalon;

import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameSetupActivity extends ActionBarActivity implements View.OnClickListener{

    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button tenButton;
    TextView howManyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);
        howManyTextView = (TextView) findViewById(R.id.howmany_textview);
        fiveButton = (Button) findViewById(R.id.five_button);
        fiveButton.setOnClickListener(this);
        sixButton = (Button) findViewById(R.id.six_button);
        sixButton.setOnClickListener(this);
        sevenButton = (Button) findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(this);
        eightButton = (Button) findViewById(R.id.eight_button);
        eightButton.setOnClickListener(this);
        nineButton = (Button) findViewById(R.id.nine_button);
        nineButton.setOnClickListener(this);
        tenButton = (Button) findViewById(R.id.ten_button);
        tenButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_setup, menu);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.five_button:
                GameState.getInstance().setNumPlayers(5);
                break;
            case R.id.six_button:
                GameState.getInstance().setNumPlayers(6);
                break;
            case R.id.seven_button:
                GameState.getInstance().setNumPlayers(7);
                break;
            case R.id.eight_button:
                GameState.getInstance().setNumPlayers(8);
                break;
            case R.id.nine_button:
                GameState.getInstance().setNumPlayers(9);
                break;
            case R.id.ten_button:
                GameState.getInstance().setNumPlayers(10);
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
    }
}
