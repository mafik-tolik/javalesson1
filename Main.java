import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
    }

    static void ex1() {

        System.out.print("\nЗадание 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n).\n");
        System.out.print("Введите n-ое треугольного число: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.printf("Cумма чисел от 1 до %d -> %d\n", n, sum);
    }

    static void ex2() {

        System.out.println("\nЗадание 2. Вычислить n! (произведение чисел от 1 до n).");
        System.out.print("Введите n: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int mult = 1;

        for (int i = 1; i <= num; i++) {
            mult *= i;
        }
        System.out.printf("%d! -> %d\n", num, mult);
    }

    static void ex3() {

        System.out.println("\nЗадание 3. Вывести все простые числа от 1 до 1000 (простые числа - это числа " +
                "которые делятся только на себя и на единицу без остатка. Чтобы найти остаток от деления " +
                "используйте оператор % , например 10%3 будет равно единице).");
        int limit = 1000;
        for (int i = 1; i <= limit; i++) {

            if (i > 0 && i < 4) {
                System.out.print(i + ", ");
            } else {
                boolean flag = true;
                int j = 2;
                while (flag) {
                    if (i % j == 0) {
                        if (i == j) {
                            System.out.print(i + ", ");
                        }
                        flag = false;
                    } else {
                        j++;
                    }
                }
            }
        }
    }

    static void ex4() {
        System.out.print("\n\nЗадание 4. Реализовать простой калькулятор (Введите первое число... Введите " +
                "второе число... Укажите операцию, которую надо выполнить с этими числами... Ответ: ...)\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double num1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Введите второе число:");
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.println("Укажите операцию, которую надо выполнить с этими числами (+, -, * или /):");
        String oper = scanner.nextLine();

        switch (oper) {
            case "+":
                System.out.printf("%f + %f = %f\n", num1, num2, num1 + num2);
                break;
            case "-":
                System.out.printf("%f - %f = %f\n", num1, num2, num1 - num2);
                break;
            case "*":
                System.out.printf("%f * %f = %f\n", num1, num2, num1 * num2);
                break;
            case "/":
                System.out.printf("%f / %f = %f\n", num1, num2, num1 / num2);
                break;
            default:
                System.out.println("Указана неверная операция");
                break;
        }
    }

    static void ex5() {
        System.out.print("\nЗадание 5. Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры " +
                "могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить " +
                "выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.\n");

        Random random = new Random();
        int rand = random.nextInt(2);
        String q;
        String w;
        if (rand == 0) {
            q = random.nextInt(9) + 1 + "?";
            w = "?" + (random.nextInt(9) + 1);
        } else {
            q = "?" + (random.nextInt(9) + 1);
            w = random.nextInt(9) + 1 + "?";
        }

        int e = random.nextInt(90) + 10;

        System.out.printf("Cлучайное уравнение -> %s + %s = %d\n", q, w, e);

        char[] qChar = q.toCharArray();
        char[] wChar = w.toCharArray();
        int limit = 10;
        boolean flag = false;

        if (qChar[0] == '?') {
            for (int i = 0; i < limit; i++) {
                for (int j = 0; j < limit; j++) {
                    if (Integer.parseInt(Integer.toString(i) + Character.toString(qChar[1]))
                            + Integer.parseInt(Character.toString(wChar[0]) + Integer.toString(j)) == e) {
                        System.out.printf("Восстановленное выражение -> %d + %d = %d\n",
                                Integer.parseInt(Integer.toString(i) + Character.toString(qChar[1])),
                                Integer.parseInt(Character.toString(wChar[0]) + Integer.toString(j)), e);
                        flag = true;
                    }
                }
            }
        } else {
            for (int i = 0; i < limit; i++) {
                for (int j = 0; j < limit; j++) {
                    if (Integer.parseInt(Character.toString(qChar[0]) + Integer.toString(i))
                            + Integer.parseInt(Integer.toString(j) + Character.toString(wChar[1])) == e) {
                        System.out.printf("Восстановленное выражение -> %d + %d = %d\n",
                                Integer.parseInt(Character.toString(qChar[0]) + Integer.toString(i)),
                                Integer.parseInt(Integer.toString(j) + Character.toString(wChar[1])), e);
                        flag = true;
                    }
                }
            }
        }

        if (flag == false) {
            System.out.println("Решения нет");
        }
    }
}
