package com.lcbs.theresistanceavalon;

import android.content.Context;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_player_names);
        containerLayout = (LinearLayout)findViewById(R.id.linear1);
        NAMES_NEEDED = GameState.getInstance().getNumPLayers();
        createEditTexts();
    }

    // Dynamically creates EditText Elements
    private void createEditTexts() {
        int num = 1;
        for (int i = 0; i < NAMES_NEEDED; i++) {
            EditText editText = new EditText(getBaseContext());
            containerLayout.addView(editText);
            editText.setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
            layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.setMargins(30, 20, 30, 0);
            editText.setLayoutParams(layoutParams);
            editText.setHint("Player " + num + "\'s Name");
            editText.setHintTextColor(Color.BLACK); // change these later
            editText.setTextColor(Color.BLACK); // change these later
            editText.setTag("PLAYER" + num);
            editText.setId(i+1);
            num++;
        }
        // create submit button here
        final Button submitButton = new Button(this);
        submitButton.setText("Submit");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(15,15,15,15); // left, top, right, botton
        submitButton.setWidth(200);
        submitButton.setGravity(Gravity.CENTER_HORIZONTAL);
        containerLayout.addView(submitButton, lp);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                submitButton.setText("It worked");
                saveNamesStartGame();
            }
        });
    }

    // Saves the names entered and starts new game
    public void saveNamesStartGame() {

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
