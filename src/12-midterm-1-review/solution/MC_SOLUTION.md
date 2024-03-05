<h2 align=center>Week 07</h2>

<h1 align=center>Midterm 1: <em>Review</em></h1>

<p align=center><strong><em>Song of the day</strong>: <a href="https://youtu.be/Gw96jPDtoDQ?si=FlJsYvTWWZQgUiZB"><strong><u>虎狼来 (Korōrai)</u></strong></a> by Eve (2023).</em></p>

## Multiple Choice Solutions

1. Which of the following is an invalid Java `if` statement?

- [ ] `if (condition == true) { System.out.println(); }`
- [ ] `if (condition) { System.out.println(); }`
- [ ] `if (condition) System.out.println();`
- [X] `if (condition.isEqual(true)) { System.out.println(); }`

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
- [X] `10 | 5 2 | 1`
- [ ] This code results in an infinite loop.
- [ ] `10 5 | 2 1 |`

<br>

3. How many individual comparisons on average does it take linear search to find an item in an array of sorted numbers?

- [ ] Half of the length of the array.
- [ ] The log<sub>2</sub> of the length of the array. 
- [ ] The log<sub>10</sub> of the length of the array. 
- [X] The length of the array.

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

- [X] `5 4 1 0`
- [ ] `2 5 1 0`
- [ ] `5 4 0 1`
- [ ] `2 5 0 1`