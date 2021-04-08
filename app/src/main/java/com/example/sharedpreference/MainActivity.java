package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    public static  final String MyFiles =  "MyFile";
    EditText email;
    EditText password;
    SharedPreferences sharedPreferences;

    SharedPreferences getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
         password = findViewById(R.id.password);
        Button button  =  findViewById(R.id.button);
        Button get = findViewById(R.id.btn_get);

         sharedPreferences = getSharedPreferences(MyFiles, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor  editor =  sharedPreferences.edit();

                editor.putString("email",email.getText().toString());
                editor.putString("password",password.getText().toString());

                boolean b =  editor.commit();
                if(b){

                    Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_SHORT).show();
                }
                else {


                    Toast.makeText(MainActivity.this,"Not Saved",Toast.LENGTH_SHORT).show();
                }

                email.setText("");
                password.setText("");
            }
        });




        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getSharedPreferences(MyFiles, MODE_PRIVATE);
                String getEmail = (shared.getString("email", "No email"));
                String getPassword = (shared.getString("password", "No Password"));
                 email.setText(getEmail);
                 password.setText(getPassword);

            }
        });
    }
}
