package com.example.hospitalfinderzuhaimu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class developers extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        button = (Button) findViewById(R.id.btnhome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdashboard();
            }
        });
    }
    public void userdashboard(){
        Intent intent = new Intent(this, UserDashboard.class);
        startActivity(intent);
    }
}