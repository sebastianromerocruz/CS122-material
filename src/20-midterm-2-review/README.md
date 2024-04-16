<h2 align=center>Week 13: <em>Day 1</em></h2>

<h1 align=center>Midterm II Review</em></h1>

<!-- <p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/Vx1Yljmm3ck?si=jmGH0jnILrdNyIBT"><strong><u>そして、次の曲が始まる (And So, The Next Piece Begins)</u></strong></a> by Akito Matsuda (2019)</em></p> -->

---

### Sections

1. [**Multiple Choice**](#multiple-choice)
2. [**Short Response**](#short-response)
3. [**Programming**](#programming)

---

<a id="multiple-choice"></a>

### Part 1: _Multiple Choice_

1. Which of the following is _not_ true about Java interfaces?

    - [ ] Java interfaces have to use the `public` access modifier.
    - [ ] Java interfaces can declare multiple methods.
    - [ ] Java classes can implement only one Java interface.
    - [ ] All of these are true statements.

2. Why will compiling and running `Student.java` result in an error?

    ```java
    // Person.java
    public abstract class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }
    }

    // Student.java
    public class Student extends Person {
        private String major;

        protected Student(String major, String name) {
            this.major = name;
            super(major);
        }
    }
    ```

    - [ ] Because the `Person` constructor is `public` and the `Student` constructor is `protected`.
    - [ ] Because the super-constructor of `Student` is called after `major` is given a value.
    - [ ] Because the `major` parameter was given to the super-constructor instead of the `name` parameter.
    - [ ] This program will not result in an error.

3. Say we attempted to create an array objects in the `main()` method of the `Student` class from above:

    ```java
    Person[] people = {
        new Student("Sebastián", "Chemical and Biomolecular Engineering"),
        new Student("Jemma", "Biomolecular Science")
    };
    ```

    Why will this line of code fail?

    - [ ] Because we didn't create individual variables for each individual student before placing them into an array.
    - [ ] Because we are attempting to place `Student` objects into a `Person` array–the types don't match.
    - [ ] Because we didn't specify the size of the `Person` array.
    - [ ] This line will fail? What are you talking about? No, it won't.

4. Who can access `private` class members?

    - [ ] Only that class itself.
    - [ ] Only that class and its subclasses.
    - [ ] Only that class, its subclasses, and any other Java file in the same folder.
    - [ ] Any Java file across our entire project.

5. For what reason do we set an abstract class's constructor to `protected`?

    - [ ] Because not doing so will result in a compiler error.
    - [ ] Because it's conversion to do so, but there are no real practical reasons.
    - [ ] Because not doing so will allow all files in the same folder as this abstract class to be able to call the constructor.
    - [ ] Because that way, we can guarantee that files outside of the package (folder) cannot access this constructor, but its subclasses can.

<br>

<a id="short-response"></a>

### Part 2: _Short Response_

What will compiling and running `C.java` print as output?

```java
public abstract class A {
    private char b;

    protected A(char one) {
        this.b = one;
        System.out.print('a');
    }

    @Override
    public String toString() {
        return Character.toString(this.b);
    }
}
```

```java
public interface B {
    public char e = 'f';
}
```

```java
public class C extends A implements B {
    public static final char H = 'i';

    public static void main(String[] args) {
        System.out.print('o');
        C c = new C('p');
        System.out.print(c);
    }

    public C(char two) {
        super(H);
        System.out.print('j');
        System.out.print(super.toString());
        System.out.print(e);
    }
}
```


<br>

<a id="programming"></a>

### Part 3: _Programming_

#### _Sections_

1. [**Background**](#background)
2. [**The `Train` Abstract Class**](#train)
3. [**The `Subway` Class**](#subway)
4. [**Sample Output**](#sample-output)

<a id="background"></a>

#### _Background_

We'll be testing our understanding of object-oriented programming concepts by creating objects that simulate a city's public underground trains (I've based this on the NYC subway because it's just another excused to make fun of it). 

Subway trains are themselves trains, but there are certainly other types of trains that we could think of: bullet trains, freight trains, overground trains, etc.. To accommodate for this variety, we will also be creating a general class to represent every kind of train, from which the Subway will get some of its properties from.

<br>

<a id="train"></a>

#### _The `Train` Abstract Class_

This general concept of trains will, itself, be represented by an abstract class called `Train`. Your implementation of this class must include:

- Two _private attributes_ and their _getters_:
    - **`String manufacturer`**: The name of the manufacturer of this train.
    - **`Date manufacturingDate`**: A `Date` object representing this train's manufacturing date. In order to declare this constant, please include the following import statement at the top of your file:
        ```java
        import java.util.Date;
        ```
- A _protected_ constructor that:
    - Accepts one parameter, `String manufacturer`.
    - Assigns the value of the parameter `manufacturer` to the private attribute `manufacturer`.
    - Assigns the `manufacturingDate` attribute the value of a `Date` object with the today's date and time. Do this by creating a new `Date` object and passing `System.currentTimeMillis()` as an argument to its constructor.
    - Prints the following message:
        ```
        MANUFACTURER Train manufactured on MANUFACTURING_DATE
        ```
        Where `MANUFACTURER` and `MANUFACTURING_DATE` should be replaced with their appropriate values.
- The declaration of a _public abstract void_ method called **`travel()`** that accepts two parameters:
    1. **`String origin`**: The starting point of this train's trip.
    2. **`String destination`**: The destination point of this train's trip.
- An overriden **`equals()`** method that returns `true` if the other object being used for comparison...
    - Is not `null`.
    - Is of the same class as this `Train` object.
    - Has the same exact `manufacturingDate`.
    
    Otherwise, return `false`.

Because the `Train` class is abstract, we unfortunately can't test it, so let's just move along. It's ok–believe in yourself. _I_ believe in you, anyway.

<br>

<a id="subway"></a>

#### _The `Subway` Class_

The actual cause of 20% of my daily stress will be thus represented by the `Subway` class, which will:

- Inherit from the `Train` class.
- Be _comparable_ to other `Train` objects.
- Have two _public static_ constants:
    - **`int MAX_OCCUPANCY`**: The max amount of people that can be riding this train at any given moment. For simplicity, let's use `100` as its value.
    - **`String MANUFACTURER`**: The manufacturer of _all NYC Subway trains_, `"New York City Subway Rolling Stock"`.
- Have two _private attributes_:
    - **`char line`**: The line to which this `Subway` train belongs to (e.g. `A`, `F`, `2`, etc.).
    - **`int currentOccupancy`**: The current amount of people riding this train.
- Have a _public_ constructor that:
    1. Accepts one parameter, `char line`.
    2. Initialises this `Subway` train's `Train` properties.
    3. Assigns the value of the parameter `line` to the private attribute `line`.
    4. Assigns the value of `0` to the private attribute `currentOccupancy`.
- Define a _public void_ method called **`boardRiders()`** that:
    1. Accepts one parameter, `int riderAmount`.
    2. Increases the value of `currentOccupancy` by `riderAmount`.
    3. Prints the message:
        ```
        RIDER_AMOUNT people/person tried to get on the LINE train...
        ```
        Where `RIDER_AMOUNT` and `LINE` should be replaced by their appropriate values.
    4. Check if the current occupancy is greater than or equal to the max occupancy. If it is set the value of `currentOccupancy` to the value of the max occupancy and print the following message:
        ```
        ...but the LINE train is full!
        ```
        Where `LINE` should be replaced by its appropriate value.
- Override the `travel()` method to print the following message:
    ```
    This stop is ORIGIN...
    This is a *REALLY LOUD STATIC*–bound LINE train. The next stop is *EVEN LOUDER STATIC* (DESTINATION)
    ```
    Where `ORIGIN`, `LINE`, and `DESTINATION` should be replaced by their appropriate values.
- Override the `compareTo()` method so that it will return 0 if both this `Subway` train's current occupancy is equal to the other `Subway` train's current occupancy. If this train's current occupancy is higher than the other's, return a positive value, and if it is lower, return a negative value.

<br>

<a id="sample-output"></a>

#### Sample Output

Copy the following code into the `Subway` class's `main()` method and run to test your code. Since there's some random behaviour involved here, the output will look slightly different each time (you might have to try a few times to get your train to be full):

```java
Subway[] subwayTrains = {
    new Subway('C'),
    new Subway('R')
};

System.out.println();
for (Subway train : subwayTrains) {
    for (int i = 0; i < 5; i++) {
        int riders = (int) (Math.random() * 50);

        train.boardRiders(riders);
    }

    train.travel("Lafayette Avenue", "Jay Street-MetroTech");
    System.out.println();
}

if (subwayTrains[0].compareTo(subwayTrains[1]) == 0) {
    System.out.printf(
        "The %c train the same amount of people as the %c train right now.", 
        subwayTrains[0].getLine(), 
        subwayTrains[1].getLine()
        );
} else if (subwayTrains[0].compareTo(subwayTrains[1]) > 0) {
    System.out.printf(
        "The %c train has more people than the %c train right now.", 
        subwayTrains[0].getLine(), 
        subwayTrains[1].getLine()
        );
} else {
    System.out.printf(
        "The %c train less has more people than the %c train right now.", 
        subwayTrains[0].getLine(), 
        subwayTrains[1].getLine()
        );
}
```

Possible output:

```
New York City Subway Rolling Stock Train manufactured on Sat Apr 13 17:49:21 EDT 2024
New York City Subway Rolling Stock Train manufactured on Sat Apr 13 17:49:21 EDT 2024

20 people/person tried to get on the C train...
29 people/person tried to get on the C train...
21 people/person tried to get on the C train...
29 people/person tried to get on the C train...
25 people/person tried to get on the C train...
...but the C train is full!
This stop is Lafayette Avenue...This is a *REALLY LOUD STATIC*–bound C train. The next stop is *EVEN LOUDER STATIC* (Jay Street-MetroTech).

1 people/person tried to get on the R train...
9 people/person tried to get on the R train...
1 people/person tried to get on the R train...
2 people/person tried to get on the R train...
3 people/person tried to get on the R train...
This stop is Lafayette Avenue...This is a *REALLY LOUD STATIC*–bound R train. The next stop is *EVEN LOUDER STATIC* (Jay Street-MetroTech).

The C train has more people than the R train right now.
```