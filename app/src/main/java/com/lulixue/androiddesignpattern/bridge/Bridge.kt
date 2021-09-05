package com.lulixue.androiddesignpattern.bridge

// 将抽象部分与它的实现部分分离，使它们都可以独立地变化。

// 如果需要新增car，只需要扩展car的子类，
// 如果需要新增engine，只需要扩展engine的子类
fun testBridge() {
    val car: RefinedCar = BossCar(HybridEngine())
    car.drive()
}

interface Engine {
    fun start()
}

abstract class Car(engine: Engine) {
    // 引用Engine:
    protected var engine: Engine = engine
    abstract fun drive()
}

abstract class RefinedCar(engine: Engine?) :
    Car(engine!!) {
    override fun drive() {
        engine.start()
        println("Drive $brand car...")
    }

    abstract val brand: String
}

class TinyCar(engine: Engine?) :
    RefinedCar(engine) {
    override val brand: String
        get() = "Tiny"
}

class BossCar(engine: Engine?) :
    RefinedCar(engine) {
    override val brand: String
        get() = "Boss"
}

class HybridEngine : Engine {
    override fun start() {
        println("Start Hybrid Engine...")
    }
}