import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class BotApi20 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
        BotApi20 botApi20 = new BotApi20();
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (update.getMessage().getText().equals("/start")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("You send /start");
                SendMessage message1 = new SendMessage()
                        .setChatId((long)1307084432)
                        .setText("You send /start");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
                rowInline.add(new InlineKeyboardButton().setText("Delete message text").setCallbackData("delete_msg_text"));
                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                message1.setReplyMarkup(markupInline);
                try {
                    botApi20.execute(message); // Sending our message object to user
//                    sendMessage(message1); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();
            if(call_data.equals("delete_msg_text")) {
                String answer = "deleted message";
                EditMessageText deleted_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(answer);
                EditMessageText deleted_message1 = new EditMessageText()
                        .setChatId((long)1307084432)
                        .setMessageId(toIntExact(8183))
                        .setText(answer);
                try {
                    botApi20.execute(deleted_message);
                    botApi20.execute(deleted_message1);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (call_data.equals("update_msg_text")) {
                String answer = "Updated message text";
                EditMessageText new_message = new EditMessageText()
                        .setChatId(chat_id)
                        .setMessageId(toIntExact(message_id))
                        .setText(answer);
                EditMessageText new_message1 = new EditMessageText()
                        .setChatId((long)1307084432)
                        .setMessageId(toIntExact(8183))
                        .setText(answer);
                try {
                    botApi20.execute(new_message);
                    botApi20.execute(new_message1);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {

    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "testBotForWork";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "1389913268:AAFw40lnZHJw8dTBU8DUMuLu_WhHFywJma8";
    }
}