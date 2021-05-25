import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    private static final String TOKEN = "1811234762:AAHHt8uA_fehNhQt_HOfumIgedNnkJLtJvA";
    private static final String USERNAME = "protowork_bot";

    public Bot() {
    }
    Integer messageStartId = 0;
    ArrayList list = new ArrayList();
    double bill = 5.0;

    @Override
    public void onUpdateReceived(Update update) {
        Integer messages_id = update.getMessage().getMessageId();
        System.out.println(messages_id);
        String text = update.getMessage().getText();
        if(update.hasMessage()){
            list.add(update.getMessage().getText());
            if(text.equals("/start")) {
                Model model = new Model();
                model.setCurrencyName("USD");
                Model model1 = new Model();
                model1.setCurrencyName("RUB");
                Model model2 = new Model();
                model2.setCurrencyName("UAH");
                NbrbCourse nbrbCourse = new NbrbCourse();
                NbrbCourse nbrbCourse1 = new NbrbCourse();
                NbrbCourse nbrbCourse2 = new NbrbCourse();
                messageStartId = update.getMessage().getMessageId();
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());

                try {

                    nbrbCourse.getCourse(model);
                    nbrbCourse1.getCourse(model1);
                    nbrbCourse2.getCourse(model2);

                    execute(message.setText("Выберите тип праздника: 1 - НГ, 2 - ДР").setReplyMarkup(getReplyKeyboardMarkupAnswerOne()));
                } catch (IOException | TelegramApiException e){
                    e.printStackTrace();
                }
            }
            else if (text.equals("НГ")) {
                list.add("НГ");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Выберите тип шаблона: 1 - верт, 2 - гориз, 3 - анимир").setReplyMarkup(getReplyKeyboardMarkupAnswerTwo()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            list.remove("НГ");
            }
            else if (text.equals("ДР")) {
              //  list.add("ДР");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Выберите тип шаблона: 1 - верт, 2 - гориз, 3 - анимир").setReplyMarkup(getReplyKeyboardMarkupAnswerTwo()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }

            else if (text.equals("вертикальная")) {
               // list.add("вертикальная");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Выберите тип открытки: 1 - электронная, 2 - аудио").setReplyMarkup(getReplyKeyboardMarkupAnswerFour()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (text.equals("горизонтальная")) {
             //   list.add("горизонтальная");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Выберите тип открытки: 1 - электронная, 2 - аудио").setReplyMarkup(getReplyKeyboardMarkupAnswerFour()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (text.equals("анимированная")) {
            //    list.add("анимированная");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Выберите тип открытки: 1 - электронная, 2 - аудио").setReplyMarkup(getReplyKeyboardMarkupAnswerFour()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (text.equals("аудиооткрытка")) {
            //    list.add("аудиооткрытка");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Введите номер телефона").setReplyMarkup(getReplyKeyboardMarkupRestart()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (text.equals("электронная")) {
            //    list.add("электронная");
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    execute(message.setText("Введите номер телефона").setReplyMarkup(getReplyKeyboardMarkupAnswerThree()));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
              //  list.remove("электронная");
            }
            if (text.equals("Далее")) {
                Model model = new Model();
                model.setCurrencyName("USD");

                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                try {
                    NbrbCourse nbrbCourse = new NbrbCourse();
                    nbrbCourse.getCourse(model);
                    String billConverted = String.valueOf(model.getCur_OfficialRate()*bill);
                    execute(message.setText("Стоймость вашего заказа: ".concat(billConverted)
                            .concat(", ваш заказ: ").concat(list.toString()))
                            .setReplyMarkup(getReplyKeyboardMarkupRestart()));
                } catch (TelegramApiException | IOException e) {
                    e.printStackTrace();
                }
            }
        list.remove("/start");
        }
    }




    private ReplyKeyboardMarkup getReplyKeyboardMarkupAnswerOne() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("НГ"));
        keyboardFirstRow.add(new KeyboardButton("ДР"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getReplyKeyboardMarkupAnswerTwo() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("вертикальная"));
        keyboardFirstRow.add(new KeyboardButton("горизонтальная"));
        keyboardFirstRow.add(new KeyboardButton("анимированная"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getReplyKeyboardMarkupAnswerThree() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Далее"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getReplyKeyboardMarkupAnswerFour() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("электронная"));
        keyboardFirstRow.add(new KeyboardButton("аудиооткрытка"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup getReplyKeyboardMarkupRestart() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("/start"));

        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);

        return replyKeyboardMarkup;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}

