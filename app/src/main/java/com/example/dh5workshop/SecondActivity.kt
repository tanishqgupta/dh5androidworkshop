package com.example.dh5workshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_second.*
import java.util.concurrent.TimeUnit

class SecondActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val api = CurrencyAPI.create()

        val disposableObserver = object : DisposableObserver<Map<String, Cryptocurrency>>() {
            override fun onComplete() { }

            override fun onNext(t: Map<String, Cryptocurrency>) {
                startListview(t)
            }

            override fun onError(e: Throwable) {
                Log.d("error", "Oops, something went wrong ${e.localizedMessage}")
            }
        }

        api.getCurrencies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(disposableObserver)
    }

    fun startListview(currencies: Map<String, Cryptocurrency>) {
        linearLayoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        this.recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = HomeActivityAdapter( currencies )
    }
}
