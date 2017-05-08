package jp.ogiwara.test.java.rxjava

import com.brianegan.bansa.BaseStore


class Application: android.app.Application() {

    val store = BaseStore(ApplicationState(),CounterReducer())

}