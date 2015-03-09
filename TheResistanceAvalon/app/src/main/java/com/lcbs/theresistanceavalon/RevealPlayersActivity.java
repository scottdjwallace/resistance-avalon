package com.lcbs.theresistanceavalon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RevealPlayersActivity extends ActionBarActivity implements View.OnClickListener {

    TextView nameTextView;
    TextView motiveTextView;
    Button readyButton;
    private int counter;
    private Player[] plyrs;
    private boolean reveal;
    private boolean doneRevealing;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_players);
        readyButton = (Button) findViewById(R.id.ready_button);
        readyButton.setOnClickListener(this);
        nameTextView = (TextView) findViewById(R.id.player_name_textview);
        motiveTextView = (TextView) findViewById(R.id.player_motive_textview);
        plyrs = GameState.getInstance().getPlayers();
        nameTextView.setText(plyrs[counter].getName());
        counter = 0;
        reveal = true;
        doneRevealing = false;
        num = GameState.getInstance().getNumPlayers();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reveal_players, menu);
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
        if (doneRevealing) {
            // start new intent
            Intent intent = new Intent(this, RoundSummaryActivity.class);
            startActivity(intent);
            return;
        }

        if (reveal) {
            // reveal player
            motiveTextView.setText("You are " + plyrs[counter].getMotive());
            readyButton.setText("Next Player");
            if (counter == num - 1) { readyButton.setText("Start Questing"); doneRevealing = true; }
            counter++;
        } else {
            //ready next player
            nameTextView.setText(plyrs[counter].getName());
            motiveTextView.setText("You are ...");
            readyButton.setText("Ready to Reveal");
        }
        reveal = !reveal;
    }

}