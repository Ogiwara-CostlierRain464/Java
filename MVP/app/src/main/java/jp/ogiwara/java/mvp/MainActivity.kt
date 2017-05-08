package jp.ogiwara.java.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import jp.ogiwara.java.mvp.contract.UserActions
import jp.ogiwara.java.mvp.contract.View
import jp.ogiwara.java.mvp.presenter.RepositoryLoader
import jp.ogiwara.java.mvp.view.MVPApplication

class MainActivity : AppCompatActivity(),View {

    val repositories: TextView by bindView(R.id.repositories)
    val loadButton: Button by bindView(R.id.load_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region load views

        val gitHubService = (application as MVPApplication).githubService
        val repositoryLoader = RepositoryLoader(this as View,gitHubService!!)

        loadButton.setOnClickListener {//これがMVVMだとなくなる
            repositoryLoader.loadRepository()
        }
        //endregion
    }

    override fun showRepositories(str: String) {
        repositories.text = str
    }
}
