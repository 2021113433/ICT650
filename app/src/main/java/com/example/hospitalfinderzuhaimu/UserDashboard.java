package com.example.hospitalfinderzuhaimu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserDashboard extends AppCompatActivity {
    TextView username;
    String name,email;
    Button hospital,developers,out,userprofile;
    DatabaseReference userdb= FirebaseDatabase.getInstance("https://hospital-finder-zuhaimu-d4772-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users");
    //setup database
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        email= user.getEmail();
        username = (TextView)findViewById(R.id.etName);

        userdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot keyID : datasnapshot.getChildren() ){

                    if(keyID.child("email").getValue().equals(email) ){
                        name = keyID.child("name").getValue().toString();
                        username.setText(name);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //open user profile
        userprofile = (Button) findViewById(R.id.btnuserprofile);
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openuserprofile();
            }
        });
        //hospital
        hospital = (Button) findViewById(R.id.btnHospital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hospital();
            }

        });
        //developers
        developers = (Button) findViewById(R.id.btnAboutDevelopers);
        developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                developers();
            }
        });
        //signout
        out = (Button) findViewById(R.id.btnSignOut);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signout();
            }
        });


    }
    public void openuserprofile(){
        Intent intent = new Intent(this, com.example.hospitalfinderzuhaimu.ProfileActivity.class);
        startActivity(intent);
    }
    public void hospital(){
        Intent intent = new Intent(this, com.example.hospitalfinderzuhaimu.nearbyHospital.class);
        startActivity(intent);
    }
    public void developers(){
        Intent intent = new Intent(this, com.example.hospitalfinderzuhaimu.developers.class);
        startActivity(intent);
    }
    public void signout(){

        Toast.makeText(getApplicationContext(),"User successfully logged out ",Toast.LENGTH_SHORT).show();
        auth.signOut();
        Intent i = new Intent(UserDashboard.this,MainActivity.class);
        startActivity(i);
        finish();
        //Intent i = new Intent(this,MainActivity.class);

        //startActivity(i);
    }
}