package com.camille.architecture

class Presenter (name: String = "no name", age: Int = -1, numberOfCats: Int = -1) {
    var model: Model = Model(name, age, numberOfCats)

    fun parseData(): String {
        return when (model.numberOfCats) {
            in 0..2 -> "Не любишь кошек"
            in 3..5 -> "Начинающий любитель кошек"
            in 6..8 -> "Бывалый любитель кошек"
            in 9..10 -> "Профессиональный любитель кошек"
            else -> "Булочка с ничем"
        }
    }
    fun updateProgress(progress: Int) {
        model.numberOfCats = progress
    }
}