package Poscard;

import java.util.Scanner;

public class Cuntomber {
    public static void main(String[] args) {
        String[] typeEvent = {"День рождения","Свадьба","Новый год"};
        String[] typeTemplate = {"вертикальная", "горизонтальная", "круглая"};
        String[] typePoscard = {"аудио", "видео", "изображение"};
        String[] customerData = new String[4];

        Scanner in = new Scanner(System.in);

        System.out.println("Добрый день! Выберетите тип праздника");
        for(int i=0; i<typeEvent.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать "+typeEvent[i]+"; ");
        }
        int numberEvent  = in.nextInt();
        customerData[0] = typeEvent[numberEvent];


        System.out.println("Выберетите тип открытки");
        for(int i=0; i<typeTemplate.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать "+typeTemplate[i]+"; ");}
            int numberTemplate = in.nextInt();
            customerData[1] =typeTemplate[numberTemplate];


        System.out.println("Введите номер телефона получателя");
        customerData[2] =in.next();

        System.out.println("Выберетите тип услуги");
        for(int i=0; i<typePoscard.length; i++) {
            System.out.println("Нажмите "+i+" если вы хотие выбрать "+typePoscard[i]+"; ");}
            int numberPoscard = in.nextInt();
            customerData[3] =typePoscard[numberPoscard];


        System.out.println("Ваш заказ: ");
        for(int i=0; i<customerData.length; i++) {
            System.out.print(customerData[i]+"; ");
        }
        System.out.println("");
        System.out.println("С вас 5$");
    }
}
