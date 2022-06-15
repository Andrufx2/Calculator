// Класс целых арабских чисел.

class ArabianIntegerNumber extends AbstractIntegerNumber implements Calculation<ArabianIntegerNumber> {

    // защищенный конструктор класса
    protected ArabianIntegerNumber(int decimalValue, String stringValue) {
        super(TypeOfDigit.ARABIAN, decimalValue, stringValue);
    }

    // возвращает объект "арабское целое число" по десятичному значению числа

    public static ArabianIntegerNumber valueOf(int decimalValue) {
        return new ArabianIntegerNumber(decimalValue, String.valueOf(decimalValue));
    }

    // возвращает объект "арабское целое число" по строке символов

    public static ArabianIntegerNumber valueOf(String stringValue) {
        try {
            int decimalValue = Integer.parseInt(stringValue.trim());
            return ArabianIntegerNumber.valueOf(decimalValue);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    // сложение

    @Override
    public ArabianIntegerNumber add(ArabianIntegerNumber a) {
        return valueOf(this.getDecimalValue() + a.getDecimalValue());
    }
    // вычитание

    @Override
    public ArabianIntegerNumber subtract(ArabianIntegerNumber a) {
        return valueOf(this.getDecimalValue() - a.getDecimalValue());
    }

    // умножение

    @Override
    public ArabianIntegerNumber multiply(ArabianIntegerNumber a) {
        return valueOf(this.getDecimalValue() * a.getDecimalValue());
    }

    // целочисленное деление

    @Override
    public ArabianIntegerNumber division(ArabianIntegerNumber a) {
        return valueOf(this.getDecimalValue() / a.getDecimalValue());
    }

    @Override
    public String toString() {
        return getStringValue();
    }
}
