package com.example.emailauthentication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Genaral_info extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText name, date, reason, sceenexpo, age, duration, reduction, remark;
    FirebaseFirestore db;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genaral_info);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextText13);
        date = findViewById(R.id.editTextDate3);
        reason = findViewById(R.id.editTextText20);
        sceenexpo = findViewById(R.id.editTextText21);
        age = findViewById(R.id.editTextText22);
        duration = findViewById(R.id.editTextText23);
        reduction = findViewById(R.id.editTextText24);
        remark = findViewById(R.id.editTextText25);

        btn1 = findViewById(R.id.previousbtn);
        btn2 = findViewById(R.id.previousbtn2);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String names = name.getText().toString().trim();
                        String dates = date.getText().toString().trim();
                        String reasons = reason.getText().toString().trim();
                        String screenexpo = sceenexpo.getText().toString().trim();
                        String ages = age.getText().toString().trim();
                        String durations = duration.getText().toString().trim();
                        String reductions = reduction.getText().toString().trim();
                        String remarks = remark.getText().toString().trim();


                        Map<String, Object> user = new HashMap<>();
                        user.put("name", names);
                        user.put("date", dates);
                        user.put("reason", reasons);
                        user.put("sceenexpo", screenexpo);
                        user.put("age", ages);
                        user.put("duration", durations);
                        user.put("reduction", reductions);
                        user.put("remark", remarks);


// Add a new document with a generated ID
                        db.collection("genaral Information")
                                .add(user)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });


                        Intent it = new Intent(Genaral_info.this, Client_Information_2.class);
                        startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent it = new Intent(Genaral_info.this, Genaral_info2.class);
                                        startActivity(it);

                                    }
                                }
        );
    }
}





