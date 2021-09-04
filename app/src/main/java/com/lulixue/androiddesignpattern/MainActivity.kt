package com.lulixue.androiddesignpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lulixue.androiddesignpattern.prototype.testPrototype
import com.lulixue.androiddesignpattern.proxy.testProxy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testProxy()
        testPrototype()
    }
}