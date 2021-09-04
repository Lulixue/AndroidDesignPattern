package com.lulixue.androiddesignpattern.builder

import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import android.content.Context

class BuilderParent {
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
        var birthYear: Int = 0

    }
}