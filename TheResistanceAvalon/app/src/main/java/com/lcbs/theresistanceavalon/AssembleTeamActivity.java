package com.lcbs.theresistanceavalon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;


public class AssembleTeamActivity extends ActionBarActivity {

    private String CAPTAIN;
    private int TEAM_SIZE;
    private int RND;
    private Player[] selected;
    private Player[] ALL_PLAYERS;

    TextView questLeaderTextView;
    LinearLayout containerLayout;

    // Players that can be put in the game
    TextView p1;
    TextView p2;
    TextView p3;
    TextView p4;
    TextView p5;
    TextView p6;
    TextView p7;
    TextView p8;
    TextView p9;
    TextView p10;
    TextView[] pTextViews = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assemble_team);
        CAPTAIN = GameState.getInstance().getTeamCaptain();
        TEAM_SIZE = GameState.getInstance().getNumPlayersThisRound();
        RND = GameState.getInstance().getRound();
        selected = new Player[TEAM_SIZE];
        ALL_PLAYERS = GameState.getInstance().getPlayers();
        questLeaderTextView = (TextView) findViewById(R.id.quest_leader_textview);
        questLeaderTextView.setText("The Quest Leader is " + CAPTAIN);
        containerLayout = (LinearLayout)findViewById(R.id.linear2);
        listAllPlayers(ALL_PLAYERS);
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

    public void listAllPlayers(Player[] players) {
        int num = GameState.getInstance().getNumPlayers();
        for (int i = 0; i < num; i++) {
            pTextViews[i] = new TextView(this);
            containerLayout.addView(pTextViews[i]);
            //pTextViews[i].setGravity(Gravity.CENTER_HORIZONTAL);
            pTextViews[i].setText(players[i].getName());
            pTextViews[i].setId(i);

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pTextViews[i].getLayoutParams();
            layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.setMargins(250, 30, 0, 0);

        }

        // create submit button here
        final Button submitButton = new Button(this);
        submitButton.setText("Propose This Team");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(250,60,250,0); // left, top, right, bottom
        //submitButton.setWidth(200);
        //submitButton.setHeight(80);
        submitButton.setGravity(Gravity.CENTER_HORIZONTAL);
        containerLayout.addView(submitButton, lp);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                proposeTeam();
            }
        });

    }

    public void proposeTeam() {
        // check radio buttons and if ok go to team voting
        // else report error
    }

}
