import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

@AllArgsConstructor
@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    final int RECONNECT_PAUSE =10000;

    @Setter
    @Getter
    String userName;
    @Setter
    @Getter
    String token;

    @Override
    public void onUpdateReceived(Update update) {
//        log.debug("Receive new Update. updateID: " + update.getUpdateId());
        System.out.println(update);
        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();

        if (inputText.startsWith("/start")) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Hello. This is start message");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
//
//            System.out.println(update);
//
//            // We check if the update has a message and the message has text
//            if (update.hasMessage() && update.getMessage().hasText()) {
//                String message_text = update.getMessage().getText();
//                long chat_id = update.getMessage().getChatId();
//                if (update.getMessage().getText().equals("/start")) {
//                    SendMessage message = new SendMessage() // Create a message object object
//                            .setChatId(chat_id)
//                            .setText("You send /start");
//                    SendMessage message1 = new SendMessage()
//                            .setChatId((long)1307084432)
//                            .setText("You send /start");
//                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
//                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
//                    List<InlineKeyboardButton> rowInline = new ArrayList<>();
//                    rowInline.add(new InlineKeyboardButton().setText("Update message text").setCallbackData("update_msg_text"));
//                    rowInline.add(new InlineKeyboardButton().setText("Delete message text").setCallbackData("delete_msg_text"));
//                    // Set the keyboard to the markup
//                    rowsInline.add(rowInline);
//                    // Add it to the message
//                    markupInline.setKeyboard(rowsInline);
//                    message.setReplyMarkup(markupInline);
//                    message1.setReplyMarkup(markupInline);
//                    try {
//                        execute(message); // Sending our message object to user
////                    sendMessage(message1); // Sending our message object to user
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//
//                }
//
//            } else if (update.hasCallbackQuery()) {
//                // Set variables
//                String call_data = update.getCallbackQuery().getData();
//                long message_id = update.getCallbackQuery().getMessage().getMessageId();
//                long chat_id = update.getCallbackQuery().getMessage().getChatId();
//                if(call_data.equals("delete_msg_text")) {
//                    String answer = "deleted message";
//                    EditMessageText deleted_message = new EditMessageText()
//                            .setChatId(chat_id)
//                            .setMessageId(toIntExact(message_id))
//                            .setText(answer);
//                    EditMessageText deleted_message1 = new EditMessageText()
//                            .setChatId((long)1307084432)
//                            .setMessageId(toIntExact(8183))
//                            .setText(answer);
//                    try {
//                        execute(deleted_message);
//                        execute(deleted_message1);
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (call_data.equals("update_msg_text")) {
//                    String answer = "Updated message text";
//                    EditMessageText new_message = new EditMessageText()
//                            .setChatId(chat_id)
//                            .setMessageId(toIntExact(message_id))
//                            .setText(answer);
//                    EditMessageText new_message1 = new EditMessageText()
//                            .setChatId((long)1307084432)
//                            .setMessageId(toIntExact(8183))
//                            .setText(answer);
//                    try {
//                        execute(new_message);
//                        execute(new_message1);
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                }
//        }
        // TODO: 11/18/2019 добавить обработку полученных сообщений
        log.debug("new Update recieve");
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {


    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void botConnect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
            log.info("TelegramAPI started. Look for messages");
        } catch (TelegramApiException e) {
            log.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());
            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
                return;
            }
            botConnect();
        }
    }
}