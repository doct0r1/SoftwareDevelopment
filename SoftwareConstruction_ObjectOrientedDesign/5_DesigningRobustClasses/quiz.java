public class A {
    public void doA(String string) throws BadException, IQuitException, ReallyBadException {
        if (string.length() > 1) {
            B b = new B();
            try {
                b.doB(string);      // catch one exception [OhNo] & throw [ReallyBad] (1)
            } catch (OhNoException e) {
                System.out.println("Oh no!");
                throw new IQuitException();     // throwing [IQuit]                   (2)
                                                // this will NEVER be thrown
            }
        } else {
            throw new BadException();       // throwing [Bad]                         (3)       // no super here!!!
        }
        System.out.println("I knew I shouldn't have taken this job.");
    }
}

public class B {
    public void doB(String string) throws OhNoException, ReallyBadException {
        C c = new C();
        try {
            c.doC(string);
        } catch (TooLongException e) {      // catching only exception [TooLong]
            System.out.println("Too long? This is bad. Is it really bad?");
            if (string.length() > 5) {
                System.out.println("It's Bad!");
                throw new ReallyBadException();     // throw [ReallyBad] passed to A;  (1)
            } else if (string.length() > 3) {
                System.out.println("Really Bad!");
                throw new OhNoException();      // throw [OhNo] cought at A;
                                                // this will NEVER be thrown
            }
        } finally {
            System.out.println("I should call my manager!");
        }
    }
}

public class C {
    public void doC(String string) throws TooLongException {
        System.out.println("Today's going to be a good day!");
        if (string.length() > 5) {
            throw new TooLongException();   // throw [TooLong] cought at B;
        } else {
            System.out.println("The word of the day is " + string + "!");
        }
    }
}

// There is one class in the ui package, called ExceptionThrower, which includes the main method: 
public class ExceptionThrower {
    public static void main(String[] args) {
        String string = null; // (*) "hello world" < 5;
                              // (*) "Hello" == 5;
        A a = new A();
        try {
            a.doA(string);      // throw [ReallyBad]
                                // ,,    [IQuit] --;
                                // ,,    [Bad]
        } catch (RecoverableException e) {  //ReallyBad && Bad
            System.out.println("Phew! It's all okay");
        } catch (IQuitException e) {            // ,,    [IQuit]
            System.out.println("It's not okay");
        } finally {
            System.out.println("I'm too old for this.");
        }
    }
}