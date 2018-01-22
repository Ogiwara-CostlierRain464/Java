package jp.ogiwara.test.java.rxjava

import com.brianegan.bansa.BaseStore

val store = BaseStore(ApplicationState(),CounterReducer())

class Application: android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        store.dispatch(CounterActions.INIT)
    }
}