package com.lcbs.theresistanceavalon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AssembleTeamActivity extends ActionBarActivity {

    private String CAPTAIN;
    private int TEAM_SIZE;
    private int RND;
    private Player[] selected;
    private Player[] ALL_PLAYERS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assemble_team);
        CAPTAIN = GameState.getInstance().getTeamCaptain();
        TEAM_SIZE = GameState.getInstance().getNumPlayersThisRound();
        RND = GameState.getInstance().getRound();
        selected = new Player[TEAM_SIZE];
        ALL_PLAYERS = GameState.getInstance().getPlayers();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assemble_team, menu);
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
}
