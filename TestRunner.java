import java.util.Arrays;
import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) {
        double bill = 5.0;
        String clientNumber = "";
        String[] typeEvent = {"Christmas", "Birthday"};
        int[] templateNumber = {1, 2, 3};
        String[] typeService = {"postcard", "audiocard"};

        String[] payHistory = {"bill", "clientNumber", "typeEvent", "templateNumber", "typeService"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите тип праздника: 1 - НГ, 2 - ДР");
        int number = sc.nextInt();
        if (number == 1) {
            String tempTypeEvent = "Christmas";
            payHistory[0] = tempTypeEvent;
        } else if (number == 2) {
            String tempTypeEvent = "Birthday";
            payHistory[0] = tempTypeEvent;
        } else System.out.println("Вы ввели неверное число. Выберите тип праздника: 1 - НГ, 2 - ДР ");

        System.out.println("Выберите тип шаблона: 1 - верт, 2 - гориз, 3 - анимир");
        Scanner sc2 = new Scanner(System.in);
        int number2 = sc2.nextInt();
        if (number2 == 1) {
            String tempTemplateNumber = "вертикальная";
            payHistory[1] = tempTemplateNumber;
        } else if (number2 == 2) {
            String tempTemplateNumber = "горизонтальная";
            payHistory[1] = tempTemplateNumber;
        } else if (number2 == 3) {
            String tempTemplateNumber = "анимированная";
            payHistory[1] = tempTemplateNumber;
        } else System.out.println("Вы ввели неверное число. Выберите тип шаблона: 1 - верт, 2 - гориз, 3 - анимир");

        System.out.println("Выберите тип открытки: 1 - электронная, 2 - аудио");
        Scanner sc3 = new Scanner(System.in);
        int number3 = sc3.nextInt();
        if (number3 == 1) {
            String tempTypeService = "электронная";
            payHistory[2] = tempTypeService;
        } else if (number3 == 2) {
            String tempTypeService = "аудио";
            payHistory[2] = tempTypeService;
        } else System.out.println("Вы ввели неверное число. Выберите тип открытки: 1 - электронная, 2 - аудио");
// TODO сделать цикл while, который задает следующий вопрос пока правильно не отвечен текущий вопрос.


        while (number3 < 1) {
            System.out.println("Вы ввели неверное число. Выберите тип открытки: 1 - электронная, 2 - аудио");
            number3++;
            if (number3 == 1) {
                number3 = sc3.nextInt();
                }
             else  if (number3 == 2) {
                number3 = sc3.nextInt();
             }
        }
        while (number3 >= 3) {
            System.out.println("Вы ввели неверное число. Выберите тип открытки: 1 - электронная, 2 - аудио");
            number3--;
            if (number3 == 1) {
                number3 = sc3.nextInt();
            }
            else  if (number3 == 2) {
                number3 = sc3.nextInt();
            }
        }




            System.out.println("Введите номер телефона");
            Scanner sc4 = new Scanner(System.in);
            int number4 = sc4.nextInt();

            String b = String.valueOf(number4);
            payHistory[3] = b;
            String c = String.valueOf(bill);
            payHistory[4] = c;
            System.out.println("Спасибо за заказ. С вас 5$");

            System.out.println("Ваш заказ: " + Arrays.toString(payHistory));



    }
}

