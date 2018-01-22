package jp.ogiwara.test.java.rxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(RootView(this,store))
    }
}
