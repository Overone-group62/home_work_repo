import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String[] cardNum = {"6666","6666","6666","6666"};
        Card card1 = new Card(100, 256.7, cardNum, "Azazel");
        card1.withdraw(card1.getCardHolderName(), card1.getCardNumber());
        //System.out.println(Arrays.toString(card1.getCardNumber()));
        System.out.print("С чем хотите провести операцию: 1-USD, 2-BYN\nВаш выбор: ");
        Scanner scanner = new Scanner(System.in);
        int whatCur = scanner.nextInt();
        card1.put(card1.getCardHolderName(), card1.getCardNumber(), 25, whatCur);
        System.out.println("Card1 history: " + card1.getHistory());
    }
}
