package com.trinityjayd.wordguessgame

class Words {

    //create companion object
    companion object {
        //create a list of words
        private val words = listOf("Apple",
            "Banana",
            "Orange",
            "Pear",
            "Grape",
            "Strawberry",
            "Pineapple",
            "Watermelon",
            "Mango",
            "Peach",
            "Cherry",
            "Lemon",
            "Lime",
            "Raspberry",
            "Blueberry",
            "Blackberry",
            "Pomegranate",
            "Kiwi",
            "Apricot")
    }

    //create a function to return the list
    fun getWords(): List<String> {
        return words
    }
}