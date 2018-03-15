#### Some Thoughts about the Module Question

The module wrap-up question:


Suppose you have the following data type comments:

```racket
    ;; Student is String
    ;; interp. the name of a student

    ;; Section is Natural 
    ;; the section number of a class

    (define-struct group (section s1 s2 s3) 
    ;; Group is (make-group Section Student Student Student)
    ;; a group of students for a project, with the section they're in

```

As this course requires careful and detailed study, from the final answer you can see that about 51% of student summit the wrong answer! may they didn't **grok** the _Reference_ Subject.

but what I can see that reading it carefully you can find out
```;; Group is (make-group Section Student Student Student) ```
is not a primitive data like ```String or Interger``` but there reference is.

![](https://github.com/doct0rX/SoftwareDevelopment/blob/9b570d5ba5f62b494947736207793f7e33c97106/HowToCode_SimpleData/week4/4b:Reference/screens/Screen%20Shot%202018-03-15%20at%2011.42.02%20PM.png)