# Homework 1

### Tasks
1. Create one **interface**, called **`Musician`**, that requires classes that subscribe to it to implement a single `void`
   method called `perform()`.
2. Create one **abstract class**, **`BandMember`**, that implements the `Musician` interface. Your `BandMember` class
   must have **two** private, immutable, instance attributes:
    - A **string** called **`name`**, representing the band member's name.
    - A **string** called **`instrument`**, representing the band member's instrument's name.
3. Create **one concrete class** that inherits/extends from `BandMember`—**`Guitarist`**. This class must:
    - Implement the **`perform()`** method. You're free to do whatever you want here for each class.
    - Have at least **one** instance attribute particular to each class.
