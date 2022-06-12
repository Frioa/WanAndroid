package com.yqq.wanandroid

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}