package jp.ogiwara.java.mvp

import org.junit.Test

import org.junit.Assert.*
import rx.Observable
import rx.Observer
import java.util.Arrays.asList

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    /*@Test
    @Throws(Exception::class)
    fun zip(){
        //Observables.static.ofNullable(null).subscribe(::println)
        val o1 = Observable.just(1,3,5)
        val o2 = Observable.just(2,4,6)

        Observable
                .zip(o1,o2,{d1,d2 -> "$d1 + $d2 = ${d1 + d2}"})
                .subscribe(::println)
    }

    @Test
    fun groupBy(){
        Observable.range(1,5)
                .groupBy { it % 2 }
                .subscribe {  grouped ->
                    grouped.toList().subscribe{
                        list -> println(String.format("key=%d,value=%s",grouped.key,list))
                    }
                }
    }

    @Test
    fun distinct(){
        Observable.from(asList(1,2,2,2,3,4,3))
                .distinct()
                .subscribe(::println)
    }

    @Test
    fun timeOut(){

    }*/
    @Test
    fun begin(){
        Observable.range(1,10)
                .subscribe(object: Observer<Int>{
                    override fun onCompleted() {
                        
                    }

                    override fun onError(e: Throwable?) {

                    }

                    override fun onNext(t: Int?) {

                    }
                } )
    }
}