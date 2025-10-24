package com.unsoed.responsi1mobileh1d023100

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.unsoed.responsi1mobileh1d023100.CoachActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHistory = findViewById<CardView>(R.id.btnHistory)
        val btnCoach = findViewById<CardView>(R.id.btnCoach)
        val btnSquad = findViewById<CardView>(R.id.btnSquad)

        // Tombol untuk Club History
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        // Tombol untuk Head Coach
        btnCoach.setOnClickListener {
            // Tambahkan Intent agar pindah ke halaman CoachActivity
            val intent = Intent(this, CoachActivity::class.java)
            startActivity(intent)
        }

        // Tombol untuk Team Squad
        btnSquad.setOnClickListener {
            val intent = Intent(this, TeamSquadActivity::class.java)
            startActivity(intent)
        }
    }
}
