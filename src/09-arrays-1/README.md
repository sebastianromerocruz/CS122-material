<h2 align=center>Week 05: <em>Day 1</em></h2>

<h1 align=center>Arrays: <em>Basics</em></h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/CvtJVku_mJw?si=oCpF0NdkYQXMF_iq"><strong><u>Always</u></strong></a> by Blink-182 (2004)</em></p>

### Sections

1. [**Java Arrays**](#part-1-java-arrays)
    1. [**Syntax**](#syntax)
    2. [**Examples**](#examples)
2. [**`foreach`-Loops**](#part-2-foreach-loops)

### Part 1: _Java Arrays_

Thus far in our journey through Java, we have been dealing with a very limited amount of data. That is, even when we were calculating, say, the average of a large quantity of numbers, we were accepting those numbers from the user and immediately adding them into an accumulator, thereby losing access to the original value. 

Back in our Python days, we were able to store various values inside a single object called a _collection_. Examples of these included lists, tuples, ranges, and strings. Naturally, Java has ways through which we can store multiple values and reference that collection with a single variable. The most basic of these is called an **array** which...

> ...stores a fixed-size sequential collection of elements _of the same type_.
>
> Once an array is created, its size is fixed. An array reference variable is used to access the elements in an array using an index.

<h6 align=right>– Y. Daniel Yang, <em>Introduction to Java, 12<sup>th</sup> Edition</em></h6>

#### Syntax

The basic syntax for declaring an array is as follows:

```java
type[] arrayReferenceVariable;

// or...

type arrayReferenceVariable[];  // C++ syntax; allowed, but not preferred
```

In other words, `type` can be replaced with any Java type, built-in or not, such as, say, integers and strings:

```java
int[] examGrades;

String[] studentNames;
```

Now, because arrays _must be of fixed size_, simply declaring them does not actually reserve any space in memory–this only happens when you give the array its initial value. The syntax for that is the following:

```java
type[] arrayReferenceVariable = new type[arraySize];
```

For example, let's say we have three exam grades, so I would anticipate to create my array with a size of `3`:

```java
final int EXAM_AMOUNT = 3;

int[] examGrades = new int[EXAM_AMOUNT];
```

After which we can easily start filling the values in using indices, just like we did in Python:

```java
final int EXAM_AMOUNT = 3;

int[] examGrades = new int[EXAM_AMOUNT];

examGrades[0] = 80;
examGrades[1] = 75;
examGrades[2] = 96;

for (int idx = 0; idx < examGrades.length; idx++) {
    System.out.println("Element at location " + idx + ": " + examGrades[idx]);
}

System.out.println(examGrades);
```

Output (note that, by default, arrays will not be printed nicely like Python collections are):

```
➜  javac ArrayExample.java
➜  java ArrayExample      
Element at location 0: 80
Element at location 1: 75
Element at location 2: 96
[I@18b4aac2
```

In memory, this would now look as follows:

```text
int[] examGrades = new int[3]; │
examGrades[0] = 80;            │                 ~~~~~~~~~~~~~~~
examGrades[1] = 75;            │                  │———————————│
examGrades[2] = 96;            │           unused │ mem_loc a │
        │                      │                  │———————————│
        └──────────────────────│──> examGrades[0] │    80     │     
                               │                  │———————————│
                               │    examGrades[1] │    75     │
                               │                  │———————————│
                               │    examGrades[2] │    96     │
                               │                  │———————————│
                               │           unused │ mem_loc e │
                               │                  │———————————│
                               │                 ~~~~~~~~~~~~~~~
                               │
——————————————————————————————————————————————————————————————————
         Programmer                                   RAM
```

<sub>**Figure 1**: Note that Java reserves _exactly_ 3 slots in memory.</sub>

Of course, you can also instantiate arrays with preexisting values. The general syntax for this is:

```java
type[] arrayReferenceVariable = { value1, value2, value3, ..., valuex, valuey, valuez };
```

#### Examples

1. Initialising arrays with input values:

```java
Scanner scanner = new Scanner(System.in);

System.out.print("How many numbers would you like to store in an array? ");
int length = scanner.nextInt();

double[] numbers = new double[length];

for (int idx = 0; idx < length; idx++) {
    numbers[idx] = scanner.nextDouble()
};

scanner.close();
```

2. Initialising arrays with random values:

```java
Scanner scanner = new Scanner(System.in);

System.out.print("How many random numbers would you like to store in an array? ");
int length = scanner.nextInt();
scanner.close();

double[] numbers = new double[length];

// random numbers from 0.0 to 100.0
for (int idx = 0; idx < length; idx++) {
    numbers[idx] = Math.random() * 100.0;
}

for (int idx = 0; idx < length; idx++) {
    System.out.println(numbers[idx]);
}
```

Output:

```
➜  code git:(main) ✗ javac ArrayExample.java 
➜  code git:(main) ✗ java ArrayExample      
How many random numbers would you like to store in an array? 5
82.06996119000925
3.711434807546188
21.749364650888005
29.017576162869474
31.505335228145814
```

3. Finding the largest element in an array:

```java
Scanner scanner = new Scanner(System.in);

System.out.print("How many random numbers would you like to store in an array? ");
int length = scanner.nextInt();
scanner.close();

double[] numbers = new double[length];
for (int idx = 0; idx < length; idx++) {
    numbers[idx] = Math.random() * 100.0;
}

double max = Double.MIN_VALUE;
for (int idx = 0; idx < length; idx++) {
    if (numbers[idx] > max) {
        max = numbers[idx];
    }
}

System.out.println("The max number generated was: " + max);
```

Possible output:

```
➜  javac ArrayExample.java
➜  java ArrayExample      
How many random numbers would you like to store in an array? 10
The max number generated was: 94.10446821950758
```

<br>

### Part 2: _`foreach`-Loops_

You know how, in Python, we were able to loop through a list of numbers by iterating through the list instead of by indexing through them?

```python
numbers = [1, 2, 3]

for number in numbers:
    print(number)

"""
# instead of:
numbers = [1, 2, 3]

for idx in range(len(numbers)):
    print(numbers[idx])
"""
```

Python has this convenient equivalent called a **`foreach`-loop**, which allows you to traverse the array sequentially without using an index. For example:

```java
int[] numbers = { 1, 2, 3 };

for (int number : numbers) {
    System.out.println(number);
}
```

Output:

```
➜  javac ArrayExample.java
➜  java ArrayExample      
1
2
3
```

Or:

```java
String[] members = { "Hitori", "Ikuyo", "Ryō", "Nijika" };

for (String member : members) {
    System.out.println(member);
}
```

Remember here, though, that the loop variable that the `foreach`-loop creates is simply a _copy_ of each of the values inside of the array. It is _not_ referencing the actual member strings inside of `members`. For instance:

```java
String[] members = { "Hitori", "Ikuyo", "Ryō", "Nijika" };

for (String member : members) {
    member = member.toUpperCase();
}

for (String member : members) {
    System.out.println(member);
}
```

Output:

```
➜  javac ArrayExample.java
➜  java ArrayExample      
Hitori
Ikuyo
Ryō
Nijika
```

The original string values inside of `members` were NOT changed.