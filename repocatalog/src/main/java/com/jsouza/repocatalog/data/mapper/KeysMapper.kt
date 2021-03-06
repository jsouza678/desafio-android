package com.jsouza.repocatalog.data.mapper

import com.jsouza.repocatalog.data.local.entity.RepoKeysEntity
import com.jsouza.repocatalog.data.remote.response.RepositoryResponse

class KeysMapper {

    companion object {
        fun keysToDatabaseModel(
            repos: List<RepositoryResponse>,
            prevKey: Int?,
            nextKey: Int?
        ): List<RepoKeysEntity> {

            return repos.map { repositoryResponse ->
                RepoKeysEntity(
                    repositoryId = repositoryResponse.id,
                    previousKey = prevKey,
                    nextKey = nextKey
                )
            }
        }
    }
}
