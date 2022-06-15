// Интерфейс определяет основные арифметические операции над объектами

interface Calculation<T> {

    // сложение
    T add(T a);

    // вычитание
    T subtract (T a);

    // умножение
    T multiply (T a);

    // деление
    T division (T a);
}
