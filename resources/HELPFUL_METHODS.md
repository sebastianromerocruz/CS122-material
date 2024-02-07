<h1 align=center>Helpful Class Methods</h1>

### Sections

### `Math` Class

**Usage**:

```java
Math.method()
```

|Method|Description|
|-|-|
|`sin(angle)`|Returns the trigonometric sine of an angle in radians.|
|`cos(angle)`|Returns the trigonometric cosine of an angle in radians.|
|`tan(angle)`|Returns the trigonometric tangent of an angle in radians.|
|`toRadians(angle)`|Returns the angle in radians for the angle in degrees.|
|`toDegrees(angle)`|Returns the angle in degrees for the angle in radians.|
|`asin(sine)`|Returns the angle in radians for the inverse of sine.|
|`acos(cosine)`|Returns the angle in radians for the inverse of cosine.|
|`atan(tangent)`|Returns the angle in radians for the inverse of tangent.|

|Method|Description|
|-|-|
|`exp(x)`|Returns `e` raised to power of `x` (e<sup>_x_</sup>).|
|`log(x)`|Returns the natural logarithm of `x` (ln(_x_) = log<sub>e</sub>(_x_)).|
|`log10(x)`|Returns the base-10 logarithm of `x` (log<sub>10</sub>(_x_)).|
|`pow(a, b)`|Return `a` raised to the power of `b` (a<sup>b</sup>).|
|`sqrt(x)`|Returns the square root of `x` for `x >= 0`.|

|Method|Description|
|-|-|
|`ceil(x)`|`x` is rounded up to the nearest whole number. Returns a _double_.|
|`floor(radians)`|`x` is rounded down to the nearest whole number. Returns a _double_.|
|`round(radians)`|`x` is rounded to the nearest whole number. Returns a _double_.|

|Method|Description|
|-|-|
|`random()`|Returns a random _double_ greater than or equal to 0.0 and less than 1.0.|
|`a + (int) (Math.random() + b)`|Returns a random integer between `a` and `a + b - 1`.|

### `Character` Class

**Usage**:

```java
Character.method()
```

|Method|Description|
|-|-|
|`isDigit(ch)`|Returns `true` if the specified character `ch` is a digit.|
|`isLetter(ch)`|Returns `true` if the specified character `ch` is a letter.|
|`isLetterOrDigit(ch)`|Returns `true` if the specified character `ch` is a letter or digit.|
|`isLowerCase(ch)`|Returns `true` if the specified character `ch` is a lowercase letter.|
|`isUpperCase(ch)`|Returns `true` if the specified character `ch` is an uppercase letter.|
|`toLowerCase(ch)`|Returns the specified character `ch` lowercased, if applicable.|
|`toUpperCase(ch)`|Returns the specified character `ch` uppercased, if applicable.|

### `String` Class

**Usage**:

```java
String string = "string";

string.method();
```

|Method|Description|
|-|-|
|`length()`|Returns the number of characters in this string.|
|`charAt(index)`|Returns the character at the specified `index` from this string.|
|`concat(s)`|Returns a new string that concatenates this string with string `s`.|
|`toLowerCase()`|Returns a new string with all letters lowercased.|
|`toUpperCase()`|Returns a new string with all letters uppercased.|
|`trim()`|Returns a new string with whitespace characters trimmed on both sides (same as `strip()` in Python).|

|Method|Description|
|-|-|
|`length()`|Returns the number of characters in this string.|