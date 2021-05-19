package Poscard;

import java.util.Scanner;

public class CuntomberProfie {

    public static void order(){
        String[] typeEvent = {"День рождения","Свадьба","Новый год"};
        String[] typeTemplate = {"вертикальная", "горизонтальная", "круглая"};
        String[] typePoscard = {"аудио", "видео", "изображение"};
        String[] customerData = new String[4];

        System.out.println("Добрый день! Выберетите тип праздника");
        for(int i=0; i<=typeEvent.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать"+typeEvent[i]+"; ");
            Scanner in = new Scanner(System.in);
            int numberEvent = in.nextInt();
            customerData[1] =customerData[numberEvent];
        }

        System.out.println("Выберетите тип открытки");
        for(int i=0; i<=typeTemplate.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать"+typeTemplate[i]+"; ");
            Scanner in = new Scanner(System.in);
            int numberTemplate = in.nextInt();
            customerData[2] =customerData[numberTemplate];
        }

        System.out.println("Введите номер телефона получателя");
        Scanner in = new Scanner(System.in);
        customerData[3] =in.next();

        System.out.println("Выберетите тип услуги");
        for(int i=0; i<=typePoscard.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать"+typePoscard[i]+"; ");
            Scanner in1 = new Scanner(System.in);
            int numberPoscard = in1.nextInt();
            customerData[4] =customerData[numberPoscard];
        }

        System.out.println("Ваш заказ: ");
        for(int i=0; i<=customerData.length; i++) {
            System.out.print(customerData[i]+"; ");
        }
        System.out.println("С вас 5$");
        }

}
