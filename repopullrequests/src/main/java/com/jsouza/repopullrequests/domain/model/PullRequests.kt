package com.jsouza.repopullrequests.domain.model

import com.jsouza.repopullrequests.data.remote.response.OwnerResponse

data class PullRequests(
    var id: Int,
    var url: String?,
    var title: String?,
    var body: String?,
    var owner: OwnerResponse?,
    var createdAt: String?,
    var state: String?,
    var repositoryId: Long?
)
