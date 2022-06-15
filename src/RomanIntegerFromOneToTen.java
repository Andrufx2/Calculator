// класс римских чисел от 1 до 10

final class RomanIntegerFromOneToTen extends RomanIntegerNumber {
    private static final int VALUE_MIN;
    private static final int VALUE_MAX;

    static {
        VALUE_MIN = 1;
        VALUE_MAX = 10;
    }

    // закрытый конструктор класса
    private RomanIntegerFromOneToTen(int decimalValue, String stringValue) {
        super(decimalValue, stringValue);
    }

    // возвращает объект "римское целое число от 1 до 10" по десятичному значению числа
    public static RomanIntegerFromOneToTen valueOf(int decimalValue) {
        if (decimalValue >= VALUE_MIN && decimalValue <= VALUE_MAX) {
            return new RomanIntegerFromOneToTen(decimalValue, RomanIntegerNumber.coderToRoman(decimalValue));
        } else {
            throw new RuntimeException();
        }
    }

    // возвращает объект "римское целое число" по строке символов
    public static RomanIntegerFromOneToTen valueOf(String stringValue) {
        stringValue = stringValue.trim();
        try {
            RomanIntegerNumber temp = RomanIntegerNumber.valueOf(stringValue);
            return valueOf(temp.getDecimalValue());
        }  catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}