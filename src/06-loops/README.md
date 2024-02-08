<h2 align=center>Week 03: <em>Day 1</em></h2>

<h1 align=center><code>switch</code> and Loops</h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/u9Di0D1DQps?si=Gmuom5tqc9ckMbZO"><strong><u>Pump! (feat. chelmico) [live]</u></strong></a> by PASOCOM MUSIC CLUB (2023)</em></p>

### Sections

1. [**The `switch` Keyword**](#part-1-the-switch-keyword)
2. [**The Java `while`-Loop**](#part-2-the-java-while-loop)
    - [**Syntax**](#syntax)
    - [**Sentinel Control**](#sentinel-control)
3. [**The Java `do`-`while`-Loop**](#part-3-the-java-do-while-loop)

### Part 1: _The `switch` Keyword_

One of the most glaring omissions in the Python language is that of `switch` blocks. These are super handy when you have a bunch of conditions that depend on only a single value. For example, let's part of the solution from problem 2 from lab 04 (`MajorStatusPrinter`) and see how `switch` can be used to make it much more palatable:

```java
String major;

if (majorCode.equals("C")) {
    major = "Computer Science";
} else if (majorCode.equals("M")) {
    major = "Music Composition";
} else if (majorCode.equals("A")) {
    major = "Architecture";
} else {
    major = null;
}
```

This just _looks_ complicated, even when it's a very simple check. Here's the `switch` version:

```java
String major;

switch (majorCode) {
    case "C": major = "Computer Science";  break;
    case "M": major = "Music Composition"; break;
    case "A": major = "Architecture";      break;
    default:  major = null;                break;
}
```

Pretty nice, right? So, what's going on here? The general syntax of the switch statement is as follows:

```java
switch (switch_expression) {
    case possible_value_1: statements_1;
    case possible_value_2: statements_2;
    case possible_value_3: statements_3;
    ...
    case possible_value_y: statements_y;
    case possible_value_z: statements_z;
    default: default_statements;
}
```

In other words:

1. The `switch` statement takes one argument, which can be a value or an expression, and checks its value.
2. It will then, _from top to bottom_, check if the value of its argument matches any of the `case` possibilities (`possible_value_1`, `possible_value_2` etc.) listed by the user. Just like `else if` structures, you can have as many of these as you like.
3. If the value of the argument matches one of the `case` possibilities, it will then execute the statement or statements that follow the colon `:` symbol.
4. If the value of the argument does not match any of the `case` possibilities, the `default` statements, defined after the `default` keyword, are executed instead. 

The `default` case is optional, but is largely recommended if your cases don't cover every single possible value that `switch_expression` can be. With the majors example above, `"A"`, `"C"`, and `"M"` is certainly not the only strings that can exist, so a `default` case should absolutely be included.

The year code part of this lab problem would, thus, look like this:

```java
switch (yearCode) {
    case "1":
        year = "Freshman";
        break;
    case "2":
        year = "Sophomore";
        break;
    case "3":
        year = "Junior";
        break;
    case "4":
        year = "Senior";
        break;
    case "5":
        year = "Supersenior";
        break;
    default:
        year = null;    
}
```

Note the use of `break` here. In CS 121, I discouraged the use of `break` on grounds that it had perfectly good uses, none of which existed in CS 121. Well, here's a perfectly good use of it. Once we do what we need to do with our `case`, we ask Java to `break` us out of the `switch` block. If we don't do this, **Java will actually execute the instructions of the next case automatically**. This can actually be pretty handy if you've got multiple cases that all share the same code. This is known as _cascading_.

For example:

```java
switch (day) {
    case "Monday":
    case "Tuesday":
    case "Wednesday":
    case "Thursday":
    case "Friday":
        System.out.println("It's " + day + ", a weekday!");
        break;

    case "Saturday":
    case "Sunday":
        System.out.println("It's " + day + ", a weekend!");
        break;

    default:
        System.out.println("ERROR: Invalid day.");
}
```

Possible output:

```
Which day of the week is it? Wednesday
It's Wednesday, a weekday!
```

### Part 2: The Java `while`-Loop

Let's say hello to a couple of old friends and to a new one. First up is `while`-loops. As you know, we generally use `while`-loops in situations where we cannot reliably predict the amount of times the loop will run, such as video game loops (run the game _while_ the user doesn't quit).

#### Syntax

The Java equivalent to the Python `while`-loop looks pretty similar, but with Javaesque syntax.

Python:

```python
while condition:
    # execute these steps
```

Java:

```java
while (condition) {
    // Execute these steps
}
```

In other words:

- You _must_ wrap your condition in a set of parentheses `()`.
- Wrap the code to be executed (i.e. the block of code) in a set of curly brackets `{}`.

Counting from 1 to 10 in Java with a `while`-loop is thus:

```java
final int LIMIT = 10;

int counter = 1;

while (counter <= LIMIT) {
    System.out.println(counter);
    counter++;
}
```

The `++` operator is called a _postfix increment_ operator. It's called postfix because it is placed _after_ the value being incremented, and it's called increment because it _increases the value by 1_. You can also use the _postfix decrement_ operator, `--`, to subtract by 1 instead. There is no Python equivalent (because of course there isn't).

#### Sentinel Control

Let's use this `while`-loop for something else. For example, let's ask the user to enter a password until they enter the correct password. In other words, _while the user enters the incorrect password, continue prompting for input_:

```java
import java.util.Scanner;

final String PASSWORD = "correctPassword";

Scanner scanner = new Scanner(System.in);

System.out.print("Enter your password: ");
String userPassword = scanner.nextLine();

while (!userPassword.equals(PASSWORD)) {
    System.out.print("Incorrect password. Enter your password: ");
    userPassword = scanner.nextLine();
}

// These last two lines will not run until !userPassword.equals(PASSWORD) 
// evaluates to false
System.out.println("Welcome.");

scanner.close();
```

Hopefully none of this feels too foreign to you. If you got through CS 121, the only thing you should look to get used to is Java's specific syntax.

### Part 3: _The Java `do`-`while`-Loop_

If you take a look at the sentinel control problem from above, in order for it to function the way it does, _`userPassword` needs to have an initial value_. This effectively means that we _have_ to ask the user to enter a password _before_ the sentinel `while`-loop even starts running.

Java has this neat loop called the [**`do`-`while`**](code/PasswordPrompter.java) that basically rids of this problem. Whereas the `while`-loop starts by checking the condition and then running the code block, **the `do`-`while`-loop starts by running the code block and _then_ checking for the condition**:

```java
final String PASSWORD = "correctPassword";

Scanner scanner = new Scanner(System.in);
String userPassword;

do {
    System.out.print("Enter your password: ");
    userPassword = scanner.nextLine();

    if (!userPassword.equals(PASSWORD)) { System.out.print("Incorrect! "); }
} while (!userPassword.equals(PASSWORD));

System.out.println("Welcome.");

scanner.close();
```

And the behaviour is exactly the same, but the code might be slightly easier to read:

```
Enter your password: password
Incorrect! Enter your password: correctPassword
Welcome.
```

The general syntax of this loop is:

```java
do {
    // these steps
} while (condition); // is true
```

In other words:

- Start with the `do` keyword.
- Open a code block with `{}`.
- Follow the code block with the `while` keyword.
- Include the loop's `condition`, surrounded by parentheses `()`.
- Finish with a semicolon `;`.

While extremely similar, don't feel forced to use `do`-`while`-loops just because they exist. Most of the time, you can get away with simply doing a `while`-loop equivalent so, until you are comfortable with the syntax and with recognises which situations are best suited for it (like user-input sentinel control), don't stress about it too much.

### Part 4: _The Java `for`-Loop_

#### **Syntax**

Now for everybody's favourite programming structure: the `for`-loop. `for`-loops are most useful when are have a pretty good idea of how many times the loop is going to run. This could be once for every value between `x` and `y`, or once for every object in a collection of objects. For now, we're going to stick to `for`-loops that count from one number to another. Later on, we'll learn how to iterate through collections of objects, since the syntax is much different.

To [**count from 1 to 10 with a Java `for`-loop**](code/ForLoopExample.java), we would do this:

```java
final int LIMIT = 10;

for (int number = 1; number <= LIMIT; number++) {
    System.out.println(number);
}
```

Which is equivalent to the Python:

```python
LIMIT = 10

for number in range(1, 11):
    print(number)
```

In other words:

1. Start with the `for` keyword.
2. In a set of parentheses after that, include the following three expressions:
    1. **Your starting point**: In this case, I chose my starting point to be a brand new `int` called `number`. You don't always need to create a new value as a starting point. You can use a pre-defined one (see example below).
    2. **Your end condition**: Similar to a `while`-loop, Java requires that we specify the condition that needs to remain `true` for the loop to continue running.
    3. **Your action after iteration**: Once the loop finishes running, this is the expression that would execute. In other words, how is our loop variable changing every time the loop runs?
3. Create and write a code block using `{}`.

The same `for`-loop from above, but with a pre-defined starting point:

```java
int number = 1;

// There's no need to write anything in the first part since
// we already defined it before the for-loop was implemented
for (; number <= LIMIT; number += 1) {
    System.out.println(number);
}
```

#### **Indexing**

Since we're dealing with numbers, we can actually use them to index through the members of a collection, like we did in Python. In Java, `String` objects aren't indexable, but we can simulate it using its `charAt()` method. For example, the [**following program**](code/ForLoopExample.java) counts the amount of vowels in a user-inputted string:

```java
import java.util.Scanner;

/*
 * Ask for input
 */
Scanner scanner = new Scanner(System.in);

System.out.print("Say anything: ");
String anything = scanner.nextLine().toLowerCase();  // I immediately lowercase this to make the check easier

scanner.close();

int vowelAmount = 0;

/*
 * Iterating from 0 to the length of the input
 */
for (int idx = 0; idx < anything.length(); idx++) {
    char character = anything.charAt(idx);

    /*
     * Using a switch to quickly check through the vowels.
     */
    switch (character) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u': vowelAmount++; break;
        default: break;
    }
}

System.out.println("Your input contained " + vowelAmount + " vowel(s).");
```

Output:

```
Say anything: I’m not so sure you could hit water if you fell out of a boat.   
Your input contained 22 vowel(s).
```