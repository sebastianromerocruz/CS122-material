<h2 align=center>Week 04: <em>Day 1</em></h2>

<h1 align=center>Static Methods and the <code>this</code> Keyword</h1>

<p align=center><strong><em>Song of the day:</strong> <a href="https://youtu.be/37ZFDJgVa0w?si=1Nb4t5Lqnvp99PxP"><strong><u>Now Is The Hour</u></strong></a> by The 1975 (2024)</em></p>

### Sections

1. [**Java Methods**](#java-methods)
2. [**Static Methods and the `static` Keyword**](#part-2-static-methods-and-the-static-keyword)
3. [**Arguments and Parameters**](#part-3-arguments-and-parameters)
4. [**Calling Class Methods Inside of the Class Definition**](#part-4-calling-class-methods-inside-of-the-class-definition)

### Part 1: _Java Methods_

We have been making use of some of Java's built-in classes in order to perform important operations, such as string indexing, slicing, casting, and mathematical operations like exponentiation and rooting. For example, consider the method we use to cast a string into an integer:

```java
String string = "42";
int integer = Integer.parseInt(string);
```

What we are doing here is calling a method, `parseInt()`, belonging to the class `Integer`. Now, what's interesting here is that, in the way we understand methods from our Python days, methods are simply functions that belong to an _object_ of a class, like this:

```python
class Integer:
    def parse_int(self, string):
        pass
    
integer = Integer()  # an object of the Integer class
forty_two = integer.parse_int("42")
```

The weird thing here is that when we called `Integer.parseInt(string)`, we never actually created an object of the `Integer` class. In other words, we never had to do this:

```java
String string = "42";
Integer integer = new Integer();

int newInt = integer.parseInt(string);
```

This code, in fact, will produce the following compiler error:

```
The static method parseInt(String) from the type Integer should be accessed in a static way
```

The Java compiler is calling `parseInt()` a _static method_, but what does that even mean? That's the topic of today's lecture.

<br>

### Part 2: _Static Methods and the `static` Keyword_

Succinctly put:

> **Static methods** are methods that can be called _without instantiating an object_ of the class it belongs to.

That's exactly what we saw above. Without instantiating an object of the `Integer` class, we were able to call the `parseInt()` method. This isn't actually the first time we have seen this either. What do you notice about the signature of the `main()` method?

```java
class StaticExample {
    public static void main(String[] args) {

    }
}
```

There it is, **the `static` keyword**. In other words, _we didn't need to create an object of the `StaticExample` class in order for Java to run its `main()` method_. The way we did that was by making this method `static`. 

---

Since everything in Java has to be part of a class, there are no standalone functions. Therefore, creating `static` methods is the closest we can get to that, since we don't have to create new objects in order to call them. Let's make a simple static method that just greets the caller. This function will not accept any arguments and will not return any values to the caller:

```java
class StaticExample {
    static void greet() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        StaticExample.greet();
    }
}
```

Output:

```
➜  javac StaticExample.java 
➜  java StaticExample      
Hello!
```

Notice that, aside from the `static` keyword, we also have the `void` keyword right next to the name of the method. In Java, when you define methods, **you must specify the type of the value that the method returns** immediately to the left of its name. The `void` keyword simply means that this method is _not returning anything_.

Although _not structurally equivalent_ (you can define static methods in Python too), this would be functionally equivalent to us writing the following in Python:

```python
# static_example.py
def greet():
    print("Hello!")

def main():
    greet()

main()
```

For the sake of example, let's do something slightly more complicated and print all of the even numbers from 1 to 10:

```java
class StaticExample {
    static void printOneToTenEvens() {
        final int LIMIT = 10;

        for (int number = 1; number <= LIMIT; number++) {
            if (number % 2 == 0) System.out.println(number);
        }
    }

    public static void main(String[] args) {
        StaticExample.printOneToTenEvens();
    }
}
```

Output:

```
➜  javac StaticExample.java
➜  java StaticExample      
2
4
6
8
10
```

For our current knowledge of programming, this is basically how we would write "standalone functions" in Java in the sense that they do not need objects of a class in order to be called and run. They're still considered methods because they are associated with a class definition.

---

Your burning question right now is probably why I keep avoiding the `public` keyword. The answer is that I am not avoiding it—I am simply not using it because it is not necessary right now. The `public` keyword has a very specific use in the Java language, and none of what we've done thus far has warranted its use. We'll get there very soon, so just be patient.

<br>

### Part 3: _Arguments And Parameters_

Alrighty, so our next step is to give our methods the ability to accept data from the outside. In Python, we would do something like the following:

```python
def greet_person(name):
    print(f"Hello, {name}!")

def main():
    user_name = "Junko"
    greet_person(user_name)

main()
```

To write the equivalent in Java, we would do as follows:

```java
class StaticExample {
    static void greetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        String userName = "Sebastián";
        StaticExample.greetPerson(userName);
    }
}
```

Output:

```
➜  javac StaticExample.java
➜  java StaticExample      
Hello, Sebastián!
```

In other words:

1. We used the `static` keyword to signify that this method can be called without an instance of the `StaticExample` class.
2. We used the `void` keyword to signify that this method does not return any value.
3. We specify the name of the method, `greetPerson`.
4. Inside of the method's parentheses `()`, we specify the type of the parameter we expect to get from the caller (in this case, a `String` object).
5. We specify the name of the parameter, `name`.

---

Just like in Python, we can specify as many parameters as we want. For example, let's say we wanted to write a program to print out a class multiplication table:

```java
class StaticExample {
    static void printMultiplicationTable(int numberOfRows, int numberOfColumns) {
        for (int row = 1; row < numberOfRows; row++) {
            for (int column = 1; column < numberOfColumns; column++) {
                System.out.print((row * column) + "\t");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        StaticExample.printMultiplicationTable(10, 5);
    }
}
```

Output:

```
➜  javac StaticExample.java
➜  java StaticExample      
1       2       3       4
2       4       6       8
3       6       9       12
4       8       12      16
5       10      15      20
6       12      18      24
7       14      21      28
8       16      24      32
9       18      27      36
```

### Part 4: _Calling Class Methods Inside Of The Class Definition_

You might remember that, in Python, we could call a class's methods inside of the class definition itself by using the `self` keyword.

```python
class Dog:
    def bark(self):
        print("Bark!")
    
    def eat(self):
        print("Eat!")

    def act_like_a_dog(self):
        self.bark()
        self.eat()

def main():
    dog = Dog()
    dog.act_like_a_dog()

main()
```

Output:

```
➜  python3 dog.py        
Bark!
Eat!
```

Java has an equivalent keyword, which is a bit more common among other programming languages, called `this`. Unlike Python, however, this keyword is largely optional and is only required when it comes to writing constructors (or the `__init__()` method in Python). We're not up to that point just yet, so for now, you can simply drop the word `self` and the name of the class if the method was defined inside of the class you're currently working in, as such:

The following code:

```java
class StaticExample {

    // Method definitions...

    public static void main(String[] args) {
        StaticExample.greet();
        StaticExample.printOneToTenEvens();

        String userName = "Sebastián";
        StaticExample.greetPerson(userName);

        StaticExample.printMultiplicationTable(10, 5);
    }
}
```

Can be rewritten as:

```java
class StaticExample {

    // Method definitions...

    public static void main(String[] args) {
        greet();
        printOneToTenEvens();

        String userName = "Sebastián";
        greetPerson(userName);

        printMultiplicationTable(10, 5);
    }
}
```

But only because `greet()`, `printOneToTenEvens()`, `greetPerson()`, and `printMultiplicationTable()` were all defined inside the `StaticExample` class.