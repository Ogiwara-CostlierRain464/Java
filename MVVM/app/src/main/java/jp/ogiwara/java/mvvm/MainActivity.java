package jp.ogiwara.java.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import jp.ogiwara.java.mvvm.contract.RepositoryListViewContract;
import jp.ogiwara.java.mvvm.databinding.ActivityMainBinding;
import jp.ogiwara.java.mvvm.model.GitHubService;
import jp.ogiwara.java.mvvm.view.MVVMApplication;
import jp.ogiwara.java.mvvm.view_model.RepositoryListViewModel;

public class MainActivity extends AppCompatActivity implements RepositoryListViewContract{

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        GitHubService gitHubService = ((MVVMApplication) getApplication()).getGitHubService();
        binding.setViewModel(new RepositoryListViewModel((RepositoryListViewContract) this, gitHubService));
    }

    @Override
    public void showError(@NotNull Throwable e){
        e.printStackTrace();
        Toast.makeText(this,"ERROR! CHECK LOG.",Toast.LENGTH_LONG);
    }

    @Override
    public void showRepositories(@NotNull GitHubService.Repositories repositories) {
        binding.repositories.setText(repositories.toString());
    }
}
