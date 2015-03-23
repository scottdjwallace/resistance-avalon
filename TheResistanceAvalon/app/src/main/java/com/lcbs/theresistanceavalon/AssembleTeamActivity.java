package com.lcbs.theresistanceavalon;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class AssembleTeamActivity extends ActionBarActivity {

    private String CAPTAIN;
    private int TEAM_SIZE;
    private int RND;
    private String[] selected;
    private Player[] ALL_PLAYERS;

    TextView questLeaderTextView;
    TextView teamSizeTextView;
    LinearLayout containerLayout;

    CheckBox d1;
    CheckBox d2;
    CheckBox d3;
    CheckBox d4;
    CheckBox d5;
    CheckBox d6;
    CheckBox d7;
    CheckBox d8;
    CheckBox d9;
    CheckBox d10;
    CheckBox[] dCheckBoxes = {d1,d2,d3,d4,d5,d6,d7,d8,d9,d10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assemble_team);
        CAPTAIN = GameState.getInstance().getTeamCaptain();
        TEAM_SIZE = GameState.getInstance().getNumPlayersThisRound();
        RND = GameState.getInstance().getRound();
        selected = new String[TEAM_SIZE];
        ALL_PLAYERS = GameState.getInstance().getPlayers();
        questLeaderTextView = (TextView) findViewById(R.id.quest_leader_textview);
        questLeaderTextView.setText("The Quest Leader is " + CAPTAIN);
        teamSizeTextView = (TextView) findViewById(R.id.team_size_textview);
        teamSizeTextView.setText("Please select " + TEAM_SIZE + " players");
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
            dCheckBoxes[i] = new CheckBox(this);
            containerLayout.addView(dCheckBoxes[i]);
            dCheckBoxes[i].setGravity(Gravity.CENTER_HORIZONTAL);
            dCheckBoxes[i].setText("   " + players[i].getName());
            dCheckBoxes[i].setTextColor(Color.parseColor("#c5a495"));
            dCheckBoxes[i].setId(i);

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dCheckBoxes[i].getLayoutParams();
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
        submitButton.setBackgroundColor(Color.parseColor("#f3d28f"));
        submitButton.setTextColor(Color.parseColor("#433022"));
        submitButton.setGravity(Gravity.CENTER_HORIZONTAL);
        containerLayout.addView(submitButton, lp);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                proposeTeam();
            }
        });

    }

    public void proposeTeam() {
        // check checkboxes and if ok go to team voting
        // else report error
        int checked = 0;
        int num = GameState.getInstance().getNumPlayers();
        for (int i = 0; i < num; i++) {
            final CheckBox checkBox = (CheckBox) findViewById(i);
            if (checkBox.isChecked()) {
                checked++;
            }
        }

        if (checked == TEAM_SIZE) {
            int j = 0;
            int num2 = GameState.getInstance().getNumPlayers();
            for (int i = 0; i < num2; i++) {
                final CheckBox checkBox = (CheckBox) findViewById(i);
                if (checkBox.isChecked()) {
                    selected[j] = ALL_PLAYERS[i].getName();
                    j++;
                }
            }
            GameState.getInstance().setTeamThisRound(selected);
            Intent intent = new Intent(this, TeamVoteActivity.class);
            startActivity(intent);
        } else {
            String message = "Please select " + TEAM_SIZE + " players.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

}
