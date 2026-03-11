// Interface
interface SpecialAbility {
    void performAbility();
}

// Abstract class
abstract class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    abstract void makeSound();

    void showAnimal() {
        System.out.println("Animal: " + name);
    }
}

// Lion class
class Lion extends Animal {

    Lion(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " the Lion roars!");
    }
}

// Elephant class
class Elephant extends Animal implements SpecialAbility {

    Elephant(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " the Elephant trumpets!");
    }

    public void performAbility() {
        System.out.println(name + " sprays water with its trunk!");
    }
}

// Parrot class
class Parrot extends Animal implements SpecialAbility {

    Parrot(String name) {
        super(name);
    }

    void makeSound() {
        System.out.println(name + " the Parrot chirps!");
    }

    public void performAbility() {
        System.out.println(name + " mimics human words!");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Animal[] animals = {
            new Lion("Simba"),
            new Elephant("Dumbo"),
            new Parrot("Polly")
        };

        for (Animal animal : animals) {
            animal.showAnimal();
            animal.makeSound();

            if (animal instanceof SpecialAbility) {
                ((SpecialAbility) animal).performAbility();
            }

            System.out.println();
        }
    }
}
