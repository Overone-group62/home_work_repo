import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое число в консоли");
        try {
            //вводим с кансоли число в формате String:
            String number = scanner.nextLine();

            //Из введенной строки убираем все символы кроме цифр и мат.действой (+,-,*):
            number= number.replaceAll("[^0-9,+,*,-]", "");

            //разбиваем строку на массив символов типа char:
            char[] symbolsArray = number.toCharArray();

            //преобразуем массив сиволов в arrayList типа String с преобразованием char в String:
            List<String> symbols = new ArrayList<>();
            for (char c:symbolsArray) {
                symbols.add(Character.toString(c));
            }

            //разбиваем список символов на 2 одельных списка (с мат.знаками и с числами):
            String tempNumber = "";
            String temp;
            List<String> numbersList = new ArrayList<>(); //новый список с числами
            List<String> singsList = new ArrayList<>(); //новый список с матеиматическими знаками (+-*)
            while (!symbols.isEmpty()) { //пока список не пуст
                if (symbols.get(0).equals("+")||symbols.get(0).equals("-")||symbols.get(0).equals("*")){
                    singsList.add(symbols.get(0));
                    symbols.remove(0);
                    numbersList.add(tempNumber);
                    tempNumber = "";
                } else {
                    tempNumber = tempNumber+symbols.get(0);
                    symbols.remove(0);
                }
            }
            numbersList.add(tempNumber);

            //Проводим матиматические вычисления
            while (!singsList.isEmpty()){ // пока список мат.знаков не пуст
                int result = 0;
                switch (singsList.get(0)){
                    case "+":
                        result = Integer.parseInt(numbersList.get(0))+Integer.parseInt(numbersList.get(1)); //складываем 2 первых элемента списка с числами
                        numbersList.remove(0); // удаляем первый (нуливой) элемент
                        numbersList.set(0,Integer.toString(result)); // заменяем первый (нклевой) элемен на результат вычислений
                        singsList.remove(0);
                        break;
                    case "-": // то же для -
                        result = Integer.parseInt(numbersList.get(0))-Integer.parseInt(numbersList.get(1));
                        numbersList.remove(0);
                        numbersList.set(0,Integer.toString(result));
                        singsList.remove(0);
                        break;
                    case "*": // то же для *
                        result = Integer.parseInt(numbersList.get(0))*Integer.parseInt(numbersList.get(1));
                        numbersList.remove(0);
                        numbersList.set(0,Integer.toString(result));
                        singsList.remove(0);
                        break;
                }
            }

            System.out.println("Ваше число " + numbersList.get(0));
            flag = false;
        } catch (InputMismatchException e) {
            System.out.println("Введите число");
        }
        }
        // write your code here
    }
}