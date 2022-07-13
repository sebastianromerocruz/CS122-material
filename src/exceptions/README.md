## Lectures 08

# Exceptions

### 23 Messidor, Year CCXXX

### Sections

1. [**Imperfect Code in an Imperfect World**](#part-1-imperfect-code-in-an-imperfect-world)
2. [**Java Exceptions**](#part-2-java-exceptions)

### Part 1: _Imperfect Code in an Imperfect World_

Something that you may have noticed is that we tend to end up writing code under the assumption that the user will 
always be entering valid input into every one of our methods. This, however, is rarely the case. In general, as 
programmers, we must adopt a version of [**Murphy's Law**](https://en.wikipedia.org/wiki/Murphy%27s_law) when we design
software: every possible error that could happen to our code will probably happen to our code.

This being the case, we must have ways to handle these situations, and one of those ways is via **exceptions**.

### Part 2: _Java Exceptions_

The technical definition of exceptions is the following:

> An object that describes an unusual or erroneous situation that can be **caught** and **handled**. An error does _not_
> necessarily equal an exception. An error usually represents an unrecoverable situation and should _not be caught_.

A syntax error, for instance (e.g. forgetting to write `;` at the end of a Java statement), is something from which the
JVM cannot recover from, so it is not considered to be an exception.

In general, programs can deal with exceptions in one of three ways:

- By ignoring it
- By handling it where it occurs
- By handling it at another place in the program

#### Ignoring Exceptions

Consider the following situation:

```java
public class Zero {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        System.out.printf("%d", numerator / denominator);

        System.out.print("PROGRAM ENDED.\n");
    }
}
```

<sub>**Code Block 1**: A dangerous situation.</sub>

As you can imagine, the program in code block 1 will crash with the following call stack trace:

```java
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at exceptions.Zero.main(Zero.java:8)
```

This trace is useful because it tells us:

1. That there was an exception
2. Which kind of exception happened
3. The method call trail that lead to the attempted execution of the offending line

In this case, we attempted to divide a number by 0 which, for a number of reasons, is not possible. So, as you can see,
while exceptions _can_ be handled, it is entirely possible to just hope that they don't happen and ignore them. It's
extremely bad practice, of course, but there you have it.

---

#### Handling Exceptions _In-Situ_

To handle an exception in the location where it happens, we need a brand-new, very important Java structure: **the 
`try`-`catch` statement**:

```java
try {
    // Code that can fail
} catch(ExceptionType e) {
    // What to do in the case that the code does fail under ExceptionType objects
}
```

<sub>**Code Block 2**: The most basic form of exception handling.</sub>

Let's apply this to code block 1 above and see how this process exactly works:

```java
public class Zero {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            // Code that can fail
            System.out.printf("%d\n", numerator / denominator);
        } catch(ArithmeticException ae) {
            // What to do if the code DOES fail
            System.out.printf("%d cannot be divided by %d!\n", numerator, denominator);
        }

        System.out.print("PROGRAM ENDED.\n");
    }
}
```

<sub>**Code Block 3**: Avoiding an imminent crash.</sub>

Output:

```java
10 cannot be divided by 0!
PROGRAM ENDED.

Process finished with exit code 0
```

As you can see, the program did _not_ crash and, in spite of an illegal operation being attempted, Java was able to 
_catch_ it before it crashed the entire program, and allowed it to finish execution gracefully. Now, the reason why I
knew that our exception type was `ArithmeticException` is due code block 1's stack trace telling me so:

```text
Exception in thread "main" java.lang.ArithmeticException
```

The `catch` clause is sometimes called an **exception handler** , since it literally handles what to do if and when
our code goes awry. After the exception is handled, the program continues.

---

Let's try a more complicated, realistic example:

Let's say we wanted to write a program that scanned product codes in Amazon. These product codes are **13 characters**,
and look like this, `TRQ2778A7R-19`:

```text
TRQ 2778 A7 R -19
   |    |   |
    \  /    |
     |      |
     V      |
district    V
   code    zone
           code
```

<sub>**Figure 1**: The important bits of a product code.</sub>

The district code (in this case `2778`) and the zone code (`R` here) are the important bits to check. For the purposes
of this problem, assume that _products made in zone `R` cannot be sold in districts with code `2000` or higher_.

We must be sure to make the program fault-tolerant as well. That is, even if an invalid code is entered, the program 
should not terminate, but process the erroneous code and continue until the user enters a termination signal (say 
`XXX`):

```java

```