<h2 align=center>Week 12: <em>Day 1</em></h2>

<h1 align=center>Exceptions: <em><code>try</code>-<code>catch</code> Blocks</em></h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/Vx1Yljmm3ck?si=jmGH0jnILrdNyIBT"><strong><u>そして、次の曲が始まる (And So, The Next Piece Begins)</u></strong></a> by Akito Matsuda (2019)</em></p>

---

### Sections

1. [**Imperfect Code in an Imperfect World**](#part-1-imperfect-code-in-an-imperfect-world)
2. [**Java Exceptions**](#part-2-java-exceptions)
    1. [**Ignoring Exceptions**](#ignoring-exceptions)
    1. [**Handling Exceptions _In-Situ_**](#handling-exceptions-in-situ)

---

### Part 1: _Imperfect Code in an Imperfect World_

Something that you may have noticed is that we tend to end up writing code under the assumption that the user will always be entering valid input into every one of our methods. This, however, is rarely the case. In general, as programmers, we must adopt a version of [**Murphy's Law**](https://en.wikipedia.org/wiki/Murphy%27s_law) when we design software: every possible error that could happen to our code will probably happen to our code.

This being the case, we must have ways to handle these situations, and one of those ways is via **exceptions**.

### Part 2: _Java Exceptions_

The technical definition of a Java exception is the following:

> An _object_ that describes an unusual or erroneous situation that can be **caught** and **handled**. An error does _not_ necessarily equal an exception. An error usually represents an unrecoverable situation and should _not be caught_.

A syntax error, for instance (e.g. forgetting to write `;` at the end of a Java statement), is something from which the JVM cannot recover from, so it is not considered to be an exception.

In general, programs can deal with exceptions in one of three ways:

- By ignoring it
- By handling it where it occurs
- By handling it at another place in the program

Today, we're going to cover the first two.

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

In this case, we attempted to divide a number by 0 which, for a number of reasons, is not possible. So, as you can see, while exceptions _can_ be handled, it is entirely possible to just hope that they don't happen and ignore them. It's extremely bad practice, of course, but there you have it.

---

#### Handling Exceptions _In-Situ_

To handle an exception in the location where it happens, we need a brand-new, very important Java structure: **the `try`-`catch` statement**:

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

As you can see, the program did _not_ crash and, in spite of an illegal operation being attempted, Java was able to _catch_ it before it crashed the entire program, and allowed it to finish execution gracefully. Now, the reason why I knew that our exception type was `ArithmeticException` is due code block 1's stack trace telling me so:

```text
Exception in thread "main" java.lang.ArithmeticException
```

The `catch` clause is sometimes called an **exception handler** , since it literally handles what to do if and when our code goes awry. After the exception is handled, the program continues.

<!-- ---

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
import java.util.Scanner;

public class ProductCodes {
    public static final String TERMINATION_CODE = "XXX";
    public static final int ZONE_INDEX = 9;
    public static final int DISTRICT_LOW_IDX = 3;
    public static final int DISTRICT_HIGH_IDX = 7;
    public static final char INVALID_ZONE = 'R';
    public static final int INVALID_DISTRICT = 2000;

    public static void main(String[] args) {
        String code;
        char zone;
        int district;

        // We'll count the number of valid codes we encounter
        // As well as the number of banned codes
        int numberOfValidCodes = 0, numberOfBannedCodes = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
        code = scanner.nextLine();

        // STEP 1: While the user doesn't enter the termination code
        while (!code.equals(TERMINATION_CODE)) {
            // Attempt the following things that COULD go wrong...
            try {
                // STEP 2: Extract the zone code (could be out of bounds)
                zone = code.charAt(ZONE_INDEX);

                // STEP 3: Extract the district code (could be a non-integer)
                district = Integer.parseInt(code.substring(DISTRICT_LOW_IDX, DISTRICT_HIGH_IDX));

                // STEP 4: If it passes both of those tests, it is a valid code
                numberOfValidCodes++;

                // STEP 5: But if happens to be in a district that is incompatible with the invalid zone, make sure to
                //         note that it is a banned code
                if (zone == INVALID_ZONE && district >= INVALID_DISTRICT) {
                    numberOfBannedCodes++;
                }
            } catch (StringIndexOutOfBoundsException exception) {
                // STEP 6: If step 2 went wrong, handle it here
                System.out.printf("ERROR: Improper code length: %s", code);
            } catch (NumberFormatException exception) {
                // STEP 7: If step 3 went wrong, handle it here
                System.out.printf("ERROR: District is not numeric: %s", code);
            }

            // STEP 8: Prompt the user to enter next code to start again
            System.out.printf("Enter product code (%s to quit): ", TERMINATION_CODE);
            code = scanner.nextLine();
        }

        // STEP 9: Print results
        System.out.printf("Number of valid codes entered: %d.", numberOfValidCodes);
        System.out.printf("Number of banned codes entered: %d.", numberOfBannedCodes);
    }
}
```

<sub>**Code Block 4**: The [**solution**](ProductCodes.java) to the problem. Read the comments for the steps!</sub>

---

#### Handling Exceptions at Another Place in the Program

Our exceptions don't necessarily have to be handled within the method where they occurred. This may be a bit of a
confusing concept, but we've actually seen something similar before. Let's say we have the following class:

```java
public class StandardDeviation {
    public double getStandardDeviation(int[] numbers) {
        double standardDeviation = 0.0d;
        double average = getAverage(numbers);

        for(double number : numbers) {
            standardDeviation += Math.pow(number - average, 2);
        }

        return standardDeviation;
    }

    private double getAverage(int[] numbers) {
        return (double) getSum(numbers) / numbers.length;
    }

    private int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) sum += number;

        return sum;
    }
}
```

<sub>**Code Block 5**: A simple standard deviation calculator.</sub>

Let's say we try to use it with an array of integers, but that array object happened to be null? What does the error 
message look like?

```java
StandardDeviation stdev = new StandardDeviation();

int[] grades = null;

System.out.printf("The standard deviation is %.2f.\n", stdev.getStandardDeviation(grades));
```

Output:

```text
Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "<local3>" is null
	at exceptions.StandardDeviation.getSum(StandardDeviation.java:29)
	at exceptions.StandardDeviation.getAverage(StandardDeviation.java:24)
	at exceptions.StandardDeviation.getStandardDeviation(StandardDeviation.java:14)
	at exceptions.StandardDeviation.main(StandardDeviation.java:9)
```

You see how the last four lines follow a sort of path through the methods necessary to get the standard deviation? That
is:

1. The `main()` calls on the `getStandardDeviation()` method in line 9.
2. The `getStandardDeviation()` method calls on the `getAverage()` method in line 14.
3. The `getAverage()` method calls on the `getSum()` method in line 24.
4. Finally, the `getSum()` method attempts to use the number array in line 29, but since it is `null`, it raises the
`NullPointerException` exception.

This is what is called a **method hierarchy**, and it represents the order in which the methods are called in the stack.
In other words, since one method is dependent on the other, the "outer method" will be placed on the stack first, 
followed by the "inner method", and so on and so forth.

So, where exactly should this exception be handled? The answer is that it could be handled at any of these steps—it's 
really up to the programmer to decide. Since `NullPointerException` exceptions will always first happen in `getSum()` 
(since they are the first method to even touch the array of integers), it may seem natural to handle it there, but Java
provides an alternative way of doing this. For this, it's helpful to look at Java's `Exception` class hierarchy:

![exception-class-hierarchy](assets/exception-class-hierarchy.png)

<sub>**Figure 2**: The inheritance hierarchy of Java's `Exception` class.</sub>

As you can see, all error and exception classes are descendants of the `Throwable` class. While these are pretty 
extensive, as our projects grow in complexity and specificity, we are bound to want to have our own, project-specific
exceptions. Fortunately, thanks to inheritance, we can extend the `Exception` class and achieve exactly that. Going
back to our `StandardDeviation` class, let's define an exception that has a more specific name, such as 
[**`StandardDeviationNotCalculableException`**](StandardDeviationNotCalculableException.java):

```java
public class StandardDeviationNotCalculableException extends NullPointerException {
    public NullArrayException(String message) {
        super(message);
    }
}
```

<sub>**Code Block 6**: A simple extension of `NullPointerException`.</sub>

Now, how do we apply this very long-titled exception in practice? You may have noticed that all exceptions extend 
something called `Throwable`. And that's our bread and butter.

### Part 3: _The `Throwable` Class_

How, exactly, is an exception triggered? There is no immediately obvious syntax to tell Java to throw its built-in
exceptions, so it's hard to tell. However, in Java:

> A method that can trigger an exception is said **to throw an exception**.

For example, our `getSum()` method from earlier can be said to **throw a `NullPointerException`**. Since a large number
of Java situations throw this exception, Java doesn't need you to tell it so. For our own custom exceptions, however,
we have to explicitly do so. For this, we use the **`throws`** keyword:

```java
private int getSum(int[] numbers) throws StandardDeviationNotCalculableException {
   if (numbers == null || numbers.length == 0) {
      throw new StandardDeviationNotCalculableException("This array is unsuitable for standard deviation " +
              "calculations. Check that it is not null or empty."); 
   }
   
   int sum = 0;
   for (int number : numbers) sum += number;
   
   return sum;
}
```

<sub>**Code Block 7**: Java now knows that `getSum()` can throw our custom 
`StandardDeviationNotCalculableException`.</sub>

As you can see, three things are necessary here:

1. The method signature must include the keyword `throws` followed by the name of the exception.
2. A way of checking whether this exception will be thrown. In this case, a standard deviation cannot be calculated
from a null array nor from an empty one.
3. In order to actually raise this exception, we must use the `throw` keyword followed by an object of that exception
class.

This is what is called a **checked** exception, i.e. an exception that must be explicitly checked for in order for it
to be thrown. Some built-in Java exceptions, such as `ArithmeticExcpetion` objects, are **unchecked**, since they are
raised regardless of whether we check them or not.

Checked exceptions include:

- **`ClassNotFoundException`**: Thrown when an application tries to load in a class but no definition for the class with
the specifed name could be found.
- **`IOException`**: Produced by failed or interrupted I/O operations, such as opening files.
- **`SQLException`**: Thrown when an [**SQL 
Server**](https://www.yourofficeanywhere.co.uk/info-hub/what-is-sql-server/) returns a warning or error.

Unchecked exceptions include:

- **`ArithmeticException`**: Thrown when an exceptional arithmetic condition has occurred. For example, a number 
divided by zero throws an instance of this class.
- **`ArrayStoreException`**: Thrown to indicate that an attempt has been made to store the wrong type of object into an 
array of objects (for example, trying to store a `double` in an `int` array).
- **`ClassCastException`**: Thrown to indicate that the code has attempted to cast an object to a subclass of which it 
is not an instance (for example, trying to cast a `String` object into a `byte`).

---

One final thing that you should watch out for is the following situation:

```java
System.out.println("Before throw");

throw new OutOfRangeException("Too High");

System.out.println("After throw");
```

<sub>**Code Block 7**: In which situations does this exception get thrown?</sub>

Because we don't actually check for a situation where an `OutOfRangeException` might happen (say, with an 
`if`-statement), this exception will **always** be thrown, regardless of the situation, which is most certainly not
what we want.

### Part 5: _Lab_

Consider the following code:

```java
public class Lab {
    public static double getAverageLength(String[] strings) {
        int amountOfStrings = strings.length;
        int sumOfLengths = 0;

        for (String string : strings) {
            sumOfLengths += string.length();
        }

        double averageLength = (double) sumOfLengths / amountOfStrings;

        return averageLength;
    }
}
```

In the static method `getAverageLength()`, two kinds of built-in Java exceptions can happen (I'm not telling you which 
two, but they're not particularly uncommon). Using `try`-`catch` blocks, make sure that the value of `-1` is always 
returned in case either of those two exceptions happen.

### Part 6: _I / O Exceptions_

We talked about JavaFX being an extension to our current knowledge in the sense that it provides a visual output to our
programming. Of course, these inputs and outputs don't always have to be visual, and oftentimes take the form of files
that are created / edited. In order to do this with Java, we need to take advantage of something called a _stream_.

> A **stream** is a sequence of bytes that flow from a source to a destination. In a program, we read information from 
> an input stream and write information to an output stream. A program can manage multiple streams simultaneously.

There are three standard I / O streams:
- **Standard Output**, which is defined by `System.out`.
- **Standard Input**, which is defined by `System.in`.
- **Standard Error**, which is defined by `System.err`.

We've naturally seen `System.out` a whole bunch. Both it and `System.err` typically represent the console window. 
`System.in` on the other hand typically represents keyboard input, which we've used many times with `Scanner` objects.

---

It probably goes without saying that the user can input all sorts of garbage values into a program. This is not 
necessarily done on purpose; users have to learn how to use a program, and the learning curve for any given program
can vary from person to person. This being the case, it helps for us to to have a specific exception that deals with
these unpredictable scenarios. The `IOException` class—a **checked** exception—deals with such operations performed by 
some of Java's I / O classes.

For example, it's helpful in situations when:

- A file might not exist
- A file exists, but the program is not able to find / open it
- The file exists, can be found and opened, but does not contain the kind of data that we expect (e.g. tryng to open
a Word file with Apple Music or Spotify)

Let's illustrate this by writing some data onto a file using the `PrintWriter` class. In this case, this output stream
must be closed explicitly—a good use for our `finally` clause:

```java
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestData {
    public static final int MAX = 10;
    public static final String FILE_NAME = "test.txt";

    public static void main(String[] args) throws IOException {
        int value;

        // Our output stream is no long System.out, but a PrintWriter object
        PrintWriter outFile = new PrintWriter(FILE_NAME);

        Random random = new Random();

        for (int lineNumber = 1; lineNumber <= MAX; lineNumber++) {
            for (int number = 1; number <= MAX; number++) {
                value = random.nextInt(90) + MAX;
                outFile.printf("%d\t", value); // The same methods—print(), printf(), println()—are available to us
            }

            outFile.print('\n');
        }

        outFile.close();
        System.out.printf("Output file has been created: %s!\n", FILE_NAME);
    }
}
```

<sub>**Code Block 8**: Delegating the `IOException` to the caller of `main()`.</sub>

Or, if you want to handle the exception _in-situ_:

```java
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestData {
    public static final int MAX = 10;
    public static final String FILE_NAME = "test.txt";

    public static void main(String[] args) {
        int value;

        try {
            // Our output stream is no long System.out, but a PrintWriter object
            PrintWriter outFile = new PrintWriter(FILE_NAME);

            Random random = new Random();

            for (int lineNumber = 1; lineNumber <= MAX; lineNumber++) {
                for (int number = 1; number <= MAX; number++) {
                    value = random.nextInt(90) + MAX;
                    outFile.printf("%d\t", value); // The same methods—print(), printf(), println()—are available to us
                }

                outFile.print('\n');
            }

            outFile.close();
            System.out.printf("Output file has been created: %s!\n", FILE_NAME);
        } catch (IOException ioe) {
            System.out.println("ERROR: Something went wrong.");
        }
    }
}
```

<sub>**Code Block 9**: Catching the exception inside of `main()`.</sub> -->