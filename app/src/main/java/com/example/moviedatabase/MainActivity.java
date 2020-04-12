package com.example.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String user = "rockstar";
    public static String password = "rockstar";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userName_mock = findViewById(R.id.user_name);
        final EditText password_mock = findViewById(R.id.password);


        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName_mock.getText().toString().equals(user)&&password_mock.getText().toString().equals(password)){
                startActivity(new Intent(MainActivity.this, FeedActivity.class));
                finish();}
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
