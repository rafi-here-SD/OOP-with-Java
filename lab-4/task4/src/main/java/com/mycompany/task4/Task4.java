// Create a multi-level inheritance hierarchy for vehicles. Start with an
// abstract base class "Vehicle" with final attributes "manufacturerName" and
// "modelYear". Add a static counter "totalVehicles". Create an intermediate
// abstract class "PoweredVehicle" that extends Vehicle and adds an abstract
// method "startEngine()". Finally, create concrete classes "Car" and
// "Motorcycle" that extend PoweredVehicle and implement the abstract
// methods. Each concrete class should increment the static counter in its
// constructor. Create a static method in the Vehicle class to report statistics
// about all vehicles created.
// package com.mycompany.task4;

/**
 *
 * @author Gcl
 */
abstract class Vehicle {
    
    final String manufacturerName;
    final int modelYear;

    // Static counter to track the total number of vehicles created
    static int totalVehicles = 0;

    // Constructor to initialize manufacturerName and modelYear
    Vehicle(String manufacturerName, int modelYear) {
        this.manufacturerName = manufacturerName;
        this.modelYear = modelYear;
        totalVehicles++;  // Increment the total vehicle count whenever a new vehicle is created
    }

    // Static method to get the total number of vehicles created
    static int getTotalVehicles() {
        return totalVehicles;
    }

    // Abstract method to be implemented by subclasses
    abstract void startEngine();
}

// Intermediate abstract class: PoweredVehicle
abstract class PoweredVehicle extends Vehicle {

    // Constructor to initialize the base class (Vehicle) attributes
    PoweredVehicle(String manufacturerName, int modelYear) {
        super(manufacturerName, modelYear);
    }

    // Abstract method to start the engine, to be implemented by concrete classes
    abstract void startEngine();
}

// Concrete class: Car
class Car extends PoweredVehicle {

    // Constructor to initialize Car-specific details and increment totalVehicles
    Car(String manufacturerName, int modelYear) {
        super(manufacturerName, modelYear);  // Call the parent constructor
    }

    // Implementing the startEngine method for Car
    @Override
    void startEngine() {
        System.out.println("Car - " + manufacturerName + " " + modelYear + ": Engine started.");
    }
}

// Concrete class: Motorcycle
class Motorcycle extends PoweredVehicle {

    // Constructor to initialize Motorcycle-specific details and increment totalVehicles
    Motorcycle(String manufacturerName, int modelYear) {
        super(manufacturerName, modelYear);  // Call the parent constructor
    }

    // Implementing the startEngine method for Motorcycle
    @Override
    void startEngine() {
        System.out.println("Motorcycle - " + manufacturerName + " " + modelYear + ": Engine started.");
    }
}

// Main class to test the functionality
public class Task4 {
    public static void main(String[] args) {
        // Creating instances of Car and Motorcycle
        Car car = new Car("Toyota Corolla", 2022);
        Motorcycle motorcycle = new Motorcycle("Yamaha R1", 2021);

        // Starting the engines of the vehicles
        car.startEngine();
        motorcycle.startEngine();

        // Displaying the total number of vehicles created
        System.out.println("\nTotal vehicles created: " + Vehicle.getTotalVehicles());
    }
}
