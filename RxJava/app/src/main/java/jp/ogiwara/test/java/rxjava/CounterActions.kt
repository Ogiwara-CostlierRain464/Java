package jp.ogiwara.test.java.rxjava

import com.brianegan.bansa.Action


sealed class CounterActions {
    object INIT : Action

    object INCREMENT : Action

    object DECREMENT : Action
}