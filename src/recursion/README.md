## Lecture 11

# Recursion

***Song of the day***: _[**Part Of The Band**](https://youtu.be/87nG3LuabUs) performed by The 1975 (2022)._

### Sections

1. [**Recursive Thinking**](#part-1-recursive-thinking)
2. [**Recursive Algorithms**](#part-2-recursive-algorithms)
3. [**Making `getSumOfArray()` Recursive**](#part-3-making-getsumofarray-recursive)

### Part 1: _Recursive Thinking_

Oh boy. Recursion.

This is one of those topics in computer science that feels like magic at first and that many people find difficult, but
it's a fundamental programming technique that can provide wonderfully elegant solutions for certain kinds of problems.

To illustrate how recursion works, consider the structure of an array of integers of some unknown length:

```text
{ value1, value2, value3, value4, ... }
```

Let's say we were to divide this array into two sections:

- **The head**: Simply the first number in the array.
- **The tail**: The remaining numbers in the array.

```text
value1 { value2, value3, value4, ... }
|    | |                             |
+————+ +—————————————————————————————+
  |                   |
  V                   V    
 Head                Tail
(value)         (list of values)
```

What we thus get is quite simply **a value** and **another list of values**. Since the tail is a list itself, we can
divide it into a head and a tail, just like we did with the original array

```text
value1 { value2, value3, value4, ... }
           |
           V
         value2 { value3, value4, value5, ... }
         |    | |                             |
         +————+ +—————————————————————————————+
            |                   |
            V                   V    
          Head                Tail
         (value)         (list of values)
```

You can probably guess where this is going. We can continue dividing the remaining tails into two pieces for as long as
there remains a tail with at least two values:

```text
value1 { value2, value3, value4, ... }
           |
           V
         value2 { value3, value4, value5, ... }
                    |
                    V
                 value3 { value4, value5, value6, ... }
                 |    | |                             |
                 +————+ +—————————————————————————————+
                   |                   |
                   V                   V    
                 Head                Tail
               (value)         (list of values)
```
```text
value1 { value2, value3, value4, ... }
           |
           V
         value2 { value3, value4, value5, ... }
                    |
                    V
                 value3 { value4, value5, value6, ... }
                            |
                            V
                         value4 { value5, value6, value7, ... }
                         |    | |                             |
                         +————+ +—————————————————————————————+
                           |                   |
                           V                   V    
                          Head                Tail
                         (value)         (list of values)
```
```text
value1 { value2, value3, value4, ... }
           |
           V
         value2 { value3, value4, value5, ... }
                    |
                    V
                 value3 { value4, value5, value6, ... }
                            |
                            V
                         value4 { value5, value6, value7, ... }
                                    |
                      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                          Some iterations later...
                      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                    |
                                    V
                                  value_y { value_z }
                                  |     | |         |
                                  +—————+ +—————————+
                                     |         |
                                     V         V    
                                    Head      Tail
                                   (value)   (value)
```

<sub>**Figure 1**: Something to note here is that if this array were of infinite length, this process would never
end.</sub>

If we think about an array like this, we could define it the following way in English:

> An **array** is the combination of a **head value and a tail array**, which itself is a combination of a **head value
> and a tail array**, which itself is a combination of a **head value and a tail array**, which itself is...

This would be synonymous to defining a word in the dictionary by using the same word:

> **Decoration** /ˌdekəˈrāSH(ə)n/ (_verb_): The act of _decorating_ something.

Not exactly helpful, is it? Another famous example of this kind of behaviour is something that is known as 
[**Hofstadter's Law**](https://en.wikipedia.org/wiki/Hofstadter%27s_law), which I've repeatedly found to be true 
throughout my life:

> **Hofstadter's Law**: It always takes longer than you expect, even when you take into account Hofstadter's Law.

---

While none of these examples may seem to be particularly useful or relevant to computer science, there's a whole set of
algorithms that follow this principle—and we will learn about them today.

### Part 2: _Recursive Algorithms_

Let's consider a very simple method that calculates the sum of an array:

```java
public class SumOfAnArray {
    public static int getSumOfArray(int[] array) {
        if (array == null) throw new NullPointerException("Arrays must be not-null.");

        int sum = 0;
        for (int value: array) sum += value;

        return sum;
    }
}
```

This type of algorithm is known as an **iterative algorithm**, since it uses a structure to _iterate_ through its 
values. If we try to frame this process in a recursive way, we would the following steps:

1. Start at the first value of the array.
2. Add this value to the current sum.
3. Take the next value of the array.
4. Repeat steps 1 and 2 **until** we've reached the end of the array.
5. Return the sum.

Step 3 is our recursive step here. Visualising it may help:

```text
currentSum (final sum)
    |
    v
  currentSum + lastValue
       |
       V
     currentSum + secondToLastValue
           |
           V
         currentSum + thirdToLastValue
               |
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
             Some iterations later...
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                  |
                                  V
                                currentSum (initial value of 0)
```

<sub>**Figure 2**: Visualising the sum of the elements in an array recursively.</sub>

We can write this in more mathematical notation the following way:

> **Sum<sub>0</sub>** = 0
> 
> **Sum<sub>N</sub>** = **N** + **Sum<sub>N-1</sub>**

That is, the sum of a set of `N` numbers is equal to ***the sum of the `N`<sup>th</sup> number plus the sum of the set
of `N - 1` numbers***. Notice here that our list must have a final value in order for this definition to hold. If the
list were of infinite length, `Sum` would recur infinitely.

While our current definition of `getSumOfArray()` does not work recursively as it stands, we'll get to it soon enough.

---

Another famous recursive algorithm is the [**Fibonacci sequence 
algorithm**](https://en.wikipedia.org/wiki/Fibonacci_number), where:

> Any number in the Fibonacci sequence **is the sum of the two preceding numbers**.
> 
> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ..., **X<sub>n - 2</sub>** _(X<sub>n - 3</sub> + X<sub>n - 4</sub>)_, 
> **X<sub>n - 1</sub>** _(X<sub>n - 2</sub> + X<sub>n - 3</sub>)_, **X<sub>n</sub>** _(X<sub>n - 2</sub> + X<sub>n -
> 1</sub>)_

This function can be defined mathematically as:

> `f(0) = 0`
> 
> `f(1) = 1`
> 
> `f(n) = f(n - 1) + f(n - 2)`

In this definition, we need separate cases for the 0<sup>th</sup> and 1<sup>st</sup> numbers in the sequence because 
they don't have enough preceding numbers require to calculate a regular Fibonacci number. Let's visualise, say, `f(6)`:

```text
f(6) = f(5) + f(4)                              =                                  5 + 3 = 8
         |                                                                         ^
         V                                                                         |
       f(5) = f(4) + f(3)                       =                          3 + 2 = 5
                |                                                          ^
                V                                                          |
              f(4) = f(3) + f(2)                =                  2 + 1 = 3
                       |                                           ^
                       V                                           |
                     f(3) = f(2) + f(1)         =          1 + 1 = 2
                              |                            ^
                              V                            |
                            f(2) = f(1) + f(0)  =  1 + 0 = 1
                                     |      |      ^
                                     V      V      |
                                     1  +   0   =  1
```

<sub>**Figure 3**: The 6<sup>th</sup> Fibonacci number is 8.</sub>

How can we summarise the steps done in figure 3 along with the mathematical definition of a Fibonacci number to apply to
any recursive situation? Essentially, any non-infinite recursive algorithm must have:

1. **At least one basis step**: Specify the value(s) of the function at the base case. In the case of the Fibonacci 
sequence, these are `f(0)` and `f(1)`.
2. **A recursive step**: A rule for finding the functions result using its smaller results.

### Part 3: _Making `getSumOfArray()` Recursive_

How might we make `getSumOfArray()` recursive instead of iterative? Let's define a base case first:

> **Base Case**: If `array` is empty, the sum is 0.

We are now guaranteed a basic stopping point, which helps with our recursive step:

> **Recursive Case**: Is `array.length > 0`, its sum is the value of `array[0] + 
> getSumOfArray(Arrays.copyOfRange(array, 1, array.length))` (i.e. the first value plus the value of the sum of its 
> tail).

In code:

```java
import java.util.Arrays;

public class SumOfAnArray {
    public static int getRecursiveSumOfArray(int[] array) {
        if (array == null) throw new NullPointerException("Arrays must be not-null.");

        // BASE CASE
        if (array.length == 0) return 0;

        int   head = array[0];
        int[] tail = Arrays.copyOfRange(array, 1, array.length);

        // RECURSIVE CASE: the function calling itself
        return head + getRecursiveSumOfArray(tail);
    }
}
```

<sub>**Code Block 1**: A [**recursive complement**](SumOfAnArray.java) to our sum function.

How does this work? Again, let's visualise:

```java
getRecursiveSumOfArray(new int[] { 1, 2, 3, 4, 5 });
    |
    |——> head: array[0] ——> 1
    |——> tail: getRecursiveSumOfArray(new int[] { 2, 3, 4, 5 });
            |
            |——> head: array[0] ——> 2
            |——> tail: getRecursiveSumOfArray(new int[] { 3, 4, 5 });
                    |
                    |——> head: array[0] ——> 3
                    |——> tail: getRecursiveSumOfArray(new int[] { 4, 5 });
                            |
                            |——> head: array[0] ——> 4
                            |——> tail: getRecursiveSumOfArray(new int[] { 5 });
                                    |
                                    |——> head: array[0] ——> 5
                                    |——> tail: getRecursiveSumOfArray(new int[] { });
                                            |
                                            V 
                                        0 + 5 = 5
                                                |
                                                V
                                            4 + 5 = 9
                                                    |
                                                    V
                                                3 + 9 = 12
                                                        |
                                                        V
                                                    2 + 12 = 14
                                                             |
                                                             V
                                                         1 + 14 = 15
```

<sub>**Figure 4**: It's like magic, right? Recursion is one of those things that feels like it shouldn't work, then you
watch it actually work, and you are never the same.</sub>