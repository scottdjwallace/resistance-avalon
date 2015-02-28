package com.lcbs.theresistanceavalon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class InstructionsActivity extends ActionBarActivity {

    ListView stepsListView;

    String[] stepsList = {
            "Welcome to The Resistance: Avalon, a game of hidden loyalties.",
            "To begin, select the number of players about to embark on quests. ",
            "Input the names of all players in the order of which you are sitting."
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        ListView mainListView;
        ArrayAdapter mArrayAdapter;
        ArrayList mNameList = new ArrayList();
        stepsListView = (ListView) findViewById(R.id.steps_listview);
        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stepsList);
        stepsListView.setAdapter(mArrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instructions, menu);
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
