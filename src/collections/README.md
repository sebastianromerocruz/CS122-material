## Lectures 13, 14

# Collections

### 17, 21 Thermidor, Year CCXXX

### Sections

1. [**Collections**](#part-1-collections)
2. [**Object References / Pointers**](#part-2-object-references--pointers)
3. [**Dynamic Linked-List**](#part-3-dynamic-linked-list)
4. [**Linked-List Operations**](#part-4-linked-list-operations)
   1. [**Pushing To A Linked-List**](#pushing-to-a-linked-list)
   2. [**Inserting To A Linked-List At A Specified Location**](#inserting-to-a-linked-list-at-a-specified-location)
   3. [**Deleting A Node From a Linked-List At A Specified 
   Index**](#deleting-a-node-from-a-linked-list-at-a-specified-index)

### Part 1: _Collections_

Today, we're going to learn about collections. These are actually pretty nice—we're reaching a point in our Java journey
where we're equipped with enough knowledge to use more abstract and complex structures. Let's take a look at what these
are.

---

A **collection** is an object that serves as a repository for other objects. Generally speaking, all Java collections
provide services for adding, removing, and managing the elements it contains. Depending on the collection type, these
elements may or may not be ordered—choosing which collections to use in a given situation is up to you and what you 
think is most useful.

These collections are what we call **generic**, which means that we are not limited to which type of data you store in
them. For example, you can create an `ArrayList` collection that can store, `int` objects, one that can create `String`
objects, and one than can store `Pokemon` objects.

```java
ArrayList<Integer> integers = new ArrayList<Integer>();
ArrayList<String> strings   = new ArrayList<String>();
ArrayList<Pokemon> pokemon  = new ArrayList<Pokemon>();
```

<sub>**Code Block 1**: Here, the same collection type has been instantiated to store three different types of objects.
This is what we mean by _generic_.</sub>

So what is, exactly, an `ArrayList`? All Java collections are implemented with a particular underlying data structure;
in the case of `ArrayList`, this data structure is a [**linked-list**](https://en.wikipedia.org/wiki/Linked_list), which
you can think of as a chain with each of its links containing a single data point of a certain type.

![](assets/Singly-linked-list.svg.png)

<sub>**Figure 1**: A linked-list of integers.</sub>

In the case of `ArrayList`, this linked-list is what we call **dynamic** (that is, unlike regular Java array, they can
grow, shrink, and change after they have been instantiated).

We generall say that collections are **abstractions** of pre-existing data structures—that is, they abstract away 
behaviour from the user so that we don't have to worry about it; we can just use them. Another term for this is 
**abstract data type**: an organized collection of information and a set of operations used to manage that information.

### Part 2: _Object References / Pointers_

Let's say you wanted to maintain a list of Pokémon with information for their name, types, level, and _the Pokemon 
object to which they [**evolve**](https://bulbapedia.bulbagarden.net/wiki/Evolution)_. This implies that one `Pokemon`
object would contain an object of the `Pokemon` class inside it. 

```java
import java.util.ArrayList;

public class Pokemon {
    private final String name;
    private final ArrayList<String> types;
    private final int level;
    private final Pokemon evolution;

    public Pokemon(String name, ArrayList<String> types, int level, Pokemon evolution) {
        this.name = name;
        this.types = types;
        this.level = level;
        this.evolution = evolution;
    }
}
```

<sub>**Code Block 2**: The `Pokemon` class containing a reference to another `Pokemon` object.</sub>

It turns out that the ideal structure for something like this is a linked-list as well. After all, linked-lists are 
collections of links in a chain—and if we have a chain of Pokémon evolution, then this is exactly what we're looking 
for. This `this.pokemon` variable is what we call an **object reference**—that is, it stores the _address of the next
Pokémon down the chain_. 

Think of this as a military or corporate system whereby, if I asked any given individual who
their superior was, they would be able to **point me to them**. Because this analogy is so close to what the data 
structure is doing, we call these references ***pointers*** in computer science.

```text
 +———————————+             +———————————+             +———————————+
 | Pichu     |      +----> | Pikachu   |      +----> | Raichu    |
 +———————————+      |      +———————————+      |      +———————————+
 | Electric  |      |      | Electric  |      |      | Electric  |
 | 5         |      |      | 25        |      |      | 50        |
 | Pikachu   | -----+      | Raichu    | -----+      | null      |
 +———————————+             +———————————+             +———————————+
```

<sub>**Figure 2**: A visual representation of a linked-list of `Pokemon` objects. Notice that, since Raichu doesn't 
evolve to another Pokémon, its `evolution` pointer doesn't point to anything (i.e. it points to `null`).</sub>

We could, therefore, do something like this:

```java
Pokemon raichu = new Pokemon("Raichu", new String[] { "Electric" }, 50, null);
Pokemon pikachu = new Pokemon("Pikachu", new String[] { "Electric" }, 25, raichu);
Pokemon pichu = new Pokemon("Pichu", new String[] { "Electric" }, 5, pikachu);

System.out.println(pichu.getEvolution().getEvolution().getName());
```

<sub>**Code Block 3**: Printing the name of the evolution of the evolution of `pichu`.</sub>

Output:

```text
Raichu
```

### Part 3: _Dynamic Linked-List_

Now, the problem here is that unfortunately, our linked-list is completely static; because of the `final` qualifier in
front of `evolution`, we cannot change the list at all. This is a problem for us, since the Pokémon Company constantly
releases new evolution / new versions of evolutions with every game. For example, Pikachu can now evolve to both Raichu
or to Alolan Raichu depending on the game:

![](assets/pichu-evol-line.png)

<sub>**Figure 3**: The Pichu evolutionary chain. 
[**Source**](https://bulbapedia.bulbagarden.net/wiki/Pikachu_(Pok%C3%A9mon)#Evolution) </sub>

We need, therefore a way of making our chain _mutable_. Let's remove the `final` qualifier and add some more 
functionality to our `Pokemon` class:

```java
public class Pokemon {
    private final String name;
    private final String[] types;
    private final int level;

    private Pokemon evolution;

    public Pokemon(String name, String[] types, int level) {
        this.name = name;
        this.types = types;
        this.level = level;
        this.evolution = null;
    }

    public void changeEvolution(Pokemon newEvolution) {
        this.evolution = newEvolution;
    }
}
```
```java
Pokemon raichu = new Pokemon("Raichu", new String[] { "Electric" }, 50);
Pokemon pikachu = new Pokemon("Pikachu", new String[] { "Electric" }, 25);
Pokemon pichu = new Pokemon("Pichu", new String[] { "Electric" }, 5);

pichu.changeEvolution(pikachu);                 // Change Pichu's evolution
pichu.getEvolution().changeEvolution(raichu);   // Change Pichu's evolution's evolution

Pokemon alolanRaichu = new Pokemon("Alolan Raichu", new String[] { "Electric", "Psychic"}, 50);
pichu.getEvolution().changeEvolution(alolanRaichu);  // Change Pichu's evolution's evolution again

System.out.println(pichu.getEvolution().getEvolution().getName());
```

<sub>**Code Block 4**: Calling `Pokemon` methods of `Pokemon` objects inside other `Pokemon` objects. In other words, 
we're calling `raichu` methods via `pikachu`, which is being referenced by `pichu` using `getEvolution()`.</sub>

What if we wanted write a method that prints out the entire evolutionary chain of a single Pokémon, starting with the
Pokémon itself?

```java
public void printEvolutionaryChain() {
    Pokemon current = this; // Create a separate reference to the current object

    do {
        System.out.printf("%s", current.name);  // Print its name
        current = current.getEvolution();       // And change the value of the reference to the next evolution

        if (current != null) System.out.print(" -> ");  // For formatting
    } while (current != null);  // Repeat this until there is no evolution left
}
```

<sub>**Code Block 5**: Printing a linked-list is a very common algorithm asked in interview questions.</sub>

We can also do this recursively, since we have the base step of `current != null`!

```java
public static void printEvolutionaryChainRecursively(Pokemon first) {
    if (first == null) return;  // If the current pokemon is null, then we're done

    System.out.printf("%s", first.getName()); // If not, print its name
    if (first.getEvolution() != null) System.out.print(" -> "); // And an arrow if it has another evolution

    printEvolutionaryChainRecursively(first.getEvolution());  // Recursive step
}
```

<sub>**Code Block 6**: Recursive version of code block 5.</sub>

```java
pichu.printEvolutionaryChain();
Pokemon.printEvolutionaryChainRecursively(pichu);
```

Both of these print:

```text
Pichu -> Pikachu -> Alolan Raichu
```

### Part 4: _Linked-List Operations_

I will walk through some common linked-list operations that every softare engineer™ should know about. Let's say  that
our linked-list is represented by the class called `PokemonTeam`. I made some slight modifications to the 
[**`Pokemon`**](Pokemon.java) class to help us here:

```java
// I've only included the additions to this class here
public class Pokemon {
    private Pokemon nextInTeam;

    public void setNextInTeam(Pokemon nextInTeam) { this.nextInTeam = nextInTeam; }

    public Pokemon getNextInTeam() {
        return this.nextInTeam;
    }
}
```
```java
public class PokemonTeam {
    private Pokemon headPokemon;
    private int teamSize;

    public PokemonTeam(Pokemon headPokemon) {
        // In case the list has a starting value
        this.headPokemon = headPokemon;
        this.teamSize = 1;
    }

    public PokemonTeam() {
        // In case they decide to create an empty list; very common
        this.headPokemon = null;
        this.teamSize = 0;
    }

    public void printTeam() {
        // Create a separate reference to the current object
        Pokemon current = this.headPokemon;

        do {
            System.out.printf("%s", current.getName());  // Print its name
            current = current.getNextInTeam();       // And change the value of the reference to the next pokemon

            if (current != null) System.out.print(" || ");
        } while (current != null);  // Repeat this until there is no pokemon left

        System.out.println();
    }

    public int getTeamSize() {
        return this.teamSize;
    }

    public Pokemon getHeadPokemon() {
        return this.headPokemon;
    }
}
```

<sub>**Code Blocks 7 and 8**: A class representing a Pokémon team (i.e. a linked-list of `Pokemon` objects) Notice that 
the `PokemonTeam` class only keeps a pointer to the first (i.e. head) Pokémon in the team.</sub>

#### **Pushing To A Linked-List**

The most common linked-list operation is _pushing a new object / node_. This is basically just adding a new object to
the back of the linked-list. The steps are as follows:

1. Create a separate pointer to the head Pokémon, so we can traverse the list
2. If this pointer is `null`, then just have the list's head pointer point to the new Pokémon, and return
3. If it is not, then iterate through the team until you find the first Pokémon whose next-in-line is `null`. This means
that you have reached the end of the list
4. Make the new Pokémon its next-in-line

```java
public void addPokemon(Pokemon pokemon) {
    // Of course, we can't add a null Pokemon to our team
    if (pokemon == null) throw new NullPointerException();
    
    Pokemon current = this.headPokemon; // Step 1

    // Step 2
    if (current == null) {
        this.headPokemon = pokemon;
        this.teamSize++;
        return;
    }

    while (current.getNextInTeam() != null) current = current.getNextInTeam(); // Step 3

    current.setNextInTeam(pokemon); // Step 4
        
    this.teamSize++; // Don't forget to increase the size!
}
```

<sub>**Code Block 9**: Adding a new Pokémon to the back of our team (i.e. pushing a `Pokémon` obejct to our 
linked-list).</sub>

#### **Inserting To A Linked-List At A Specified Location**

What if you don't want to push to the back of the list, but have a specific place that your new object to be located
at? In this case, you need to break the link between the objects that will flank the new object, and reconnect it with
the new object between them:

```text
BEFORE:
          +———+        +———+
... ----> | A | -----> | B | ----> ...
          +———+        +———+
          
                +———+
                | X |
                +———+
 (Node to be inserted between A and B)
  
—————————————————————————————————————————————————————

INTERMEDIARY STEP:
          +———+         +———+
... ----> | A | - X ->  | B | ----> ...
          +———+         +———+
              \       /
               \     /
                +———+
                | X |
                +———+
   
—————————————————————————————————————————————————————
   
AFTER:
          +———+       +———+        +———+
... ----> | A | ----> | X | ---->  | B | ----> ...
          +———+       +———+        +———+       
```

<sub>**Figure 4**: A visual representation of inserting a node into a linked-list.</sub>

The steps are as follows:

1. Check if the index specified is larger than the actual list. If so, simply [**push**](#pushing-to-a-linked-list) the 
new node / object (that's why it is helpful to keep a list length counter)
2. If the index specified is `0`, then make the current head node the new node's next-in-line. If the list was empty to
begin with, this is basically the same as pushing
3. In all other cases, create a separate reference to the head node
4. Use it to traverse `x`-number of steps along the chain, where `x` is the specified index
5. Set new node's next-in-line to the node at that location's next-in-line
6. Set the node at that location's next-in-line to the new node. This step **has to come before step 5**, otherwise, we
lose the location of its previous next-in-line.

Code:

```java
public void insertPokemon(Pokemon pokemon, int index) {
    // Of course, we can't add a null Pokemon to our team
    if (pokemon == null) throw new NullPointerException();

    if (index > this.teamSize) {
        // Step 1
        this.addPokemon(pokemon);
        this.teamSize++;
        return;
    } else if (index == 0) {
        // Step 2
        pokemon.setNextInTeam(this.headPokemon);
        this.headPokemon = pokemon;
        this.teamSize++;
        return;
    }
    
    Pokemon current = this.headPokemon; // Step 3
        
    for (int i = 0; i < index - 1; i++) current = current.getNextInTeam(); // Step 4
        
    pokemon.setNextInTeam(current.getNextInTeam()); // Step 5

    current.setNextInTeam(pokemon); // Step 6
        
    this.teamSize++; 
}
```

<sub>**Code Block 10**: Inserting a new Pokémon to our team at a specific place (i.e. inserting a `Pokemon` object at a
specified index in a linked-list).</sub>

#### **Deleting A Node From a Linked-List At A Specified Index**

Deleting an object / node from a linked-list is very similar to inserting. The key difference is that we need to keep
track of **two pointers instead of one**. These pointers should keep track of the two nodes flanking the node that is
to be deleted.

```text
BEFORE:
          +———+       +———+        +———+
... ----> | A | ----> | C | ---->  | C | ----> ...
          +———+       +———+        +———+       
                        ^
                        |
               (Node to be deleted)
               
————————————————————————————————————————————————————————————————————————————————

INTERMEDIARY STEP:
          +———+        +———+        +———+
... ----> | A | - X -> | C | ---->  | C | ----> ...
          +———+        +———+        +———+       
               \                   /
                \_________________/

————————————————————————————————————————————————————————————————————————————————

AFTER:
                            NOTE:
                   +———+    It's not necessary to delete the link from B to C.
                   | B |    Unless you plan on using B somewhere else and/or 
                   +———+    don't want it connected to C at all. In this case
                      \     simply set B's next-in-line to null.
                       \
          +———+       +———+
... ----> | A | ----> | C | ----> ...
          +———+       +———+
```

<sub>**Figure 4**: A visual representation of "deleting" a node from a linked-list. The actual node is rarely actually
destroyed, and is commonly used as the method's return value.</sub>

The algorithm is as follows:

1. If the specified index is larger than the list, then return null
2. If we want to delete the first node:
   1. Create a separate reference to it that you can return
   2. Set the list's head pointer to first node's next-in-line
   3. (Optional) Set the pointer to the former head's next-in-line to `null`
   4. Return to the reference to the former head of the list
3. In all other situations, create **two separate** pointers. Usually, their starting values are both set to the head.
4. Traverse the list by setting one pointer to the second one, and then the second one to its own next-in-line. Repeat
this until the second pointer is pointing to the node we want to remove
5. Create a third pointer, this time pointing to the second pointer. This is the reference that we are going to return
6. Have the first pointer point to the second pointers next-in-line.
7. (Optional) Set the third pointer's next-in-line to `null`.
8. Return the third pointer.

And here's the corresponding code:

```java
public Pokemon storePokemon(int index) {
    // NOTE: equivalent to deleteNode() in a traditional linked-list
    if (index >= this.teamSize) {
        // If the index is larger than our actual team, then return null
        System.out.printf("ERROR: Your team only contains %d Pokémon.\n", this.teamSize);
        return null;
    } else if (index == 0) {
        // If we want to store the first Pokemon, isolate it
        Pokemon storedPokemon = this.headPokemon;

        // Then simply make the headPokemon pointer point to the next in line
        this.headPokemon = this.headPokemon.getNextInTeam();
        this.teamSize--;

        // Sever its ties to the team
        storedPokemon.setNextInTeam(null);

        // And return it
        return storedPokemon;
    }

    // In all other situations, we need to make sure that the Pokemon flanking the one that is leaving
    // connect to each other after the removal, so we need to keep pointers to both of them
    Pokemon current = this.headPokemon;
    Pokemon previous = current;

    // Traverse the list until we flank the Pokemon that is leaving
    for (int i = 0; i < index; i++) {
        previous = current;
        current = current.getNextInTeam();
    }

    // Isolate the Pokemon being stored
    Pokemon storedPokemon = current;

    // Have the Pokemon to its left connect to the Pokemon to its right;
    previous.setNextInTeam(current.getNextInTeam());
    this.teamSize--;

    // Sever the stored Pokemon's connection to the team (optional)
    storedPokemon.setNextInTeam(null);

    // And return it
    return storedPokemon;
}
```

<sub>**Code Block 11**: Storing a Pokémon from our team to the Pokémon Centre's PC i.e. deleting a `Pokemon` object from
our list.</sub>

### Part 5: *Queues*

Now that we've explored the basic linked-list, we'll  examine some commonly used collections that are helpful in many 
situations. Within the realm of classical linear collections, one of the most commonly used is the 
[**queue**](https://en.wikipedia.org/wiki/Queue_(abstract_data_type)).

This data structure acts, quite literally, like a queue in real life: data enters from the front, and then it leaves 
from the back. This is what is called [**first-in-first-out 
(FIFO)**](https://en.wikipedia.org/wiki/FIFO_(computing_and_electronics)):

![](assets/Fifo_queue.png)

<sub>**Figure 5**: Visual representation of a FIFO queue with enqueue and dequeue operations 
([**Source**](https://en.wikipedia.org/wiki/FIFO_(computing_and_electronics)#/media/File:Fifo_queue.png)). </sub>

For this, we can easily expand our `Pokémon` class:

```java
public void enqueue(Pokemon newPokemon) {
    // Insert Pokémon at the front
     this.insertPokemon(newPokemon, 0);
 }

 public Pokemon dequeue() {
     if (this.teamSize == 0) return null;

     // Remove Pokémon at the end
     return this.storePokemon(this.teamSize - 1);
}
```

Or, expanded:

```java
public void enqueue(Pokemon newPokemon) {
    if (newPokemon == null) throw new NullPointerException();
    
    pokemon.setNextInTeam(this.headPokemon);
    this.headPokemon = pokemon;
    this.teamSize++;
    return;
}

public Pokemon dequeue() {
    return this.storePokemon(this.teamSize - 1);
}
```