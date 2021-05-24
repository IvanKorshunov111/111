import java.util.Scanner;


public class Calcuator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение вида 1 + 1 или I + I");
        String num1 = scanner.next();
        char operation = scanner.next().charAt(0);
        String num2 = scanner.next();
        int arabicNumber1;
        int arabicNumber2;
        int result;
        if (Character.isDigit(num1.charAt(0)) && Character.isDigit(num2.charAt(0))) {
            arabicNumber1 = Integer.parseInt(num1);
            arabicNumber2 = Integer.parseInt(num2);
            if (arabicNumber1 < 1 || arabicNumber1 > 10 || arabicNumber2 < 1 || arabicNumber2 > 10) {
                System.out.println("Введите число от 1 до 10");
            } else {
                result = calcuator(arabicNumber1, arabicNumber2, operation);
                System.out.println("Полученый результат = " + result);
            }
        } else {
            arabicNumber1 = romanToArabic(num1);
            arabicNumber2 = romanToArabic(num2);
            if (arabicNumber1 < 1 || arabicNumber1 > 10 || arabicNumber2 < 1 || arabicNumber2 > 10) {
                System.out.println("Введите число от 1 до 10");
            } else {
                result = calcuator(arabicNumber1, arabicNumber2, operation);
                System.out.println("Полученый результат = " + arabToRoman(result));
            }
        }
    }

    public static int calcuator(int num1, int num2, char operation) {
        Integer result = null;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Введите корректную операцию");
        }


        return result;
    }

    private static String arabToRoman(int num) {
        String c[] = {"", "C"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];
        return hundreds + tens + ones;
    }


    private static int romanToArabic(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    result = result + s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
                i++;
            }
        }
        return result;
    }

    private static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        return -1;
    }
}