package com.lulixue.androiddesignpattern.builder

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*


fun testBuilder() {
    val citizen = Citizen.Builder("张三", 23, "374-283432")
        .setReligion("佛教")
        .create()
}

class Citizen private constructor(val name: String, val age: Int, val id: String,
                                  val birthYear: Int, val religion: String){

    // 经典的建造者模式为AlertDialog
    // Builder()负责对象的构建，采用链式调用的方式
    // 对类成员定制，屏蔽了实例化类对象的细节，在create时可以做统一的数据校验
    // 必填的属性填在constructor中
    // 选填的属性使用链式设置函数
    fun test() {
        val context: Context = Activity()
        val dialog = AlertDialog.Builder(context)
            .setMessage("message")
            .setNegativeButton("取消", null)
            .create()
        dialog.show()
    }


    class Builder(val name: String, val age: Int, val id: String) {
        companion object {
            val thisYear = Calendar.YEAR
        }

        private var birthYear: Int = 0 // 出生年份可由id算出
        private var religion: String = "None" // 宗教信仰

        fun setReligion(rel: String): Builder {
            this.religion = rel
            return this
        }
        // 检测数据是否合法
        private fun idToYear(id: String): Int {
            val year = id.substring(0, 4).toInt()
            if (year > thisYear) {
                throw RuntimeException("invalid id")
            }
            return year
        }

        fun create(): Citizen {
            return Citizen(name, age, id, idToYear(id), religion)
        }
    }
}