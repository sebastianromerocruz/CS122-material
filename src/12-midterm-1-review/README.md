<h2 align=center>Week 07</h2>

<h1 align=center>Midterm 1: <em>Review</em></h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/Gw96jPDtoDQ?si=FlJsYvTWWZQgUiZB"><strong><u>虎狼来 (Korōrai)</u></strong></a> by Eve (2023).</em></p>

---

## Sections

1. [**Multiple Choice**](#multiple-choice)
2. [**Programming**](#programming)
    1. [**Background**](#part-1-custom-classes-in-java)
    2. [**Specifications**](#specifications)
    3. [**Sample Execution**](#sample-execution)

---

## Multiple Choice

1. Which of the following is an invalid Java `if` statement?

- [ ] `if (condition == true) { System.out.println(); }`
- [ ] `if (condition) { System.out.println(); }`
- [ ] `if (condition) System.out.println();`
- [ ] `if (condition.isEqual(true)) { System.out.println(); }`

<br>

2. What is the output of the following code?

```java
int number = 10;

do {
    System.out.print(number + " ");
    number /= 2;
    if (number % 2 == 0) { continue; }
    System.out.print("| "); 
} while (number > 0);
```

- [ ] `10 | 5`
- [ ] `10 | 5 2 | 1`
- [ ] This code results in an infinite loop.
- [ ] `10 5 | 2 1 |`

<br>

3. How many individual comparisons on average does it take linear search to find an item in an array of sorted numbers?

- [ ] Half of the length of the array.
- [ ] The log<sub>2</sub> of the length of the array. 
- [ ] The log<sub>10</sub> of the length of the array. 
- [ ] The length of the array.

<br>

4. What is the output of the following code:

```java
public class MainClass {
    public static void method(int[][] array, int x, int y) {
        int temp = x;
        x = y;
        y = temp;
        
        array[x][y] *= 2;
    }
  
    public static void main(String[] args) {
        int[][] array = {
            { 1, 2, 3, 4 },  
            { 5, 6, 7, 8 }
        };
        
        int x = 1;
        int y = 0;
        
        method(array, x, y);
        
        System.out.println(array[x][y] + " " + array[y][x] + " " + x + " " + y);
    }
}
```

- [ ] `5 4 1 0`
- [ ] `2 5 1 0`
- [ ] `5 4 0 1`
- [ ] `2 5 0 1`

## Programming

### Background

Say that we're playing a life-simulator game, and our local grocery shop is holding an event called the "Grocery Lottery", giving us the chance to take as many random items as your character's cart can fit. For example, if your character's cart size is 3, it can only fit 3 random grocery items.

The event won't stop when the character's capacity (how many items they have in their cart) reaches the size of the cart, though. You can continue trying to pick up random items in the store for as long as you like until you decide to leave. In these situations, though, trying to add that item to your cart will simply result in an error message.

We will implement this system using the specifications below. Note that, for this problem, you can assume that the following public static constants will be defined in the class and are available to use anywhere inside of it:

```java
public static String[] ITEMS = {
    "Kiwis", "Granola", "Eggs",
    "Yuzu", "Tamarind", "Hibiscus",
    "Gochujang", "Cod", "Pasta"
};

public static String END_SIGNAL = "DONE";
```

### Specifications

#### **`static boolean getItem(String[] cart, int itemsInCart)`**

The **`getItem`** method will accept the following attributes:

1. `String[] cart`: This string array represents the player's cart, where each member `String` object represents one grocery item.
2. `int itemsInCart`: The current amount of items in `cart`. This means that if `cart.size` is equal to 4 and `itemsInCart` is equal to 2, then `cart[0]` and `cart[1]` contain strings, but `cart[3]` and `cart[4]` do not contain anything.

Using these arguments, we're going to do the following:

1. Check if `cart` is full. If it is, print an error message and return `false`.
2. If it isn't full, then select a random item name from `ITEMS` to put into our cart. Recall that we can get a random integer in the range `[0, a]` by doing the following:

```java
int randomInteger = (int) (Math.random() * a);
```

3. Store that random item name in the next available free space inside of `cart` and print a message letting the player know which item was picked.
4. Return `true`.

To test this method, you can write the following in your `main` method before moving on to the next part:

```java
String cart[] = new String[3];
int itemsInCart = 0;

for (int item = 0; item < 5; item++) {
    boolean gotItem = getItem(cart, itemsInCart);
    
    if (gotItem) {
        itemsInCart++;
        System.out.println("Current items in cart: " + itemsInCart);
    }
}
```

Which should give you a similar output to the following:

```
Picked: Granola
Current items in cart: 1
Picked: Yuzu
Current items in cart: 2
Picked: Hibiscus
Current items in cart: 3
ERROR: Cart full.
ERROR: Cart full.
```

#### **`static void main(String[] args)`**

Inside your `main` method, perform the following steps:

1. Welcome the user to the Grocery Lottery with a message.
2. Ask them to enter how many items their cart can hold.
3. Create a variable to represent the user's cart, and a variable to represent how many items the user currently has in their cart (which is 0 at the start).
4. Until the user enters the `END_SIGNAL`:
    1. Ask them if they want to take an item (their options are `"[Y/N/DONE]"`, and you can assume that they will always enter one of those three; use `.next()` instead of `.nextLine()` here).
    2. If they enter `"N"`, you can skip and ask the user again.
    3. If they enter `"DONE"`, then stop asking the user to enter items.
    4. If they enter `"Y"`, make a call to `getItem`. If `getItem` returns `true`, then update how many items are currently in your cart and print the current cart capacity. If it returns `false`, do the same but also indicate that the cart is full.

See my sample execution below. Your output doesn't need to match mine exactly.

### Sample Execution

```
➜  javac GroceryList.java
➜  java GroceryList
Welcome to the Grocery Lottery!
How big is your cart? 3

Take an item? [Y/N/DONE] Y
Picked: Gochujang
Cart capacity: 1

Take an item? [Y/N/DONE] N

Take an item? [Y/N/DONE] Y
Picked: Pasta
Cart capacity: 2

Take an item? [Y/N/DONE] Y
Picked: Gochujang
Cart capacity: 3

Take an item? [Y/N/DONE] Y
ERROR: Cart full.
Cart capacity (FULL): 3

Take an item? [Y/N/DONE] Y
ERROR: Cart full.
Cart capacity (FULL): 3

Take an item? [Y/N/DONE] DONE

Thank you for coming to the Grocery Lottery!
```