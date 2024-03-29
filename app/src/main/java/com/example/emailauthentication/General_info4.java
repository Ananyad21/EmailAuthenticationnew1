package com.example.emailauthentication;



import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class General_info4 extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private EditText Specify, weight, mention,OtherSpecify, MedicationNames;
    FirebaseFirestore db;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_general_info4);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Specify = findViewById(R.id.editTextText40);
        weight = findViewById(R.id.editTextText45);
        mention = findViewById(R.id.editTextText46);
        OtherSpecify = findViewById(R.id.editTextText47);
        MedicationNames = findViewById(R.id.editTextText48);



        btn1 = findViewById(R.id.button5);
        btn2 = findViewById(R.id.button7);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String S = Specify.getText().toString().trim();
                        String We = weight.getText().toString().trim();
                        String Men = mention.getText().toString().trim();
                        String OtherS = OtherSpecify.getText().toString().trim();
                        String Mname = MedicationNames.getText().toString().trim();




                        Map<String, Object> user = new HashMap<>();
                        user.put("Specify", S);
                        user.put("weight", We);
                        user.put("mention", Men);
                        user.put("OtherSpecify", OtherS);
                        user.put("MedicationNames", Mname);




// Add a new document with a generated ID
                        db.collection("genaral Information 2")
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


                       Intent it = new Intent(General_info4.this, Genaral_info2.class);
                       startActivity(it);
                    }
                }

        );

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                       Intent it = new Intent(General_info4.this, General_info5.class);
                                      startActivity(it);

                                    }
                                }
        );
    }
}