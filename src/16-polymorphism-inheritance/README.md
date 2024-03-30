<h2 align=center>Week 11: <em>Day 1</em></h2>

<h1 align=center>Polymorphism: <em>Inheritance</em></h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/8ZP5eqm4JqM?si=GinLsPy4AJyfPxg1"><strong><u>Bibbidiba</u></strong></a> by Hoshimachi Suisei (2024)</em></p>

---

### Sections

1. [**Method Binding**](#part-1-method-binding)
2. [**An Introduction To Polymorphism With Inheritance**](#part-2-an-introduction-to-polymorphism-with-inheritance)
3. [**An Example**](#part-3-an-example)
4. [**Overriding The `Object` class's `equals()` Method**](#part-4-overriding-the-object-classs-equals-method)

---

### Part 1: _Method Binding_

Consider the following lines:

```java
Country france = new Country("France", "Europe", "Semiparlimentary Presidental Republic");
france.holdElections();
```

We expect that, when this program compiles and runs, the instructions contained in the `holdElections()` will execute—and they will. But, as we have seen in the past few lectures, multiple versions of a single method can exist. For example, overridden and overloaded version of methods are all versions of the same method, invoked in different situations. 

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
```

```java
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

Basically, at some point, Java must choose which version of this method to execute before actually executing it. This is known as **binding**.

Now, you may be aware of this, but Java is a compiled language i.e. it must compile into machine code first before being run by your machine. If Java were to method bind during compile time, the same version of any method would be bound every single time. Java, though, does not bind during compile time, but **during runtime instead**. This is what is called _dynamic_, or _late_, _binding_.

The difference may not sound obvious at first—after all, why would Java ever pick `PoliticalEntity`'s `holdElections()` method if `france` is a `Country` object? It turns out that the answer is not quite as clear-cut at this—and that is because of something called **polymorphism**.

<br>

### Part 2: _An Introduction To Polymorphism With Inheritance_

The word _polymorphism_ comes from the Greek, and it literally means "having many forms" or, more literally, "many shapes". This is a pretty important term in object-oriented programming, because child classes technically exhibit this polymorphic, or many-formed behaviour. `france` for example, may be a `Country` object, but it is also a `PoliticalEntity` object; it can't be one without being the other. Because of this fact alone, the following Java code is perfectly valid:

```java
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
```

And why not? All `Country` objects are also `PoliticalEntity` objects, after all. Here, the variable `czechia` is what is referred to as a **polymorphic reference**.

> **Polymorphic Reference**: A variable that can refer to different types of objects at different points in time.


So, in this case, if `czechia` were to call its `holdElections()` method, which of the two would be bound by Java? The rule here is that **the type of the object being referenced, not the reference's type, determines which method is invoked.** In other words, the type of the reference here is `PoliticalEntity`, but the type of the object being referenced is `Country`. Therefore, the `Country` version of `holdElections()` would be executed:

```java
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
czechia.holdElections();
```

Output:

```text
Czechia, a Unitary Parliamentary Republic in Europe, is holding presidential elections...
Czechia is also holding parliamentary elections...
```

Can the opposite be true? That is, can we create a polymorphic reference of a child class that references an object of its parent class? The short answer is: yes, but you need to typecast.

```java
Country japan = (Country) new PoliticalEntity("Japan", "Unitary Parliamentary Constitutional Monarchy");
```

Now, _should_ we do this? It depends. If your class structure is robust and you have all your bases covered, then there's no harm. But even from the instantiation of `japan` above we can see issues arising: namely, all `Country` objects need a `continent` attribute to be created, but `PoliticalEntities` do not. This is not a problem at compile time because of late binding, but during runtime, we will get the following exception:

```text
Exception in thread "main" java.lang.ClassCastException: class PoliticalEntity cannot be cast to class Country
	at Country.main(Country.java:13)
```

So, while it is technically possible in compile time, you probably should stay away from it.

<br>

### Part 3: _An Example_

Let's define a second class that also extends from `PoliticalEntity`:

```java
public class Territory extends PoliticalEntity {
    private final PoliticalEntity sovereign;

    public Territory(String name, String typeOfGovernment, PoliticalEntity sovereign) {
        super(name, typeOfGovernment);
        this.sovereign = sovereign;
    }

    @Override
    public void holdElections() {
        System.out.printf("%s, a non-governing territory of %s, is holding local elections.\n", getName(),
                sovereign.getName());
    }

    public PoliticalEntity getSovereign() {
        return sovereign;
    }
}
```

Notice here that `Territory` objects have one instance attribute: a `PoliticalEntity` object called `sovereign`. This is interesting because, as we know, it is impossible for abstract classes to have objects. What this actually means, then, is that **any and every class that extends from `PoliticalEntity` can fulfill this role**. This is hugely convenient; Non-self-governing territories are administered by a wide variety of political entities: countries, empires, kingdoms, etc. By giving `sovereign` the polymorphic reference of `PoliticalEntity` we are basically saying: you do you; as long as you adhere to one of the many classes that could potentially inherit from `PoliticalEntity`, you're good.

And, of course, it doesn't stop there. Let's say all of this political bodies were holding elections at the same time. Instead of calling each of their methods individually:

```java
france.holdElections();
czechia.holdElections();
japan.holdElections();
gibraltar.holdElections();
```

It would be much more efficient to store them in an array and loop through it. And because of polymorphism, we can:

```java
Country france          = new Country("France", "Europe", "Semiparliamentary Presidential Republic");
PoliticalEntity czechia = new Country("Czechia", "Europe", "Unitary Parliamentary Republic");
Country japan           = new Country("Japan", "Asia", "Unitary Parliamentary Constitutional Monarchy");
Territory gibraltar     = new Territory("Gibraltar", "Devolved representative democratic parliamentary dependency", france);

PoliticalEntity[] countriesHoldingElections = { france, czechia, japan, gibraltar };

for (PoliticalEntity politicalEntity : countriesHoldingElections) {
    politicalEntity.holdElections();
}
```

<sub>**Code Block 2**: Because all of these objects are descendants of `PoliticalEntity`, they can coexist in the same array.</sub>

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

<br>

### Part 4: _Overriding The `Object` class's `equals()` Method_

We can actually override `equals()`'s behaviour as well. Different objects will equal each other under different circumstances (i.e. are two `MiniCooperClubman` objects with identical attributes but different license plate numbers equal to each other?), and you can decide when this is the case.

When overriding this method, you should always:

1. Check if the object we are being compared to exists (i.e. is not `null`) 
2. Check if it is of the same class.
3. Choose which attributes to use as points of comparison.

```java
public class Coordinates {
    private final double latitude;
    private final double longitude;

    public static void main(String args[]) {
        Coordinates pointA = new Coordinates(34.5d, 40.0d);
        Coordinates pointB = new Coordinates(34.5d, 40.0d);

        System.out.println(pointA.equals(pointB));
    }

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object o) {
        // STEPS 1 AND 2: Check if the Object instance o exists and is of the same class.
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        // STEP 3 If none of these are a problem, let's make 2 Coordinate objects equal if their lats and longs are equal
        return ((Coordinates) o).getLatitude() == getLatitude() && ((Coordinates) o).getLongitude() == getLongitude();
    }
}
```

Output:

```text
true
```