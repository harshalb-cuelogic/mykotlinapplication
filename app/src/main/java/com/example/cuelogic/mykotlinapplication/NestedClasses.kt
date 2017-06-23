package com.example.cuelogic.mykotlinapplication

/**
 * Created by cuelogic on 23/06/17.
 */

/**
 * Nested Classes
 * Classes can be nested in other classes
 */

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

val demo = Outer.Nested().foo() // == 2

/**
 * Inner classes
 *
 * A class may be marked as inner to be able to access members of outer class. Inner classes carry
 * a reference to an object of an outer class:
 */

class Outer1 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}

val demo = Outer1().Inner().foo() // == 1
/**
 * See Qualified this expressions to learn about disambiguation of this in inner classes.
 */

/**
 * Anonymous inner classes
 * Anonymous inner class instances are created using an object expression:
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
 * If the object is an instance of a functional Java interface (i.e. a Java interface with a single
 * abstract method), you can create it using a lambda expression prefixed with the type of the
 * interface:
 */

//val listener = ActionListener { println("clicked") }