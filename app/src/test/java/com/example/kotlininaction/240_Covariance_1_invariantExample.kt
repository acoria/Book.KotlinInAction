package com.example.kotlininaction

//A covariant class is a generic class for which the following holds:
//Producer<A> is a subtype of Producer<B> if A is a subtype of B

//out: this class is declared as covariant on T
//This means any subtype of T can be used. Without the "out" only type T could be used
interface Producer<out T> {
    fun produce(): T
}

//-------invariant example-----
open class Virus(val id: Int){
    fun spread(){ }
}

//invariant collection-like class:
class Herd<T: Virus>(private val viruses: List<T>){
    val size: Int get() = viruses.size
    operator fun get(i: Int) : T { return viruses[i]
    }
}

fun feedAll(viruses: Herd<Virus>){
    for(i in 0 until viruses.size){
        viruses[i].spread()
    }
}
//now I have a herd of flu viruses to take care of:
class FluVirus(id: Int): Virus(id){
    fun spawnInWinter(){}
}

fun spreadMyFluVirus(fluViruses: Herd<FluVirus>){
    for(i in 0 until fluViruses.size){
        fluViruses[i].spawnInWinter()
        //type missmatch because a FluVirus is not directly a Virus
//        feedAll(fluViruses)
    }
}