package com.jiheneDorsaf.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor mEditor;
    EditText user,password;
    CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        box=(CheckBox)findViewById(R.id.checkbox);
        Button send=findViewById(R.id.btn_send);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEditor=sharedPreferences.edit();
        shared();
        send.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StringFormatInvalid")
            @Override
            public void onClick(View v) {
                if(box.isChecked()){
                    mEditor.putString(getString(R.string.checkbox),"true");
                    mEditor.commit();
                    String name=user.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();
                    String pass=password.getText().toString();
                    mEditor.putString(getString(R.string.password),pass);
                    mEditor.commit();
                }
                else
                {
                    mEditor.putString(getString(R.string.checkbox),"false");

                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();

                }
            }
        });

    }
    private void  shared(){
        String chek=sharedPreferences.getString(getString(R.string.checkbox),"false");
        String name=sharedPreferences.getString(getString(R.string.name),"");
        String pass=sharedPreferences.getString(getString(R.string.password),"");
        user.setText(name);
        password.setText(pass);
        if(chek.equals("true")){
            box.setChecked(true);

        }
        else{
            box.setChecked(false);
        }
    }
}
