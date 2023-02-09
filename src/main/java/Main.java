import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        String name;
        double price;
        System.out.println("Приветствую!\nВведите на скольких человек необходимо разделить счёт:\n");
        int atm = 0;
        while(atm <= 1) {
            atm = scanner.nextInt();// amt - сокращение от amount (количество). Узнаём у пользователя количество людей.
            if (atm > 1) {
                Сalc calc = new Сalc();
                String select = "";
                while (!select.equalsIgnoreCase("завершить")) {// Цикл работает пока пользователь не введёт слово "Завершить" без учёта регистра.
                    System.out.println("Введите название товара:\n");
                    name = scanner.next() + " ";
                    System.out.println("Введите цену товара:\n");
                    price = scanner.nextDouble();
                    calc.add(price, name);
                    calc.showPrice();
                    System.out.println("Хотите добавить еще один товар ?\nЧтобы завершить добавление товара и начать посчёт - Завершить");
                    select = scanner.next();
                }
                calc.showAll();
                double result = calc.price / atm;// считаем по сколько каждый должен заплатить
                result *= 100; // начало округления
                int tmp = (int)result;
                result = (double)tmp / 100;// конец округления
                int lineEnding = (int)result;
                lineEnding = lineEnding%10;
                switch (lineEnding){
                    case 1:
                        System.out.println("Счёт разделяется по " + result + " рубль на человека.");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("Счёт разделяется по " + result +" рубля на человека.");
                        break;
                    default:
                        System.out.println("Счёт разделяется по " + result +" рублей на человека.");
                }
            } else if (atm < 1) {
                System.out.println("Некорректное значение для подсчёта.");
            } else if (atm == 1) {
                System.out.println("Делить счёт не требуется.");
            }
        }
    }
    public static class Сalc{// Класс калькулятор
        double price = 0;
        String name = "\n";
        void add(double addPrice, String addName){
            name += addName + "\n";
            price += addPrice;
            System.out.println("Товар успешно добавлен!");
        }
        void showAll(){// покзать все занесённые данные
            System.out.println("Добавленные товары:" + name);
            int lineEnding = (int)price;
            lineEnding = lineEnding%10;
            switch (lineEnding){
                case 1:
                    System.out.println("Сумма всех покупок: " + price + " рубль");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("Сумма всех покупок: " + price + " рубля");
                    break;
                default:
                    System.out.println("Сумма всех покупок: " + price + " рублей");
            }
        }
        void showPrice(){// показать цену всех товаров
            int lineEnding = (int)price;
            lineEnding = lineEnding%10;
            switch (lineEnding){
                case 1:
                    System.out.println("Текущая сумма всех покупок: " + price + " рубль");
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("Текущая сумма всех покупок: " + price + " рубля");
                    break;
                default:
                    System.out.println("Текущая сумма всех покупок: " + price + " рублей");
            }
        }
    }
}

