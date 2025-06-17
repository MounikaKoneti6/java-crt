class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}
