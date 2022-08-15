## Lectures 15

# Vectors and Mutli-Threaded Programming

### 28 Thermidor, Year CCXXX

### Sections

1. [**Vector Collection**](#part-1-vector-collection)
2. [**Multi-Threading**](#part-2-multi-threading)
3. [**The `Thread` Class**](#part-3-the-thread-class)
4. [**The `Runnable` Interface**](#part-4-the-runnable-interface)

### Part 1: *Vector Collection*

Let's learn about one final member of the `collections` library—the `Vector` class. A `Vector` is very similar to an
`ArrayList`, but the express purpose of a `Vector` is to grow with time. The `ArrayList` class can also change in size,
but it is less optimised to do so. For example, you can specify by how much you want a `Vector` to change in size 
whenever it gets filled up:

```java
// Creating a vector of size 2, which will increase in size by 5 every time it reaches capacity
Vector<String> students = new Vector<String>(2, 5);

System.out.printf("The `students` vector, before adding students, has a capacity of: %d\n%n",
students.capacity());

students.add("Justin");
students.add("Sarp");
students.add("Sean");
students.add("Cristian");
students.add("Parker");

System.out.printf("The `students` vector, after adding students has a capacity of: %d\n%n",
students.capacity());
```

Output:

```text
The `students` vector, before adding students, has a capacity of: 2

The `students` vector, after adding students has a capacity of: 7
```

You can also treat it similar to an array in `for`-loops:

```java
for (int i = 0; i < students.size(); i++) System.out.println(students.get(i));
```

Output:

```text
Justin
Sarp
Sean
Cristian
Parker
```

And:

```java
for (int i = 0; i < students.capacity(); i++) System.out.println(students.get(i));
```

Output:

```text
Justin
Sarp
Sean
Cristian
Parker
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 5
	at java.base/java.util.Vector.get(Vector.java:750)
	at multithreading.VectorExample.main(VectorExample.java:23)
```

From the application programming interface (API) perspective, these two classes are very similar—that is, they both 
perform virtually the same task without any noticable difference in behaviour from the user's end. From synchronization
perspective, however, they are different—**`Vector` objects are synchronised, while `ArrayList` is unsynchronised**.

**_Synchronisation_ is a concept related with multi-thread programming.** Notice that `multithreading` keyword in the
error message above? That's what we'll be looking at next.

### Part 2: *Multi-Threading*

Multi-threading is, in many ways, one of the most important concepts in computer science. The very fact that you are 
reading these notes, maybe listening to music, and talking to somebody on the same computer at the same time (and that
we don't even think about it) is a testament to this. At its essence, multi-threaded programming is what allows a 
single computer to do multiple processes at a time.

Consider this simple example. Let's say we have two people counting from 1 to 10. Represented by a couple of 
`for`-loops, we might have something like this:

```java
package multithreading;

public class Counter {
    private final String name;

    public static void main(String[] args) {
        Counter chisato = new Counter("Chisato");
        Counter takina = new Counter("Takina");

        chisato.countToTen();
        takina.countToTen();
    }

    public Counter(String name) {
        this.name = name;
    }

    public void countToTen() {
        for (int i = 0; i < 10; i++) System.out.printf("%s: %d...%n", this.name, i + 1);
    }
}
```

Output:

```text
Chisato: 1...
Chisato: 2...
Chisato: 3...
Chisato: 4...
Chisato: 5...
Chisato: 6...
Chisato: 7...
Chisato: 8...
Chisato: 9...
Chisato: 10...
Takina: 1...
Takina: 2...
Takina: 3...
Takina: 4...
Takina: 5...
Takina: 6...
Takina: 7...
Takina: 8...
Takina: 9...
Takina: 10...
```

While we imagine both of these "counters" counting from one to ten at the same time, this program is very clearly
_sequential_. That is, `Takina` does not start counting until `Chisato` is done. This is, of course, a problem when
we replace the act of counting with something more crucial to our day-to-day operations—things like communications and
financial transactions. Multi-threading aims to fix this by leveraging your computer's ability to create separate 
"threads", each doing its own thing on its own time.

### Part 3: *The `Thread` Class*

The easiest way to run a process that will run on its own individual thread is by inheriting the build-in `Thread` 
class:

```java
package multithreading;

import java.util.Random;

public class Counter extends Thread {
    private static final int WAITING_TIME_LIMIT = 1000;
    
    private final String name;

    public static void main(String[] args) {
        Counter chisato = new Counter("Chisato");
        Counter takina = new Counter("Takina");

        // Notice that we've switched from countToTen() to start()
        chisato.start();
        takina.start();
    }

    public Counter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.countToTen();
    }

    private void countToTen() {
        Random waiter = new Random();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.printf("%s: %d...%n", this.name, i + 1);
                Thread.sleep(waiter.nextInt(WAITING_TIME_LIMIT)); // for visual illustration purposes
            } catch (InterruptedException e) {
                System.out.printf("%s was interrupted.%n", this.name);
            }
        }
    }
}
```

Output:

```text
Takina: 1...
Chisato: 1...
Takina: 2...
Chisato: 2...
Chisato: 3...
Takina: 3...
Chisato: 4...
Takina: 4...
Takina: 5...
Takina: 6...
Chisato: 5...
Takina: 7...
Chisato: 6...
Chisato: 7...
Takina: 8...
Takina: 9...
Chisato: 8...
Takina: 10...
Chisato: 9...
Chisato: 10...
```

So, what happened here. Let's break it down.

---

Our main "activity" is still counting to ten, which has changed to the following:

```java
private void countToTen() {
    Random waiter = new Random();

    for (int i = 0; i < 10; i++) {
        try {
            System.out.printf("%s: %d...%n", this.name, i + 1);
            Thread.sleep(waiter.nextInt(WAITING_TIME_LIMIT)); // for visual illustration purposes
        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.%n", this.name);
        }
    }
}
```

<sub>**Code Block 1**: The only thing that changed here is that, after counting a number, we ask the thread to wait
for a certain amount of time (`Thread.sleep()`) before counting the next number. This process throws a checked 
`InterruptedException`, so we need to handle that.</sub>

In order to make this process runnable in a thread, we need to include it in the `Thread` class's `run()` method:

```java
@Override
public void run() {
    this.countToTen();
}
```

<sub>**Code Block 1**: Any process that you'd like to run in its own independent thread—running parallel to the main
thread as it were—goes in the `run()` method.</sub>

Interestingly, in order to actually execute whatever going the `run()` method, you have to run the `start()` method
**instead**. This method takes care of all the necessary procedures to ensure multi-threaded safety.

### Part 4: `Vector` Objects and Synchronisation

The reason why `Vectors` are better in multi-threaded situations is that a synchronized structure makes sure only one 
thread can work on the structure at one time; an unsynchronized structure allows multiple threads access at the same 
time.

Consider the situation where, in a collection where there are three elements saved, one thread wants to delete the first 
element and another thread wants to retrieve the first element. The result from an unsynchronized structure could be 
unpredictable, since no one thread has precedence over the other. A synchronized structure will make sure when the 
delete operation is done, the retrieve operation can be performed.