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
    TextView motiveTextView2;
    TextView evilPlayersTextView;
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
        motiveTextView2 = (TextView) findViewById(R.id.player_motive_textview2);
        motiveTextView2.setText("");
        evilPlayersTextView = (TextView) findViewById(R.id.evil_players_textview);
        plyrs = GameState.getInstance().getPlayers();
        nameTextView.setText(plyrs[counter].getName());
        evilPlayersTextView.setText("");
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
            Intent intent = new Intent(this, RoundOneActivity.class);
            startActivity(intent);
            return;
        }

        if (reveal) {
            // reveal player
            //motiveTextView.setText("You are " + plyrs[counter].getMotive());
            readyButton.setText("Pass to Next Player");
            if (plyrs[counter].getMotive() == "Evil"){
                motiveTextView.setText("You are a Minion of Mordred!");
                motiveTextView2.setText("You fight for Evil.");
                String evil = GameState.getInstance().listEvilPlayers(plyrs[counter]);
                evilPlayersTextView.setText("Other Minions: " + evil);
            } else {
                motiveTextView.setText("You are one of King Arthur\'s Knights!");
                motiveTextView2.setText("You fight for Good.");
            }
            if (counter == num - 1) { readyButton.setText("Start Questing"); doneRevealing = true; }
            counter++;
        } else {
            //ready next player
            nameTextView.setText(plyrs[counter].getName());
            motiveTextView.setText("You are ...");
            motiveTextView2.setText("");
            evilPlayersTextView.setText("");
            readyButton.setText("Ready to Reveal");
        }
        reveal = !reveal;
    }

}