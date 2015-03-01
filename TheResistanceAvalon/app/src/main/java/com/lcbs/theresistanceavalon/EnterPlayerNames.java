package com.lcbs.theresistanceavalon;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;


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
        for (int i = 0; i < NAMES_NEEDED; i++) {
            EditText editText = new EditText(getBaseContext());
            containerLayout.addView(editText);
            editText.setGravity(Gravity.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
            layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            layoutParams.setMargins(15, 0, 0, 0);
            editText.setLayoutParams(layoutParams);
            editText.setHint("Player " + (i+1) + "\'s Name");
            editText.setTag("PLAYER" + (i+1));
        }
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
