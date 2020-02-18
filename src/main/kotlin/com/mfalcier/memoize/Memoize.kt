package com.mfalcier.memoize

class Memoize<in T, out R>(val f: (T) -> R) : (T) -> R {
    private val values = HashMap<T, R>()
    override fun invoke(x: T): R {
        return values.getOrPut(x, { f(x) })
    }
}

fun <T, R> ((T) -> R).memoize(): (T) -> R = Memoize(this)