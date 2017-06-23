package com.example.cuelogic.mykotlinapplication

/**
 * Created by cuelogic on 23/06/17.
 */

/**
 * Generics
 * As in Java, classes in Kotlin may have type parameters:
 */

class Box<T>(t: T) {
    var value = t
}

fun function2() {
    /**
     * In general, to create an instance of such a class, we need to provide the type arguments:
     */

    val box: Box<Int> = Box<Int>(1)
    /**
     * But if the parameters may be inferred, e.g. from the constructor arguments or by some other
     * means, one is allowed to omit the type arguments:
     */

    val box1 = Box(1) // 1 has type Int, so the compiler figures out that we are talking about Box<Int>
}
/**
 * Variance
 *
 * One of the most tricky parts of Java's type system is wildcard types (see Java Generics FAQ).
 * And Kotlin doesn't have any. Instead, it has two other things: declaration-site variance and
 * type projections.
 *
 * First, let's think about why Java needs those mysterious wildcards. The problem is explained in
 * Effective Java, Item 28: Use bounded wildcards to increase API flexibility. First, generic types
 * in Java are invariant, meaning that List<String> is not a subtype of List<Object>. Why so? If
 * List was not invariant, it would have been no better than Java's arrays, since the following
 * code would have compiled and caused an exception at runtime:
 */

/**
 * Type projections
 *
 * Use-site variance: Type projections
 *
 * It is very convenient to declare a type parameter T as out and avoid trouble with subtyping on
 * the use site, but some classes can't actually be restricted to only return T's! A good example
 * of this is Array:
 */

//class Array<T>(val size: Int) {
//    fun get(index: Int): T { /* ... */ }
//    fun set(index: Int, value: T) { /* ... */ }
//}

/**
 * This class cannot be either co- or contravariant in T. And this imposes certain inflexibilities. Consider the following function:
 */

fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)

    for (i in from.indices)
        to[i] = from[i]
}

/**
 * This function is supposed to copy items from one array to another. Let's try to apply it in
 * practice:
 */

val ints1: Array<Int> = arrayOf(1, 2, 3)
val any1 = Array<Any>(3) { "" }

fun function3() {
    copy(ints1, any1) // Error: expects (Array<Any>, Array<Any>)
}

/**
 * Generic functions
 * Not only classes can have type parameters. Functions can, too. Type parameters are placed before
 * the name of the function:
 */

fun <T> singletonList(item: T): List<T> {
// ...
}

fun <T> T.basicToString() : String {  // extension function
// ...
}
/**
 * To call a generic function, specify the type arguments at the call site after the name of the
 * function:
 */

val l = singletonList<Int>(1)

/**
 * Generic constraints
 * The set of all possible types that can be substituted for a given type parameter may be
 * restricted by generic constraints.
 */

/**
 * Upper bounds
 * The most common type of constraint is an upper bound that corresponds to Java's extends keyword:
 */

fun <T : Comparable<T>> sort(list: List<T>) {
    // ...
}

/**
The type specified after a colon is the upper bound: only a subtype of Comparable<T> may be substituted for T. For example
*/

//sort(listOf(1, 2, 3)) // OK. Int is a subtype of Comparable<Int>
//sort(listOf(HashMap<Int, String>())) // Error: HashMap<Int, String> is not a subtype of Comparable<HashMap<Int, String>>

/**
 * The default upper bound (if none specified) is Any?. Only one upper bound can be specified
 * inside the angle brackets. If the same type parameter needs more than one upper bound, we need
 * a separate where-clause:
 */

//fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
//        where T : Comparable, T : Cloneable {
//    return list.filter { it > threshold }.map { it.clone() }
//}