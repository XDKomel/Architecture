package com.camille.architecture

class Model (name: String = "no name", age: Int = -1, numberOfCats: Int = -1) {
    var name: String = name
    var age: Int = age
    var numberOfCats: Int = numberOfCats

    fun getNewData(): Int {
        return numberOfCats
    }
}