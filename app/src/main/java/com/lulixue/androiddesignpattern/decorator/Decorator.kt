package com.lulixue.androiddesignpattern.decorator

import java.io.*

// 装饰器类，是功能的增强
class Decorator {
    // JAVA IO是装饰器模式的例子
    fun test() {
        val inputStream = FileInputStream("/sdcard/file.txt")
        val reader = DataInputStream(inputStream)
        val bufferedReader = BufferedInputStream(inputStream)

        // DataInputStream BufferedInputStream继承自
        // InputStream的增加类，FilterInputStream
        bufferedReader.close()
        reader.close()
        inputStream.close()
    }
}