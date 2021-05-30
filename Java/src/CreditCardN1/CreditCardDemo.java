package CreditCardN1;

public class CreditCardDemo {
    public static void main(String[] args) {
        CreditCard card = new CreditCard(44,69,new String []{"1444", "4224", "2442", "4824"}, "Vlad");
        card.CreditCardOperation();
        card.cashOut(2,4.8);
        card.casPut(8, 7.7);
        card.information();
    }

}
