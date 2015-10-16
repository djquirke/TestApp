package com.example.m2035690.testapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    //TextView tv;

    TextView tv;
    char[] lhs;


    public void onClick(View v) {
//        EditText e1 = (EditText)findViewById(R.id.num1);
//        EditText e2 = (EditText)findViewById(R.id.num2);
//        try
//        {
//            int num1 = Integer.parseInt(e1.getText().toString());
//            int num2 = Integer.parseInt(e2.getText().toString());
//            int sum = num1 + num2;
//            TextView t1 = (TextView)findViewById(R.id.result);
//            t1.setText(Integer.toString(sum));
//        }
//        catch(Exception e)
//        {
//            TextView t1 = (TextView)findViewById(R.id.result);
//            t1.setText("Invalid input");
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(this.getLocalClassName(), "Activity loaded");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
