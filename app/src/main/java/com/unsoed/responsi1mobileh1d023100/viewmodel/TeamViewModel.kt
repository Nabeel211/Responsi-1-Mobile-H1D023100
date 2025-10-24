package com.unsoed.responsi1mobileh1d023100.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.unsoed.responsi1mobileh1d023100.data.model.SearchResponse
import com.unsoed.responsi1mobileh1d023100.data.repository.TeamRepository

class TeamViewModel : ViewModel() {
    private val repository = TeamRepository()

    val teamData: LiveData<SearchResponse> = repository.teamData
    val error: LiveData<String> = repository.error

    fun loadTeam(teamId: Int, token: String) {
        repository.getTeamDetail(teamId, token)
    }
}