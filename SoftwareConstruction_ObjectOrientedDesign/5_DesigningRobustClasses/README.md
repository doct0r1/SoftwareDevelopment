# Designing Robust Classes

**_Overview_**

Robust software performs well in a variety of situations, and has the ability to recover in foreseeable exceptional situations. 

Up to now, our code has been designed to work in very specific situations, when called with the correct inputs, and when the system is in a well-formed state.  In this module we will learn how to elegantly recover when the system reaches a state which would normally halt execution.  We do this using exception handling through the exceptions language mechanism in Java, and present in most other programming languages.  By handling exceptional behaviour directly, we can reduce some of the preconditions we place on methods. 

We will also explore assertions -- a mechanism similar to exceptions, but used instead to discover flaws in our logic, rather than to recover from them during execution.


#### Things You'll Learn

- How to use Exceptions to design programs that can recover from exceptional states. 
- How to test programs that have exceptions
- How to use Assertions in the development stage to discover when your program is behaving improperly