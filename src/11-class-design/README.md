<h2 align=center>Week 06</h2>

<h1 align=center>Object-Oriented Design</h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/nGCd8cNFLd0?si=BZo6tzFSBTY4tes7"><strong><u>When Winter Comes Around</u></strong></a> by The Lemon Twigs (2023).</em></p>

---

### Sections

1. [**Custom Classes In Java**](#part-1-custom-classes-in-java)
2. [**Java Constructors**](#part-2-java-constructors)
3. [**Methods**](#part-3-methods)
4. [**Access Modifiers**](#part-4-access-modifiers)

---

### Part 1: _Custom Classes In Java_

It's time, y'all. We've reached the point where CS121 material ends, and object-oriented programming begins in earnest. Java is particularly suited for this role, since we literally write all of our code in a class definition. But now, our goal is to be able to write our own class so that we can do this:

```java
MyOwnClass anObject = new MyOwnClass();

onObject.myClassMethod();
```

Or, maybe more realistically:

```java
Song elScorcho = new Song("El Scorcho", "Weezer");
Song sagaJihen = new Song("Saga Jihen", "FranChouChou");
Song venus     = new Song("Venus", "Shocking Blue");

Song[] playlist = { elScorcho, sagaJihen, venus };

for (Song song : playlist) {
    song.play();
}
```

So, let's go through the steps to make the above behaviour happen.

<br>

### Part 2: _Java Constructors and Attributes_

Java constructors are basically the equivalent of Python's initializer. So, let's say we wanted to turn the following Python class into Java:

```py
class Song:
    def __init__(self, song_title, artist):
        self.song_title = song_title
        self.artist = artist
```

The equivalent in Java is the following:

```java
class Song {
    String songTitle;
    String artist;

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
    }
}
```

So, what do we notice here?

1. The constructor method is much simpler than the Python initializer method. It simply needs to have the **same name as the class**.
2. It needs to have the **`public` access modifier**. We'll (finally) talk about access modifiers later in the lecture.
3. Just like with Python's `self`, Java constructors require you to **use the `this` keyword** when creating _attributes_. The use of `this` is only necessary in Java constructors.
4. This is the biggest difference. _Outside of any Java methods_, declare the attributes you are creating in your constructor.

In order to test this, we can create a `main()` function inside of the `Song` class and create an object:

```java
class Song {
    String songTitle;
    String artist;

    public static void main(String[] args) {
        Song elScorcho = new Song("El Scorcho", "Weezer");

        System.out.println(elScorcho.artist);
        System.out.println(elScorcho.songTitle);
    }

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
    }
}
```

Output:

```
➜  javac Song.java
➜  java Song                  
Weezer
El Scorcho
```

Since all songs start with a play count of 0, we can put that in the constructor as well and make it a constant. In Java, class constants are usually made `static`:

```java
class Song {
    static final int INITIAL_PLAY_COUNT = 0;

    String songTitle;
    String artist;

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.playCount = INITIAL_PLAY_COUNT;
    }
}
```

<br>

### Part 3: _Methods_

We already know about Java methods from our time with `static` methods. Since now we want to write methods that are called from objects of classes, we no longer need the `static` keyword. Let's write a `play` that increments the `playCount` attribute.

```java
class Song {
    final int INITIAL_PLAY_COUNT = 0;

    String songTitle;
    String artist;
    int playCount;

    public static void main(String[] args) {
        Song elScorcho = new Song("El Scorcho", "Weezer");

        System.out.println("Before calling the play method: " + elScorcho.playCount);
        elScorcho.play();
        System.out.println("After calling the play method: " + elScorcho.playCount);
    }

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.playCount = INITIAL_PLAY_COUNT;
    }

    void play() {
        playCount++;
    }
}
```

Output:

```
➜  javac Song.java
➜  java Song
Before calling the play method: 0
After calling the play method: 1
```

We pretty much know how methods work otherwise, so that's enough for now.

<br>

### Part 4: _Access Modifiers_

So, what is `public` for? You see, Java was designed with safety primarily in mind. In other words, Java wants you to design your classes in a way that gives the users of those classes the _least power to modify objects of that class_. In other words, the problem with our `Song` class definition is that the user of a `Song` object can easily change the name of the song whenever they want to:

```java
Song elScorcho = new Song("El Scorcho", "Weezer");

System.out.println(elScorcho.songTitle);
elScorcho.songTitle = "Rain";
System.out.println(elScorcho.songTitle);
```

Output:

```
➜  javac Song.java 
➜  java Song 
El Scorcho
Rain
```

This is, naturally, extremely dangerous, since potentially really sensitive data can be changed on the fly. This is not the fault of the user, either–if a programming language gives you the ability to do something, it's unlikely that you will be able to stay away from doing it forever. Accidents _will_ happen, and Java wants to make sure that they never do. For that reason, we have keywords in Java that can restrict the user from accessing / modifying these values to keep these objects as safe as possible. Here's a list of these modifiers:

|Modifier|Description|
|-|-|
|**`private`**|Classes, methods or data members declared as _private_ are accessible only within the class in which they are declared.|
|**`protected`**|Classes, methods or data members declared as _protected_ are accessible within the same package or subclasses in different packages (more on this one after the midterm).|
|**`public`**|Classes, methods, or data members that are declared as _public_ are accessible from everywhere in the program. There is no restriction on the scope of public data members..|
|**Default**|When no access modifier is specified for a class, method, or data member – It is said to be having the default access modifier by default. The data members, classes, or methods that are not declared using any access modifiers i.e. having default access modifiers are accessible only within the same package (i.e. same folder).|

The two modifiers that we're going to concern ourselves with for now are `public` and `private`. Here's the rules-of-thumb I want you to follow:

1. **All _abstract_ classes should be `private`**. For now, none of our classes will be abstract, but rather _concrete_, so you can set them as `public`.
2. Unless absolutely necessary, **all attributes should be `private`**.
3. Static constants are usually `public`.
4. Any methods that the user **will not use should be `private`**.

By making all attributes `private`, this means that the user can no longer call them directly using the `.` operator _outside of the class_. Let's create a separate class inside of the same folder as `Song.java` called `App.java`. Because both classes are in the same folder, we can access the `Song` class in the `App` class as well without importing:

```java
public class App {
    public static void main(String[] args) {
        Song elScorcho = new Song("El Scorcho", "Weezer");

        System.out.println(elScorcho.songTitle);
    }
}
```

Will result in a compilation error. The way we would instead access these attributes is by making _public methods called **getters**_:

```java
public class Song {
    public static final int INITIAL_PLAY_COUNT = 0;

    private String songTitle;
    private String artist;
    private int playCount;

    public Song(String songTitle, String artist) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.playCount = INITIAL_PLAY_COUNT;
    }

    public void play() {
        playCount++;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }
}
```

Making `App.java` look like this:

```java
public class App {
    public static void main(String[] args) {
        Song elScorcho = new Song("El Scorcho", "Weezer");

        System.out.println(elScorcho.getSongTitle());
    }
}
```