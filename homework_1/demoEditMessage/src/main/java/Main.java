import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
    public static void main(String[] args) {
        // Initialize Api Context
        ApiContextInitializer.init();
        Bot test_habr_bot = new Bot("testBotForWork", "1389913268:AAFw40lnZHJw8dTBU8DUMuLu_WhHFywJma8");
        test_habr_bot.botConnect();
    }
}