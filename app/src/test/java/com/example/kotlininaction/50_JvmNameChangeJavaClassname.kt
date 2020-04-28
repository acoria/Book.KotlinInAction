@file:JvmName("GiveMeAnotherClassName")
package strings

//JvmName Annotation ändert den Dateinamen in Java -> siehe Verwendungsnachweis

//Changes the addressable class name of a Kotlin top level function
//(which is otherwise generated e.g. join.kt -> becomes JoinKt-Class in Java)
//needs to be added before the package declaration

fun someTopLevelFunctionToBeCalledInJava(){
    println("someTopLevelFunctionToBeCalledInJava")
}

