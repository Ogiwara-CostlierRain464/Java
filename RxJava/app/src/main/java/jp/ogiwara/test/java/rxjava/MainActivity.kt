package jp.ogiwara.test.java.rxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.jakewharton.rxbinding.widget.RxTextView

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as Application

        setContentView(RootView(this,app.store))
    }
}
