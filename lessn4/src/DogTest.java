public class DogTest {
    String name;

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.barc();
        dog1.name= "Bark";

        Dog[] myDogs = new Dog[3];

        myDogs[0]= new Dog();
        myDogs[1]= new Dog();
        myDogs[2]= dog1;

        myDogs[0].name= "Fred";
        myDogs[1].name= "George";

        System.out.print("Имя последней собаки - ");
        System.out.println(myDogs[2].name);

        int x=0;
        while (x<myDogs.length){
            myDogs[x].barc();
            x=x+1;
        }

    }
}
