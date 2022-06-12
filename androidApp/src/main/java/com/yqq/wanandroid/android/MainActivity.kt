package com.yqq.wanandroid.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.yqq.wanandroidapimodule.WanAndroidApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        mainScope.launch {
            kotlin.runCatching {
                WanAndroidApi().greeting()
            }.onSuccess {
                tv.text = it.data.datas.first().title
            }.onFailure {
                println(it.printStackTrace())
                tv.text = "Error: ${it.localizedMessage}"
            }
        }
    }
}
