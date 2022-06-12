package com.yqq.wanandroidapimodule

import com.yqq.wanandroidapimodule.model.BaseResponse
import com.yqq.wanandroidapimodule.model.WanAndroidArticleResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*


class WanAndroidApi {

    val json= Json {
        ignoreUnknownKeys = true
    }

    suspend fun greeting(): BaseResponse<WanAndroidArticleResponse> {
        val response = HttpClient().get("https://www.wanandroid.com/article/list/0/json")
        print(response.bodyAsText())
        return json.decodeFromString(response.bodyAsText())
    }

}