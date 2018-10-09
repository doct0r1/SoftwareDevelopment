# Types, Polymorphism and Dispatch

## Overview

Many object-oriented programming languages use type hierarchies and polymorphism to simplify the expression of software. Software programs compute and manipulate data. Each piece of data a software program creates or uses has a type that defines the operations that can be performed on that piece of data. Some programming languages infer the type of a piece of data. For instance, in the teaching languages, you could write a function to calculate the cost of a bus trip if you need to buy n tickets as:

```raket
(define (cost-of-bus-trip n) (* 2.50 n))
```

This function attempts to treat the value passed as a parameter (i.e. n) as a number because it is used in an operation (*) that operates on numbers. If a string is passed, as in (cost-of-bus-trip ""), the interpreter will complain that the expected type of n is a number.

In other programming languages, such as Java, each variable used in a program must have a type declared by the programmer. In Java, expressions are also typed. The process of type checking ensures that the code written by a programmer meets constraints about how types can be used together. For instance, type checking ensures that a method which expects a String parameter is only called with variables or expressions of type String. Because Java is a statically-typed programming language, this type checking is performed by the compiler (essentially as the program is being written), rather than when the program is executed.

### Things you'll learn:

- What options there are for types in Java **(Classes, Abstract Classes, and Interfaces)**, and which type can be used to create objects (just Classes!)
- **Type hierarchies**: get to know how subtypes can be used in place of super types for declaration, instantiation and parameter passing
- **Method dispatch**: how Java determines which implementation of a method to use when that method is called
- **How to extract a type** from a class to better structure a codebase and make it more extensible