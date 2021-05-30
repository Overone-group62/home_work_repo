public class UsingCard {
    public static void main(String[] args) {
       CreditCard myCard = new CreditCard(134, 158, new String[]{"12334", "3456", "1234", "1234"},
               "Oksana");

myCard.operation( "Снять", 15, "BYN");
myCard.operation( "Снять", 200, "BYN");
myCard.operation( "Положить", 35, "USD");

for (int i=0; i<myCard.getHistory().size(); i++) {
    System.out.println(myCard.getHistory(i));
}









    }
}
