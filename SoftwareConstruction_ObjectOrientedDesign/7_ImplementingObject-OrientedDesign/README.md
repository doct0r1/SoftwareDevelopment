# Implementing Object-Oriented Design

**_Overview_**

In this module, we will consider how to implement a given OO design, largely by translating a UML class diagram into code. The UML diagrams we have looked at to date were pretty simple: just boxes with three parts and maybe an annotation to say a box represents an interface or abstract class.

Objects don’t work in isolation, they work in conjunction with other objects. Sometimes, the use of one object by another is transient, in the context of one method. Other times, an object might remember another object because it will use it several times or because it is representing how the information is linked together in the domain. These cases where an object remembers one or more other objects are important for how the application works and how we design an application. We can record these relationships between objects by recording relationships between the classes in a UML class diagram.

#### Things You'll Learn

- How to express a UML class diagram as a Java program, including expressing associations and aggregations
- How to initialize and set fields that depend on each other
- How to ensure a Java class can be used correctly with the Java Collections Framework by correctly overriding appropriate methods (e.g., equals, hashCode)