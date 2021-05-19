package Dog;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog one = new Dog();
        one.setSize(70);
        Dog two = new Dog();
        two.setSize(8);
        Dog three = new Dog();
        three.setSize(35);

        one.bark();
        two.bark();
        three.bark();

    }
}
