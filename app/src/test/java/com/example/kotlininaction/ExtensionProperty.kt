package strings

import java.lang.StringBuilder

var StringBuilder.secondLastChar: Char
    get() = get(length - 2)
    set(value: Char) =
        this.setCharAt(length - 2, value)

