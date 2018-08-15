Abstraction
===========

In this module, we look at another technique for improving the structure of code. Most of the problems in this module involve refactoring existing programs -- so there's relatively little new coding to do. But that doesn't mean you won't be designing programs! One of the things that separates good programmers from the other kind is taking the time to improve the structure of their code once it is written. This material is super important, and... it is really important to practice doing it!

This module covers abstraction, which is a technique for taking highly repetitive code and refactoring out the identical parts to leave behind a shared helper and just the different parts of the original code. The shared helper is called an abstract function because it is more general, or less detailed, than the original code.

Abstraction is a crucial technique for managing complexity in programs. One aspect of this is that it can make programs smaller if the abstract functions are used by many other functions in the system. Another aspect is that it helps separate knowledge domains more clearly in code. All the work you've done understanding templates is about to give you a nice surprise.

### Learning Goals

- Be able to identify 2 or more functions that are candidates for abstraction.
- Be able to design an abstract function starting with 2 or more highly repetitive functions (or expressions).
- Be able to design an abstract fold function from a template.
- Be able to write signatures for abstract functions.
- Be able to write signatures that use type parameters.
- Be able to identify a function which would benefit from using a built-in abstract function
- Be able to use built-in abstract functions
