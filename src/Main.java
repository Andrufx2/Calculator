import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(calc(str));
    }

    // метод преобразует строку в арифметическое выражение и возвращает результат вычисления
    public static String calc(String input) throws Exception {
        // попытка перехватывает любые исключения и вызывает Exeption
        try {
            AbstractIntegerNumber res = null;
            input = input.trim(); // ликвидируем лишние пробелы в сроке
            // создаем массив операндов
            String[] arrayOperands = input.split("\\+|\\-|\\*|\\/");
            char operator;
            // должно быть только 2 операнда
            if (arrayOperands.length == 2) {
                operator = input.charAt(arrayOperands[0].length()); // получаем символ оператора
                AbstractIntegerNumber operandFirst = getNumberFromOneToTen(arrayOperands[0]);
                AbstractIntegerNumber operandSecond = getNumberFromOneToTen(arrayOperands[1]);
                // оеранд 1 и операнд 2 должны быть или только римскими или только арабскимичислами;
                if (operandFirst instanceof ArabianIntegerNumber t1 && operandSecond instanceof ArabianIntegerNumber t2) {
                    switch (operator) {
                        case '+':
                            res = t1.add(t2);
                            break;
                        case '-':
                            res = t1.subtract(t2);
                            break;
                        case '*':
                            res = t1.multiply(t2);
                            break;
                        case '/':
                            res = t1.division(t2);
                            break;
                    }

                } else if (operandFirst instanceof RomanIntegerNumber t1 && operandSecond instanceof RomanIntegerNumber t2) {
                    switch (operator) {
                        case '+':
                            res = t1.add(t2);
                            break;
                        case '-':
                            res = t1.subtract(t2);
                            break;
                        case '*':
                            res = t1.multiply(t2);
                            break;
                        case '/':
                            res = t1.division(t2);
                            break;
                    }
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
            return res.toString();
        } catch (Exception ex) {
            throw new Exception();
        }
    }

    // преобразует операнды в целые числа от 1 до 10 (римские или арабские)
    public static AbstractIntegerNumber getNumberFromOneToTen (String operand) throws Exception {
        AbstractIntegerNumber res;
        // попытка преобразовать первый операнд в арабское число от 1 до 10
        try {
            res = ArabianIntegerFromOneToTen.valueOf(operand);
        } catch (Exception ex){
            // иначе попытка преобразовать первый операнд в римское число от 1 до 10
            try {
                res = RomanIntegerFromOneToTen.valueOf(operand);
            } catch (Exception ex1) {
                throw new Exception();
            }
        }
        return res;
    }
}
