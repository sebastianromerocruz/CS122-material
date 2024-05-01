<h2 align=center>Week 15</h2>

<h1 align=center>Collections</h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/orDIIjiTWzY?si=Ycj3DxzSrW5gKJVu"><strong><u>Ride Into The Sun (Session Outtake)</u></strong></a> by The Velvet Underground (1970)</em></p>

---

### Sections

1. [**What Are Java Collections?**](#collections)
2. [**`ArrayList`**](#array)
3. [**`HashMap`**](#map)

---

<a id="collections"></a>

### Part 1: _What Are Java Collections?_

Collections are pretty neat. They're basically a group of classes and interfaces that provide an architecture to store and manipulate groups of objects efficiently. The primary purpose of Java collections is to offer a standard way to work with groups of objects, regardless of the specific implementation details of the underlying data structures. Here's an explanation of Java collections and their purpose:

#### Common Interfaces in Java Collections Framework:

1. **Collection**: Represents a group of objects known as elements. It is the root interface in the collections hierarchy.

2. **List**: Represents an ordered collection that allows duplicate elements. It maintains the insertion order of elements.

3. **Set**: Represents a collection that does not allow duplicate elements. It models the mathematical set abstraction.

4. **Map**: Represents a mapping from keys to values. Each key can map to at most one value.

The two collections you need to know about are the following:

- **ArrayList**: Implements the `List` interface using a dynamically resizable array. Think of Python lists.

- **HashMap**: Implements the `Map` interface using a hash table for storage. Think of Python dictionaries.

<br>

<a id="array"></a>

### Part 2: _`ArrayList`_

**`ArrayList`** in Java is a dynamic array-based implementation of the `List` interface, providing resizable arrays and a variety of methods for manipulating elements. Here's a detailed explanation of `ArrayList` along with examples of its most common methods:

- **Resizable Array**: `ArrayList` internally uses an array to store elements. It dynamically resizes its underlying array as elements are added or removed, providing flexibility in managing the collection's size.

- **Ordered Collection**: `ArrayList` maintains the order of elements based on their insertion sequence. You can rely on the index to access elements in the same order they were added.

- **Allows Duplicates**: `ArrayList` allows duplicate elements. You can add the same element multiple times, and it will maintain all occurrences.

- **Random Access**: `ArrayList` provides constant-time access to elements by index. Retrieving elements by index is fast because it directly calculates the memory location based on the index.

#### Common Methods of `ArrayList`:

1. **add(E element)**: Appends the specified element to the end of the list.

    ```java
    ArrayList<String> list = new ArrayList<>();
    list.add("Java");
    list.add("Python");
    ```

2. **get(int index)**: Returns the element at the specified index.

    ```java
    String firstElement = list.get(0);
    ```

3. **set(int index, E element)**: Replaces the element at the specified index with the specified element.

    ```java
    list.set(1, "C++");
    ```

4. **remove(int index)**: Removes the element at the specified index from the list.

    ```java
    list.remove(0);
    ```

5. **size()**: Returns the number of elements in the list.

    ```java
    int listSize = list.size();
    ```

6. **isEmpty()**: Returns `true` if the list contains no elements.

    ```java
    if (list.isEmpty()) {
        System.out.println("The list is empty.");
    }
    ```

7. **contains(Object element)**: Returns `true` if the list contains the specified element.

    ```java
    if (list.contains("Java")) {
        System.out.println("The list contains 'Java'.");
    }
    ```

8. **indexOf(Object element)**: Returns the index of the first occurrence of the specified element in the list, or `-1` if the element is not found.

    ```java
    int index = list.indexOf("Python");
    ```

9. **clear()**: Removes all elements from the list.

    ```java
    list.clear();
    ```

#### Example Usage:

```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Adding elements to the ArrayList
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Retrieving elements
        String firstElement = list.get(0);
        System.out.println("First element: " + firstElement);

        // Removing an element
        list.remove(1);
        System.out.println("After removing the second element: " + list);

        // Checking if the list is empty
        if (!list.isEmpty()) {
            System.out.println("The list is not empty.");
        }

        // Getting the size of the list
        int size = list.size();
        System.out.println("Size of the list: " + size);

        // Checking if the list contains an element
        if (list.contains("Java")) {
            System.out.println("The list contains 'Java'.");
        }
    }
}
```

In summary, `ArrayList` in Java provides a wide range of methods for adding, retrieving, updating, and removing elements from the list. Its dynamic resizing, ordered storage, and fast random access make it a valuable tool in Java programming for managing collections of data.

<br>

<a id="map"></a>

### Part 3: _`HashMap`_

`HashMap` in Java is a data structure that implements the `Map` interface, providing key-value pair storage with fast retrieval—think of Python dictionaries for this one. Let's dive into a detailed explanation of `HashMap` along with examples of its most common methods:

#### Overview of `HashMap`:

- **Key-Value Pair Storage**: `HashMap` stores data in key-value pairs. Each key is unique and maps to a specific value.

- **Fast Retrieval**: Retrieval of values based on keys in a `HashMap` is efficient, typically with constant-time complexity (O(1)), making it suitable for applications where fast lookup is required.

- **Null Keys and Values**: `HashMap` allows one `null` key and multiple `null` values.

- **Dynamic Sizing**: `HashMap` automatically resizes itself when the number of elements exceeds a certain threshold, ensuring efficient space utilization and performance.

- **Collision Handling**: When different keys hash to the same bucket (collision), `HashMap` handles it by storing multiple key-value pairs in the same bucket, usually using a linked list (or a balanced tree in Java 8 and later).

#### Common Methods of `HashMap`:

1. **put(K key, V value)**: Adds a key-value pair to the map. If the key already exists, the previous value associated with the key is replaced by the new value.

    ```java
    HashMap<String, Integer> ages = new HashMap<>();
    ages.put("Alice", 30);
    ages.put("Bob", 25);
    ```

2. **get(Object key)**: Retrieves the value associated with the specified key, or `null` if the key is not found.

    ```java
    Integer aliceAge = ages.get("Alice");
    ```

3. **containsKey(Object key)**: Checks if the map contains the specified key.

    ```java
    if (ages.containsKey("Bob")) {
        System.out.println("Bob's age is present in the map.");
    }
    ```

4. **containsValue(Object value)**: Checks if the map contains the specified value.

    ```java
    if (ages.containsValue(25)) {
        System.out.println("The value 25 is present in the map.");
    }
    ```

5. **remove(Object key)**: Removes the mapping for the specified key from the map.

    ```java
    ages.remove("Alice");
    ```

6. **size()**: Returns the number of key-value mappings in the map.

    ```java
    int mapSize = ages.size();
    ```

7. **isEmpty()**: Returns `true` if the map contains no key-value mappings.

    ```java
    if (ages.isEmpty()) {
        System.out.println("The map is empty.");
    }
    ```

8. **keySet()**: Returns a set view of the keys contained in the map.

    ```java
    Set<String> keys = ages.keySet();
    ```

9. **values()**: Returns a collection view of the values contained in the map.

    ```java
    Collection<Integer> ageValues = ages.values();
    ```

10. **entrySet()**: Returns a set view of the key-value mappings contained in the map.

    ```java
    Set<Map.Entry<String, Integer>> entries = ages.entrySet();
    ```

#### Example Usage:

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<String, Integer> ages = new HashMap<>();

        // Adding key-value pairs
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        // Retrieving values
        System.out.println("Age of Bob: " + ages.get("Bob"));

        // Checking if a key exists
        if (ages.containsKey("Bob")) {
            System.out.println("Bob's age is present in the map.");
        }

        // Removing a key-value pair
        ages.remove("Charlie");

        // Iterating over key-value pairs
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
```