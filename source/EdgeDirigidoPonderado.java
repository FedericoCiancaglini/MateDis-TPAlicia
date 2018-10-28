/**
 * @author Florencia Vimberg
 */
public class EdgeDirigidoPonderado<T> {
    private T from;
    private T to;
    private int value;

    public EdgeDirigidoPonderado(T from, T to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }

    public int getValue() {
        return value;
    }

    public void setFrom(T from) {
        this.from = from;
    }

    public void setTo(T to) {
        this.to = to;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
