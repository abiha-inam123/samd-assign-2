package com.example.samdassign2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    EditText mytext = (EditText) findViewById(R.id.text);
    Spinner spfont = (Spinner) findViewById(R.id.fontstyle);
    Spinner spcolor = (Spinner) findViewById(R.id.fontcolor);
    CheckBox cbbold=(CheckBox) findViewById(R.id.bold);
    CheckBox cbitalic=(CheckBox) findViewById(R.id.italic);
    Button show_btn = findViewById(R.id.btnshow);
    EditText myresult = (EditText) findViewById(R.id.result);
    show_btn.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick(View v){
            if (TextUtils.isEmpty(mytext.getText().toString())) {
                Toast.makeText(MainActivity.this, "Kindly Enter Text First", Toast.LENGTH_SHORT).show();
            }
            myresult.setText(mytext.toString());
            if (spfont.getSelectedItemId() == 0)
                myresult.setTypeface(Typeface.);
            else if (spfont.getSelectedItemId() == 1)
                myresult.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/cursive.ttf"));
            else if (spfont.getSelectedItemId() == 2)
                myresult.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/monospace.ttf"));
            else if (spfont.getSelectedItemId() == 3)
                myresult.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/sans.ttf"));
            else
                Toast.makeText(MainActivity.this, "invalid option", Toast.LENGTH_SHORT).show();
            if (spcolor.getSelectedItemId() == 0)
                myresult.setTextColor(Color.BLACK);
            else if(spcolor.getSelectedItemId() == 1)
                myresult.setTextColor(Color.RED);
            else if(spcolor.getSelectedItemId() == 2)
                myresult.setTextColor(Color.CYAN);
            else if(spcolor.getSelectedItemId() == 3)
                myresult.setTextColor(Color.GREEN);
            else
                Toast.makeText(MainActivity.this, "invalid option", Toast.LENGTH_SHORT).show();

            if(cbbold.isChecked()==true)
                myresult.setTypeface(Typeface.DEFAULT_BOLD);
            if(cbitalic.isChecked()==true)
                myresult.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        }
    });

    }
}
