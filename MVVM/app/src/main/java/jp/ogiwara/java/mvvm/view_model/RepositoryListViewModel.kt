package jp.ogiwara.java.mvvm.view_model

import android.databinding.ObservableInt
import android.view.View
import jp.ogiwara.java.mvvm.contract.RepositoryListViewContract
import jp.ogiwara.java.mvvm.model.GitHubService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class RepositoryListViewModel(val repositoryListView: RepositoryListViewContract,val gitHubService: GitHubService) {

    fun loadRepositories(){
        gitHubService.listRepos("language:Kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Subscriber<GitHubService.Repositories>(){
                    override fun onCompleted() {
                        //Nothing
                    }

                    override fun onError(e: Throwable) {
                        repositoryListView.showError(e)
                    }

                    override fun onNext(t: GitHubService.Repositories) {
                        repositoryListView.showRepositories(t)
                    }
                })
    }
}