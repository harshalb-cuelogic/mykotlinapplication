package com.example.cuelogic.mykotlinapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
