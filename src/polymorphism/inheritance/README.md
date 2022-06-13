## Lecture 05

# Polymorphism: The Inheritance Perspective

***Song of the day***: _[****]() by  ()._

---

### Sections

1. [**Lab Exercise**](#part-0-lab-exercise)
2. [**An introduction to polymorphism**](#part-1-an-introduction-to-polymorphism)

### Part 0: _Lab Exercise_

_Due Wednesday June 14th, 11:59pm on Classes_

1. Using the two classes you used in lab 01 (i.e. `Sport` and your own custom child class), define an interface that 
the child class has to implement in addition to extending the `Sport` abstract superclass. (5pts)
2. Your interface must specify at least one attribute/variable and at least one method. (5pts)

Additional requirements:
- The name and purpose of this interface is completely up to you, but it should be something that is not necessarily 
specific to only sports. For example, the `ElectricAppliance` interface does not only apply to `ElectricGuitar` objects.
- **Due at 11:59pm, 6/14**. Late assignments will receive a 2pt penalty per day late. Last day to submit is Friday, 
6/17.
- Your submission must be a ***zipped*** folder of the following structure:

```text
[lastName_firstName_lab01]
    |
    |   Required:
    |
    |-- Sport.java
    |-- YourSportConcreteClass.java
    |-- YourInterface.java
    |
    |   If you choose to do the extra credit:
    |
    |-- YouExtraCreditInterface.java
```

For potential extra points (not required):
- Define a second interface that the `Sport` superclass can extend from. This interface can contain anything you'd like,
but it must have at least one variable **or** at least one method.

### Part 1: _An introduction to polymorphism: inheritance_

Consider the following lines:

```java
Country france = new Country("France", "Europe", "Semiparlimentary Presidental Republic");
france.holdElections();
```

We expect that, when this program compiles and runs, the instructions contained in the `holdElections()` will 
execute—and they will. But, as we have seen in the past few lectures, multiple versions of a single method can exist. 
For example, overridden and overloaded version of methods are all versions of the same method, invoked in different
situations. 

```java
// PoliticalEntity.java
public abstract class PoliticalEntity {
    private final String name;
    private final String typeOfGovernment;
    
    // Some code...
    
    public void holdElections() {
        System.out.printf("%s will now hold elections...", name);
    }
}

// Country.java
public class Country extends PoliticalEntity {
    private final String continent;
    
    // Some code...

    @Override
    public void holdElections() {
        holdPresidentialElections();
        holdParliamentaryElections();
    }

    private void holdPresidentialElections() {
        System.out.printf("%s, a %s in %s, is holding presidential elections...\n", getName(), getTypeOfGovernment(),
                getContinent());
    }

    private void holdParliamentaryElections() {
        System.out.printf("%s is also holding parliamentary elections...\n", getName());
    }
}
```

<sub>**Code Block 1**: Two different versions of `holdElections()` exist.</sub>

Basically, at some point, Java must choose which version of this method to execute before actually executing
it. This is known as **binding**.

Now, you may be aware of this, but Java is a compiled language i.e. it must compile into machine code first before being
run by your machine. If Java were to method bind during compile time, the same version of any method would be bound 
every single time. Java, though, does not bind during compile time, but **during runtime instead**. This is what is 
called _dynamic_, or _late_, _binding_.

The difference may not sound obvious at first—after all, why would Java ever pick `PoliticalEntity`'s `holdElections()`
method if `france` is a `Country` object? It turns out that the answer is not quite as clear-cut at this—and that is 
because of something called **polymorphism**.

---

The word _polymorphism_ comes from the Greek, and it literally means "having many forms" or, more literally, "many 
shapes". This is a pretty important term in object-oriented programming, because child classes technically exhibit this
polymorphic, or many-formed behaviour. `france` for example, may be a `Country` object, but it is also a 
`PoliticalEntity` object; it can't be one without being the other. Because of this fact alone, the following Java code
is perfectly valid:

```java
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
```

And why not? All `Country` objects are also `PoliticalEntity` objects, after all. Here, the variable `czechia` is what 
is referred to as a **polymorphic reference**.

> **Polymorphic Reference**: A variable that can refer to different types of objects at different points in time.


So, in this case, if `czechia` were to call its `holdElections()` method, which of the two would be bound by Java? The
rule here is that **the type of the object being referenced, not the reference's type, determines which method is 
invoked.** In other words, the type of the reference here is `PoliticalEntity`, but the type of the object being 
referenced is `Country`. Therefore, the `Country` version of `holdElections()` would be executed:

```java
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
czechia.holdElections();
```

Output:

```text
Czechia, a Unitary Parliamentary Republic in Europe, is holding presidential elections...
Czechia is also holding parliamentary elections...
```

Can the opposite be true? That is, can we create a polymorphic reference of a child class that references an object of
its parent class? The short answer is: yes, but you need to typecast.

```java
Country japan = (Country) new PoliticalEntity("Japan", "Unitary Parliamentary Constitutional Monarchy");
```

Now, _should_ we do this? It depends. If your class structure is robust and you have all your bases covered, then 
there's no harm. But even from the instantiation of `japan` above we can see issues arising: namely, all `Country`
objects need a `continent` attribute to be created, but `PoliticalEntities` do not. This is not a problem at compile
time because of late binding, but during runtime, we will get the following exception:

```text
Exception in thread "main" java.lang.ClassCastException: class PoliticalEntity cannot be cast to class Country
	at Country.main(Country.java:13)
```

So, while it is technically possible in compile time, you probably should stay away from it.

---

### Part 2: _An example_

Let's define a second class that also extends from `PoliticalEntity`:

```java
public class NonSelfGoverningTerritory extends PoliticalEntity {
    private final PoliticalEntity governingPoliticalEntity;

    public NonSelfGoverningTerritory(String name, String typeOfGovernment, PoliticalEntity governingPoliticalEntity) {
        super(name, typeOfGovernment);
        this.governingPoliticalEntity = governingPoliticalEntity;
    }

    @Override
    public void holdElections() {
        System.out.printf("%s, a non-governing territory of %s, is holding local elections.\n", getName(),
                governingPoliticalEntity.getName());
    }

    public PoliticalEntity getGoverningPoliticalEntity() {
        return governingPoliticalEntity;
    }
}
```

Notice here that `NonSelfGoverningTerritory` objects have one instance attribute: a `PoliticalEntity` object called
`governingPoliticalEntity`. This is interesting because, as we know, it is impossible for abstract classes to have 
objects. What this actually means, then, is that **any and every class that extends from `PoliticalEntity` can fulfill
this role**. This is hugely convenient; Non-self-governing territories are administered by a wide variety of political
entities: countries, empires, kingdoms, etc. By giving `governingPoliticalEntity` the polymorphic reference of
`PoliticalEntity` we are basically saying: you do you; as long as you adhere to one of the many classes that could 
potentially inherit from `PoliticalEntity`, you're good.

And, of course, it doesn't stop there. Let's say all of this political bodies were holding elections at the same time.
Instead of calling each of their methods individually:

```java
france.holdElections();
czechia.holdElections();
japan.holdElections();
gibraltar.holdElections();
```

It would be much more efficient to store them in an array and loop through it. And because of polymorphism, we can:

```java
Country france = new Country("France", "Europe", "Semiparliamentary Presidential Republic");
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
Country japan = new Country("Japan", "Asia", "Unitary Parliamentary Constitutional Monarchy");
NonSelfGoverningTerritory gibraltar = new NonSelfGoverningTerritory("Gibraltar", "Devolved representative democratic parliamentary dependency", france);

PoliticalEntity[] countriesHoldingElections = { france, czechia, japan, gibraltar };

for (PoliticalEntity politicalEntity : countriesHoldingElections) {
    politicalEntity.holdElections();
}
```

<sub>**Code Block 2**: Because all of these objects are descendants of `PoliticalEntity`, they can coexist in the same
array.</sub>

Output:

```text
France, a Semiparliamentary Presidential Republic in Europe, is holding presidential elections...
France is also holding parliamentary elections...
Czechia, a Unitary Parliamentary Republic in Europe, is holding presidential elections...
Czechia is also holding parliamentary elections...
Japan, a Unitary Parliamentary Constitutional Monarchy in Asia, is holding presidential elections...
Japan is also holding parliamentary elections...
Gibraltar, a non-governing territory of France, is holding local elections.
```