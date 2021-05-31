public class Test {
    public static void main(String[] args) {
        Creditcard creditcard = new Creditcard(100, 150, new String[]{"1111", "2222", "3333", "4444"}, "Ilya");
        creditcard.cashPut(20, "USD");
        creditcard.cashPut(50, "BYN");
        creditcard.cashWithdrawal(30, "USD");
        creditcard.cashWithdrawal(60, "BYN");
        creditcard.cashWithdrawal(300, "USD");
        creditcard.getHistory();


    }
}
