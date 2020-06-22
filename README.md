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

Look at the code under the first package (_1), it produces the desired behavior.
Each service encapsulate a well-defined business responsibility.

Make yourself familiar with the code of that package.

# Production issues starts to kick in