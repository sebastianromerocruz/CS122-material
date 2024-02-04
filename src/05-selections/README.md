<h2 align=center>Week 03: <em>Day 1</em></h2>

<h1 align=center>Selections</h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/u9Di0D1DQps?si=Gmuom5tqc9ckMbZO"><strong><u>Pump! (feat. chelmico) [live]</u></strong></a> by PASOCOM MUSIC CLUB (2023)</em></p>

### Sections

1. [**Comparison and Boolean Operators**](#part-1-comparison-and-boolean-operators)
    1. [**Relational Operators**](#relational-operators)
    2. [**Logical Operators**](#logical-operators)
2. [**Selection Statements**](#part-2-selection-statements)
    1. [**`if` and `else`**](#if-and-else)
    2. [**More Than Two Paths**](#more-than-two-paths)

---

### Part 1: _Relational and Boolean Operators_

As we learned back in CS 121, the crux upon which computer science is built is a program's ability to make decisions based on any given condition or conditions. In other words, your computer is considered to be a computar and not, say, a simple machine, because it can determine whether something is _true_ or _false_ and then perform a different set of instructions in either case. In CS, we call data values that hold this true/false value **booleans**, and they're represented by the **`boolean`** keyword in Java:

```java
boolean true_condition  = true;
boolean false_condition = false;
```

Now, the way most of these values are ever arrived at is via the execution of a _logical expression_ (i.e. a set of operations based entirely on yes/no questions). The expressions that evaluate to `boolean` values use two sets of operators: _relational_ and _logical_ operators. These are pretty similar to the ones we had in Python, so let's give them a quick look:

<br>

#### **Relational Operators**

Relational, or comparison, operators are those who check how to values relate, or compare, to each other. In Java, these are:

| **Operator** | **Verbal Equivalent**                         | **Example**                                           |
|--------------|-----------------------------------------------|-------------------------------------------------------|
| `==`         | _"Is A equal in value to B?"_                 | `45 == 45.0` (evaluates to `boolean` value `true`)         |
| `!=`         | _"Is A not equal in value to B?"_             | `10 != 10.0` (evaluates to `boolean` value `false`)        |
| `>`          | _"Is A greater in value than B?"_             | `0.15 > 0.045` (evaluates to `boolean` value `true`)       |
| `>=`         | _"Is A greater than or equal in value to B?"_ | `25 >= 25` (evaluates to `boolean` value `frue`)           |
| `<`          | _"Is A less in value than B?"_                | `10 < 150` (evaluates to `boolean` value `true`)           |
| `<=`         | _"Is A less than or equal in value to B?"_    | `93.4323 <= 93.4324` (evaluates to `boolean` value `true`) |

<sub>**Figure 1**: Relational operators in Java, where both A and B are _comparable_ values.</sub>

This is super simple with _primitive types_, like `int` and `double`, but can get much more complex when it comes to objects, since there might be multiple ways of determining when two objects of the same class are equal in value. For example, are two objects of a hypothetical `Student` class equal when they have the same `student_name` attribute? Or do they need to have the same `student_name` and `student_id` (and/or any other) attibute as well? 

Because this comparison process can get pretty tricky, most built-in Java classes have an **`equals()`** method that you should use instead of the `==` operator:

```java
String anglicised_name = "Reina Kousaka";
String romaji_name = "Rēna Kōsaka";
System.out.println(romaji_name.equals(anglicised_name));

final String USER_EMAIL = "sromerocruz@pace.edu";
String email = "sromerocruz@pace.edu";
System.out.println(USER_EMAIL.equals(email));
```
Output:
```
false
true
```

If you use `=`, what you are checking instead is whether two objects of the same class share the same location in memory, not the same value. 

```java
import java.util.Scanner;

Scanner scanner_a = new Scanner(System.in);
Scanner scanner_b = new Scanner(System.in);
Scanner scanner_alias = scanner_a;  // here, we don't create a new object, we just create another "link" to the same memory address

System.out.println(scanner_a == scanner_b);
System.out.println(scanner_a == scanner_alias);

scanner_a.close();
scanner_b.close();
```

Output:

```
false
true
```

TLDR: **use `==` for primitives and `equals()` for objects**. Be sure to remember this! It's super easy to miss and can cause a lot of debugging headaches.

#### **Logical Operators**

In order to chain various conditions together, we have to employ the use of what we call logical operators. These determine whether something is true or false based on the values of its operands. Again, these are largely the same from Python, but their symbols are different, so let's look at them:

| **`a`**   | **`!a`**     | **Description**                                                   |
|-----------|--------------|-------------------------------------------------------------------|
| `true`    | `false`      | If **`a`** evaluates to `true`, **`!a`** evaluates to `False`     |
| `false`   | `true`       | If **`a`** evaluates to `false`, **`!a`** evaluates to `True`     |

<sub>**Figure 2**: The "not" operator in Java is simply written when an exclamation mark `!`.</sub>

Example:

```java
import java.util.Scanner;

final int AMERICAN_DRINKING_AGE = 21;

Scanner scanner = new Scanner(System.in);

System.out.print("How old are you? ");
int age = scanner.nextInt();

System.out.println("You are (not) old enough to drink in the United States: " + 
                    !(age >= AMERICAN_DRINKING_AGE));

scanner.close()
```

Output:

```
How old are you? 30 
You are NOT old enough to drink in the United States: false
```

<br>

| **a**   | **b**   | **`a && b`**  | **Description**                                                                                    |
|---------|---------|-------------|------------------------------------------------------------------------------------------------------|
| `true`  | `true`  | `true`      | If **a** evaluates to `true` and **b** evaluates to `true`, then **`a && b`** evaluates to `true`      |
| `true`  | `false` | `false`     | If **a** evaluates to `true`, and **b** evaluates to `false`, then **`a && b`** evaluates to `false`   |
| `false` | `true`  | `false`     | If **a** evaluates to `false`, and **b** evaluates to `true`, then **`a && b`** evaluates to `false`   |
| `false` | `false` | `false`     | If **a** evaluates to `false`, and **b** evaluates to `false`, then **`a && b`** evaluates to `false`  |

<sub>**Figure 3**: The "and" operator in Java is written when two ampersigns `&&`.</sub>

Example:

```java
final int AMERICAN_DRINKING_AGE = 21;

Scanner scanner = new Scanner(System.in);

System.out.print("How old are you? ");
int age = scanner.nextInt();

System.out.print("Do you have valid identification with you? ");
boolean hasIdentification = scanner.nextBoolean();

System.out.println("You may purchase alcohol in the United States: " + 
                    (age >= AMERICAN_DRINKING_AGE && hasIdentification));

scanner.close()
```

Output:

```
How old are you? 30
Do you have valid identification with you? true
You may purchase alcohol in the United States: true
```

<br>

| **a**   | **b**   | **`a ││ b`** | **Description**                                                                                         |
|---------|---------|--------------|---------------------------------------------------------------------------------------------------------|
| `true`  | `true`  | `true`       | If either **a** evaluates to `true` or **b** evaluates to `true`, then **`a ││ b`** evaluates to `true` |
| `true`  | `false` | `true`       | If **a** evaluates to `true` or **b** evaluates to `false`, then **`a ││ b`** evaluates to `true`       |
| `false` | `true`  | `true`       | If **a** evaluates to `false` or **b** evaluates to `true`, then **`a ││ b`** evaluates to `true`       |
| `false` | `false` | `false`      | If **a** evaluates to `false` or **b** evaluates to `false`, then **`a ││ b`** evaluates to `false`     |

<sub>**Figure 4**: In Java, the "or" operator is written using two pipe characters `||`.</sub>

Example:

```java
final int AMERICAN_DRINKING_AGE = 21;

Scanner scanner = new Scanner(System.in);

System.out.print("How old are you? ");
int age = scanner.nextInt();

System.out.print("Do you have valid identification with you? ");
boolean hasIdentification = scanner.nextBoolean();

System.out.print("Are you accompanied by an adult? ");
boolean isAccompanied = scanner.nextBoolean();

boolean isLicensedAdult = age >= AMERICAN_DRINKING_AGE && hasIdentification;
        
System.out.println("You may go ahead with your purchase of alcohol: " + 
                    (isAccompanied || isLicensedAdult));
```
Output:
```
How old are you? 19
Do you have valid identification with you? true
Are you accompanied by an adult? true
You may go ahead with your purchase of alcohol: true
```

<br>

### Part 2: _Selection Statements_

You know where this is headed. The structures that make use of boolean values in order to run are called _control-flow structures_, and of those, the most important are **selection statements**. 

#### **`if` and `else`**

In Java, unlike Python, we only have two keywords dedicated for this structure: **`if`** and **`else`**:

```java
import java.util.Scanner;

final String USER_PASSWORD = "thisIsAGoodPassword";

System.out.print("Enter your password: ");
Scanner scanner = new Scanner(System.in);
String userInput = scanner.nextLine();

if (userInput.equals(USER_PASSWORD)) {
    System.out.println("Logging in...");
} else {
    System.out.println("ERROR: Incorrect password.");
}

scanner.close();
```

Let's talk about the differences between Java and Python selection statements:

- When write the condition after the `if` keyword, you _must_ surround your condition by a set of parentheses `()`. This is possible in Python as well, but it is not necessary and largely discouraged.
- Unlike Python, In Java you do _not_ write a `:` with control-flow structures. Instead, each structure starts its own **code block using `{}`**.
- If there is an `else`-statement after the `if`-statement, you simply add it after the `if`-statement's code block.
- While indentation was absolutely necessary in Python, it is completely optional in Java. So, the above selection structure can also be written as such:

```java
if (userInput.equals(USER_PASSWORD)) { System.out.println("Logging in..."); } 
else { System.out.println("ERROR: Incorrect password."); }
```

In general, Java is pretty lax as to how you space out your lines of code. All it really cares about is that you abide by the rules of `{}` and `;`.

That's essentially all there is to selections. Everything else is basically just a combination of `if`- and `else`-statements, along with their respective code blocks `{}`.

#### **More Than Two Paths**

For example, if we wanted to simulate an `elif`-statement from Python:

```python
R_RATED_MOVIE_AGE = 18

age = int(user_input("How old are you? "))

if age == R_RATED_MOVIE_AGE:
    print("Happy birthday! You can watch R-rated films by yourself.")
elif age > AMERICAN_DRINKING_AGE:
    print("You can watch R-rated films by yourself.")
else:
    print("You need to be chaperoned by someone to watch R-rated films.")
```

We would do:

```java
import java.util.Scanner;

final int R_RATED_MOVIE_AGE = 18;

Scanner scanner = new Scanner(System.in);

System.out.print("How old are you? ");
int userAge = scanner.nextInt();

if (userAge == R_RATED_MOVIE_AGE) {
    System.out.println("Happy birthday! You can watch R-rated films by yourself.");
} else if (userAge > R_RATED_MOVIE_AGE) {
    System.out.println("You can watch R-rated films by yourself.");
} else {
    System.out.println("You need to be chaperoned by someone to watch R-rated films.");
}

scanner.close();
```

Nested selection statements work in a similar way and are, in my opinion, much easier to read in Java than in Python:

```java
import java.util.Scanner;

final int R_RATED_MOVIE_AGE = 18;

Scanner scanner = new Scanner(System.in);

System.out.print("Is anybody in your party 18 or over? (true/false) ");
boolean isChaperoned = scanner.nextBoolean();

if (!isChaperoned) {
    System.out.print("How old are you? ");
    int userAge = scanner.nextInt();

    if (userAge == R_RATED_MOVIE_AGE) {
        System.out.println("Happy birthday! You can watch R-rated films by yourself.");
    } else if (userAge > R_RATED_MOVIE_AGE) {
        System.out.println("You can watch R-rated films by yourself.");
    }
} else {
    System.out.println("You need to be chaperoned by someone to watch R-rated films.");
}

scanner.close();
```