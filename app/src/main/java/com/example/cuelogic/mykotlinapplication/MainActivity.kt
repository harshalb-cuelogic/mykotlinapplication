package com.example.cuelogic.mykotlinapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datatypes()
        packages()
        ControlFlow()
        ReturnsAndJumps()
        PropertiesAndFields()
    }

    fun datatypes()
    {
        /**
         * Data Types	https://kotlinlang.org/docs/reference/basic-types.html
         * */

        //Variable declaration
        var variable = 10

        //Constant declaration
        val constant = 10

        /**
         * Basic Types
         * In Kotlin, everything is an object in the sense that we can call member functions and
         * properties on any variable. Some types are built-in, because their implementation is
         * optimized, but to the user they look like ordinary classes.
         */

        /**
         * Numbers
         * Kotlin handles numbers in a way close to Java, but not exactly the same. For example,
         * there are no implicit widening conversions for numbers, and literals are slightly
         * different in some cases.
         * Kotlin provides the following built-in types representing numbers (this is close to Java)
         *
         * Type	    Bit width
         * Double	64
         * Float	32
         * Long	    64
         * Int	    32
         * Short	16
         * Byte	    8
         * Note that characters are not numbers in Kotlin.
         */

        //Double
        var bigDouble: Double = Double.MAX_VALUE
        var smallDouble: Double = Double.MIN_VALUE

        println("Biggest Double : " + bigDouble)
        println("Smallest Double : " + smallDouble)

        //Float
        var bigFloat: Float = Float.MAX_VALUE
        var smallFloat: Float = Float.MIN_VALUE

        println("Biggest Float : " + bigFloat)
        println("Smallest Float : " + smallFloat)

        //Long
        var bigLong: Long = Long.MAX_VALUE
        var smallLong: Long = Long.MIN_VALUE

        println("Biggest Long : " + bigLong)
        println("Smallest Long : " + smallLong)

        //Int
        var bigInt: Int = Int.MAX_VALUE
        var smallInt: Int = Int.MIN_VALUE

        println("Biggest Int : " + bigInt)
        println("Smallest Int : " + smallInt)

        //Short
        var bigShort: Short = Short.MAX_VALUE
        var smallShort: Short = Short.MIN_VALUE

        println("Biggest Short : " + bigShort)
        println("Smallest Short : " + smallShort)

        //Byte
        var bigByte: Byte = Byte.MAX_VALUE
        var smallByte: Byte = Byte.MIN_VALUE

        println("Biggest Byte : " + bigByte)
        println("Smallest Byte : " + smallByte)

        /**
         * Booleans are either true or false
         */

        if (true is Boolean){
            print("true is boolean\n")
        }

        /**
         * Characters
         */

        var letterGrade: Char = 'A'
        println("A is a Char : " + (letterGrade is Char))

        /**
         * Stings
         */

        var sampleString: String = "Sample String"
        println("Sample String is a String : " + (sampleString is String))

        /**
         * Literal Constants
         * There are the following kinds of literal constants for integral values:
         * Decimals: 123
         * Longs are tagged by a capital L: 123L
         * Hexadecimals: 0x0F
         * Binaries: 0b00001011
         * NOTE: Octal literals are not supported.
         */

        /**
         * Kotlin also supports a conventional notation for floating-point numbers:
         * Doubles by default: 123.5, 123.5e10
         * Floats are tagged by f or F: 123.5f
         */

        /**
         * Underscores in numeric literals (since 1.1)
         * You can use underscores to make number constants more readable:
         */

        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val socialSecurityNumber = 999_99_9999L
        val hexBytes = 0xFF_EC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010

        println(oneMillion)
        println(creditCardNumber)
        println(socialSecurityNumber)
        println(hexBytes)
        println(bytes)
        println("End")

        /**
         * Every number type supports the following conversions:
         * toByte(): Byte
         * toShort(): Short
         * toInt(): Int
         * toLong(): Long
         * toFloat(): Float
         * toDouble(): Double
         * toChar(): Char
         */

        /**
         * Casting
         */

        println("3.14 to Int : " + (3.14.toInt()))
        println("A to Int : " + (letterGrade.toInt()))
        println("65 to Char : " + (65.toChar()))


        /**
         * Operations
         * Kotlin supports the standard set of arithmetical operations over numbers, which are
         * declared as members of appropriate classes (but the compiler optimizes the calls down to
         * the corresponding instructions).
         *
         * As of bitwise operations, there're no special characters for them, but just named
         * functions that can be called in infix form, for example:
         */

        println("1 shl 2 ${1 shl 2}")
        println("2 shr 1 ${2 shr 1}")
        println("2 ushr 1 ${2 ushr 1}")
        println("2 or 1 ${2 or 1}")
        println("2 xor 1 ${2 xor 1}")
        println("2 inv ${2.inv()}")

        /**
         * Here is the complete list of bitwise operations (available for Int and Long only):
         * shl(bits) – signed shift left (Java's <<)
         * shr(bits) – signed shift right (Java's >>)
         * ushr(bits) – unsigned shift right (Java's >>>)
         * and(bits) – bitwise and
         * or(bits) – bitwise or
         * xor(bits) – bitwise xor
         * inv() – bitwise inversion
         */

        /**
         * Booleans
         * The type Boolean represents booleans, and has two values: true and false.
         * Booleans are boxed if a nullable reference is needed.
         * Built-in operations on booleans include
         * || – lazy disjunction
         * && – lazy conjunction
         * ! - negation
         */

        println(true || false)
        println(true || true)
        println(true && false)
        println(true && true)
        println(!true)
        println(!false)

        /**
         * Arrays
         * Arrays in Kotlin are represented by the Array class, that has get and set functions
         * (that turn into [] by operator overloading conventions), and size property, along with a
         * few other useful member functions
         */

        /**
         * To create an array, we can use a library function arrayOf() and pass the item values to
         * it, so that arrayOf(1, 2, 3) creates an array [1, 2, 3]. Alternatively, the
         * arrayOfNulls() library function can be used to create an array of a given size filled
         * with null elements
         */

        var arrayOfInt = arrayOf(1,2,3)
        var arrayOfMixTypes = arrayOf(1,2.0,'3',"Four")

        println("Array of integers ${arrayOfInt}")
        println("Array of mix types ${arrayOfMixTypes}")

        /**
         * Creates an Array<String> with values ["0", "1", "4", "9", "16"]
         * it simply make square of the i and convert it into string and return as element
         */
        val asc = Array(5, { i -> (i * i).toString() })

        println("Element at index 2 in asc ${asc[2]}")

        /**
         * Kotlin also has specialized classes to represent arrays of primitive types without boxing
         * overhead: ByteArray, ShortArray, IntArray and so on. These classes have no inheritance
         * relation to the Array class, but they have the same set of methods and properties. Each
         * of them also has a corresponding factory function:
         */

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]

        /**
         * Strings
         * Strings are represented by the type String. Strings are immutable. Elements of a string
         * are characters that can be accessed by the indexing operation: s[i]. A string can be
         * iterated over with a for-loop
         */

        var strHelloWorld = "Hello World"

        for (c in strHelloWorld) {
            println(c)
        }

    }

    fun packages()
    {
        /**
         * Packages
         * A source file may start with a package declaration:
         * package foo.bar
         * fun baz() {}
         * class Goo {}
         *
         * All the contents (such as classes and functions) of the source file are contained by the
         * package declared. So, in the example above, the full name of baz() is foo.bar.baz, and
         * the full name of Goo is foo.bar.Goo.
         * If the package is not specified, the contents of such a file belong to "default" package
         * that has no name.
         */

        /**
         * Default Imports
         * A number of packages are imported into every Kotlin file by default:
         *
         * kotlin.*
         * kotlin.annotation.*
         * kotlin.collections.*
         * kotlin.comparisons.* (since 1.1)
         * kotlin.io.*
         * kotlin.ranges.*
         * kotlin.sequences.*
         * kotlin.text.*
         * Additional packages are imported depending on the target platform:
         *
         * JVM:
         * java.lang.*
         * kotlin.jvm.*
         * JS:
         * kotlin.js.*
         */

        /**
         * Imports
         *
         * Apart from the default imports, each file may contain its own import directives. Syntax
         * for imports is described in the grammar.
         *
         * We can import either a single name, e.g.
         * import foo.Bar // Bar is now accessible without qualification or all the accessible
         * contents of a scope (package, class, object etc):
         *
         * import foo.* // everything in 'foo' becomes accessible
         * If there is a name clash, we can disambiguate by using as keyword to locally rename the
         * clashing entity:
         *
         * import foo.Bar // Bar is accessible
         * import bar.Bar as bBar // bBar stands for 'bar.Bar'
         *
         * The import keyword is not restricted to importing classes; you can also use it to import
         * other declarations:
         *
         * Unlike Java, Kotlin does not have a separate "import static" syntax; all of these
         * declarations are imported using the regular import keyword.
         */
    }

    fun ControlFlow()
    {
        /**
         * If Expression
         *
         * In Kotlin, if is an expression, i.e. it returns a value. Therefore there is no ternary
         * operator (condition ? then : else), because ordinary if works fine in this role.
         */

        // Traditional usage
        var a = 1
        var b = 2

        var max = a
        if (a < b) max = b

        println("Max is ${max}")

        // With else
        var max1: Int
        if (a > b) {
            max1 = a
        } else {
            max1 = b
        }
        println("Max1 is ${max1}")

        // As expression
        val max2 = if (a > b) a else b
        println("Max2 is ${max2}")

        /**
         * if branches can be blocks, and the last expression is the value of a block:
         */

        val max3 = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }
        println("Max3 is ${max3}")
        /**
         * Note : If you're using if as an expression rather than a statement (for example,
         * returning its value or assigning it to a variable), the expression is required to have
         * an else branch.
         */


        /**
         * When Expression : when replaces the switch operator of C-like languages. In the simplest
         * form it looks like this
         */
        var x = 5
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }

        /**
         * when matches its argument against all branches sequentially until some branch condition
         * is satisfied. when can be used either as an expression or as a statement. If it is used
         * as an expression, the value of the satisfied branch becomes the value of the overall
         * expression. If it is used as a statement, the values of individual branches are ignored.
         * (Just like with if, each branch can be a block, and its value is the value of the last
         * expression in the block.)
         *
         * The else branch is evaluated if none of the other branch conditions are satisfied.
         * If when is used as an expression, the else branch is mandatory, unless the compiler can
         * prove that all possible cases are covered with branch conditions.
         */

        /**
         * If many cases should be handled in the same way, the branch conditions may be combined
         * with a comma:
         */

        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }

        /**
         * We can use arbitrary expressions (not only constants) as branch conditions
         * */

        var s = "2"

        when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
        }
        /**
         * We can also check a value for being in or !in a range or a collection:
         */

        var validNumbers = arrayOf(1,6,9,4,7)

        when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
        }

        /**
         * Another possibility is to check that a value is or !is of a particular type. Note that,
         * due to smart casts, you can access the methods and properties of the type without any
         * extra checks.
         */

        fun hasPrefix(x: Any) = when(x) {
            is String -> x.startsWith("prefix")
            else -> false
        }

        println(hasPrefix(1))
        println(hasPrefix("prefix string"))

        /**
         * when can also be used as a replacement for an if-else if chain. If no argument is
         * supplied, the branch conditions are simply boolean expressions, and a branch is executed
         * when its condition is true:
         */

        when {
            (x % 2 != 0) -> print("x is odd")
            (x % 2 == 0) -> print("x is even")
            else -> print("x is funny")
        }

        /**
         * For Loops
         * for loop iterates through anything that provides an iterator. The syntax is as follows:
         */

        for (item in validNumbers) print(item)
        /**
         * The body can be a block.
         */

        for (item: Int in validNumbers) {
            println("Num ${item}")
        }

        /**
         * If you want to iterate through an array or a list with an index, you can do it this way:
         */
        for (i in validNumbers.indices) {
            print(validNumbers[i])
        }

        /**
         * Note that this "iteration through a range" is compiled down to optimal implementation
         * with no extra objects created.
         *
         * Alternatively, you can use the withIndex library function:
         */

        for ((index, value) in validNumbers.withIndex()) {
            println("the element at $index is $value")
        }

        /**
         * While Loops
         * while and do..while work as usual
         */

        while (x > 0) {
            x--
        }

        x = 5

        do {
            x--
        } while (x > 0)

        /**
         * Break and continue in loops
         * Kotlin supports traditional break and continue operators in loops.
         */
    }

    fun ReturnsAndJumps()
    {
        /**
         * Returns and Jumps
         * Kotlin has three structural jump expressions:
         *
         * return. By default returns from the nearest enclosing function or anonymous function.
         *
         * break. Terminates the nearest enclosing loop.
         *
         * continue. Proceeds to the next step of the nearest enclosing loop.
         *
         * All of these expressions can be used as part of larger expressions:
         */

        val s = "Harshal" ?: return

        /**
         * The type of these expressions is the Nothing type.
         */

        /**
         * Break and Continue Labels
         * Any expression in Kotlin may be marked with a label. Labels have the form of an
         * identifier followed by the @ sign, for example: abc@, fooBar@ are valid labels
         * (see the grammar). To label an expression, we just put a label in front of it
         */

        loop@ for (i in 1..100) {
            // ...
        }
        /**
         *
        Now, we can qualify a break or a continue with a label:
         */

        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (i < j) break@loop
            }
        }
        /**
         *  A break qualified with a label jumps to the execution point right after the loop marked
         *  with that label. A continue proceeds to the next iteration of that loop.
         */

        /**
         * Return at Labels
         * With function literals, local functions and object expression, functions can be nested
         * in Kotlin. Qualified returns allow us to return from an outer function. The most
         * important use case is returning from a lambda expression.
         * Recall that when we write this:
         */

        var ints = arrayOf(1,2,4,5,6,8)

        fun foo1() {
            ints.forEach {
                if (it == 0) return
                print(it)
            }
        }
        foo1()

        /**
         * The return-expression returns from the nearest enclosing function, i.e. foo. (Note that
         * such non-local returns are supported only for lambda expressions passed to inline
         * functions.) If we need to return from a lambda expression, we have to label it and qualify the return:
         */

        fun foo2() {
            ints.forEach lit@ {
                if (it == 0) return@lit
                print(it)
            }
        }
        foo2()

        /**
         * Now, it returns only from the lambda expression. Oftentimes it is more convenient to use
         * implicits labels: such a label has the same name as the function to which the lambda is
         * passed.
         */

        fun foo3() {
            ints.forEach {
                if (it == 0) return@forEach
                print(it)
            }
        }
        foo3()

        /**
         * Alternatively, we can replace the lambda expression with an anonymous function. A return
         * statement in an anomymous function will return from the anonymous function itself.
         */

        fun foo4() {
            ints.forEach(fun(value: Int) {
                if (value == 0) return
                print(value)
            })
        }
        foo4()

        /**
         *  When returning a value, the parser gives preference to the qualified return, i.e.
         *  return@a 1
         *  means "return 1 at label @a" and not "return a labeled expression (@a 1)".
         */

    }

    fun PropertiesAndFields()
    {
        /**
         * Properties and Fields
         *
         * Declaring Properties
         *
         * Classes in Kotlin can have properties. These can be declared as mutable, using the var keyword or read-only using the val keyword.
         */

        class Address {
        var name: String = "Harshal"
        var street: String = "Wakad"
        var city: String = "Chinchwad"
        var state: String? = "Maharashtra"
        var zip: String = "000000"
        }

        /**
         * To use a property, we simply refer to it by name, as if it were a field in Java:
        */

        fun copyAddress(address: Address): Address {
            val result = Address() // there's no 'new' keyword in Kotlin
            result.name = address.name // accessors are called
            result.street = address.street
            // ...
            return result
        }

        /**
         * Getters and Setters
         * The full syntax for declaring a property is
         * var <propertyName>[: <PropertyType>] [= <property_initializer>]
         * [<getter>]
         * [<setter>]
         *
         * The initializer, getter and setter are optional. Property type is optional if it can be
         * inferred from the initializer (or from the getter return type, as shown below).
         * Examples:
         */



    }

}
