import java.util.*;

public class Array {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0, "ноль");
        a.add(1,"один");
        a.add(2,"два");
        a.add(3, "три");
        printAl(a);

       if (a.contains("три")){
            a.add("четыре");
        }
        a.remove(2);
        printAl(a);
        if (a.contains("два")) {
            a.add("2.2");
        }
        if (a.indexOf("четыре") !=4) {
            a.add(4, "4.2");
        }
    printAl(a);
        printAl(a);
    }

    public static void printAl(ArrayList<String> a1) {
        for (String element : a1) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}
