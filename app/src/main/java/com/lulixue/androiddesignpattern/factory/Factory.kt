package com.lulixue.androiddesignpattern.factory

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import java.text.DateFormat
import java.util.*

class Factory {


    // 工厂方法, 针对不同的LayoutInflater inflater不同的View
    // 使一个类的实例化，延迟到子类
    companion object {
        // 静态工厂方法
        // Integer n = Integer.valueOf(100);
        fun getFactory(): Factory {
            return Factory()
        }
    }

    //复杂度无法被消除，只能被转移：
    //
    //- 不用工厂模式，if-else 逻辑、创建逻辑和业务代码耦合在一起
    //- 简单工厂是将不同创建逻辑放到一个工厂类中，if-else 逻辑在这个工厂类中
    //- 工厂方法是将不同创建逻辑放到不同工厂类中，先用一个工厂类的工厂来来得到某个工厂，再用这个工厂来创建，if-else 逻辑在工厂类的工厂中

    // 简单工厂，根据传入参数返回实例的对象
    // 违背开放-封闭
    fun test() {
        // 简单工厂, 传入参数，生成对应的实例
        Calendar.getInstance();
        DateFormat.getDateInstance();

    }

    // 抽象工厂，工厂是抽象的，产品是具体的，有些情况产品也是抽象的
    class TestFactory : LayoutInflater.Factory2 {
        override fun onCreateView(
            parent: View?,
            name: String,
            context: Context,
            attrs: AttributeSet
        ): View? {
            return null
        }

        override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            return null
        }
    }

}