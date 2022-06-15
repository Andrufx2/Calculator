//перечисление позиций разрядов чисел, соответствие минимального, среднего и максимального значения
enum DigitOfNumber {


    THOUSANDS(DigitRoman.M, DigitRoman.M, DigitRoman.M), // тысячи
    HUNDREDS(DigitRoman.С, DigitRoman.D, DigitRoman.M), // сотни
    DOZENS(DigitRoman.X, DigitRoman.L, DigitRoman.С),	 // десятки
    UNITS(DigitRoman.I, DigitRoman.V, DigitRoman.X);    // единицы

    private DigitRoman min; //минимальная граница разряда (включая)
    private DigitRoman average; // среднее число в разряде
    private DigitRoman max; // максимальная граница в разряде (не включая)

    private DigitOfNumber(DigitRoman min, DigitRoman average, DigitRoman max) {
        this.min = min;
        this.average = average;
        this.max = max;
    }

    public DigitRoman getMin() {
        return min;
    }

    public DigitRoman getAverage() {
        return average;
    }

    public DigitRoman getMax() {
        return max;
    }
}
