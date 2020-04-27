package com.example.kotlininaction

//-------covariant example-----
open class CoVirus(val id: Int){
    fun spread(){ }
}

//the OUT keyword marks it as covariant.
//Now the herd can be used with all subtypes of Virus because it is ensured that anything
//called on animal can also be called on any subtype
class CoHerd<out T: CoVirus>(private val viruses: List<T>){
    val size: Int get() = viruses.size
    operator fun get(i: Int) : T { return viruses[i] }

    //parameters marked as "out" cannot be used as "in" parameters because they could be changed
    //out-positions are returns, in-positions are importing
//    fun tryToChangeT(virus: T){}
}

fun feedAll(viruses: CoHerd<CoVirus>){
    for(i in 0 until viruses.size){
        viruses[i].spread()
    }
}
//now I have a herd of flu viruses to take care of:
class CoFluVirus(id: Int): CoVirus(id){
    fun spawnInWinter(){}
}

fun spreadMyCoFluVirus(fluViruses: CoHerd<CoFluVirus>){
    for(i in 0 until fluViruses.size){
        fluViruses[i].spawnInWinter()
        //Now the herd can handle subtypes of virus (instead of having to cast to make it work)
        feedAll(fluViruses)
    }
}

//MutableList in Kotlin defined the following:
//MutableList<out T>
//correlates to this in Java:
//MutableList<? extends T>