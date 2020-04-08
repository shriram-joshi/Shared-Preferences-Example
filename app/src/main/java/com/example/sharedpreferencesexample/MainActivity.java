package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,contact;
    Button save,delete,show;
    SharedPreferences mSharedPreference;
    String nameString,phoneString;
    Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_edit_text);
        contact = findViewById(R.id.phone_edit_text);
        save = findViewById(R.id.save_btn);
        delete = findViewById(R.id.delete_btn);
        show = findViewById(R.id.show_btn);

        mSharedPreference = getApplicationContext().getSharedPreferences("MyPrefs",MODE_PRIVATE);
        final SharedPreferences.Editor mEditor = mSharedPreference.edit();

        Intent intent = new Intent(MainActivity.this,Main2Activity.class);

        flag = mSharedPreference.getBoolean("flag",false);
        nameString = mSharedPreference.getString("name",null);
        phoneString = mSharedPreference.getString("contact",null);
        if(flag)
        {
            intent.putExtra("name",nameString);
            intent.putExtra("contact",phoneString);
            startActivity(intent);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameString = name.getText().toString();
                phoneString = contact.getText().toString();
                flag=true;

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                mEditor.putString("name",nameString);
                mEditor.putString("contact",phoneString);
                mEditor.putBoolean("flag",flag);

                mEditor.commit();
                Toast.makeText(MainActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();

                intent.putExtra("name",nameString);
                intent.putExtra("contact",phoneString);
                startActivity(intent);
             }
        });

//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mEditor.remove("name");
//                mEditor.remove("contact");
//
//                mEditor.clear();
//                mEditor.commit();
//
//                name.setText("");
//                contact.setText("");
//                Toast.makeText(MainActivity.this, "Data deleted successfully!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                nameString = mSharedPreference.getString("name",null);
//                phoneString = mSharedPreference.getString("contact",null);
//
//                name.setText(nameString);
//                contact.setText(phoneString);
//            }
//        });

    }
}
