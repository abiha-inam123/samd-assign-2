package com.example.samdassign2;
import static android.graphics.Typeface.createFromAsset;

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
                if (spfont.getSelectedItemPosition() == 0)
                    myresult.setTypeface(Typeface.createFromAsset(getAssets(), "font/admiration_pains.ttf"));
                else if (spfont.getSelectedItemPosition() == 1)
                    myresult.setTypeface(Typeface.createFromAsset(getAssets(), "font/playfairdisplay_bold.ttf"));
                else if (spfont.getSelectedItemPosition() == 2)
                    myresult.setTypeface(Typeface.createFromAsset(getAssets(), "font/remachinescript_personal_use.ttf"));
                else if (spfont.getSelectedItemPosition() == 3)
                    myresult.setTypeface(Typeface.createFromAsset(getAssets(), "font/waltographui.ttf"));
                else
                    Toast.makeText(MainActivity.this, "invalid option", Toast.LENGTH_SHORT).show();
                if (spcolor.getSelectedItemPosition() == 0)
                    myresult.setTextColor(Color.BLACK);
                else if(spcolor.getSelectedItemPosition() == 1)
                    myresult.setTextColor(Color.RED);
                else if(spcolor.getSelectedItemPosition() == 2)
                    myresult.setTextColor(Color.CYAN);
                else if(spcolor.getSelectedItemPosition() == 3)
                    myresult.setTextColor(Color.GREEN);
                else
                    Toast.makeText(MainActivity.this, "invalid option", Toast.LENGTH_SHORT).show();

                if(cbbold.isChecked()==true)
                    myresult.setTypeface(null, Typeface.BOLD);
                if(cbitalic.isChecked()==true)
                    myresult.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }
        });

    }
}
