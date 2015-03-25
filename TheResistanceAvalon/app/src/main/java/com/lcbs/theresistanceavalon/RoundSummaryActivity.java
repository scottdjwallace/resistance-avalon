package com.lcbs.theresistanceavalon;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class RoundSummaryActivity extends ActionBarActivity {

    TextView roundOverTextView;
    TextView goodScoreTextView;
    TextView badScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_summary);
        roundOverTextView = (TextView) findViewById(R.id.round_number_textview);
        int m = GameState.getInstance().getRound() - 1; // -1 because we've incremented round already
        roundOverTextView.setText("Round " + m + " Over");
        goodScoreTextView = (TextView) findViewById(R.id.good_score_textview);
        int n = GameState.getInstance().getGoodScore();
        goodScoreTextView.setText("Arthur\'s Knights: " + n);
        badScoreTextView = (TextView) findViewById(R.id.bad_score_textview);
        int o = GameState.getInstance().getBadScore();
        badScoreTextView.setText("Mordred\'s Minions: " + o);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_round_summary, menu);
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

    public void nextRound(View v){
        // get round
        // start new intent on new round #
        int r = GameState.getInstance().getRound();
        Log.e("current round: ", Integer.toString(r));
        switch (r) {
            case 2:
                Intent intent2 = new Intent(this, RoundTwoActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, RoundThreeActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this, RoundFourActivity.class);
                startActivity(intent4);
                break;
            case 5:
                Intent intent5 = new Intent(this, RoundFiveActivity.class);
                startActivity(intent5);
                break;
            default:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }
}
