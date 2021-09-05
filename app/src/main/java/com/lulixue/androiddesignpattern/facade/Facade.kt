package com.lulixue.androiddesignpattern.facade

import android.app.Activity
import android.content.Context

// 多个接口，调用多个步骤，与不同的子系统交互
// 建立一个中介，合成一个步骤
// 适配器是做接口转换，解决的是原接口和目标接口不匹配的问题。
//门面模式做接口整合，解决的是多接口调用带来的问题。
class Facade {
    // android中的示例则有context.startActivity
    fun test() {
        val context: Context = Activity()
        //context.startActivity()
        // 封装了接口
    }
}