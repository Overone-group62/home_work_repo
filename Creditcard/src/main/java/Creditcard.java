import java.util.ArrayList;
import java.util.Arrays;

public class Creditcard {
    private int USD;
    private double BYN;
    private String[] cardNumber;
    private String cardHolderName;
    private ArrayList<String> history = new ArrayList<>();


    public Creditcard(int USD, double BYN, String[] cardNumber, String cardHolderName) {
        this.USD = USD;
        this.BYN = BYN;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }


    public void cashWithdrawal(double cash, String currency) {
        StringBuilder cardnumber = new StringBuilder();
        for (String s : cardNumber) {
            cardnumber.append(s + " ");
        }
        String histor = null;
        boolean count = false;
        if (currency.contains("BYN")) {
            if (BYN - cash > 0) {
                BYN = BYN - cash;
                histor = "Номер карты: "+cardnumber + " Баланс: " + BYN + "" + currency + " Снятие: " + cash + "BYN";
                count = true;
            } else System.out.println("Недостаточно средств");
        } else if (currency.contains("USD")) {
            if (USD - cash > 0) {
                USD = USD + (int) cash;
                histor = "Номер карты: "+cardnumber + " Баланс: " + USD + "" + currency + " Снятие: " + (int)cash + "USD";
                count = true;
            } else System.out.println("Недостаточно средств");
        }
        if (count) {
            history.add(histor);
            System.out.println(histor);
        }
    }

    public void cashPut(double cash, String currency) {
        StringBuilder cardnumber = new StringBuilder();
        for (String s : cardNumber) {
            cardnumber.append(s + " ");
        }
        String histor = null;
        if (currency.contains("BYN")) {
            BYN = BYN + cash;
            histor = "Номер карты: "+cardnumber + " Баланс: " + BYN + "BYN " + "Пополнение: " + cash + "BYN";
        } else if (currency.contains("USD")) {
            USD = USD + (int) cash;
            histor = "Номер карты: "+cardnumber + " Баланс: " + USD + "USD " + "Пополнение: " + (int)cash + "USD";
        }
        history.add(histor);
        System.out.println(histor);
    }

    public void getHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }
}
