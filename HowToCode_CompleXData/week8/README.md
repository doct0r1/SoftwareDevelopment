Week 8
======

a: Two One-of Types
------------------

In this module, we will learn to design functions consuming two arguments which are one-of types. In order to do this, we will develop a new model of our code, the cross product of the types comment table.

The cross product of the types comment table first provides us with a way to clearly think of all possible test cases. We will then find it helps us get a basis for what our function's body will look like -- and even allow us to simplify it -- all before we even start coding. In this sense, it plays a role similar to the role of type comments and templates -- and in fact extends our idea of templating from simply what we copy from the types comments to what it really is; a method of knowing a great deal about what code will look like before we start coding details.

### Learning Goals

- Be able to produce the cross-product of type templates table for a function operating on two values with one-of types.
- Be able to use the table to generate examples and a template.
- Be able to use the table to simplify the function when there are equal answers in some cells.

b: Local
--------

In this module we look at a new technique for improving the structure of code. Most of the problems in this module involve refactoring existing programs -- so there's relatively little new coding to do. But that doesn't mean you won't be designing programs! One of the things that separates good programmers from the other kind is taking the time to improve the structure of their code once it is written. This material is super important, and... it's really important to practice doing it!

We'll learn local expressions which are a new kind of expression in the Intermediate Student Language (ISL) that makes it possible to write definitions (constants, functions and structures) that are only visible within the local expression. We will see how to use local expressions to encapsulate "private" helper functions. We will also use local to avoid redundant computation.

### Learning Goals

- Be able to write well-formed local expressions.
- Be able to diagram lexical scoping on top of expressions using local.
- Be able to hand-evaluate local expressions.
- Be able to use local to encapsulate function definitions.
- Be able to use local to avoid redundant computation.
