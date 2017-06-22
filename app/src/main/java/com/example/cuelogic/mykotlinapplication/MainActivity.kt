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
         */

        /**
         *
         */
    }
}
