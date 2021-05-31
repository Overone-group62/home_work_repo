import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private int usd;
    private double byn;
    private String[] cardNumber = new String[4];
    private String cardHolderName;
    private ArrayList<String> history = new ArrayList<>();

    public ArrayList<String> getHistory(){
        return history;
    }

    public void setHistory(ArrayList<String> history){
        this.history = history;
    }

    public Card(int usd, double byn, String[] cardNumber, String cardHolderName) {
        this.usd = usd;
        this.byn = byn;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public double getByn() {
        return byn;
    }

    public void setByn(double byn) {
        this.byn = byn;
    }

    public String[] getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String[] cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void withdraw(String cardHolderName, String[] cardNumber)
    {
        for (int i = 1; i <= 5; i++)
        {
            this.usd -= 5;
        }
        this.history.add(Arrays.toString(this.getCardNumber()) +" "+this.getUsd()+" USD "+"снять");
    }

    public void put(String cardHolderName, String[] cardNumber, int amount, int whatCurrency)
    {
        if (whatCurrency == 1)
        {
            this.usd += amount;
            this.history.add(Arrays.toString(this.getCardNumber()) +" "+this.getUsd()+" USD "+"положить");
        }
        else if (whatCurrency == 2)
        {
            this.byn += amount;
            this.history.add(Arrays.toString(this.getCardNumber()) +" "+this.getByn()+" BYN "+"положить");
        }
        else System.out.println("Никаких других валют у тебя нет, поэтому работать не буду");
    }
}
