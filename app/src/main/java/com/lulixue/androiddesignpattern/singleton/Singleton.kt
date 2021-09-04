package com.lulixue.androiddesignpattern.singleton

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

// 一个类只有一个实例
class Singleton {
    @RequiresApi(Build.VERSION_CODES.O)
    fun test() {
        // 单例
        val decoder = Base64.getDecoder()

    }
    companion object {
        // 1. 懒汉式，只有在对象单个实例需要时才创建
        @Volatile
        private var lazyInstance: Any? = null

        // 使用双重锁保证
        fun getLazySingleton(): Any {
            if (lazyInstance == null) {
                synchronized(this) {
                    if (lazyInstance == null) {
                        lazyInstance = Object()
                    }
                }
            }
            return lazyInstance!!
        }


        // 2.饿汉式，单例不管你需不需要，在一开始就创建好
        // 不需要加锁，因为一开始就初始化好了对象
        private var hungryInstance = Object()

        fun getHungryInstance(): Any {
            return hungryInstance
        }

    }
}