package com.jsouza.repodetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsouza.repodetail.domain.usecase.FetchPullRequestsFromApi
import com.jsouza.repodetail.domain.usecase.GetPullRequestsFromDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepoDetailViewModel(
    private val fetchPullRequestsFromApi: FetchPullRequestsFromApi,
    private val getPullRequestsFromDatabase: GetPullRequestsFromDatabase
) : ViewModel() {

    fun returnPullRequestsOnLiveData(
        repositoryId: Long
    ) = getPullRequestsFromDatabase.invoke(repositoryId)

    fun loadPullRequestsOfRepository(
        userName: String?,
        repoName: String?,
        repositoryId: Long?
    ) {
        if (userName != null && repoName != null && repositoryId != null) {
            viewModelScope.launch(Dispatchers.IO) {
                fetchPullRequestsFromApi.invoke(userName, repoName, repositoryId)
            }
        }
    }
}
