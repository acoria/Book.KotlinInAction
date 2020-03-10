package com.example.kotlininaction.importCheck

import com.example.kotlininaction.Plant
import com.example.kotlininaction.Plant.*


fun isAwesome(plant: Plant){
    when(plant){
        TREE -> "tree"
        else -> "nothing"
    }
}