package com.jsouza.repocatalog.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jsouza.repocatalog.data.local.RepoDatabase
import com.jsouza.repocatalog.data.local.entity.RepositoryEntity
import com.jsouza.repocatalog.data.remote.RepoCatalogService
import com.jsouza.repocatalog.domain.repository.RepoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class RepoRepositoryImpl(
    private val catalogService: RepoCatalogService,
    private val reposDatabase: RepoDatabase
) : RepoRepository {

    @ExperimentalPagingApi
    override suspend fun getSearchResultStream(): Flow<PagingData<RepositoryEntity>> {

        val pagingSourceFactory = { reposDatabase.reposDao().getRepos() }

        return Pager(
            config = PagingConfig(pageSize = GITHUB_PAGE_SIZE),
            remoteMediator = RepoMediator(
                catalogService, reposDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    private companion object {
        private const val GITHUB_PAGE_SIZE = 20
    }
}
