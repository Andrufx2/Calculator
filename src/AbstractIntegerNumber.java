/* Абстрактный класс целых чисел.
 * Экземпляры класса имеют три неизменяемых поля, описывающих целые числа:
 * вид цифр, значение в десятичной форме и строковое представление числа
 */


abstract class AbstractIntegerNumber {

    private final TypeOfDigit typeOfDigit; // вид цифры (римские,арабские и т.д)
    private final int decimalValue; // значение числа в десятичной форме;
    private final String stringValue; // строковое представление числа (5 -> "5"; 7 -> "VII" и т.д.)

    protected AbstractIntegerNumber(TypeOfDigit typeOfDigit, int decimalValue, String stringValue) {
        this.typeOfDigit = typeOfDigit;
        this.decimalValue = decimalValue;
        this.stringValue = stringValue;
    }

    public TypeOfDigit getTypeOfDigit() {
        return typeOfDigit;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

