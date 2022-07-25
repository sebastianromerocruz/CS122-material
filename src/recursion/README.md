## Lectures 11 and 12

# Recursion

***Song of the day***: _[**Part Of The Band**](https://youtu.be/87nG3LuabUs) performed by The 1975 (2022)._

### Sections

1. [**Recursive Thinking**](#part-1-recursive-thinking)
2. [**Recursive Algorithms**](#part-2-recursive-algorithms)
3. [**Making `getSumOfArray()` Recursive**](#part-3-making-getsumofarray-recursive)
4. [**Lab 06**](#part-4-lab-06)
5. [**Solving A Maze With Recursion**](#part-5-solving-a-maze-with-recursion)

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

### Part 4: _Lab 06_

_Due Friday, July 29th, at 11:59pm on Classes_

Similar to how we got the recursive sum of an array, define a static method `getRecursiveSumOfEvens()` that will, as the
name suggests, calculate and return the sum of all the **even** integers of an array. This algorithm is very similar to
calculating the regular sum of an array—in fact, its base case is exactly the same:

> **Base Case**: If `array` is empty, the sum is 0.

The difference is in the recursive step, where we now have two possibilities:

> **Recursive Case**: If the value of `head` is even, then its sum is `head` + the sum of all the even integers of the 
> **tail**; if the value of `head` is odd, then its sum is just the sum of all the even integers of the **tail**.

Recall that you can determine whether an integer is even by doing `number % 2 == 0` (`true` —> even).

### Part 5: _Solving A Maze With Recursion_

As with most programming techniques, just because we _have_ the ability to use recursion to solve a problem, it doesn't
mean that we _should_ use it all the time. For example, we generally wouldn't use recursion to get the sum of the 
elements of an array—a `for`-loop is much easier to understand and is not any less effective.

There are, however, some problems that truly lend themselves to recursive solutions. For example, consider the situation
where we need to find a path through a maze. Below, a `1` represents a location that we can traverse, and a `0` 
represents a wall:

```text
1 1 1 0 1 1 0 0 0 1 1 1 1
1 0 1 1 1 0 1 1 1 1 0 0 1
0 0 0 0 1 0 1 0 1 0 1 0 0
1 1 1 0 1 1 1 0 1 0 1 1 1
1 0 1 0 0 0 0 1 1 1 0 0 1
1 0 1 1 1 1 1 1 0 1 1 1 1
1 0 0 0 0 0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1 1 1 1 1 1

In other words, the following maze:

S — +   + —       + — — +
|   + — +   + — + + +   |
        |   |   |   |    
+ — +   + — +   |   + — +
|   |         + + +     |
|   + — — — — +   + — — +
| 
+ — — — — — — — — — — — G
```

<sub>**Figure 1**: A maze represented by a two-dimensional array of ones and zeros. Here, `S` represents the start 
position of the maze, and `G` the destination.</sub>

There _is_ an iterative solution to this problem, but it's a bit of a nightmare. We'd have to keep track of four 
cardinal directions using `if`-statements, and follow each path until its very end before moving on to the next path.
Recursion offers a much more elegant solution. So what are the base and recursive steps.

> We can consider the ***base case*** either an **invalid move (hitting a wall), or the act of reaching the 
> destination**.

Let's see what we mean by this. Essentially, for every location we consider:

1. Check if this location is within bounds of the maze.
2. If so, then check if the path is traversable (i.e. == 1).
   1. If the step is valid, then we should mark it as having been **checked** by turning the `1` into a different 
   number. This will basically prevent us from checking it again because it will fail the isStepValid() test (which 
   checks for `1`).
   2. If we have, by any chance, reached our the goal, then we are done here.
3. If either of the above conditions are false, then we cannot traverse that location.
4. If this step is not valid, then we have either reached our destination or hit a wall. Either way, we are done.

Code:

```java
// What is a valid move?
public boolean isStepValid(int row, int column) {
    
    // Step 1: Check if this location is within bounds of the maze
    if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) {
        
        // Step 2: If so, then check if the path is traversable i.e. == 1.
        //         This will return true if it is, and false if it is not.
        return grid[row][column] == 1;
    }

    // Step 3: If the above conditions are false, then we cannot traverse that location anyway
    //         So return false.
    return false;
}

public boolean traverse (int row, int column) {
        boolean isDone;

        if (!isStepValid(row, column)) {

            // Step 1: If this step is not valid, then we have either reached our destination
            //         Or hit a wall. Either way, we are done here.
            isDone = false;
        } else {

            // Step 2: If the step is valid, then we should mark it as having been checked,
            //         since we are checking it right now. This will basically prevent us
            //         from checking it again because it will fail the isStepValid() test.
            grid[row][column] = CHECKED;
    
            if (row == GOAL_ROW && column == GOAL_COL) {
    
            // Step 3: First, we should check if we have reached the goal. If we have,
            //         then we are done here.
            isDone = true;
            
        ...
```

<sub>**Code Block 1**: Implementation of the base step. Notice that this only includes half of the `traverse()` 
method.</sub>

---

> The ***recursive step*** would be to check each individual direction, and invoking the same traverse method from that
> new position.

In other words:

1. We check the positions **above**, **below, to the **right** and to the **left** of our current location using the 
`traverse()` method—as if that location were our new starting point.
2. If either of these paths returned true, then we are on the right path. So, we mark it as part of this correct path
by changing its value from the "_checked_" value we had earlier.
3. Whether we are on the right path or not ,we signal the result to the step above us.

```java
        ...
        
        else {
        
        // Step 4: If we haven't, then that's where recursion takes over. We check
        //         the positions above, below, to the right and to the left of our
        //         current location using the traverse() method—as if that location
        //         were our new starting point.
        isDone = traverse(row + 1, column);               // check below
        if (!isDone) isDone = traverse(row, column + 1);  // check right
        if (!isDone) isDone = traverse(row - 1, column);  // check up
        if (!isDone) isDone = traverse(row, column - 1);  // check left
        }

        // Step 5: If either of these paths returned true, then we are on the right path.
        //         So, we mark it as part of the PATH.
        if (isDone) grid[row][column] = PATH;
    }

    // Step 6: Whatever the case may be, whether we return true or false, we need to signal
    //         the step above us whether we are done here or not.
    return isDone;
}
```

<sub>**Code Block 2**: Implementation of the recursive step i.e. the remaining half of the `traverse()` method. Notice
that `traverse()` calls itself here, making it recursive.</sub>