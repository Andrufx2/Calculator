/* Перечисление римских цифр.
 * Константа 1: десятичное представление цифры;
 * Константа 2: строчное представление цифры.
 */

enum DigitRoman {
    I(1, "I"), //
    V(5, "V"),
    X(10, "X"),
    L(50, "L"),
    С(100, "C"),
    D(500, "D"),
    M(1000, "M");

    private int valueDecimal;
    private String valueString;

    private DigitRoman(int valueDecimal, String valueString) {
        this.valueDecimal = valueDecimal;
        this.valueString = valueString;
    }

    public int getValueDecimal() {
        return this.valueDecimal;
    }

    public String getValueString() {
        return this.valueString;
    }
}
