package lesson;

import java.util.Objects;

public class BlackBox {
    int a;
    int b;

    public BlackBox(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //методы для одинаковых hash
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackBox blackBox = (BlackBox) o;
        return a == blackBox.a &&
                b == blackBox.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "BlackBox{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
