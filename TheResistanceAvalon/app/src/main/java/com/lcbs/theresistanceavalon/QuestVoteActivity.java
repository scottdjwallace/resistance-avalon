package com.lcbs.theresistanceavalon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class QuestVoteActivity extends ActionBarActivity {

    TextView currentVoterTextView;
    private int NUM_VOTERS;
    private String[] VOTERS;
    private int voteInc;
    private String currentVoter;
    private int passed;
    private int failed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_vote);
        //VOTERS = GameState.getInstance().getTeamThisRound(); // getting null array here
        NUM_VOTERS = GameState.getInstance().getNumPlayersThisRound();
        currentVoterTextView = (TextView) findViewById(R.id.team_textview);
        voteInc = 0;
        passed = 0;
        failed = 0;
        nextVoter();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quest_vote, menu);
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

    // updates voter string
    public void nextVoter(){
        if (voteInc == NUM_VOTERS) { // done voting
            if ((failed > 1) && (GameState.getInstance().getRound() == 4) && (GameState.getInstance().getNumPlayers() >= 7)) { // failed
                openFailed(currentVoterTextView);
            } else if (failed > 0) { // failed
                openFailed(currentVoterTextView);
            } else { // passed
                openPassed(currentVoterTextView);
            }
        } else {
            //currentVoter = "Current voter is: " + VOTERS[0];
            //currentVoterTextView.setText(currentVoter);

        }
        voteInc++;
    }



    // opens vote alert on button click
    public void openVote(View v){
        //String title = currentVoter;
        String title = "Voter Name";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.vote_message);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton(R.string.pass,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        passed++;
                        nextVoter();
                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.fail,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        failed++;
                        nextVoter();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openFailed(View v) {
        String title = "QUEST HAS FAILED";
        String message = "Evil has succeeded in thworting the quest.";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        GameState.getInstance().newRound();
                        GameState.getInstance().roundWin("evil");
                        Intent intent = new Intent(getApplicationContext(), RoundSummaryActivity.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void openPassed(View v) {
        String title = "QUEST WAS SUCCESSFUL!";
        String message = "Servants of King Arthur rejoice!";

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        GameState.getInstance().newRound();
                        GameState.getInstance().roundWin("good");
                        Intent intent = new Intent(getApplicationContext(), RoundSummaryActivity.class);
                        startActivity(intent);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
