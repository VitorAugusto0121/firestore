package com.example.firestore

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.submitbutton)
        val cepEdit = findViewById<TextView>(R.id.cepEdit).text
        val districtEdit = findViewById<TextView>(R.id.districtEdit).text
        val addressEdit = findViewById<TextView>(R.id.addressEdit).text
        val nameEdit = findViewById<TextView>(R.id.nameEdit).text
        btn.setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            val user = hashMapOf(
                "nome" to nameEdit.toString(),
                "endereco" to addressEdit.toString(),
                "bairro" to districtEdit.toString(),
                "cep" to cepEdit.toString()
            )
            db.collection("users").add(user)
                .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }
        }
    }
}
