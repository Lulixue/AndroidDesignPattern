package com.lulixue.androiddesignpattern.flyWeight

// 运用共享技术有效地支持大量细粒度的对象。
// 享元：共享的单元
// 享元模式的意图是复用对象，节省内存，前提是享元对象是不可变对象。
// 创建对象缓存池, WeakReference
class Flyweight {
    fun test() {
        // -128~127, 存在缓存中 IntegerCache
        Integer.valueOf(1)

        // String利用享元模式复用字面值常量
        // JVM开辟的字符常量池
        val first = "String"
        val second = "String"
    }
}