package com.lulixue.androiddesignpattern.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

fun testProxy() {
    val proxy = NormalProxy()
    proxy.request()

    val dp = DynamicProxy().createProxy(Subject::class.java)
    dp.request()
    (dp as Subject2).response()
}

//抽象主题
interface Subject {
    fun request()
}

interface Subject2 {
    fun response()
}
//真实主题
class RealSubject : Subject {
    override fun request() {
        println("访问真实主题方法...")
    }
}

//代理, 真实主题必须先存在
class NormalProxy : Subject {
    private var realSubject: RealSubject? = null
    override fun request() {
        if (realSubject == null) {
            realSubject = RealSubject()
        }
        preRequest()
        realSubject!!.request()
        postRequest()
    }

    fun preRequest() {
        println("访问真实主题之前的预处理。")
    }

    fun postRequest() {
        println("访问真实主题之后的后续处理。")
    }
}


class DynamicProxy {

    fun<T> createProxy(obj: Class<T>): T {
        return Proxy.newProxyInstance(obj.classLoader, arrayOf(obj, Subject2::class.java), DynamicHandler()) as T
    }

    class DynamicHandler: InvocationHandler {
        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
            println("dynamic ${method!!.name}")
            return null
        }
    }
}