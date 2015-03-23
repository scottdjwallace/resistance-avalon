package com.lcbs.theresistanceavalon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class EnterPlayerNames extends ActionBarActivity {

    LinearLayout containerLayout;
    Context context;
    private int NAMES_NEEDED;
    EditText playerOne;
    EditText playerTwo;
    EditText playerThree;
    EditText playerFour;
    EditText playerFive;
    EditText playerSix;
    EditText playerSeven;
    EditText playerEight;
    EditText playerNine;
    EditText playerTen;
    EditText[] editTexts = {playerOne, playerTwo, playerThree, playerFour, playerFive, playerSix, playerSeven, playerEight, playerNine, playerTen};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_player_names);
        containerLayout = (LinearLayout)findViewById(R.id.linear1);
        NAMES_NEEDED = GameState.getInstance().getNumPlayers();
        createEditTexts();
    }

    // Dynamically creates EditText Elements
    private void createEditTexts() {
        for (int i = 1; i <= NAMES_NEEDED; i++) {
            editTexts[i-1] = new EditText(getBaseContext());
            containerLayout.addView(editTexts[i-1]);
            editTexts[i-1].setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editTexts[i-1].getLayoutParams();
            layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.setMargins(30, 20, 30, 0);
            editTexts[i-1].setLayoutParams(layoutParams);
            editTexts[i-1].setHint("Player " + i + "\'s Name");
            editTexts[i-1].setHintTextColor(Color.parseColor("#c5a495"));
            editTexts[i-1].setTextColor(Color.parseColor("#c5a495"));
        }
        // create submit button here
        final Button submitButton = new Button(this);
        submitButton.setText("Submit");
        submitButton.setBackgroundColor(Color.parseColor("#f3d28f"));
        submitButton.setTextColor(Color.parseColor("#433022"));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(15,15,15,15); // left, top, right, bottom
        submitButton.setWidth(200);
        submitButton.setGravity(Gravity.CENTER_HORIZONTAL);
        containerLayout.addView(submitButton, lp);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                saveNamesStartGame();
            }
        });
    }

    // Saves the names entered and starts new game
    public void saveNamesStartGame() {
        String[] names = new String[NAMES_NEEDED];
        String name;
        for (int i = 0; i < NAMES_NEEDED; i++) {
            name = editTexts[i].getText().toString();
            if (name.matches("")) {
                Toast.makeText(this, "You all needth a name first.", Toast.LENGTH_SHORT).show();
                return;
            }
            names[i] = name;
        }
        GameState.getInstance().createPlayers(names);

        Intent intent = new Intent(this, RevealPlayersActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_player_names, menu);
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
