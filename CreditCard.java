import java.util.ArrayList;

public class CreditCard {
    private int USD;
    private double BYN;
    private String[] cardNumber = new String[4];
    private String cardHolderName;
    private ArrayList<String> history = new ArrayList<String>();
    private int caunt = -1;
    private String stringBilder1;
    private String stringBilder2;

    public CreditCard(int USD, double BYN, String[] cardNumber, String cardHolderName) {
        this.USD = USD;
        this.BYN = BYN;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;

    }


    public void takeOffUsd(int summ){
        if ((USD-summ)<0){
            System.out.println("У вас не достаточно средств для списания "+ summ+" USD" );
            stringBilder2 = "Попытка снять "+ summ +" USD. Ошибка: Не достаточно средств! Баланс: " + USD +" USD";
                    } else {
        USD = USD-summ;
        System.out.println("Вы сняли "+ summ+ " USD.  У Вас на счету осталось: " + USD);

        stringBilder2 = "Было снято " + summ +" USD. Баланс: " + USD +" USD";
        caunt++;

        }
    }

    public void takeOffByn(double summ){
        if ((BYN-summ)<0){
            System.out.println("У вас не достаточно средств для списания "+ summ +" BYN" );
            stringBilder2 = "Попытка снять "+ summ +" BYN. Ошибка: Не достаточно средств! Баланс: " + BYN +" BYN";
        } else {
        BYN = BYN-summ;
        System.out.println("Вы сняли "+ summ+ " BYN.  У Вас на счету осталось: " + BYN);
        stringBilder2 = "Было снято " + summ +" BYN. Баланс: " + BYN +" BYN";
        caunt++;
        }
    }

    public void putOnUsd(int summ){
        USD = USD+summ;
        System.out.println("Вы положили "+summ+ " USD.  Ваш баланс составляет: " + USD);
        stringBilder2 = "Положили на счёт " + summ +" USD. Баланс: " + USD +" USD";
        caunt++;
    }

    public void putOnByn(double summ){
        BYN = BYN+summ;
        System.out.println("Вы положили "+ summ+ " USD.  Ваш баланс составляет: " + BYN);
        stringBilder2 = "Положили на счёт " + summ +" BYN. Баланс: " + BYN +" BYN";
        caunt++;
    }

//    public void historyCard(String cardHolderName; ){
//
//    }


    public void operation(String operation ,double summ, String currency){
        String stringBilder1 = "Владелец карты: "+ cardHolderName +"; Номер карты: "+ cardNumber[0] +
                " " + cardNumber[1] + " "+ cardNumber[2] + " "+ cardNumber[3] + "; ";

        if (operation == "Снять"){
            if (currency == "BYN"){
                takeOffByn(summ);
            }else{
                int newSumm = (int) summ;
                takeOffUsd(newSumm);
            }
        } else {
            if (currency == "BYN"){
                putOnByn(summ);
            }else{
                int newSumm = (int) summ;
                putOnUsd(newSumm);
            }
        }

        String s = stringBilder1+stringBilder2;
        history.add(caunt, s);

    }


    public int getUSD() {
        return USD;
    }

    public void setUSD(int USD) {
        this.USD = USD;
    }

    public double getBYN() {
        return BYN;
    }

    public void setBYN(double BYN) {
        this.BYN = BYN;
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

    public ArrayList<String> getHistory() {
        return history;
    }

    public String getHistory(int i) {
        return history.get(i);
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }


    public void setCardNumber(String s, String s1, String s2, String s3) {
    }
}
