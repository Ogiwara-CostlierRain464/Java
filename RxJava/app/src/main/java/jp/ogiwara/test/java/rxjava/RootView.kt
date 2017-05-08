package jp.ogiwara.test.java.rxjava

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.brianegan.bansa.Store
import com.brianegan.bansa.Subscription
import trikita.anvil.Anvil
import trikita.anvil.BaseDSL
import trikita.anvil.RenderableView
import trikita.anvil.DSL.*

class RootView(c: Context,val store: Store<ApplicationState>): RenderableView(c){

    override fun view() {
        template(buildPresentationModel())
    }

    val increment = View.OnClickListener {
        store.dispatch(CounterActions.INCREMENT)
    }

    val decrement = View.OnClickListener {
        store.dispatch(CounterActions.DECREMENT)
    }

    private fun buildPresentationModel(): ViewModel{
        val counter = store.state.counter
        return ViewModel(counter,increment,decrement)
    }

    private fun template(model: ViewModel){
        val (counter,increment,decrement) = model

        linearLayout {
            size(BaseDSL.FILL, BaseDSL.WRAP)
            orientation(LinearLayout.VERTICAL)

            textView {
                text("Counts: ${counter.toString()}")
            }

            button {
                size(BaseDSL.FILL, BaseDSL.WRAP)
                padding(dip(10))
                text("+")
                onClick(increment)
            }

            button {
                size(FILL,WRAP)
                padding(dip(5))
                text("-")
                onClick(decrement)
            }

        }
    }

    var subscription: Subscription? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        subscription = store.subscribe {
            Anvil.render()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        subscription?.unsubscribe()
    }

    data class ViewModel(val counter: Int,val increment: OnClickListener,val decrement: OnClickListener)
}