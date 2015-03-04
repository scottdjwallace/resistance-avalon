package com.lcbs.theresistanceavalon;

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
    private int reveal;

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
        counter = 1;
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
        // first time show motive
        // then show ready for next player -- change motive and change name and change button
        // last players button == Start Game
        // once we are done new Intent start game

    }

}
