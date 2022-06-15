
import java.util.HashMap;

// Класс целых римских чисел
class RomanIntegerNumber extends AbstractIntegerNumber implements Calculation<RomanIntegerNumber> {


    // защищенный конструктор класса
    protected RomanIntegerNumber(int decimalValue, String stringValue) {
        super(TypeOfDigit.ROMAN, decimalValue, stringValue);
    }

    // возвращает объект "римское целое число" по десятичному значению числа
    public static RomanIntegerNumber valueOf(int decimalValue) {
        if (decimalValue > 0 && decimalValue <= 3999) {
            return new RomanIntegerNumber(decimalValue, coderToRoman(decimalValue));
        } else {
            throw new RuntimeException();
        }
    }

    // возвращает объект "римское целое число" по строковой записи римского числа (I, V и т.д.)
    public static RomanIntegerNumber valueOf(String stringValue) {
        char[] tempStr = stringValue.trim().toCharArray();
        HashMap<Character, Integer> vocabularyDigit = new HashMap<>();
        vocabularyDigit.put('I', 1);
        vocabularyDigit.put('V', 5);
        vocabularyDigit.put('X', 10);
        vocabularyDigit.put('L', 50);
        vocabularyDigit.put('C', 100);
        vocabularyDigit.put('D', 500);
        vocabularyDigit.put('M', 1000);
        int len = tempStr.length;
        int[] numberPoints = new int[len];
        Integer number;
        // преобразование римских символов в цифры поразрядно
        for (int i = 0; i < len; i++) {
            if((number = vocabularyDigit.get(tempStr[i])) != null) {
                numberPoints[i] = number;
            } else {
                throw new RuntimeException();
            }
        }

        // проверка на не более 3-x одинаковых цифр подряд
        for (int i = 3; i < len; i++) {
            if(numberPoints[i] == numberPoints[i - 1] && numberPoints[i] == numberPoints[i - 2]
                    && numberPoints[i] == numberPoints[i - 3]) {
                throw new RuntimeException();
            }
        }

        // цифре не должно предшествовать более чем 1 цифра меньшая текущей
        for (int i = 2; i < len; i++) {
            if(numberPoints[i] > numberPoints[i - 1] && numberPoints[i] > numberPoints[i - 2]) {
                throw new RuntimeException();
            }
        }
        // исключение 2-х и более подряд идущих цифр 5, 50, 500 (V, L, D)
        // цифры I, X, C вычитаются из следующей цифры, которая больше в 10 или 5 раз текущей иначе исключение.
        // цифры V, L, D не вычитаются, программа при этом вызывает исключение
        for (int i = 1; i < len; i++) {
            if((numberPoints[i] == 5 || numberPoints[i] == 50 || numberPoints[i] == 500)
                    && numberPoints[i] == numberPoints[i - 1]) {
                throw new RuntimeException();
            }
            if(numberPoints[i] > numberPoints[i - 1]) {
                if((numberPoints[i - 1] == 1 || numberPoints[i - 1] == 10 || numberPoints[i - 1] == 100)
                        && (numberPoints[i] / numberPoints[i - 1] == 10 || numberPoints[i] / numberPoints[i - 1] == 5)) {
                    numberPoints[i - 1] *= -1;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        // числа  a[n] не должны быть больше a[n - 1] + a[n - 2], если a[n - 2] < 0;
        // числа  a[n] не должны быть одного порядка с  a[n - 2], если a[n - 2] < 0;
        for (int i = 2; i < len; i++) {
            if(numberPoints[i - 2] < 0) {
                if (numberPoints[i] > numberPoints[i - 1] + numberPoints[i - 2]
                        || String.valueOf(Math.abs(numberPoints[i])).length() == String.valueOf(Math.abs(numberPoints[i - 2])).length()) {
                    throw new RuntimeException();
                }
            }
        }
        int sum = 0;
        for (int p: numberPoints) {
            sum += p;
        }
        return RomanIntegerNumber.valueOf(sum);
    }

    // метод возвращает полное представление десятичного числа в римской системе
    protected static String coderToRoman(int number) {
        StringBuilder res = new StringBuilder(""); // строка формирования результата в римской системе
        int temp = number;
        res.append(coderRoRomanPosition(temp / 1000, DigitOfNumber.THOUSANDS));
        temp %= 1000;
        res.append(coderRoRomanPosition(temp / 100, DigitOfNumber.HUNDREDS));
        temp %= 100;
        res.append(coderRoRomanPosition(temp / 10, DigitOfNumber.DOZENS));
        temp %= 10;
        res.append(coderRoRomanPosition(temp, DigitOfNumber.UNITS));
        return res.toString();
    }

    // мотод возвращает представление соответствующей позиции десятичного числа в римской системе
    private static StringBuilder coderRoRomanPosition(int quantity, DigitOfNumber digitOfNumber) {
        StringBuilder str = new StringBuilder();
        if (digitOfNumber == DigitOfNumber.THOUSANDS) {
            String digitRoman = digitOfNumber.getMin().getValueString();
            for(int i = 0; i < quantity; i++) {
                str.append(digitRoman);
            }
        } else {
            if (quantity == 9) {
                str.append(digitOfNumber.getMin().getValueString());
                str.append(digitOfNumber.getMax().getValueString());
            } else if (quantity == 4) {
                str.append(digitOfNumber.getMin().getValueString());
                str.append(digitOfNumber.getAverage().getValueString());
            } else {
                int deltaMin = quantity;
                if (deltaMin > 4) {
                    str.append(digitOfNumber.getAverage().getValueString());
                    deltaMin = quantity - 5;
                }
                String digitRoman = digitOfNumber.getMin().getValueString();
                for (int i = 0; i < deltaMin; i++) {
                    str.append(digitRoman);
                }
            }
        }

        return str;
    }

    // сложение
    @Override
    public RomanIntegerNumber add(RomanIntegerNumber a) {
        return valueOf(this.getDecimalValue() + a.getDecimalValue());
    }

    // вычитание
    @Override
    public RomanIntegerNumber subtract(RomanIntegerNumber a) {
        return valueOf(this.getDecimalValue() - a.getDecimalValue());
    }

    // умножение
    @Override
    public RomanIntegerNumber multiply(RomanIntegerNumber a) {
        return valueOf(this.getDecimalValue() * a.getDecimalValue());
    }

    // деление
    @Override
    public RomanIntegerNumber division(RomanIntegerNumber a) {
        return valueOf(this.getDecimalValue() / a.getDecimalValue());
    }

    @Override
    public String toString() {
        return getStringValue();
    }
}
