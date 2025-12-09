# Java Abstraction Lab

## Table of Contents
1. [Understanding Abstraction](#1-understanding-abstraction)
2. [Abstract Classes](#2-abstract-classes)
3. [Interfaces](#3-interfaces)
4. [Abstract Classes vs. Interfaces](#4-abstract-classes-vs-interfaces)
5. [Practical Applications](#5-practical-applications)

## Lab Setup
1. Create a package called `ie.atu.abstraction`
2. Create a `Main` class inside this package
3. Place all the below classes from the DIY sections into this package

## 1. Understanding Abstraction

### Learning Objective
Understand what abstraction is and how it helps us write better code by hiding complicated details.

### Real-World Example
Think about driving a car. To drive a car, you only need to know about:
- The steering wheel
- The pedals (gas and brake)
- The gear shift

You don't need to know how the engine works, how the transmission functions, or how the electrical system operates. This is abstraction - hiding complex details while showing only what's necessary to use something.

### Simple Code Example: Animal Sounds
Let's create a simple system for animal sounds:

```java
// This is our abstract class - it defines what all animals can do
public abstract class Animal {
    // Properties that all animals have
    protected String name;
    protected int age;
    
    // Constructor to set up basic animal properties
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Abstract method - each animal must implement their own sound
    public abstract void makeSound();
    
    // Regular method all animals can use as-is
    public void introduce() {
        System.out.println("I am " + name + " and I am " + age + " years old");
    }
}

// A specific type of animal
public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    
    // Dog's specific implementation of makeSound
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Another type of animal
public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    
    // Cat's specific implementation of makeSound
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
```

Using these animals:
```java
public class Main {
    public static void main(String[] args) {
        // Create some animals
        Animal spot = new Dog("Spot", 3);
        Animal whiskers = new Cat("Whiskers", 2);
        
        // Make them introduce themselves and make sounds
        spot.introduce();      // Prints: I am Spot and I am 3 years old
        spot.makeSound();      // Prints: Woof! Woof!
        
        whiskers.introduce();  // Prints: I am Whiskers and I am 2 years old
        whiskers.makeSound();  // Prints: Meow!
    }
}
```

### DIY Exercise: Simple Shape System
Create a basic shape system with three classes: `Shape`, `Circle`, `Square`, and a `Main` class to test them.

#### Step 1: Create an abstract class named `Shape`
Copy this code into a new file called `Shape.java`:
```java
public abstract class Shape {
    protected String color;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Every shape must implement this
    public abstract double getArea();
    
    // All shapes can use this as-is
    public void displayColor() {
        System.out.println("I am " + color + " in color");
    }
}
```

#### Step 2: Create a calss named `Circle` which extends the `Shape` class
- Add a `radius` instance variable (type `double`)
- Add a constructor that takes `color` and `radius` as parameters
- Implements the `getArea()` method using the formula: `π × radius²`
  - Hint: Use `Math.PI * radius * radius`

#### Step 3: Create a class named `Square` whcih extends the `Shape` class
- Add a `sideLength` instance variable (type `double`)
- Add a constructor that takes `color` and `sideLength` as parameters
- Implements the `getArea()` method using the formula: `sideLength × sideLength`

#### Step 4: Create the `Main` class to test your shapes
```java
public class Main {
    public static void main(String[] args) {
        // Use Shape references (polymorphism)
        Shape circle = new Circle("Red", 5.0);
        Shape square = new Square("Blue", 4.0);
        
        // Test the circle below by calling the getArea() and displayColor() methods

        
        // Test the square below by calling the getArea() and displayColor() methods
  
    }
}
```

> **Note:** We use `Shape` as the reference type (`Shape circle = ...`) instead of `Circle` to demonstrate polymorphism—the same principle shown in the Animal example above.

## 2. Abstract Classes

### Learning Objective
Understand what abstract classes are and how they help us create a blueprint for related objects.

### Simple Example: Remote Controls
Let's create a simple remote control system:

```java
public abstract class RemoteControl {
    protected boolean isOn;
    protected String deviceName;
    
    public RemoteControl(String deviceName) {
        this.deviceName = deviceName;
        this.isOn = false;
    }
    
    // All remote controls must implement these
    public abstract void powerButton();
    public abstract void volumeUp();
    public abstract void volumeDown();
    
    // All remote controls can use this
    public void displayStatus() {
        System.out.println(deviceName + " is " + (isOn ? "ON" : "OFF"));
    }
}

public class TVRemote extends RemoteControl {
    public TVRemote() {
        super("TV");
    }
    
    @Override
    public void powerButton() {
        isOn = !isOn;
        System.out.println("TV turning " + (isOn ? "on" : "off"));
    }
    
    @Override
    public void volumeUp() {
        if (isOn) {
            System.out.println("TV volume increasing");
        }
    }
    
    @Override
    public void volumeDown() {
        if (isOn) {
            System.out.println("TV volume decreasing");
        }
    }
}
```

### DIY Exercise: Vehicles
Create a simple vehicle system:

1. Create an abstract `Vehicle` class with:
   - Instance Variable: brand
   - Regular method: displayInfo()
   - Abstract methods: startEngine(), stopEngine()

2. Create two types of vehicles the inherit from the abstract Vehicle class:
   - Car
   - Motorcycle

3. Inside the Main class in the main() method, create two new Vehicles, Car and Motorcycle, and test all their methods. 

Example solution for Vehicle class:
```java
public abstract class Vehicle {
    protected String brand;
    protected String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Regular concrete method with body and implementation
    public void displayInfo() {
        System.out.println("This is a " + brand + " " + model);
    }

    // Abstract methods go below here. They will just be method signatures.

}
```

## 3. Interfaces

### Learning Objective
Understand interfaces as contracts that classes must follow.

### Real-World Example
Think of a power outlet. Any device with the right plug can connect to it, regardless of what the device does. The power outlet is like an interface - it defines a standard way of connecting.

### Simple Code Example: Musical Instruments

```java
// The interface defines what methods musical instruments must have
public interface MusicalInstrument {
    void play();
    void stop();
    void tune();
}

// A piano that implements the MusicalInstrument interface
public class Piano implements MusicalInstrument {
    @Override
    public void play() {
        System.out.println("Piano playing beautiful music");
    }
    
    @Override
    public void stop() {
        System.out.println("Piano stopped playing");
    }
    
    @Override
    public void tune() {
        System.out.println("Piano being tuned");
    }
}

// A guitar that also implements MusicalInstrument
public class Guitar implements MusicalInstrument {
    @Override
    public void play() {
        System.out.println("Guitar strumming chords");
    }
    
    @Override
    public void stop() {
        System.out.println("Guitar stopped playing");
    }
    
    @Override
    public void tune() {
        System.out.println("Guitar strings being tuned");
    }
}
```

### DIY Exercise: Simple Game Characters
Create a simple game character system:

1. Create an interface called `GameCharacter`:
```java
public interface GameCharacter {
    void move();
    void speak();
    void useItem();
}
```

2. Create two types of characters that implement this interface:
   - Hero
   - Villain

Each should implement the methods in their own way.

## 4. Abstract Classes vs. Interfaces

### Learning Objective
Understand when to use abstract classes versus interfaces.

### Simple Comparison
Think of it this way:
- Abstract Class: "is-a" relationship (a Dog is an Animal)
- Interface: "can-do" relationship (a Bird can Fly)

### Example: Pet Care System

```java
// Interface for things pets can do
public interface Playable {
    void play();
    void rest();
}

// Abstract class for all pets
public abstract class Pet {
    protected String name;
    protected int age;
    
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract void eat();
    public abstract void makeSound();
    
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// A dog is a pet that can play
public class Dog extends Pet implements Playable {
    public Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating dog food");
    }
    
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    
    @Override
    public void play() {
        System.out.println(name + " is playing fetch");
    }
    
    @Override
    public void rest() {
        System.out.println(name + " is resting after play");
    }
}
```

### DIY Exercise: School System
Create a simple school system:

1. Create an interface `Teachable`:
```java
public interface Teachable {
    void study();
    void doHomework();
}
```

2. Create an abstract class `Person`:
```java
public abstract class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract void introduce();
}
```

3. Create a `Student` class that extends `Person` and implements `Teachable`

## 5. Practical Applications

### Learning Objective
See how abstraction works in a real-world example.

### Simple Example: Drawing Application

```java
// Interface for basic drawing operations
public interface Drawable {
    void draw();
    void erase();
}

// Abstract class for all drawing tools
public abstract class DrawingTool {
    protected String color;
    protected int thickness;
    
    public DrawingTool(String color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }
    
    public abstract void startDrawing();
    public abstract void stopDrawing();
    
    public void changeColor(String newColor) {
        this.color = newColor;
        System.out.println("Changed color to " + newColor);
    }
}

// A pencil tool
public class Pencil extends DrawingTool implements Drawable {
    public Pencil(String color, int thickness) {
        super(color, thickness);
    }
    
    @Override
    public void startDrawing() {
        System.out.println("Starting to draw with pencil");
    }
    
    @Override
    public void stopDrawing() {
        System.out.println("Stopped drawing with pencil");
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing with " + color + " pencil");
    }
    
    @Override
    public void erase() {
        System.out.println("Erasing pencil marks");
    }
}
```

### Final DIY Exercise: Library System
Create a simple library system:

1. Create an interface `Borrowable`:
```java
public interface Borrowable {
    void checkOut();
    void returnItem();
    boolean isAvailable();
}
```

2. Create an abstract class `LibraryItem`:
```java
public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected boolean isCheckedOut;
    
    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
    
    public abstract void displayInfo();
}
```

3. Create a `Book` class that extends `LibraryItem` and implements `Borrowable`

This system shows how abstraction helps organize code in a real-world application while keeping the implementation simple and understandable.

## Summary
Through these examples and exercises, we've learned that:
- Abstraction helps hide complex details
- Abstract classes provide a blueprint for related objects
- Interfaces define what actions an object can perform
- Both help write cleaner, more organized code

Remember: Start simple, and add complexity only when needed!

End of Lab
---
