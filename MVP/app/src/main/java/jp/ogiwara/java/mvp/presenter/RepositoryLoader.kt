package jp.ogiwara.java.mvp.presenter

import jp.ogiwara.java.mvp.contract.UserActions
import jp.ogiwara.java.mvp.contract.View
import jp.ogiwara.java.mvp.model.GitHubService
import jp.ogiwara.java.mvp.model.Repositories
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RepositoryLoader(val view: View,val gitHubService: GitHubService): UserActions {

    override fun loadRepository() {
        gitHubService.listRepos("language:kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Repositories>(){
                    override fun onNext(t: Repositories?) {
                        view.showRepositories(t.toString())
                    }

                    override fun onError(e: Throwable?) {
                        e?.printStackTrace()
                    }

                    override fun onCompleted() {
                        //NOTHING
                    }
                })
    }
}