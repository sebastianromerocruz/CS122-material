<h4 align=center>Pace University</h4>
<h3 align=center>CS 122 Fall 2023</h3>
<h1 align=center>Final Exam</h1>
<h3 align=center><em>Tuesday, May 7th, 2024</em></h3>

1. [**The `Temple` Abstract Class**](#temple)
2. [**The `VisitationNotAllowedException` Class**](#exception)
3. [**The `Prayer` Interface**](#prayer)
4. [**The `ShintoTemple` Class**](#shinto)
5. [**The `BuddhistTemple` Class**](#buddhist)
6. [**The `searchForOffering()` Method**](#search)

<a id="background"></a>

### **Background**

Say that we are level designers for a video game whose world is inspired by the serene landscapes of Japan, and thus we find ourselves tasked with developing a system to manage information about temples. Our goal is to create a structured framework for representing both Buddhist and Shinto temples, incorporating aspects unique to each tradition.

```
               +------------------+
               | Temple (abstract)|
               +------------------+
               | - name           |
               | - location       |
               | - yearBuilt      |
               +------------------+
                     ^        ^
                    / inherits \
       +------------------+   +------------------+
       | BuddhistTemple   |   | ShintoTemple     |
       +------------------+   +------------------+
       | - isZen          |   | - hasTorii       |
       +------------------+   +------------------+
                                     | implements
                                     v
                            +---------------------+
                            | Prayer (interface)  |
                            +---------------------+
                            | conductPrayer()     |
                            +---------------------+
```

<sub>**Figure 1**: A diagram of how our classes/interfaces relate to each other.</sub>

<br>

<a id="temple"></a>

### The `Temple` Abstract Class

Let's proceed to construct the foundational class for all temples. The `Temple` class serves as a blueprint for representing both Buddhist and Shinto temples, encapsulating essential attributes and behaviors common to all temple traditions.

This class must...

- Be abstract.
- Have the following _private_ attributes (_along with their respective getters_):
    - **`String name`**: Represents the name of the temple.
    - **`String location`**: Represents the location of the temple.
    - **`int yearBuilt`**: Represents the year the temple was built.
- Have a _protected_ constructor that:
    - Accepts the following parameters:
        1. **`String name`**: Represents the name of the temple.
        2. **`String location`**: Represents the location of the temple.
        3. **`int yearBuilt`**: Represents the year the temple was built.
    - Initializes all three private attributes with the values of the parameters.
- An _abstract void_ method called **`explore()`** that doesn't accept any parameters. This method represents the act of exploring the temple.
- An overridden **`equals()`** method that bases equality on:
    - Non-null objects of the `Temple` class that...
    - Have exactly equal values for _all three_ private attributes.
- An overridden **`toString()`** method that returns a single multi-line string of the following format:
    ```
    Temple: TEMPLE_NAME
    Location: LOCATION
    Year Built: YEAR_BUILT
    ```
    Where `TEMPLE_NAME`, `LOCATION`, and `YEAR_BUILT` are replaced by their appropriate values.

<br>

<a id="exception"></a>

### The `VisitationNotAllowedException` Class (5%)

Before we proceed, let's handle exceptional cases where visiting a temple is not allowed. The **`VisitationNotAllowedException`** class will represent such scenarios.

This class must...

- Inherit from the built-in `Exception` class.
- Have a _public_ constructor that accepts a single parameter, `String message`, representing the exception message.

To test your exception, create a `main()` method in the class and run the following code:

```java
try {
    throw new VisitationNotAllowedException("Visitation to this temple is restricted.");
} catch (VisitationNotAllowedException e) {
    System.out.println(e.getMessage());
}
```

Which should output:

```
Visitation to this temple is restricted.
```

<br>

<a id="prayer"></a>

### The `Prayer` Interface (10%)

At the heart of temple rituals lies the act of prayer, a practice shared by many traditions. We'll define a common interface, **`Prayer`**, to encapsulate this fundamental aspect.

The **`Prayer`** interface must include...

- A single _public_ method signature, **`conductPrayer()`**, that throws a `VisitationNotAllowedException`. This method represents the act of conducting a prayer.

<br>

<a id="shinto"></a>

### The `ShintoTemple` Class (10%)

Moving forward, we'll delve into the mystical realm of Shinto temples. The **`ShintoTemple`** class encapsulates the sacred practices and architectural features of Shinto shrines. As Shintoism places a particular emphasis on prayer, this class also implements the **`Prayer`** interface.

This class must...

- Be a subclass of the **`Temple`** class.
- Implement the **`Prayer`** interface.
- Define the following _public static_ constants:
    - **`String NAME`**: Represents the generic name for Shinto temples, with a value of `"Shinto Shrine"`.
- Define an additional _private_ attribute, **`boolean hasTorii`**, which represents whether the temple has a traditional [**_Torii_**](https://en.wikipedia.org/wiki/Torii).
- Define a _public_ constructor that:
    1. Accepts three parameters: 
        1. **`String location`**: Representing the location of the temple.
        2. **`int yearBuilt`**: The year the temple was built
        3. **`boolean hasTorii`**: Whether the temple has a torii or not.
    2. Initializes all of its `Temple` attributes.
    3. Initializes the `hasTorii` attribute with the value of the `hasTorii` parameter.
- Implement the **`conductPrayer()`** method to throw a `VisitationNotAllowedException` _if the temple has no torii_. If this is the case, the message this exception should recieve should be:
    ```
    Visitation to this Shinto temple is restricted without a torii.
    ```
    If the temple does have a torii, simply print the following message:
    ```
    Conducting a prayer at this Shinto Shrine (LOCATION).
    ```
    Where `LOCATION` should be replaced by its appropriate value.
- Override the **`explore()`** method so that it:
    - _Attempts to safely_ utilise the **`conductPrayer()`** method to incorporate prayer into the exploration process. If an `VisitationNotAllowedException` is raised, simply print that exception's message _and return_.
    - Then, print the message:
        ```
        Exploring the mystical atmosphere of the Shinto Shrine (LOCATION).
        ```
        Where `LOCATION` should be replaced by its appropriate value.
    - Additionally, if the temple has a Torii, also print:
        ```
        Passing through the sacred Torii, marking the entrance to the shrine.
        ```

To test your class, write a `main()` method with the following code:

```java
ShintoTemple shintoTemple = new ShintoTemple("Tokyo", 1600, false);

System.out.println(shintoTemple);
shintoTemple.explore();
```

Which, when compiled and run, should output:

```
Temple: Shinto Shrine
Location: Tokyo
Year Built: 1600
Visitation to this Shinto temple is restricted without a torii.
```

<br>

<a id="buddhist"></a>

### The `BuddhistTemple` Class

Transitioning to Buddhist traditions, the **`BuddhistTemple`** class embodies the serene ambiance and spiritual practices observed in Buddhist sanctuaries. This class encapsulates the characteristics specific to Buddhist traditions.

This class must...

- Be a subclass of the **`Temple`** class.
- Define the following _public static_ constants:
    - **`String NAME`**: Represents the generic name for Buddhist temples, with a value of `"Buddhist Temple"`.
- Define an additional _private_ attribute, **`boolean isZen`**, which represents whether the temple follows the Zen tradition.
- Define a _public_ constructor that:
    1. Accepts three parameters:
        1. **`String location`**: Representing the location of the temple.
        2. **`int yearBuilt`**: The year the temple was built
        3. **`boolean isZen`**: Whether the monks of this temple follow the Zen tradition.
    2. Initializes all of its `Temple` attributes.
    3. Initializes the `isZen` attribute with the value of the `isZen` parameter.
- Override the **`explore()`** method so that it:
    - Prints the message:
        ```
        Exploring the serene ambiance of the Buddhist Temple. (LOCATION)
        ```
        Where `LOCATION` should be replaced by its appropriate value.
    - If the temple follows the Zen tradition, also print:
        ```
        Engaging in meditation under the guidance of Zen masters.
        ```

To test your code, create a `main()` method and run the following code in it:

```java
BuddhistTemple buddhistTemple = new BuddhistTemple("Kyoto", 1200, true);

System.out.println(buddhistTemple);
buddhistTemple.explore();
```

Which should output:

```
Temple: Buddhist Temple
Location: Kyoto
Year Built: 1200
Exploring the serene ambiance of the Buddhist Temple.
Engaging in meditation under the guidance of Zen masters.
```

<br>

### The `searchForOffering()` Method

As we approach the conclusion of our system design, it's essential to implement a method for efficiently searching for offerings within temple inventories. Most of the `Japan` class is already defined for you. Your job is to provide the implementation for the **`searchForOffering()`** method. The method recursively searches for a specific offering in an array of offerings. It returns true if the offering is found in the array and false otherwise. Implement this method using recursion to enable efficient searching for offerings in the temples. The **`searchForOffering()`** method must...

- Accept two parameters:
    1. **`String[] offerings`**: An array containing the names of offerings within the temple.
    2. **`String offering`**: The name of the offering we are searching for.
- Implement a _recursive_ search algorithm to efficiently find the offering within the array.
- Base cases should include:
    1. Checking if the offerings array is `null`. If so, throw a `NullPointerException`.
    2. Checking if we are searching through an empty array. If so, return `false`.
    3. Checking if the head of `offerings` is equal to the offering we're looking for. If so, return `true`.
- The recursive case should call the `searchForOffering()` method with the remaining elements of the offerings array and the name of the offering we're looking for.

<br>

<a id="sample"></a>

### Sample Output

If all went well, take a deep few deep breaths and look away from your screen for twenty seconds. Then, compile and run the `Japan` class to have its `main()` method execute. You should see output similar to the following:

```
Temple: Shinto Shrine
Location: Kyōto
Year Built: 794
Conducting a prayer at the Shinto Shrine.
Exploring the mystical atmosphere of the Shinto Shrine.
Passing through the sacred Torii, marking the entrance to the shrine.
Temple: Buddhist Temple
Location: Nara
Year Built: 607
Exploring the serene ambiance of the Buddhist Temple.
true
false
```