package com.example.cuelogic.mykotlinapplication

/**
 * Created by cuelogic on 23/06/17.
 */

/**
 * Object Expressions and Declarations
 */

/**
 * Sometimes we need to create an object of a slight modification of some class, without explicitly
 * declaring a new subclass for it. Java handles this case with anonymous inner classes. Kotlin
 * slightly generalizes this concept with object expressions and object declarations.
 */

/**
 * Object expressions
 *
 * To create an object of an anonymous class that inherits from some type (or types), we write:
 */

/**
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            // ...
        }

        override fun mouseEntered(e: MouseEvent) {
            // ...
        }
    })
*/

/**
 * If a supertype has a constructor, appropriate constructor parameters must be passed to it. Many
 * supertypes may be specified as a comma-separated list after the colon:
 */

open class A2(x: Int) {
    public open val y: Int = x
}

interface B2 { }

val ab: A2 = object : A2(1), B2 {
    override val y = 15
}

/**
 * If, by any chance, we need "just an object", with no nontrivial supertypes, we can simply say:
 */

fun foo2() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

/**
 * Note that anonymous objects can be used as types only in local and private declarations. If you
 * use an anonymous object as a return type of a public function or the type of a public property,
 * the actual type of that function or property will be the declared supertype of the anonymous
 * object, or Any if you didn't declare any supertype. Members added in the anonymous object will
 * not be accessible.
 */

class C3 {
    // Private function, so the return type is the anonymous object type
    private fun foo() = object {
        val x: String = "x"
    }

    // Public function, so the return type is Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // Works
        //val x2 = publicFoo().x  // ERROR: Unresolved reference 'x'
    }
}

/**
 * Just like Java's anonymous inner classes, code in object expressions can access variables from
 * the enclosing scope. (Unlike Java, this is not restricted to final variables.)
 */

//fun countClicks(window: JComponent) {
//    var clickCount = 0
//    var enterCount = 0
//
//    window.addMouseListener(object : MouseAdapter() {
//        override fun mouseClicked(e: MouseEvent) {
//            clickCount++
//        }
//
//        override fun mouseEntered(e: MouseEvent) {
//            enterCount++
//        }
//    })
//    // ...
//}

/**
 * Object declarations
 * Singleton is a very useful pattern, and Kotlin (after Scala) makes it easy to declare
 * singletons:
 */

//object DataProviderManager {
//    fun registerDataProvider(provider: DataProvider) {
//        // ...
//    }
//
//    val allDataProviders: Collection<DataProvider>
//        get() = // ...
//}

/**
 * This is called an object declaration, and it always has a name following the object keyword.
 * Just like a variable declaration, an object declaration is not an expression, and cannot be
 * used on the right hand side of an assignment statement.
 * To refer to the object, we use its name directly:
 */

//DataProviderManager.registerDataProvider(...)

/**
 * Semantic difference between object expressions and declarations
 *
 * There is one important semantic difference between object expressions and object declarations:
 *
 * object expressions are executed (and initialized) immediately, where they are used
 * object declarations are initialized lazily, when accessed for the first time
 * a companion object is initialized when the corresponding class is loaded (resolved),
 * matching the semantics of a Java static initializer
 */
