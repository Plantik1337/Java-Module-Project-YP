import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amt = 0;
        System.out.println("Приветствую!\nВведите количество гостей: ");
        while (true){
            if (scanner.hasNextInt()){
                amt = scanner.nextInt();
                if (amt > 1) {
                    break;
                }
                else if (amt == 1){
                    System.out.println("Делить счёт не имеет смысла :)");
                }
                else {
                    System.out.println("Введите корректное значение");
                }
            }
            else {
                System.out.println("Введите число");
                scanner.next();
            }
        }
        Calc calc = new Calc();// создаём калькулятор
        double price;
        while (true) {
            System.out.println("Хотите добавить товар - введите название товара.\nЧтобы завершить добавление товара и начать посчёт - Завершить");
            String name = scanner.next();
            if (name.equalsIgnoreCase("Завершить")) {
                System.out.println("Начинаем подсчёт...");
                break;
            }
            else{
                System.out.println("Введите стоимость товара в формате < руб,коп > \n");
            }
            while (true){
                if (scanner.hasNextDouble()) {
                    price = scanner.nextDouble();
                    if (price > 0){
                        break;
                    } else if (price < 0) {
                        System.out.println("Стоимость не может быть отрицательной.");
                    } else {
                        System.out.println("Некорректное значение");
                    }
                }
                else {
                    System.out.println("Введите число");
                    scanner.next();
                }

            }
            calc.add(price, name);
            calc.showPrice();
        }
        calc.showGoods();
        System.out.printf("Каждый должен заплатить: %.2f %s", calc.price / amt, calc.valid(calc.price / amt));
    }
}
class Calc {// Класс калькулятор
    double price = 0;
    String name = "\n";

    public void add(double addPrice, String addName) {
        name += addName + "\n";
        price += addPrice;
        System.out.println("Товар успешно добавлен!");
    }

    public void showGoods() {// покзать все занесённые данные
        System.out.println("Добавленные товары:" + name);

    }
    public void showPrice(){// Показать цену
        System.out.printf("Сумма всех добавленных товаров: %.2f %s\n", price, valid(price));
    }

    public String valid(double lign) {// проверка на правильное написание слова "рубль"
        if ((lign % 10 == 1) && !(lign % 100 > 10 && lign % 100 < 20)) {// 1 кроме от 10 до 20 Рубль
            return " Рубль";
        } else if ((lign % 10 >= 2 && lign % 10 < 5) && !(lign % 100 > 10 && lign % 100 < 20)) {// 2 - 4 кроме от 10 до 20 Рубля
            return " Рубля";
        } else if ((lign % 10 >= 5 && lign % 10 < 10) && !(lign % 100 > 10 && lign % 100 < 20)) {// 5 - 9 кроме от 10 до 20 Рублей
            return " Рублей";
        } else if (lign % 100 >= 10 && lign % 100 <= 20) {// 10 - 19 исключение
            return " Рублей";
        }
        return " Рубль";
    }
}
