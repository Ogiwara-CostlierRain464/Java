package jp.ogiwara.java.mvvm.contract

import jp.ogiwara.java.mvvm.model.GitHubService

/**
 * Created by ogiwara on 2017/05/05.
 */
interface RepositoryListViewContract {
    fun showRepositories(repositories: GitHubService.Repositories)

    fun showError(error : Throwable)
}