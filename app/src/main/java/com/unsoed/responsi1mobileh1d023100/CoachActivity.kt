package com.unsoed.responsi1mobileh1d023100

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023100.databinding.ActivityCoachBinding

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Contoh data biodata (bisa diubah sesuai kebutuhan)
        binding.coachName.text = "Mahmud Figmansyah"
        binding.coachBirth.text = "1945-08-12"
        binding.coachCountry.text = "Blater"
    }
}
