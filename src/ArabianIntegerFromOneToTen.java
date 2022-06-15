// Класс целых арабских целых чисел от 1 до 10

final class ArabianIntegerFromOneToTen extends ArabianIntegerNumber {

    private static final int VALUE_MIN;
    private static final int VALUE_MAX;

    static {
        VALUE_MIN = 1;
        VALUE_MAX = 10;
    }

    // закрытый конструктор класса
    private ArabianIntegerFromOneToTen(int decimalValue, String stringValue) {
        super(decimalValue, stringValue);
    }

    // возвращает объект "арабское целое число от 1 до 10" по десятичному значению числа
    public static ArabianIntegerFromOneToTen valueOf(int decimalValue) {
        if (decimalValue >= VALUE_MIN && decimalValue <= VALUE_MAX) {
            return new ArabianIntegerFromOneToTen(decimalValue, String.valueOf(decimalValue));
        } else {
            throw new RuntimeException();
        }
    }

    // возвращает объект "арабское целое число" по строке символов

    public static ArabianIntegerFromOneToTen valueOf(String stringValue) {
        try {
            int decimalValue = Integer.parseInt(stringValue.trim());
            return ArabianIntegerFromOneToTen.valueOf(decimalValue);
        }  catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}

