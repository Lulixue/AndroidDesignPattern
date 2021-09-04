package com.lulixue.androiddesignpattern.prototype

import java.util.*
import kotlin.collections.HashMap


data class User(val name: String, val id: Int, val avatar: String) {
    var lastLogin: Int = 0
}


class UserNormal: Cloneable {
    var name: String = ""

    public override fun clone(): Any {
        return UserNormal().apply {
            name = this@UserNormal.name
        }
    }
}

// 对象的成本比较大，这种基于原型来创建对象的方式就叫作原型设计模式（Prototype Design Pattern），简称原型模式。
class Prototype {

    fun test() {
        val user = User("张三", 1, "zhangsan.png")
        user.lastLogin = 1034
        // 深拷贝, userNew会复制user对象
        val userNew = user.copy()
        println(userNew === user)

        val userNml = UserNormal()
        val userNewNml = userNml.clone()
        println(userNml === userNewNml)


        // 浅拷贝，只会拷贝地址
        val hashMap = HashMap<Int, Any>()
        hashMap[0] = "hello"
        hashMap[1] = Date()
        val copied = hashMap.clone() as HashMap<Int, Any>

        for ((k, v) in hashMap) {
            if (copied[k]!! === v) {
                println("same $k")
            } else {
                println("not same $k")
            }
        }

    }
}


fun testPrototype() {
    Prototype().test()
}