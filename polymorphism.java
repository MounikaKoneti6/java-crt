public class PolymorphismDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Add two ints: " + calc.add(5, 3));
        System.out.println("Add three ints: " + calc.add(1, 2, 3));
        System.out.println("Add two doubles: " + calc.add(2.5, 4.3));
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myAnimal.makeSound(); 
        myDog.makeSound();  
        myCat.makeSound();  
    }
}
