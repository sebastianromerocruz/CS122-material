<h2 align=center>Week 04: <em>Day 2</em></h2>

<h1 align=center>Return Types</h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/_Xcq6bbY71Y?si=4Y2l33C_yoiuw9CT"><strong><u>Stacy's Mom</u></strong></a> by Fountains of Wayne (2003)</em></p>

### Sections

1. [**Returning Values**](#part-1-returning-values)
2. [**The `return` Keyword**](#part-2-the-return-keyword)

### Part 1: _Returning Values_

Just to make sure that we're on the same page, let's reestablish the idea that _all programming expressions result in a single value_:

- `4 + 4` results in `8`.
- `true && false` results in `false`.
- "Hello, " + "World" results in "Hello, World"

In this sense, we can say that the execution of these expressions ***returns*** the value that they result in (i.e. the expressions `4 + 4` returns the integer `8`).

The same exact thing can be said of methods/functions, whereby each method can be considered as an expressions and/or part of an expression, such as the following:

```java
import java.util.Scanner;

class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int integer = scanner.nextInt();

        scanner.close()
    }
}
```

Here, the value of `integer` is arrived at the following way:

1. The expression `scanner.nextInt()` _returns_ the contents of the `Scanner` method `nextInt()`.
2. The contents of the `Scanner` method `nextInt()` _returns_ the user's integer input.
3. The _returned_ user's integer input is assigned to the variable `integer`.

This means that the `Scanner` method `nextInt()` is _not_ a `void` method since it actually returns something—an integer, in this case. 

In other to write methods that return something in Java, **you must replace the `void` keyword with the type of the value that you intend to return**.

### Part 2: _The `return` Keyword_

In a very similar way to Python, the way we return values in Java is by using the `return` keyword. This, coupled with specifying the return type of the method, is all you need to make these methods happen.

For example, let's write a simple method that accepts two integers as parameters and returns their sum:

```java
class AddExample {
    static int add(int operandA, int operandB) {
        return operandA + operandB;
    }

    public static void main(String[] args) {
        int result = add(4, 5);
        System.out.println(result);
    }
}
```

Output:

```
➜  javac AddExample.java 
➜  java AddExample      
9
```

There really isn't much else to it—returning values works much the same way as it does in Python, except that if you're saving the return value in a variable, that variable's type _must_ match the return type of that method.