package com.jsouza.repocatalog.data.remote.response

import com.squareup.moshi.Json

data class RepositoryResponse(
    val id: Long,
    val name: String?,
    val owner: OwnerResponse?,
    @Json(name = "full_name") val fullName: String?,
    @Json(name = "description") var description: String?,
    @Json(name = "stargazers_count") val stargazersCount: Int?,
    @Json(name = "forks_count") val forksCount: Int?,
    @Json(name = "page_number") val pageNumber: Int?
)
