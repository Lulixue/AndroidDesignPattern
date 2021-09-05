package com.lulixue.androiddesignpattern.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 顾名思义，将不兼容的接口转成兼容的接口
// 常见的的有ListView的Adapter, RecyclerView的Adapter
// 不改变源码
// 把callable转成Runnable
class Adapter(private val callable: Callable) : Runnable {
    override fun run() {
        callable.execute()
    }
}


// 组合实现
// 把callable转成Runnable
interface Callable {
    fun execute()
}

fun testAdapter() {
    Thread(Adapter(object : Callable {
        override fun execute() {
            println("execute")
        }
    })).start()
}



// 类继承实现
// 将position转成ViewHolder
// 通过继承的方法来进行Adapter
// 类适配器
// 1. 补偿模式，为了兼容，版本升级时的兼容
class MyAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(TextView(context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

}


class MyViewHolder(private val tv: TextView) : RecyclerView.ViewHolder(tv) {

}