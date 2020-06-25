# NoNull-Workshop
Worshop to learn how to not use the keyword "null" anymore

You and your team are in charge of a small service application.
The business it does will be abstract.

Your application is composed of multiple services.
For simplicity, each service will be represented by a name and a function going from a type A to a type B.
It means that serviceAB will be a function going from A to B :

```java
public class ServiceAB {
    
    B serviceAB(A a);

}
```
We will represent such a service like this :

serviceAB : A -> B


# The Joyful Days

You start your application with the core services and compose them together.
You need to produce a G from a given A.

You use all the following services :

- serviceAB
- serviceBC
- serviceCD
- serviceDE
- serviceEF
- serviceFG

to produce your application.

Look at the code under the first package (_1), and particularly the run function
in the Application class. It produces the desired behavior.

Each service encapsulate a well-defined business responsibility.

Make yourself familiar with the code of that package.

The run method is composing all the services as if they were functions
to create a bigger function :
```
A -> B -> C -> D -> E -> F -> G
A --------------------------> G
```

The second version called "moreFamiliarRun" is a version where the intermediary
value is stored into a variable before being passed to the next function.

But they both do the exact same thing. 

# Production issues starts to kick in

OK so your application is in production and handles most cases correctly.

But sometimes, serviceAB is not able to find a B given some values of A.
Those values are called INVALID. By opposition, the previous working values
are called VALID.

This is a perfectly normal behavior that was left aside to be able to push
the current code into production dealing with the nominal cases.

So now the type A contains two 'values', VALID and INVALID and tests cases have been
updated accordingly

## simple correction

Team Decision : You and your team have decided to use a null value when there is no
value to be returned. Seems pretty reasonable, isn't it ?

Once again, I'm giving you the code, all you have to do is look at it.
Cf. package _2.firstProductionIssue
But don't worry, you will code in the very next step.

So if you look at the code, there the defective version that you are already familiar with.
It does not pass the added test.
There's also the corrected version which does. It consists simply to test is the return value is
null or not before executing the rest of the code.

Nobody likes those nasty NullPointerException, right ?

So far, nothing comes out of the ordinary, simple and robust java code.

## First contact with Optional

We will open a parenthesis. What if Optional was made available at this point ?

If you look at all the services A -> B, B -> C and so forth, they all look the same.
From the pure API point of view, there's nothing telling you that ServiceAB may return
a null value or not.

So your team heard that Optional may help on that point.

```
Change the code in order to use Optional

You should change serviceAB so it now returns Optional<B> instead of B.
Use static factory methods "Optional#of" and "Optional#empty"

Then use "Optional#isPresent" and "Optional#get" methods to make the safety checks
in the Application class.

* This part is a refactoring phase, the tests pass as it is and should remain so
```