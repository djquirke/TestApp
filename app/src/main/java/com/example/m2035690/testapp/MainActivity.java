package com.example.m2035690.testapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    String lhs;
    String rhs;
    String operator;
    Boolean isLHS = true;


    public void onNumberClick(View v) {
        Button btn = (Button)v;
        String btnText = btn.getText().toString();

        int labelID = R.id.lblBuilder;

        if(isLHS)
        {
            if(lhs.equals("0"))
                lhs = btnText;
            else
                lhs += btnText;
            setLabelText(labelID, lhs);
        }
        else
        {
            if(rhs.equals(""))
            {
                rhs = btnText;
            }
            else
                rhs += btnText;
            setLabelText(labelID, rhs);
        }
    }

    public void onOperatorClick(View v)
    {
        if(!rhs.equals("0") && !lhs.equals("0"))
            onEqualsClick(v);

        operator = ((Button) v).getText().toString();

        String topLbl = lhs + " " + operator;
        addLabelText(R.id.lblCalcBuilder, topLbl);

        isLHS = false;
    }

    public void onEqualsClick(View v)
    {
        if(rhs.equals("") || lhs.equals("0"))
            return;

        float result = 0;

        switch (operator)
        {
            case "+":
                result = Float.parseFloat(lhs) + Float.parseFloat(rhs);
                break;
            case "-":
                result = Float.parseFloat(lhs) - Float.parseFloat(rhs);
                break;
            case "*":
                result = Float.parseFloat(lhs) * Float.parseFloat(rhs);
                break;
            case "/":
                if(rhs.equals("0"))
                {
                    setLabelText(R.id.lblBuilder, "Cannot divide by zero.");
                    Reset();
                    setLabelText(R.id.lblCalcBuilder, "");
                    return;
                }
                result = Float.parseFloat(lhs) / Float.parseFloat(rhs);
                break;
            default:
                break;
        }

        if(result == Math.round(result))
        {
            String strRes = Integer.toString((int)result);
            setLabelText(R.id.lblBuilder, Integer.toString((int)result));
            lhs = strRes;
        }
        else
        {
            String strRes = Float.toString(result);
            setLabelText(R.id.lblBuilder, strRes);
            lhs = strRes;
        }

        setLabelText(R.id.lblCalcBuilder, "");

        rhs = "";
        //Reset();

    }

    private void Reset()
    {
        isLHS = true;
        lhs = "0";
        rhs = "";
    }

    public void setLabelText(int labelTextId, String str)
    {
        TextView t1 = (TextView)findViewById(labelTextId);
        t1.setText(str);
    }

    public void addLabelText(int labelId, String str)
    {
        TextView t1 = (TextView)findViewById(labelId);
        CharSequence curText = t1.getText();
        String newText = curText.toString() + str;
        t1.setText(newText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(this.getLocalClassName(), "Activity loaded");
        lhs = "0";
        rhs = "";
        TextView t1 = (TextView)findViewById(R.id.lblBuilder);
        t1.setText(lhs);
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
