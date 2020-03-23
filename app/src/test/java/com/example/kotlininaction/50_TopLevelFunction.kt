package strings

import java.lang.StringBuilder

fun <T> joinToStringTopLevel(
    collection: Collection<T>,
    separator: String = "; ",
    prefix: String = "<",
    postfix: String = ">"
): String{
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()){
        //dont append a separator before the first element
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}