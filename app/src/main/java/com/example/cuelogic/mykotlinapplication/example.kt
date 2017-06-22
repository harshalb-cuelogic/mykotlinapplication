package com.example.cuelogic.mykotlinapplication

/**
 * Created by cuelogic on 22/06/17.
 */

/**
 * Visibility Modifiers
 * Classes, objects, interfaces, constructors, functions, properties and their setters can have
 * visibility modifiers. (Getters always have the same visibility as the property.) There are four
 * visibility modifiers in Kotlin: private, protected, internal and public. The default visibility,
 * used if there is no explicit modifier, is public.
 *
 * Below please find explanations of these for different type of declaring scopes.
 *
 * Packages
 *
 * Functions, properties and classes, objects and interfaces can be declared on the "top-level",
 * i.e. directly inside a package:
 */

// file name: example.kt

fun baz() {}

class Bar {}

/**
 * If you do not specify any visibility modifier,
 *
 * public is used by default, which means that your declarations will be visible everywhere;
 *
 * If you mark a declaration private, it will only be visible inside the file containing the
 * declaration;
 *
 * If you mark it internal, it is visible everywhere in the same module;
 *
 * protected is not available for top-level declarations.
 *
 * Examples:
 */

private fun foo() {} // visible inside example.kt

public var bar: Int = 5 // property is visible everywhere
    private set         // setter is visible only in example.kt

internal val baz = 6    // visible inside the same module


/**
 * Classes and Interfaces
 *
 * For members declared inside a class:
 * private means visible inside this class only (including all its members);
 *
 * protected — same as private + visible in subclasses too;
 *
 * internal — any client inside this module who sees the declaring class sees its internal members;
 *
 * public — any client who sees the declaring class sees its public members.
 *
 * NOTE for Java users: outer class does not see private members of its inner classes in Kotlin.
 *
 * If you override a protected member and do not specify the visibility explicitly, the overriding
 * member will also have protected visibility.
 */

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a is not visible
    // b, c and d are visible
    // Nested and e are visible

    override val b = 5   // 'b' is protected
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c and o.d are visible (same module)
    // Outer.Nested is not visible, and Nested::e is not visible either
}

/**
 * Constructors
 *
 * To specify a visibility of the primary constructor of a class, use the following syntax
 * (note that you need to add an explicit constructor keyword):
 */

class C1 private constructor(a: Int) {
//...
}

/**
 * Here the constructor is private. By default, all constructors are public, which effectively
 * amounts to them being visible everywhere where the class is visible (i.e. a constructor of an
 * internal class is only visible within the same module).
 */

/**
 * Local declarations
 * Local variables, functions and classes can not have visibility modifiers.
 */

/**
 * Modules
 * The internal visibility modifier means that the member is visible with the same module. More
 * specifically, a module is a set of Kotlin files compiled together:
 * an IntelliJ IDEA module;
 * a Maven or Gradle project;
 * a set of files compiled with one invocation of the Ant task.
 */

fun extensions()
{
/**
 * Extensions
 * Kotlin, similar to C# and Gosu, provides the ability to extend a class with new functionality
 * without having to inherit from the class or use any type of design pattern such as Decorator.
 * This is done via special declarations called extensions. Kotlin supports extension functions and
 * extension properties.
 */

/**
 * Extension Functions
 * To declare an extension function, we need to prefix its name with a receiver type, i.e. the type
 * being extended. The following adds a swap function to MutableList<Int>:
 */

fun MutableList<Int>.swapElements(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * The this keyword inside an extension function corresponds to the receiver object (the one that
 * is passed before the dot). Now, we can call such a function on any MutableList<Int>:
 */
fun getSwapedValues() {
    val l = mutableListOf(1, 2, 3)
    l.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
}
/**
 * Of course, this function makes sense for any MutableList<T>, and we can make it generic:
 */

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * We declare the generic type parameter before the function name for it to be available in the
 * receiver type expression. See Generic functions.
 */

/**
 * Extensions are resolved statically
 *
 * Extensions do not actually modify classes they extend. By defining an extension, you do not
 * insert new members into a class, but merely make new functions callable with the dot-notation on
 * variables of this type.
 *
 * We would like to emphasize that extension functions are dispatched statically, i.e. they are not
 * virtual by receiver type. This means that the extension function being called is determined by
 * the type of the expression on which the function is invoked, not by the type of the result of
 * evaluating that expression at runtime. For example:
 */

open class C2

class D2: C2()

fun C2.foo() = "c"

fun D2.foo() = "d"

fun printFoo(c: C2) {
    println(c.foo())
}

printFoo(D2())

    /**
     * This example will print "c", because the extension function being called depends only on the
     * declared type of the parameter c, which is the C class.
     *
     * If a class has a member function, and an extension function is defined which has the same
     * receiver type, the same name and is applicable to given arguments, the member always wins.
     * For example:
     */


class C3 {
    fun foo() { println("member") }
}

fun C3.foo() { println("extension") }

    /**
     * If we call c.foo() of any c of type C, it will print "member", not "extension".
     *
     * However, it's perfectly OK for extension functions to overload member functions which have
     * the same name but a different signature:
     */

class C4 {
    fun foo() { println("member") }
}

fun C4.foo(i: Int)
{ println("extension")}

    /**
     * The call to C().foo(1) will print "extension".
     */

    /**
     * Nullable Receiver
     * Note that extensions can be defined with a nullable receiver type. Such extensions can be
     * called on an object variable even if its value is null, and can check for this == null
     * inside the body. This is what allows you to call toString() in Kotlin without checking for
     * null: the check happens inside the extension function.
     */

fun Any?.toString(): String {
    if (this == null) return "null"
    // after the null check, 'this' is autocast to a non-null type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}
}

/**
 * Extension Properties
 *
 * Similarly to functions, Kotlin supports extension properties:
 */

val <T> List<T>.lastIndex: Int
    get() = size - 1

/**
 * Note that, since extensions do not actually insert members into classes, there's no efficient
 * way for an extension property to have a backing field. This is why initializers are not
 * allowed for extension properties. Their behavior can only be defined by explicitly providing
 * getters/setters.
 * Example:
 */

//val Foo.bar = 1 // error: initializers are not allowed for extension properties

/**
 * Companion Object Extensions
 * If a class has a companion object defined, you can also define extension functions and
 * properties for the companion object:
 */

class MyClass {
    companion object { }  // will be called "Companion"
}

fun extensions1()
{
    fun MyClass.Companion.foo() {
        // ...
    }
    /**
     * Just like regular members of the companion object, they can be called using only the class
     * name as the qualifier:
     */

    MyClass.foo()

    /**
     * Scope of Extensions
     * Most of the time we define extensions on the top level, i.e. directly under packages:
     */
//    //package foo.bar
//
//    fun Baz.goo() { ... }
//    To use such an extension outside its declaring package, we need to import it at the call site:
//
//    package com.example.usage
//
//    import foo.bar.goo // importing all extensions by name "goo"
//// or
//            import foo.bar.*   // importing everything from "foo.bar"
//
//    fun usage(baz: Baz) {
//        baz.goo()
//    }
//
//    See Imports for more information.

    }