package CreditCardN1;

import java.util.ArrayList;

public class CreditCard {
    private int USD;
    private double BYN;
    private String[] cardNumber;
    private String cardHolderName;
    private ArrayList<String> history = new ArrayList<>();


    public CreditCard (int USD, double BYN, String[] cardNumber, String cardHolderName){
        this.USD = USD;
        this.BYN = BYN;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public void CreditCardOperation() {

        String usdCash = String.valueOf(USD);
        String bynCash = String.valueOf(BYN);

        StringBuilder cardnumber = new StringBuilder();
        for (String s : cardNumber) {
            cardnumber.append(s + " ");
        }
        history.add("USD : " + usdCash);
        history.add("BYN : " + bynCash);
        history.add("номер карты : " + cardnumber);
        history.add("Имя : " + cardHolderName);
    }

    public void cashOut(int cashUSD, double cashBYN){
        System.out.println("Снятие наличных ");
        if (USD < cashUSD) {
            System.out.println("Недостаточно средств! ");
        } else {
            System.out.println(history);
            int USDOut = USD - cashUSD;
            history.remove(0);
            String usd = String.valueOf(USDOut);
            history.add(0, "USD : " + usd);
        }

        if (BYN < cashBYN){
            System.out.println("Недостаточно средств");
        } else {
            double BYNOut = BYN - cashBYN;
            history.remove(1);
            String byn = String.valueOf(BYNOut);
            history.add(1, "BYN : " + byn);
        }
        System.out.println(history);
    }

    public void casPut(int usd2, double byn2){
        System.out.println("Зачисление ");
        System.out.println(history);
        USD = USD + usd2;
        history.remove(0);
        history.add(0,"USD : " + USD);
        BYN = BYN + byn2;
        history.remove(1);
        history.add(1,"BYN : " + BYN);
        System.out.println(history);

    }

    public void information (){
        System.out.println("Итого : ");
        System.out.println(history);
    }
}
