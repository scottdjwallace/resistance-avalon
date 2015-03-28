package com.lcbs.theresistanceavalon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GameOverActivity extends ActionBarActivity {

    TextView winnersTextView;
    TextView minionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        winnersTextView = (TextView) findViewById(R.id.winners_textview);
        minionsTextView = (TextView) findViewById(R.id.minions_textview);
        if (GameState.getInstance().getGoodScore() == 3){
            winnersTextView.setText("King Arthur\'s Knights have saved Avalon!");
        } else {
            winnersTextView.setText("Minions of Mordred have destroyed Avalon!");
        }
        String evil = GameState.getInstance().listEvilPlayers();
        minionsTextView.setText(evil + " were minions.");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_over, menu);
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

    public void mainMenu(View v) {
        GameState.getInstance().resetGame();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
