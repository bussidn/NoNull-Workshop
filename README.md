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

The different sections below each matches one package that contains a copy of the
different versions of the production and test code. Some are here only to be watch,
other are there to be refactored.

In any case, in any section I refer to the code dedicated to that section.
(if there's exception, I'll try to make them obvious)

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

Optional is a generic container that represent the fact that a value may be absent.
Seems perfect for our use case.
You can view it as a List of 0 or 1 element.
For example, an Optional<String> may contain a string, or not. But you KNOW that
the value may be absent.

If you look at all the services A -> B, B -> C and so forth, they all look the same.
From the pure API point of view, there's nothing telling you that ServiceAB may return
a null value or not.

So your team heard that Optional may help on that point.

```
Change the code in order to use Optional

You should change serviceAB so it now returns Optional<B> instead of B.
Use static factory methods "Optional#of" and "Optional#empty"

Optional.of(t) creates a container with a value inside. That value may not be null.
Optional.empty() creates an empty container.

Then use "Optional#isPresent" and "Optional#get" methods to make the safety checks
in the Application class.

* This part is a refactoring phase, the tests pass as it is and should remain so
* don't forget to change the dependency type, serviceAB will no longer be of type
A -> B
```

Normally, the produced code should look very similar to the code with null checks.
You have gained some expressiveness : now anyone knows that service AB may return
no value, at compile time !

Your team is happy wih the decision and decides to adopt Optional. New code should
not manipulate null references anymore, only Optionals.

If you think this through, that another good way to avoid NullPointerException :

```
don't use null !
```

It is that simple.

## Improving Composition

This time, you will have to modify the "Application#run" method only.
You've heard on some blog that "Optional#isPresent" and "Optional#get" should
be avoided.

We'll see why later.

Just notice that we start with the following situation :

We have a function A -> Optional[B] and we have a
series of Functions: B -> C -> D -> E -> F that we want to apply if the optional
is not empty.

That series of functions can be seen as one Function B -> F.

The problem is that :
- **f1**:A -> Optional[B]

and

- **f2**:B -> F

cannot be composed because the
return type of **f1** does not match the entry type of **f2**.


```
Refactor "Application#run" method.
The only methods from Optional you should use are
"Optional#map" and "Optional#orElse"
```

Normally, your code should look kind of like the very first "Application#run"
implementation. The one with function composition.

If it doesn't, look at the two solutions on package _5.

The code does not explicitly check presence or absence of value. It does not
access the encapsulated value either.

Instead, now we **tell** the Optional what transformation (function) we would like
to apply to the value inside. 

So what we did was to manage to compose **f1** and **f2** thanks to "Optional#map"
function which knows how to do it.

That's why this chapter is called "improving composition".

## The long run

Let's get back a little. Imagine your team have not adopted Optional finally.

The life of Application has gone for a while, and you had to deal with
other production NullPointerExceptions.

So you dealt with them the classic way, by testing nullity.

Now go take a look at the current "Application#run" code.

...

That's what a lot of service code looks like. Especially after a few years of
maintenance and added features.  

Of course, a real would be even more complicated than that. Here you could still
think that this code is pretty straightforward, just a simple cascade of
check-and-calls that is not so hard to understand.
You may be right, but we are only looking at null-checks on a dummy code.
Imagine it being cluttered with real business cases and exceptions, try and
catch from network failures or disk reads, and you could agree that this little
business is soon lost in the noise.

Did you notice that one null check is useless ?
ServiceDE is never returning a null value, you can remove it, all tests will
still pass.

We won't see how to design, name and refactor everything here, we will only
handle nullity.