package com.unsoed.responsi1mobileh1d023100

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023100.databinding.ActivityTeamSquadBinding
import com.unsoed.responsi1mobileh1d023100.ui.adapter.SquadAdapter
import com.unsoed.responsi1mobileh1d023100.ui.fragment.PlayerDetailFragment
import com.unsoed.responsi1mobileh1d023100.viewmodel.TeamViewModel

class TeamSquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamSquadBinding
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TeamViewModel::class.java]

        val teamId = 63
        viewModel.loadTeam(teamId, "212e65655a23401785a660f172793f65")

        binding.rvSquad.layoutManager = LinearLayoutManager(this)

        viewModel.teamData.observe(this) { team ->
            val adapter = SquadAdapter(team.squad) { player ->
                PlayerDetailFragment(
                    player.name,
                    player.dateOfBirth ?: "-",
                    player.nationality,
                    player.position ?: "-"
                ).show(
                    supportFragmentManager,
                    PlayerDetailFragment::class.java.simpleName
                )
            }
            binding.rvSquad.adapter = adapter
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}